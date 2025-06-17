package JAVA_APUNTES.Proyect_GAMES.CriticGames;
/**
 * @author Nicolas Vega Rojas
 * @author David López Acosta
 */

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RPGtest01 {

    public static void main(String[] args) {

        /*declaramos todas la variables*/

        int playerHP, playerATTACK, playerDEFENSE, playerSPEED, playerSPECIAL, playerCRITIC, playerFINISHER;

        int enemyHP, enemyATTACK, enemyDEFENSE, enemySPEED, enemySPECIAL, enemyCRITIC, enemyFINISHER;

        final int enemyHPinicial;

        int select;

        int turn = 1, turncritic = 1;

        int ataqueCALCULO = 0, defensaCALCULO, criticoCALCULO = 0, curar;

        int CLASEplayer;

        boolean esPrimo, defendPLAYER = false, defendENEMY = false, mageSPECIAL = false, knightSPECIAL = false, archerSPECIAL = false;

        String rojo = "\033[31m";
        String reset = "\033[0m";
        String amarillo = "\033[33m";
        String verde = "\033[32m";
        String morado = "\033[35m";
        String azul = "\033[34m";
        String Cyan= "\033[36m";

        String Clase = amarillo + "*************************\n" + //menú de elección de tipo de personaje
                "1. Mago    2. Caballero\n" +
                "3. Arquero\n" +
                "*************************" + reset;

        String spriteMAGE = morado + "      ,/   *\n" + //string para contener el avatar del mago
                "      _,'/_   |\n" +
                "      `(\")' ,'/\n" +
                "   _ _,-H-./ /\n" +
                "   \\_\\_\\.   /\n" +
                "     )\" |  (\n" +
                "  __/   H   \\__\n" +
                "  \\    /|\\    /\n" +
                "   `--'|||`--'\n" +
                "      ==^==" + reset;

        String spriteKNIGHT = Cyan + "   \n" +  //string para contener el avatar del caballero
                "      .-.\n" +
                "    __|=|__\n" +
                "   (_/`-`\\_)\n" +
                "   //\\___/\\\\\n" +
                "   <>/   \\<>\n" +
                "    \\|_._|/\n" +
                "     <_I_>\n" +
                "      |||\n" +
                "     /_|_\\" + reset;

        String spriteARCHER = verde + "     \n" +  //string para contener el avatar del arquro
                "           /   :.    \n" +
                "          /     \\\\  \n" +
                "       ,;/,      ::   \n" +
                "   ___:c/.(      ||   \n" +
                " ,'  _|:)>>>--,-'B)>  \n" +
                "(  '---'\\--'` _,'||  \n" +
                " `--.    \\ ,-'   ;;  \n" +
                "     |    \\|    //   \n" +
                "     |     \\   ;'  \n" +
                "     |_____|\\,'  \n" +
                "     :     :    \n" +
                "     |  ,  |   \n" +
                "     | : \\ :  \n" +
                "     | | : :   \n" +
                "     | | | |   \n" +
                "     | | |_`.  \n" +
                "     '--` " + reset;

        String spriteENEMY = rojo + " ,    ,    /\\   /\\\n" +  //string para contener el avatar del enemigo
                "  /( /\\ )\\  _\\ \\_/ /_\n" +
                "  |\\_||_/| < \\_   _/ >\n" +
                "  \\______/  \\|0   0|/\n" +
                "    _\\/_   _(_  ^  _)_\n" +
                "   ( () ) /`\\|V\"\"\"V|/`\\\n" +
                "     {}   \\  \\_____/  /\n" +
                "     ()   /\\   )=(   /\\\n" +
                "     {}  /  \\_/\\=/\\_/  \\" + reset;

        String MAINchar;

        String menuCOMBAT = amarillo + "**********************\n" +   //menú de elección de acción de combate
               "1. Atacar    2. Defenderse\n" +
                "3. Habilidad especial\n" +
                "4. Ataque potente\n" +
                "**********************" + reset;

        String life = azul + "<3" + reset;  //string para contener la representación de la barra de vida con corazones

        Scanner ch = new Scanner(System.in);



        //SELECCION DE CLASE
        while (true) {

            System.out.println("Selecciona tu clase \n" +
                    Clase);

            while (true) {

                try {
                    select = ch.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("...Pon un número del 1 al 3 anda");
                    ch.nextLine();
                }

            }

            //atributos del mago
            if (select == 1) {
                MAINchar = spriteMAGE;
                System.out.println(morado + "Has seleccionado al mago!" + reset);
                System.out.println(MAINchar);
                playerHP = 20;
                playerSPECIAL = 2; //*2 ataque
                playerATTACK = 7;
                playerDEFENSE = 3;
                playerSPEED = 4;
                playerCRITIC = 5;
                playerFINISHER = (int) (Math.random() * 15) + 9;
                CLASEplayer = 1;



                break;
            }

            //atributos del caballero
            if (select == 2) {
                MAINchar = spriteKNIGHT;
                System.out.println(Cyan + "Has elegido caballero" + reset);
                System.out.println(MAINchar);
                playerHP = 40;
                playerATTACK = 4;
                playerDEFENSE = 7;
                playerSPEED = 3;
                playerCRITIC = 10;
                playerSPECIAL = 2; // *2 defensa
                playerFINISHER = (int) (Math.random() * 11) + 8;
                CLASEplayer = 2;

                break;
            }

            //atributos del arquero
            if (select == 3) {
                MAINchar = spriteARCHER;
                System.out.println(verde + "Has seleccionado al arquero!" + reset);
                System.out.println(MAINchar);
                playerHP = 30;
                playerATTACK = 5;
                playerDEFENSE = 4;
                playerSPEED = 6;
                playerCRITIC = 20;
                playerSPECIAL = 5; //*5 critico 5*20=100
                playerFINISHER = (int) (Math.random() * 12) + 9;
                CLASEplayer = 3;

                break;

            } else {
                continue;
            }


        }

        //se generan atributos del enemigo
        enemyHP = (int) (Math.random() * 46) + 15;
        enemyHPinicial = enemyHP;
        enemySPECIAL = 20; //se cura un 20% de la vida
        enemyATTACK = (int) (Math.random() * 8) + 2;
        enemyDEFENSE = (int) (Math.random() * 10) + 3;
        enemySPEED = (int) (Math.random() * 9) + 2;
        enemyFINISHER = (int) (Math.random() * 13) + 9;
        enemyCRITIC = (int) (Math.random() * 22) + 4;

        do { //input del usuario para iniciar el combate

            System.out.println(amarillo + "Presiona 1 cuando estes listo para el combate!" + reset);
            while (true) {
                try { //try-catch para evitar que el programa se rompa al introducir una letra cuando se pide un número
                    select = ch.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("...Pon un número válido");
                    ch.nextLine();
                }
            }

        } while (select != 1);  //presentamos al enemigo
        System.out.println(rojo + "¡¡Te has topado con un enemigo!!" + reset);
        System.out.println(spriteENEMY);

        //inicio del combate
        while (playerHP > 0 && enemyHP > 0) {

            if (playerSPEED >= enemySPEED) { /*primer if principal dentro del while es para el caso en el que el jugador es más rápido que el enemigo*/
                System.out.println();
                System.out.println("Elige una acción \n" +
                        menuCOMBAT);

                    while (true) { //try-catch para evitar que el programa se rompa al introducir una letra cuando se pide un número

                        try {
                            select = ch.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("...Pon un número válido");
                            ch.nextLine();
                        }

                    }


                ataqueCALCULO = 0;

                //empieza el turno del jugador que elige una acción de combate: 1:ataque, 2:defensa, 3:habilidad especial, 4:finisher

                if (select == 1) {
                    //ataque

                    criticoCALCULO = (int) (Math.random() * 101); //se genera la posibilidad de que se produzca un golpe crítico basado en la estadística de playerCRITIC

                    System.out.printf("Atacas al enemigo!");

                    if (mageSPECIAL == true) {
                        ataqueCALCULO = playerATTACK * playerSPECIAL;

                        if (criticoCALCULO < playerCRITIC) {
                            ataqueCALCULO *= 3;
                            System.out.println("Tu ataque ha sido crítico");
                        }

                        System.out.println("Lanzas tu hechizo especial!");

                        if (defendENEMY == true) {

                            System.out.println("El enemigo tenia su defensa preparada!");

                            ataqueCALCULO -= enemyDEFENSE;

                            defendENEMY = false;

                        }

                        //se produce el cálculo de daño y recálculo de vida

                        if (ataqueCALCULO < 0) {  //con este if evitamos que los golpes curen cuando la defensa es muy alta (daño negativo)
                            ataqueCALCULO=0;
                        }

                        System.out.println(enemyHP);

                        System.out.println("Haces " + ataqueCALCULO + " de daño al enemigo!");

                        enemyHP -= ataqueCALCULO;

                        System.out.println(enemyHP);
                        for (int i = 1; i <= enemyHP ; i++) {
                            System.out.print(life);
                        }

                        //mostramos al usuario la barra de vida actualizada


                        mageSPECIAL = false;
                    } else if (archerSPECIAL == true) {

                        ataqueCALCULO = playerATTACK * 3;

                        System.out.println("Tu ataque especial asegura un golpe Critico!!");

                        if (defendENEMY == true) {

                            System.out.println("El enemigo tenia su defensa preparada!");

                            ataqueCALCULO -= enemyDEFENSE;

                            defendENEMY = false;

                        }

                        if (ataqueCALCULO < 0) {
                            ataqueCALCULO=0;
                        }

                        System.out.println(enemyHP);  //cálculo de daño

                        System.out.println("Haces " + ataqueCALCULO + " de daño al enemigo!");

                        enemyHP -= ataqueCALCULO;

                        System.out.println(enemyHP);
                        for (int i = 1; i <= enemyHP ; i++) {
                            System.out.print(life);
                        }

                        archerSPECIAL = false;
                    } else if (criticoCALCULO < playerCRITIC) {

                        ataqueCALCULO = playerATTACK * 3;
                        System.out.println("Tu ataque ha sido crítico");

                        if (defendENEMY == true) {

                            System.out.println("El enemigo tenia su defensa preparada!");

                            ataqueCALCULO -= enemyDEFENSE;

                            defendENEMY = false;

                        }

                        if (ataqueCALCULO < 0) {
                            ataqueCALCULO=0;
                        }

                        System.out.println("Vida enemigo: " + enemyHP);

                        System.out.println("Haces " + ataqueCALCULO + " de daño al enemigo!");

                        enemyHP -= ataqueCALCULO;

                        System.out.println(enemyHP);
                        for (int i = 1; i <= enemyHP ; i++) {   //actualización de la barra de vida (aumento o reducción de corazones)
                            System.out.print(life);
                        }


                    } else {

                        ataqueCALCULO = playerATTACK;

                        if (defendPLAYER == true) {

                            System.out.println("El enemigo tenia su defensa preparada!");

                            ataqueCALCULO -= enemyDEFENSE;

                        }

                        if (ataqueCALCULO < 0) {
                            ataqueCALCULO=0;
                        }

                        System.out.println(enemyHP);

                        System.out.println("Haces " + ataqueCALCULO + " de daño al enemigo!");

                        enemyHP -= ataqueCALCULO;

                        System.out.println(enemyHP);
                        for (int i = 1; i <= enemyHP ; i++) {
                            System.out.print(life);
                        }
                    }


                } else if (select == 2) {
                    //defensa

                    System.out.println("Preparas tus defensas!");
                    if (knightSPECIAL == true) {
                        defensaCALCULO = playerDEFENSE * playerSPECIAL;
                    }

                    defendPLAYER = true;

                } else if (select == 3) {
                    //activa habilidad especial diferente para cada personaje
                    if (CLASEplayer == 1) {
                        System.out.printf("Usas tu magia para potenciar tu siguiente ataque! (x2)");
                        mageSPECIAL = true;

                    } else if (CLASEplayer == 2) {
                        System.out.println("Adoptas una postura de guardia que aumenta tu defensa para el próximo turno (x2)");
                        knightSPECIAL = true;


                    } else if (CLASEplayer == 3) {
                        System.out.println("Tu puntería será perfecta el próximo turno (crítico 100%)");
                        archerSPECIAL = true;
                    }


                } else if (select == 4) {
                    //Ataque más potente generado aleatoriamente dentro de un rango propio de cada personaje
                    criticoCALCULO = (int) (Math.random() * 101);

                    System.out.println("Atacas con tu finisher!");

                    ataqueCALCULO = playerFINISHER;

                    if (criticoCALCULO < playerCRITIC) {
                        ataqueCALCULO *= 3;
                        System.out.println("Tu ataque ha sido crítico");
                    }

                    if (defendENEMY == true) {

                        System.out.println("El enemigo tenia su defensa preparada!");

                        ataqueCALCULO -= enemyDEFENSE;

                        defendENEMY = false;

                    }

                    if (ataqueCALCULO < 0) {
                        ataqueCALCULO=0;
                    }

                    System.out.println(enemyHP);

                    System.out.println("Haces " + ataqueCALCULO + " de daño al enemigo!");

                    enemyHP -= ataqueCALCULO;

                    System.out.println(enemyHP);

                    for (int i = 1; i <= enemyHP ; i++) {
                        System.out.print(life);
                    }


                }



                if (playerHP < 1 || enemyHP < 1) {

                    break; //se acaba el combate si alguno muere
                }
                System.out.println();
                System.out.println("El enemigo se prepara...");


                //turno enemigo

                if (enemyHP <= (enemyHPinicial * 0.15)) {

                    System.out.println("El enemigo se enfurece!!");
                    //El enemigo entra en fase 2 y sigue un patrón nuevo: curar, bloqueo/ataque, finisher

                    if (turncritic == 1) {

                        System.out.println("¡¡El enemigo se cura!! (+20% HP)");

                        enemyHP = (int) (enemyHP + (enemyHPinicial * 0.20));

                        System.out.println(enemyHP);    //recálculo de corazones
                        for (int i = 1; i <= enemyHP ; i++) {
                            System.out.print(life);
                        }

                        turncritic = 2;
                    }

                    else if (turncritic == 2) {

                        int critic50 = (int) (Math.random() * 101);
                        //probabilidad de bloqueo o ataque

                        if (critic50 >= 50) {
                            System.out.println("¡El enemigo prepara su defensa!");

                            defendENEMY = true;

                            turncritic = 3;

                        }
                        else if (critic50 < 50) {

                            criticoCALCULO = (int) (Math.random() * 101);

                            ataqueCALCULO = enemyATTACK;

                            System.out.println("El enemigo ataca!");

                            if (criticoCALCULO < enemyCRITIC) {
                                System.out.println("ES UN GOLPE CRITICO!");

                                ataqueCALCULO *= 3;

                            }


                            if (defendPLAYER == true) {

                                System.out.println("Te defiendes!");

                                ataqueCALCULO -= playerDEFENSE;

                                if (knightSPECIAL == true) {

                                    System.out.println("La defensa del caballero se activa");

                                    ataqueCALCULO -= playerDEFENSE;

                                    knightSPECIAL = false;
                                }

                                //calculo HP
                                defendPLAYER = false;


                            }

                            if (ataqueCALCULO < 0) {
                                ataqueCALCULO=0;
                            }

                            System.out.println(playerHP);

                            System.out.println("pierdes " + ataqueCALCULO + " puntos de vida!");

                            System.out.println(playerHP);
                            for (int i = 1; i <= playerHP ; i++) {
                                System.out.print(life);
                            }


                            turncritic = 3; //asignamos el valor del siguiente turno para que se cumpla la secuencia del patrón de fase 2

                        }

                    }
                    else if (turncritic == 3) {
                        //El enemigo usa un ataque potente (finisher)

                        criticoCALCULO = (int) (Math.random() * 101);

                        System.out.println("El enemigo usa todo su poder para atacarte");

                        ataqueCALCULO = enemyFINISHER;

                        if (criticoCALCULO < enemyCRITIC) {
                            System.out.println("ES UN GOLPE CRITICO!");

                            ataqueCALCULO *= 3;

                        }

                        if (defendPLAYER == true) {
                            System.out.println("Tenías tu defensa preparada!");

                            ataqueCALCULO -= playerDEFENSE;

                            defendPLAYER = false;


                            if (knightSPECIAL == true) {
                                System.out.println("Tu defensa especial de caballero se activa!");

                                ataqueCALCULO -= playerDEFENSE;

                                knightSPECIAL = false;

                            }


                        }

                        if (ataqueCALCULO < 0) {
                            ataqueCALCULO=0;
                        }

                        System.out.println(playerHP);

                        System.out.println("Pierdes " + ataqueCALCULO + " puntos de vida!");

                        playerHP -= ataqueCALCULO;

                        System.out.println(playerHP);
                        for (int i = 1; i <= playerHP ; i++) {
                            System.out.print(life);
                        }

                        turncritic = 1;
                    }


                } else if (enemyHP > (enemyHPinicial * 0.15)) { //enemigo en fase 1
                    //    Turnos nº primos ataque normal
                    //    Turnos pares no primos bloquea
                    //    Turnos impares no primos curar

                    if (GFG.isPrime(turn)) { //llamamos al método isPrime para determinar si el turno es un nº primo o no
                        //ataque normal

                        ataqueCALCULO = enemyATTACK;

                        System.out.println("El enemigo ataca normal!");

                        if (defendPLAYER == true) {

                            System.out.println("Tenias tu defensa preparada!");

                            ataqueCALCULO -= playerDEFENSE;

                            if (knightSPECIAL == true) {

                                System.out.printf("Tu defensa de caballero se activa!");

                                ataqueCALCULO -= playerDEFENSE;

                                knightSPECIAL = false;
                            }

                            defendPLAYER = false;
                        }

                        if (ataqueCALCULO < 0) {
                            ataqueCALCULO=0;
                        }

                        System.out.println(playerHP);

                        playerHP -= ataqueCALCULO;

                        System.out.println("Pierdes " + ataqueCALCULO + " puntos de vida!");

                        System.out.println(playerHP);
                        for (int i = 1; i <= playerHP ; i++) {
                            System.out.print(life);
                        }

                    }

                    else if (turn % 2 == 0 && turn > 2) {
                        //bloquea
                        System.out.println("El enemigo bloquea!");

                        defendENEMY = true;

                    } else if (turn % 2 != 0) {
                        //curar

                        System.out.println("¡¡El enemigo se cura normal!! (+20% HP)");

                        enemyHP = (int) (enemyHP + (enemyHPinicial * 0.20));

                        System.out.println(enemyHP);
                        for (int i = 1; i <= enemyHP ; i++) {
                            System.out.print(life);
                        }

                    }

                    turn++;

                }



            } else if (enemySPEED > playerSPEED) {  //misma secuencia pero para el caso en el que el enemigo sea más rápido que el jugador
                System.out.println();
                System.out.println("El enemigo es más rapido!");


                if (enemyHP <= (enemyHPinicial * 0.15)){

                    System.out.println("El enemigo se enfurece!!");
                    //curar, bloqueo/ataque, finisher

                    if (turncritic == 1) {

                        System.out.println("¡¡El enemigo se cura!! (+20% HP)");

                        enemyHP = (int) (enemyHP + (enemyHPinicial * 0.20));

                        System.out.println(enemyHP);
                        for (int i = 1; i <= enemyHP ; i++) {
                            System.out.print(life);
                        }

                        turncritic = 2;
                    }

                    else if (turncritic == 2) {

                        int critic50 = (int) (Math.random() * 100);
                        //probabilidad de bloque o ataque

                        if (critic50 >= 50) {
                            System.out.println("¡El enemigo prepara su defensa!");

                            defendENEMY = true;

                            turncritic = 3;

                        }
                        else if (critic50 < 50) {

                            criticoCALCULO = (int) (Math.random() * 101);

                            ataqueCALCULO = enemyATTACK;

                            System.out.println("El enemigo ataca!");

                            if (criticoCALCULO < enemyCRITIC) {
                                System.out.println("ES UN GOLPE CRITICO!");

                                ataqueCALCULO *= 3;

                            }


                            if (defendPLAYER == true) {

                                System.out.println("Te defiendes!");

                                ataqueCALCULO -= playerDEFENSE;

                                if (knightSPECIAL == true) {

                                    System.out.println("La defensa del caballero se activa");

                                    ataqueCALCULO -= playerDEFENSE;

                                    knightSPECIAL = false;
                                }

                                //calculo HP
                                defendPLAYER = false;


                            }

                            if (ataqueCALCULO < 0) {
                                ataqueCALCULO=0;
                            }

                            System.out.println(playerHP);

                            System.out.println("pierdes " + ataqueCALCULO + " puntos de vida!");

                            System.out.println(playerHP);
                            for (int i = 1; i <= playerHP ; i++) {
                                System.out.print(life);
                            }


                            turncritic = 3;

                        }

                    }
                    else if (turncritic == 3) {

                        criticoCALCULO = (int) (Math.random() * 101);

                        System.out.println("El enemigo usa todo su poder para atacarte");

                        ataqueCALCULO = enemyFINISHER;

                        if (criticoCALCULO < enemyCRITIC) {
                            System.out.println("ES UN GOLPE CRITICO!");

                            ataqueCALCULO *= 3;

                        }

                        if (defendPLAYER == true) {
                            System.out.println("Tenías tu defensa preparada!");

                            ataqueCALCULO -= playerDEFENSE;

                            defendPLAYER = false;


                            if (knightSPECIAL == true) {
                                System.out.println("Tu defensa especial de caballero se activa!");

                                ataqueCALCULO -= playerDEFENSE;

                                knightSPECIAL = false;

                            }


                        }

                        if (ataqueCALCULO < 0) {
                            ataqueCALCULO=0;
                        }

                        System.out.println(playerHP);

                        System.out.println("Pierdes " + ataqueCALCULO + " puntos de vida!");

                        playerHP -= ataqueCALCULO;

                        System.out.println(playerHP);
                        for (int i = 1; i <= playerHP ; i++) {
                            System.out.print(life);
                        }

                        turncritic = 1;
                    }


                } else if (enemyHP > (enemyHPinicial * 0.15)) {
                    //    Turnos nº primos ataque normal
                    //    Turnos pares no primos bloquea
                    //    Turnos impares no primos curar

                    if (GFG.isPrime(turn)) {
                        //ataque normal

                        ataqueCALCULO = enemyATTACK;

                        System.out.println("El enemigo ataca normal!");

                        if (defendPLAYER == true) {

                            System.out.println("Tenias tu defensa preparada!");

                            ataqueCALCULO -= playerDEFENSE;

                            if (knightSPECIAL == true) {

                                System.out.println("Tu defensa de caballero se activa!");

                                ataqueCALCULO -= playerDEFENSE;

                                knightSPECIAL = false;
                            }

                            defendPLAYER = false;
                        }

                        if (ataqueCALCULO < 0) {
                            ataqueCALCULO=0;
                        }

                        System.out.println(playerHP);

                        playerHP -= ataqueCALCULO;

                        System.out.println("Pierdes " + ataqueCALCULO + " puntos de vida!");

                        System.out.println(playerHP);
                        for (int i = 1; i <= playerHP ; i++) {
                            System.out.print(life);
                        }

                    }

                    else if (turn % 2 == 0 && turn >= 3) {
                        //bloquea
                        System.out.println("El enemigo bloquea!");

                        defendENEMY = true;

                    } else if (turn % 2 != 0) {
                        //curar

                        System.out.println("¡¡El enemigo se cura normal!! (+20% HP)");

                        enemyHP = (int) (enemyHP + (enemyHPinicial * 0.20));

                        System.out.println(enemyHP);
                        for (int i = 1; i <= enemyHP ; i++) {
                            System.out.print(life);
                        }

                    }

                }



                if (playerHP < 1 || enemyHP < 1) {

                    break;
                }

                //turno jugador_____

                System.out.println();
                System.out.println("Te preparas...");


                System.out.println();
                System.out.println("Elige una acción \n" +
                        menuCOMBAT);
                while (true) {

                    try {  //try-catch para evitar que el programa se rompa al introducir una letra cuando se pide un número
                        select = ch.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("...Pon un número válido");
                        ch.nextLine();
                    }

                }

                ataqueCALCULO = 0;

                if (select == 1) {
                    //ataque

                    criticoCALCULO = (int) (Math.random() * 101);

                    System.out.printf("Atacas al enemigo!");

                    if (mageSPECIAL == true) {
                        ataqueCALCULO = playerATTACK * playerSPECIAL;

                        if (criticoCALCULO < playerCRITIC) {
                            ataqueCALCULO *= 3;
                            System.out.println("Tu ataque ha sido crítico");
                        }

                        System.out.println("Lanzas tu hechizo especial!");

                        if (defendENEMY == true) {

                            System.out.println();
                            System.out.println("El enemigo tenia su defensa preparada!");

                            ataqueCALCULO -= enemyDEFENSE;

                            defendENEMY = false;

                        }

                        if (ataqueCALCULO < 0) {
                            ataqueCALCULO=0;
                        }


                        System.out.println(enemyHP);

                        System.out.println("Haces " + ataqueCALCULO + " de daño al enemigo!");

                        enemyHP -= ataqueCALCULO;

                        System.out.println(enemyHP);
                        for (int i = 1; i <= enemyHP ; i++) {
                            System.out.print(life);
                        }

                        //añadir sprites HP


                        mageSPECIAL = false;
                    } else if (archerSPECIAL == true) {

                        ataqueCALCULO = playerATTACK * 3;

                        System.out.println("Tu ataque especial asegura un golpe Critico!!");

                        if (defendENEMY == true) {

                            System.out.println("El enemigo tenia su defensa preparada!");

                            ataqueCALCULO -= enemyDEFENSE;

                            defendENEMY = false;

                        }

                        if (ataqueCALCULO < 0) {
                            ataqueCALCULO=0;
                        }

                        System.out.println(enemyHP);

                        System.out.println("Haces " + ataqueCALCULO + " de daño al enemigo!");

                        enemyHP -= ataqueCALCULO;

                        System.out.println(enemyHP);
                        for (int i = 1; i <= enemyHP ; i++) {
                            System.out.print(life);
                        }

                        archerSPECIAL = false;
                    } else if (criticoCALCULO < playerCRITIC) {

                        ataqueCALCULO = playerATTACK * 3;
                        System.out.println("Tu ataque ha sido crítico");

                        if (defendENEMY == true) {

                            System.out.println("El enemigo tenia su defensa preparada!");

                            ataqueCALCULO -= enemyDEFENSE;

                            defendENEMY = false;

                        }

                        if (ataqueCALCULO < 0) {
                            ataqueCALCULO=0;
                        }

                        System.out.println("Vida enemigo: " + enemyHP);

                        System.out.println("Haces " + ataqueCALCULO + " de daño al enemigo!");

                        enemyHP -= ataqueCALCULO;

                        System.out.println(enemyHP);
                        for (int i = 1; i <= enemyHP ; i++) {
                            System.out.print(life);
                        }


                    } else {

                        ataqueCALCULO = playerATTACK;

                        if (defendENEMY == true) {

                            System.out.println("El enemigo tenia su defensa preparada!");

                            ataqueCALCULO -= enemyDEFENSE;

                            defendENEMY = false;

                        }

                        if (ataqueCALCULO < 0) {
                            ataqueCALCULO=0;
                        }

                        System.out.println(enemyHP);

                        System.out.println("Haces " + ataqueCALCULO + " de daño al enemigo!");

                        enemyHP -= ataqueCALCULO;

                        System.out.println(enemyHP);
                        for (int i = 1; i <= enemyHP ; i++) {
                            System.out.print(life);
                        }
                    }


                } else if (select == 2) {
                    //defensa

                    System.out.println("Preparas tus defensas!");
                    if (knightSPECIAL == true) {
                        defensaCALCULO = playerDEFENSE * playerSPECIAL;
                    }

                    defendPLAYER = true;

                } else if (select == 3) {
                    //especial
                    if (CLASEplayer == 1) {
                        System.out.printf("Usas tu magia para potenciar tu siguiente ataque! (x2)");
                        mageSPECIAL = true;

                    } else if (CLASEplayer == 2) {
                        System.out.println("Adoptas una postura de guardia que aumenta tu defensa para el próximo turno");
                        knightSPECIAL = true;


                    } else if (CLASEplayer == 3) {
                        System.out.println("Tu puntería será perfecta el próximo turno (crítico 100%)");
                        archerSPECIAL = true;
                    }


                } else if (select == 4) {
                    //finisher
                    criticoCALCULO = (int) (Math.random() * 101);

                    System.out.println("Atacas con tu finisher!");

                    ataqueCALCULO = playerFINISHER;

                    if (criticoCALCULO < playerCRITIC) {
                        ataqueCALCULO *= 3;
                        System.out.println("Tu ataque ha sido crítico!!");
                    }

                    if (defendENEMY == true) {

                        System.out.println("El enemigo tenia su defensa preparada!");

                        ataqueCALCULO -= enemyDEFENSE;

                        defendENEMY = false;

                    }

                    if (ataqueCALCULO < 0) {
                        ataqueCALCULO=0;
                    }

                    System.out.println(enemyHP);

                    System.out.println("Haces " + ataqueCALCULO + " de daño al enemigo!");

                    enemyHP -= ataqueCALCULO;

                    System.out.println(enemyHP);
                    for (int i = 1; i <= enemyHP ; i++) {
                        System.out.print(life);
                    }


                }

                turn++;


                if (playerHP < 1 || enemyHP < 1) {

                    break;


                }
            }


        }

        //Fuera del bucle de batalla

        System.out.println("¡Termina el combate!");

        if (playerHP < 1) {

            //sprite para el caso en el que el jugador pierda
            System.out.println( rojo + "Oooo...Has perdido \n" +
                    "    .o oOOOOOOOo                                            OOOo\n" +
                    "    Ob.OOOOOOOo  OOOo.      oOOo.                      .adOOOOOOO\n" +
                    "    OboO\"\"\"\"\"\"\"\"\"\"\"\".OOo. .oOOOOOo.    OOOo.oOOOOOo..\"\"\"\"\"\"\"\"\"'OO\n" +
                    "    OOP.oOOOOOOOOOOO \"POOOOOOOOOOOo.   `\"OOOOOOOOOP,OOOOOOOOOOOB'\n" +
                    "    `O'OOOO'     `OOOOo\"OOOOOOOOOOO` .adOOOOOOOOO\"oOOO'    `OOOOo\n" +
                    "    .OOOO'            `OOOOOOOOOOOOOOOOOOOOOOOOOO'            `OO\n" +
                    "    OOOOO                 '\"OOOOOOOOOOOOOOOO\"`                oOO\n" +
                    "   oOOOOOba.                .adOOOOOOOOOOba               .adOOOOo.\n" +
                    "  oOOOOOOOOOOOOOba.    .adOOOOOOOOOO@^OOOOOOOba.     .adOOOOOOOOOOOO\n" +
                    " OOOOOOOOOOOOOOOOO.OOOOOOOOOOOOOO\"`  '\"OOOOOOOOOOOOO.OOOOOOOOOOOOOO\n" +
                    " \"OOOO\"       \"YOoOOOOMOIONODOO\"`  .   '\"OOROAOPOEOOOoOY\"     \"OOO\"\n" +
                    "    Y           'OOOOOOOOOOOOOO: .oOOo. :OOOOOOOOOOO?'         :`\n" +
                    "    :            .oO%OOOOOOOOOOo.OOOOOO.oOOOOOOOOOOOO?         .\n" +
                    "    .            oOOP\"%OOOOOOOOoOOOOOOO?oOOOOO?OOOO\"OOo\n" +
                    "                 '%o  OOOO\"%OOOO%\"%OOOOO\"OOOOOO\"OOO':\n" +
                    "                      `$\"  `OOOO' `O\"Y ' `OOOO'  o             .\n" +
                    "    .                  .     OP\"          : o     .\n" +
                    "                              :\n" +
                    "                              .\n" + reset);
        } else if (enemyHP<1) { //sprite para el caso en el que el jugador gane
            System.out.println( amarillo + "¡¡Has ganado!! \n" +
                    "                                                                     \n" +
                    "            88                                                       \n" +
                    "            \"\"              ,d                                       \n" +
                    "                            88                                       \n" +
                    "8b       d8 88  ,adPPYba, MM88MMM ,adPPYba,  8b,dPPYba, 8b       d8  \n" +
                    "`8b     d8' 88 a8\"     \"\"   88   a8\"     \"8a 88P'   \"Y8 `8b     d8'  \n" +
                    " `8b   d8'  88 8b           88   8b       d8 88          `8b   d8'   \n" +
                    "  `8b,d8'   88 \"8a,   ,aa   88,  \"8a,   ,a8\" 88           `8b,d8'    \n" +
                    "    \"8\"     88  `\"Ybbd8\"'   \"Y888 `\"YbbdP\"'  88             Y88'     \n" +
                    "                                                            d8'      \n" +
                    "                                                           d8'       " + reset);


    }
}
    //método isPrime para calcular si los turnos son primos o no en el combate
    class GFG {
        static boolean isPrime(int n) {
            // Corner case
            if (n < 1)
                return false;

            if (n <= 2)
                return true;

            // Check from 2 to n-1
            for (int i = 2; i < n; i++)
                if (n % i == 0)
                    return false;

            return true;
        }
    }}