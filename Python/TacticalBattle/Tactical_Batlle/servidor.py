import socket
import threading
import time
from cola import Cola
from partida import Partida, JugadorRemoto
from lista_doblemente_enlazada import ListaDoblementeEnlazada

class Servidor:
    """
    Gestiona las conexiones de los clientes, el emparejamiento y las partidas.
    """
    def __init__(self, host, puerto, max_partidas, fichero_ranking):
        self.host = host
        self.puerto = puerto
        self.max_partidas = max_partidas
        self.fichero_ranking = fichero_ranking
        self.cola_espera = Cola()
        self.partidas_en_curso = 0
        self.lock_partidas = threading.Lock()
        self.ranking = ListaDoblementeEnlazada()
        self.cargar_ranking()

        self.socket_servidor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.socket_servidor.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1) #Permite reusar la dirección
        self.socket_servidor.bind((self.host, self.puerto))
        self.socket_servidor.listen(5) #Máximo de conexiones en cola

    def cargar_ranking(self):
        """
        Carga el ranking desde el fichero.
        """
        try:
            with open(self.fichero_ranking, 'r') as f:
                for linea in f:
                    usuario, puntuacion = linea.strip().split(',')
                    self.ranking.insertar_ordenado(usuario, int(puntuacion))
        except FileNotFoundError:
            print("Fichero de ranking no encontrado. Se creará uno nuevo.")

    def guardar_ranking(self):
        """
        Guarda el ranking en el fichero.
        """
        with open(self.fichero_ranking, 'w') as f:
            for usuario, puntuacion in self.ranking.obtener_ranking():
                f.write(f"{usuario},{puntuacion}\n")

    def esperar_conexion(self):
        """
        Acepta conexiones de clientes y los añade a la cola o los empareja.
        """
        print(f"Servidor escuchando en {self.host}:{self.puerto}")
        while True:
            socket_cliente, direccion_cliente = self.socket_servidor.accept()
            print(f"Nueva conexión desde {direccion_cliente}")
            threading.Thread(target=self.gestionar_cliente, args=(socket_cliente,)).start()

    def gestionar_cliente(self, socket_cliente):
        """
        Gestiona la comunicación con un cliente.
        """
        try:
            nombre_usuario = socket_cliente.recv(1024).decode('utf-8')
            print(f"Cliente conectado: {nombre_usuario}")

            with self.lock_partidas:
                if self.partidas_en_curso < self.max_partidas:
                    jugador1 = JugadorRemoto(self.cola_espera.desencolar(), self.cola_espera.desencolar().nombre_usuario) if not self.cola_espera.esta_vacia() else JugadorRemoto(socket_cliente, nombre_usuario)
                    if jugador1.socket_cliente != socket_cliente:
                        jugador2 = JugadorRemoto(socket_cliente, nombre_usuario)
                        self.partidas_en_curso += 1
                        partida = Partida(jugador1, jugador2)
                        threading.Thread(target=partida.jugar).start()
                    else:
                        self.cola_espera.encolar(jugador1)
                        self.cola_espera.encolar(JugadorRemoto(socket_cliente, nombre_usuario))
                else:
                    self.cola_espera.encolar(JugadorRemoto(socket_cliente, nombre_usuario))
                    socket_cliente.send("Servidor lleno. Esperando en la cola...".encode('utf-8'))

        except (ConnectionResetError, ConnectionAbortedError):
            print("Cliente desconectado inesperadamente.")
        finally:
            socket_cliente.close()

def main():
    host = '127.0.0.1'  # localhost
    puerto = int(input("Introduce el puerto: "))
    max_partidas = int(input("Introduce el número máximo de partidas simultáneas: "))
    fichero_ranking = input("Introduce el nombre del fichero del ranking: ")

    servidor = Servidor(host, puerto, max_partidas, fichero_ranking)
    servidor.esperar_conexion()

if __name__ == "__main__":
    main()