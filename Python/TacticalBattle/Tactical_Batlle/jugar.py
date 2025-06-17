from utils import limpiar_terminal
from jugador import Jugador
from personaje import Medico, Artillero, Francotirador, Inteligencia

class JugadorHumano(Jugador):
    def crear_equipo(self):
        self.equipo = [
            Medico(self.equipo),
            Artillero(self.equipo),
            Francotirador(self.equipo),
            Inteligencia(self.equipo)
        ]

def main():
    print('Bienvenidos a Tactical Battle\n')

    input('Turno del Jugador 1. Pulsa intro para comenzar')
    limpiar_terminal()
    j1 = JugadorHumano()

    input('Jugador 1, pulsa intro para terminar tu turno')
    limpiar_terminal()

    input('Turno del Jugador 2. Pulsa intro para comenzar')
    limpiar_terminal()
    j2 = JugadorHumano()

    input('Jugador 2, pulsa intro para terminar tu turno')
    limpiar_terminal()

    j1.set_oponente(j2)
    j2.set_oponente(j1)

    final = False

    while not final:
        input('Turno del Jugador 1. Pulsa intro para comenzar')
        final = j1.turno()

        if final:
            print("¡El Jugador 1 ha ganado la partida!")
            break
        input('Jugador 1, pulsa intro para terminar tu turno')
        limpiar_terminal()

        input('Turno del Jugador 2. Pulsa intro para comenzar')
        final = j2.turno()

        if final:
            print("¡El Jugador 2 ha ganado la partida!")
            break
        input('Jugador 2, pulsa intro para terminar tu turno')
        limpiar_terminal()

if __name__ == "__main__":
    main()
