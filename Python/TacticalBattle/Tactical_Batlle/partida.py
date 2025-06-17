import threading
import time
from jugador import Jugador
from personaje import Medico, Artillero, Francotirador, Inteligencia
from utils import limpiar_terminal, validar_celda, comprobar_celda_disponible, validar_celda_contigua


class JugadorRemoto(Jugador):
    def __init__(self, socket_cliente, nombre_usuario):
        super().__init__()
        # Validar que socket_cliente es válido
        if not hasattr(socket_cliente, 'send') or not hasattr(socket_cliente, 'recv'):
            raise ValueError("El argumento socket_cliente debe ser un socket válido con métodos 'send' y 'recv'.")
        self.socket_cliente = socket_cliente
        self.nombre_usuario = nombre_usuario

    def enviar_mensaje(self, mensaje):
        try:
            if self.socket_cliente:
                self.socket_cliente.send(mensaje.encode('utf-8'))
            else:
                print(f"Error: socket_cliente no está inicializado para {self.nombre_usuario}.")
        except (BrokenPipeError, ConnectionResetError):
            print(f"Error al enviar mensaje a {self.nombre_usuario}. Cliente desconectado.")

    def recibir_mensaje(self):
        try:
            return self.socket_cliente.recv(1024).decode('utf-8')
        except (ConnectionResetError, ConnectionAbortedError):
            print(f"Error al recibir mensaje de {self.nombre_usuario}. Cliente desconectado.")
            return None

    def turno(self):
        """
        Gestiona el turno de un jugador remoto.
        """
        self.enviar_mensaje("\n--- SITUACION DEL EQUIPO ---")
        for personaje in self.equipo:
            self.enviar_mensaje(
                f"{type(personaje).__name__} está en {personaje.posicion} [Vida {personaje.vida_actual}/{personaje.vida_maxima}]")

        acciones = self.obtener_acciones_disponibles()
        self.enviar_mensaje("\n--- ACCIONES DISPONIBLES ---")
        for i, accion in enumerate(acciones):
            self.enviar_mensaje(f"{i + 1}: {accion}")

        self.enviar_mensaje("Selecciona la acción de este turno: ")
        while True:
            try:
                seleccion = int(self.recibir_mensaje()) - 1
                if 0 <= seleccion < len(acciones):
                    break
                else:
                    self.enviar_mensaje("Acción no válida. Inténtalo de nuevo.")
            except (ValueError, TypeError):
                self.enviar_mensaje("Entrada no válida. Introduce un número.")
            except:
                return True  # Indica que el cliente se ha desconectado

        codigo_accion = self.ejecutar_accion(seleccion, acciones)
        if codigo_accion:
            resultado = self.oponente.recibir_accion(codigo_accion)
            if resultado:
                self.enviar_mensaje("\n--- RESULTADO DE LA ACCIÓN ---")
                self.enviar_mensaje(resultado["informe"])
                self.enviar_mensaje("FIN_TURNO")  # Indicador de fin de turno para el cliente
                return resultado.get("fin_partida", False)
        self.enviar_mensaje("FIN_TURNO")
        return False

    def ejecutar_accion(self, seleccion, acciones):
        """
        Ejecuta la acción seleccionada por el jugador remoto.
        """
        personaje_index = seleccion // 2
        personaje = self.equipo[personaje_index]
        accion_index = seleccion % 2

        if "Mover" in acciones[seleccion]:
            self.enviar_mensaje(
                f"Indica la celda a la que mover al {type(personaje).__name__} (Posición actual: {personaje.posicion}): ")
            while True:
                nueva_celda = self.recibir_mensaje().upper()
                if not validar_celda(nueva_celda, 4, 4):  # Asumiendo tablero de 4x4
                    self.enviar_mensaje("Celda no válida.")
                    continue
                ocupadas = [p.posicion for p in self.equipo] + [p.posicion for p in self.oponente.equipo]
                ocupadas.remove(personaje.posicion)
                if not comprobar_celda_disponible(nueva_celda, ocupadas):
                    self.enviar_mensaje("¡Ups... la celda ya está ocupada!")
                    continue
                if not validar_celda_contigua(personaje.posicion, nueva_celda):
                    self.enviar_mensaje("Celda no contigua. Elige una celda adyacente.")
                    continue
                personaje.mover(nueva_celda)
                return None
        else:
            return personaje.habilidad(self.oponente)

    def recibir_accion(self, codigo_accion):
        """
        Gestiona la acción del oponente (para el jugador remoto).
        """
        if not codigo_accion:
            return None

        inicial = codigo_accion[0]
        celda = codigo_accion[1:]
        informe = ""
        fin_partida = False

        for personaje in self.equipo:
            if personaje.posicion and personaje.posicion in celda:
                personaje.vida_actual -= 1  # Asumiendo 1 de daño para todos los ataques de área
                informe += f"\n{type(personaje).__name__} ha sido herido en {personaje.posicion} [Vida restante: {personaje.vida_actual}]"
                if not personaje.esta_vivo():
                    informe += f"\n{type(personaje).__name__} ha sido eliminado"

        personajes_vivos = sum(1 for p in self.equipo if p.esta_vivo())
        if personajes_vivos == 0:
            fin_partida = True
            informe += "\n\n¡Has perdido la partida!"

        return {"informe": informe, "fin_partida": fin_partida}


class Partida:
    """
    Gestiona una partida individual.
    """

    def __init__(self, jugador1, jugador2):
        self.jugador1 = jugador1
        self.jugador2 = jugador2
        self.jugador1.set_oponente(self.jugador2)
        self.jugador2.set_oponente(self.jugador1)
        self.fin_partida = False
        self.lock = threading.Lock()

    def jugar(self):
        """
        Ejecuta la lógica principal de la partida.
        """
        self.jugador1.enviar_mensaje("Comienza la partida")
        self.jugador2.enviar_mensaje("Comienza la partida")
        self.jugador1.enviar_mensaje("Eres el Jugador 1")
        self.jugador2.enviar_mensaje("Eres el Jugador 2")

        # Posicionar equipo
        self.jugador1.enviar_mensaje("Posiciona a tu equipo")
        self.jugador1.posicionar_equipo()
        self.jugador2.enviar_mensaje("Posiciona a tu equipo")
        self.jugador2.posicionar_equipo()

        while not self.fin_partida:
            self.fin_partida = self.turno(self.jugador1, self.jugador2)
            if self.fin_partida:
                break
            self.fin_partida = self.turno(self.jugador2, self.jugador1)

        self.determinar_ganador()

    def turno(self, jugador, oponente):
        """
        Gestiona un turno de un jugador.
        """
        jugador.enviar_mensaje("Tu turno")
        oponente.enviar_mensaje("Turno del oponente")
        desconexion = jugador.turno()
        if desconexion:
            oponente.enviar_mensaje("Tu oponente se ha desconectado. Has ganado")
            return True
        return self.fin_partida

    def determinar_ganador(self):
        """
        Determina al ganador de la partida y envía el resultado a los jugadores.
        """
        estado_j1 = self.jugador1.obtener_estado_equipo()
        estado_j2 = self.jugador2.obtener_estado_equipo()

        if estado_j1["vivos"] > estado_j2["vivos"]:
            self.jugador1.enviar_mensaje("¡Has ganado la partida!")
            self.jugador2.enviar_mensaje("¡Has perdido la partida!")
            return self.jugador1.nombre_usuario
        elif estado_j2["vivos"] > estado_j1["vivos"]:
            self.jugador1.enviar_mensaje("¡Has perdido la partida!")
            self.jugador2.enviar_mensaje("¡Has ganado la partida!")
            return self.jugador2.nombre_usuario
        else:
            self.jugador1.enviar_mensaje("¡La partida ha terminado en empate!")
            self.jugador2.enviar_mensaje("¡La partida ha terminado en empate!")
            return None  # Empate
