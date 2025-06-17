class Nodo:
    """
    Representa un nodo en la lista doblemente enlazada.
    """
    def __init__(self, usuario, puntuacion):
        self.usuario = usuario
        self.puntuacion = puntuacion
        self.siguiente = None
        self.anterior = None

class ListaDoblementeEnlazada:
    """
    Implementa una lista doblemente enlazada para el ranking.
    """
    def __init__(self):
        self.cabeza = None
        self.cola = None
        self.tamano = 0

    def insertar_ordenado(self, usuario, puntuacion):
        nuevo_nodo = Nodo(usuario, puntuacion)

        if not self.cabeza:
            self.cabeza = nuevo_nodo
            self.cola = nuevo_nodo
        elif puntuacion > self.cabeza.puntuacion:
            nuevo_nodo.siguiente = self.cabeza
            self.cabeza.anterior = nuevo_nodo
            self.cabeza = nuevo_nodo
        else:
            actual = self.cabeza
            while actual.siguiente and puntuacion <= actual.siguiente.puntuacion:
                actual = actual.siguiente
            nuevo_nodo.siguiente = actual.siguiente
            if actual.siguiente:
                actual.siguiente.anterior = nuevo_nodo
            nuevo_nodo.anterior = actual
            actual.siguiente = nuevo_nodo
            if not nuevo_nodo.siguiente:
                self.cola = nuevo_nodo
        self.tamano += 1

    def obtener_ranking(self):
        """
        Obtiene el ranking como una lista de tuplas (usuario, puntuacion).
        """
        ranking = []
        actual = self.cabeza
        while actual:
            ranking.append((actual.usuario, actual.puntuacion))
            actual = actual.siguiente
        return ranking

    def __str__(self):
        """
        Representación en cadena de la lista.
        """
        elementos = []
        actual = self.cabeza
        while actual:
            elementos.append(f"{actual.usuario}: {actual.puntuacion}")
            actual = actual.siguiente
        return ", ".join(elementos)