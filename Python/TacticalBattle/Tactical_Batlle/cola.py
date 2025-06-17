from collections import deque
import threading

class Cola:
    """
    Implementa una cola segura para hilos.
    """
    def __init__(self):
        self.items = deque()
        self.lock = threading.Lock()

    def encolar(self, item):
        with self.lock:
            self.items.append(item)

    def desencolar(self):
        with self.lock:
            if self.items:
                return self.items.popleft()
            return None

    def esta_vacia(self):
        with self.lock:
            return len(self.items) == 0

    def tamano(self):
        with self.lock:
            return len(self.items)