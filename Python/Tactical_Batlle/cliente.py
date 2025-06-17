import socket
import threading

#@author Juan José Tornero Dato
#@author David López Acosta
#@author Enrique Benito López

class Cliente:
    """
    Gestiona la comunicación con el servidor desde el lado del cliente.
    """
    def __init__(self, host, puerto):
        self.host = host
        self.puerto = puerto
        self.socket_cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.nombre_usuario = None

    def conectar(self):
        """
        Establece la conexión con el servidor.
        """
        try:
            self.socket_cliente.connect((self.host, self.puerto))
            self.nombre_usuario = input("Introduce tu nombre de usuario: ")
            self.socket_cliente.send(self.nombre_usuario.encode('utf-8'))
            threading.Thread(target=self.recibir_mensajes, args=()).start()
            self.enviar_mensajes()
        except socket.error as e:
            print(f"Error al conectar con el servidor: {e}")

    def recibir_mensajes(self):
        """
        Recibe mensajes del servidor y los muestra en la consola.
        """
        try:
            while True:
                mensaje = self.socket_cliente.recv(1024).decode('utf-8')
                if mensaje == "FIN_TURNO":
                    input("Pulsa intro para continuar")
                else:
                    print(mensaje)
        except (ConnectionResetError, ConnectionAbortedError):
            print("Conexión con el servidor perdida.")
        finally:
            self.socket_cliente.close()

    def enviar_mensajes(self):
        """
        Envía mensajes al servidor (acciones del jugador).
        """
        try:
            while True:
                mensaje = input()
                self.socket_cliente.send(mensaje.encode('utf-8'))
        except (BrokenPipeError, ConnectionResetError):
            print("Error al enviar mensaje al servidor.")
        finally:
            self.socket_cliente.close()

def main():
    host = input("Introduce la IP del servidor: ")
    puerto = int(input("Introduce el puerto del servidor: "))
    cliente = Cliente(host, puerto)
    cliente.conectar()

if __name__ == "__main__":
    main()