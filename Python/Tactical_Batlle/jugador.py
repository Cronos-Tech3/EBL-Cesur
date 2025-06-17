from abc import ABC, abstractmethod
import random
from utils import validar_celda, comprobar_celda_disponible, validar_celda_contigua

class Personaje(ABC):
    """
    Clase base abstracta para todos los personajes.
    """
    def __init__(self, vida_maxima, dano, equipo):
        self.vida_maxima = vida_maxima
        self.vida_actual = vida_maxima
        self.dano = dano
        self.posicion = None
        self.enfriamiento_restante = 0
        self.equipo = equipo

    @abstractmethod
    def mover(self, nueva_celda):
        """Mueve al personaje a una nueva celda."""
        pass

    @abstractmethod
    def habilidad(self, oponente):
        """Ejecuta la habilidad especial del personaje."""
        pass

    def esta_vivo(self):
        return self.vida_actual > 0

class Jugador:
    """
    Representa a un jugador en el juego.
    """
    def __init__(self):
        self.oponente = None
        self.equipo = []
        self.informe = ""
        self.crear_equipo()
        self.posicionar_equipo()

    def set_oponente(self, oponente):
        self.oponente = oponente

    def crear_equipo(self):
        """Crea los miembros del equipo."""
        pass  # Implementación en las subclases

    def posicionar_equipo(self):
        """
        Permite al jugador posicionar a su equipo en el tablero.
        """
        letras_columnas = ['A', 'B', 'C', 'D']
        max_col = len(letras_columnas)
        max_fila = 4
        ocupadas = []

        for personaje in self.equipo:
            while True:
                print(f"Indica la celda (A-D, 1-4. p.ej: B2) en la que posicionar al {type(personaje).__name__}:")
                celda = input().upper()
                if not validar_celda(celda, max_col, max_fila):
                    print("¡Ups... valor de celda incorrecto!")
                    continue
                if not comprobar_celda_disponible(celda, ocupadas):
                    print("¡Ups... la celda ya está ocupada!")
                    continue
                personaje.posicion = celda
                ocupadas.append(celda)
                break
        print("Posicionamiento terminado")

    def turno(self):
        """
        Gestiona el turno de un jugador.

        Returns:
            bool: True si el juego ha terminado, False en caso contrario.
        """
        print("\n--- SITUACION DEL EQUIPO ---")
        for personaje in self.equipo:
            print(f"{type(personaje).__name__} está en {personaje.posicion} [Vida {personaje.vida_actual}/{personaje.vida_maxima}]")

        acciones = self.obtener_acciones_disponibles()
        for i, accion in enumerate(acciones):
            print(f"{i + 1}: {accion}")

        while True:
            try:
                seleccion = int(input("Selecciona la acción de este turno: ")) - 1
                if 0 <= seleccion < len(acciones):
                    break
                else:
                    print("Acción no válida. Inténtalo de nuevo.")
            except ValueError:
                print("Entrada no válida. Introduce un número.")

        codigo_accion = self.ejecutar_accion(seleccion, acciones)
        if codigo_accion:
            resultado = self.oponente.recibir_accion(codigo_accion)
            if resultado:
                print("\n--- RESULTADO DE LA ACCIÓN ---")
                print(resultado["informe"])
                return resultado.get("fin_partida", False)
        return False

    def obtener_acciones_disponibles(self):
        """
        Obtiene las acciones disponibles para los personajes del jugador.

        Returns:
            list: Una lista de cadenas que representan las acciones disponibles.
        """
        acciones = []
        for personaje in self.equipo:
            if not personaje.esta_vivo():
                continue
            acciones.append(f"Mover ({type(personaje).__name__})")
            if personaje.enfriamiento_restante == 0:
                acciones.append(f"{personaje.habilidad_nombre} ({type(personaje).__name__})")
        return acciones

    def ejecutar_accion(self, seleccion, acciones):
        """
        Ejecuta la acción seleccionada.

        Args:
            seleccion (int): El índice de la acción seleccionada.
            acciones (list): La lista de acciones disponibles.

        Returns:
            str: El código de la acción, o None si no se genera ningún código.
        """
        personaje_index = seleccion // 2
        personaje = self.equipo[personaje_index]
        accion_index = seleccion % 2

        if "Mover" in acciones[seleccion]:
            while True:
                nueva_celda = input(f"Indica la celda a la que mover al {type(personaje).__name__} (Posición actual: {personaje.posicion}): ").upper()
                if not validar_celda(nueva_celda, 4, 4):  # Asumiendo tablero de 4x4
                    print("Celda no válida.")
                    continue
                ocupadas = [p.posicion for p in self.equipo] + [p.posicion for p in self.oponente.equipo]
                ocupadas.remove(personaje.posicion)
                if not comprobar_celda_disponible(nueva_celda, ocupadas):
                    print("¡Ups... la celda ya está ocupada!")
                    continue
                if not validar_celda_contigua(personaje.posicion, nueva_celda):
                    print("Celda no contigua. Elige una celda adyacente.")
                    continue
                personaje.mover(nueva_celda)
                return None
        else:
            return personaje.habilidad(self.oponente)

    def recibir_accion(self, codigo_accion):
        """
        Gestiona la acción del oponente.

        Args:
            codigo_accion (str): El código de la acción del oponente.

        Returns:
            dict: El resultado de la acción.
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

    def obtener_estado_equipo(self):
        """
        Obtiene información sobre el estado del equipo (personajes vivos).

        Returns:
            dict: Un diccionario con el número de personajes vivos y eliminados.
        """
        vivos = sum(1 for p in self.equipo if p.esta_vivo())
        eliminados = len(self.equipo) - vivos
        return {"vivos": vivos, "eliminados": eliminados}