package Juego;

import Users.Player;
import Preguntas.Pregunta;
import Preguntas.Opcion;
import Ficheros.GestionaFicheros;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TrivialJuego {
    private Player jugador;

    public TrivialJuego(Player jugador) {
        this.jugador = jugador;
    }

    public void jugar() {
        Partida partida = new Partida(jugador);
        ArrayList<Pregunta> preguntas = GestionaFicheros.cargaPreguntas();
        Collections.shuffle(preguntas);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5 && i < preguntas.size(); i++) {
            Pregunta pregunta = preguntas.get(i);
            System.out.println(pregunta.getEnunciado());
            ArrayList<Opcion> opciones = new ArrayList<>(pregunta.getOpciones());
            Collections.shuffle(opciones);

            char opcionLetra = 'A';
            for (Opcion opcion : opciones) {
                System.out.println(opcionLetra + ": " + opcion.getTexto());
                opcionLetra++;
            }

            System.out.print("Tu respuesta: ");
            char respuesta = scanner.nextLine().toUpperCase().charAt(0);
            int indiceRespuesta = respuesta - 'A';

            if (indiceRespuesta >= 0 && indiceRespuesta < opciones.size() && opciones.get(indiceRespuesta).esCorrecta()) {
                System.out.println("¡Correcto!");
                partida.sumarPunto();
            } else {
                System.out.println("Incorrecto. La respuesta correcta era: " + opciones.get(0).getTexto());
            }
        }

        System.out.println("Puntuación final: " + partida.getPuntuacion());
        GestionaFicheros.guardaPartida(partida);
    }
}