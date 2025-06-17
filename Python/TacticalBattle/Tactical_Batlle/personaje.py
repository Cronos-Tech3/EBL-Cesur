from jugador import Personaje
import random
from utils import validar_celda

class Medico(Personaje):
    def __init__(self, equipo):
        super().__init__(vida_maxima=1, dano=0, equipo=equipo)
        self.habilidad_nombre = "Curar a un compañero"

    def mover(self, nueva_celda):
        self.posicion = nueva_celda

    def habilidad(self, oponente):
        objetivos_validos = [p for p in self.equipo if p.esta_vivo()]
        if not objetivos_validos:
            return None

        print("Selecciona el personaje a curar:")
        for i, personaje in enumerate(objetivos_validos):
            print(f"{i + 1}: {type(personaje).__name__} [{personaje.vida_actual}/{personaje.vida_maxima}]")

        while True:
            try:
                seleccion = int(input("Selecciona el personaje a curar: ")) - 1
                if 0 <= seleccion < len(objetivos_validos):
                    break
                else:
                    print("Selección no válida. Inténtalo de nuevo.")
            except ValueError:
                print("Entrada no válida. Introduce un número.")

        personaje_a_curar = objetivos_validos[seleccion]
        personaje_a_curar.vida_actual = personaje_a_curar.vida_maxima
        print(f"{type(personaje_a_curar).__name__} curado.")
        self.enfriamiento_restante = 2
        return None

class Artillero(Personaje):
    def __init__(self, equipo):
        super().__init__(vida_maxima=2, dano=1, equipo=equipo)
        self.habilidad_nombre = "Disparar en área (2x2)"

    def mover(self, nueva_celda):
        self.posicion = nueva_celda

    def habilidad(self, oponente):
        while True:
            celda_objetivo = input("Indica las coordenadas de la esquina superior izquierda en la que disparar (área 2x2): ").upper()
            if not validar_celda(celda_objetivo, 4, 4):  # Asumiendo tablero de 4x4
                print("Celda no válida.")
                continue
            break

        codigo_accion = "A" + celda_objetivo
        self.enfriamiento_restante = 2
        return codigo_accion

class Francotirador(Personaje):
    def __init__(self, equipo):
        super().__init__(vida_maxima=3, dano=3, equipo=equipo)
        self.habilidad_nombre = "Disparar a una celda"

    def mover(self, nueva_celda):
        self.posicion = nueva_celda

    def habilidad(self, oponente):
        while True:
            celda_objetivo = input("Indica las coordenadas de la celda a la que disparar: ").upper()
            if not validar_celda(celda_objetivo, 4, 4):  # Asumiendo tablero de 4x4
                print("Celda no válida.")
                continue
            break

        codigo_accion = "F" + celda_objetivo
        self.enfriamiento_restante = 2
        return codigo_accion

class Inteligencia(Personaje):
    def __init__(self, equipo):
        super().__init__(vida_maxima=2, dano=0, equipo=equipo)
        self.habilidad_nombre = "Revelar a los enemigos en un área 2x2"

    def mover(self, nueva_celda):
        self.posicion = nueva_celda

    def habilidad(self, oponente):
        while True:
            celda_objetivo = input("Indica las coordenadas de la esquina superior izquierda de la zona de observación (área 2x2): ").upper()
            if not validar_celda(celda_objetivo, 4, 4):  # Asumiendo tablero de 4x4
                print("Celda no válida.")
                continue
            break

        codigo_accion = "I" + celda_objetivo
        self.enfriamiento_restante = 2
        return codigo_accion