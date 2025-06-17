package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej19_3Rondas_Piedra_Papel_Tijera {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aleatorio, numUser;
        int contadorRonda = 1, contadorUsuario = 0, contadorMaquina = 0;

        while(contadorRonda<=3){
            System.out.println("Ronda " + contadorRonda);
            //generar numero aleatorio 0-2
            aleatorio = (int) (Math.random()*3);
            //pedir opcion a usuario en forma de numero
            System.out.println("Inserta 0 piedra, 1 papel, 2 tijera");
            numUser = sc.nextInt();
            String palabraMaquina, palabraUser;

            switch (aleatorio){
                case 0:
                    palabraMaquina = "piedra";
                    break;
                case 1:
                    palabraMaquina = "papel";
                    break;
                case 2:
                    palabraMaquina = "tijera";
                    break;
                default:
                    palabraMaquina = "aaasdfg";
                    break;
            }

            switch (numUser){
                case 0:
                    palabraUser = "piedra";
                    break;
                case 1:
                    palabraUser = "papel";
                    break;
                case 2:
                    palabraUser = "tijera";
                    break;
                default:
                    palabraUser = "aaasdfg";
                    break;
            }

            System.out.println("La maquina ha elegido: " + palabraMaquina);
            System.out.println("Tu has escogido: " + palabraUser);

            //cuando empato -> cuando opcion y aleatorio sean iguales
            if(numUser==aleatorio){
                System.out.println("Empate!");
                contadorRonda--;
                //ganaré cuando el número del usuario sea: usuario 1 - maquina 0, usuario 2 - maquina 1, usuario 0 - maquina 2
            }else if((numUser == 1 && aleatorio == 0) ||
                    (numUser == 2 && aleatorio == 1) ||
                    (numUser == 0 && aleatorio == 2)){
                System.out.println("Has ganado!");
                contadorUsuario++; //sumar una victoria a mi contador
            }else{
                //perderé cuando el número del usuario sea: usuario 0 - maquina 1, usuario 1 - maquina 2, usuario 2 - maquina 0
                //perderé si no he ganado y no he empatado
                System.out.println("Has perdido!");
                contadorMaquina++; //sumar una victoria a la maquina
            }

            contadorRonda++;
        }

        System.out.println("Has ganado: " + contadorUsuario + " rondas");
        System.out.println("La maquina ha ganado: " + contadorMaquina + " rondas");


    }
}