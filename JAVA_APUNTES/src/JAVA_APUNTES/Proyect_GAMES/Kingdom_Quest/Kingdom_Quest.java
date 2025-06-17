import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author Pascual Quiles y Juan J. Tornero
 * @version 1.1
 *<p>Juego por turnos "Kingdom Quest", con eleccion de personaje y equipamiento, batallas infinitas cada vez mas dificiles
 * y estadisticas de puntuacion</p>
 */


public class Kingdom_Quest {

    //scanner static para poder usarlos en todos los metodos. scN-numeros scL strings
    static Scanner scN = new Scanner(System.in);
    static Scanner scL = new Scanner(System.in);

    //Estadisticas del jugador
    //idClase determina el sprite que se va a mostrar
    //la defensa es plana, es decir, al daño se le resta la defensa para calcular la perdida de vida
    //el critico es un aditivo a un numero entre 1 y 10, que si resulta >=10 es critico y dobla el daño
    static int hpJugador, defJugador, atkJugador, critJugador, idClase, hpMax, usosHabilidadEspecial;
    static String nombreClase, nombreJugador, nombreArma, nombreArmadura;

    //Estadisticas del enemigo
    //hpInicialEnemigo se usa para calcular el porcentaje de vida restante
    //idAatque especial determinara 1 de 3 ataques especiales que puede tener
    //tod0 lo demas igual que jugador
    static int hpEnemigo, defEnemigo , atkEnemigo , idEnemigo, hpInicialEnemigo, idAtaqueEspecial ;
    static String nombreEnemigo;

    //Estadisticas minimas del enemigo
    static int hpMinEnemigo= 20;
    static int defMinEnemigo= 3;
    static int atkMinEnemigo= 5;
    static int critMinEnemigo= 1;

    //contadores que muestran el daño hecho y recibido en un personaje
    static int acumuladorDanio;
    static int acumuladorHp;

    //contador que se usa para determinar el movimiento del enemigo en la fase 2
    static int contadorFase2;

    //colores para dar formato al texto en la consola y reseteo para eliminarlos
    static final String RESETEO = "\u001B[0m";
    static final String NEGRO = "\u001B[30m";
    static final String ROJO = "\u001B[31m";
    static final String VERDE = "\u001B[32m";
    static final String AZUL = "\u001B[34m";
    static final String AMARILLO = "\u001B[33m";
    static final String MORADO = "\u001B[35m";
    static final String CIAN = "\u001B[36m";
    static final String FONDO_BLANCO = "\u001B[47m";



    public static void main(String[] args) {

        //puntuacion que sube cada vez que se gana un combate y maxima que se compara entre los personajes jugados
        int puntuacion;
        int puntuacionMax=0;

        //String que luego se introduce por consola para que el jugador determine si quiere seguir jugando
        String continuar;

        System.out.println(
                       VERDE+ ".-------------------------------------------------------------------------------------------------------------------------." + RESETEO + "\n" +
                       VERDE+"| _   ____                   _                           _                                      _                       _ |" +RESETEO + "\n" +
                       VERDE+"|(_) / ___| ___   _ __ ___  (_)  ___  _ __   ____ __ _  | |_  _   _    __ _ __   __ ___  _ __  | |_  _   _  _ __  __ _ | ||" +RESETEO + "\n" +
                       VERDE+"|| || |    / _ \\ | '_ ` _ \\ | | / _ \\| '_ \\ |_  // _` | | __|| | | |  / _` |\\ \\ / // _ \\| '_ \\ | __|| | | || '__|/ _` || ||" +RESETEO + "\n" +
                       VERDE+"|| || |___| (_) || | | | | || ||  __/| | | | / /| (_| | | |_ | |_| | | (_| | \\ V /|  __/| | | || |_ | |_| || |  | (_| ||_||" +RESETEO + "\n" +
                       VERDE+"||_| \\____|\\___/ |_| |_| |_||_| \\___||_| |_|/___|\\__,_|  \\__| \\__,_|  \\__,_|  \\_/  \\___||_| |_| \\__| \\__,_||_|   \\__,_|(_)|" +RESETEO + "\n" +
                       VERDE+"'-------------------------------------------------------------------------------------------------------------------------'" +RESETEO + "\n"
                );

    //antes de la creacion de personaje tod0 esta envuelto en un bucle do while en caso de que el jugador quiera volver a jugar con otro personaje
    do {
        System.out.println(MORADO + "********************************************************" + RESETEO);

        //inicializacion de puntuacion en 0 para que cada personaje comience con esa puntuacion
        puntuacion=0;

        //inicializacion acumuladores en 0 para que sean propios de cada personaje
        acumuladorDanio = 0;
        acumuladorHp = 0;

        //llamada a metodos de crear personaje
        elegirPersonaje();

        elegirArmadura();

        hpMax= hpJugador;

        System.out.println(MORADO + "********************************************************" + RESETEO);

        System.out.println("Introduzca un nombre para el personaje: ");

        nombreJugador = scL.nextLine();
        nombreJugador = AMARILLO + nombreJugador + RESETEO;

        System.out.println(MORADO + "********************************************************" + RESETEO);


        System.out.println("Tu " + nombreClase + " " + nombreJugador  + " se dispone a luchar con " + nombreArma + " y " + MORADO + nombreArmadura + RESETEO);

        System.out.println(MORADO + "********************************************************" + RESETEO);

        //metodo que muestra caracteristicas del personaje del jugador
        mostrarEstadoJugador();

        /* inicializacion de los valores minimos del enemigo, que genera sus valores finales en un rango a partir
        de los que se presentan a continuacion. Mas tarde estos minimos cambian, por ello se inicializan aqui, en caso
        de que se vuelva a empezar con otro personaje los minimos se resetean
         */
        hpMinEnemigo = 20;
        defMinEnemigo = 3;
        atkMinEnemigo = 5;
        critMinEnemigo = 1;

        /*El siguiente bucle do while contiene la generacion del enemigo y la batalla, siempre hay minimo una batalla
        pero el jugador puede decidir entrar en otra, lo que realiza otra iteracion del bucle y se genera un nuevo enemigo
         */
        do {

            /*el siguiente booleano indica si la batalla ha terminado con nosotros o el enemigo por debajo de 1 de vida
            inicializamos en false y si ganamos mas tarde cambia a true para comparaciones
             */
            boolean victoria = false;

            //variable que indica en que turno nos encontramos, importante para los ataques de enemigo,
            int turno = 1;

            //inicializamos el contador en 1 en cada batalla para determinar el patron de ataque en la fase 2
            contadorFase2 = 1;

            //llamada a la funcion que crea un enemigo aleatorio
            generarEnemigo();

            System.out.println(MORADO + "********************************************************" + RESETEO);

            System.out.println("¡El Dragón " + nombreEnemigo + " se une a la batalla!");

            //funcion que muestra la imagen del enemigo y su vida
            mostrarEnemigo();

            //comienzo del bucle de combate, tras cada accion se comprueba si el contrincante ha bajado a 0 de vida, en cuyo caso se rompe el bucle
            while (true) {

                System.out.println(MORADO + "********************************************************" + RESETEO);

                System.out.println("Es tu turno " + nombreJugador);

                //funcion de las posibilidades en el turno del jugador
                turnoJugador();

                //comprobacion de si el enemigo ha bajado a 0 de vida, en cuyo caso se rompe el bucle y victoria=true
                if (hpEnemigo < 1) {
                    victoria = true;
                    break;
                }

                System.out.println(MORADO + "********************************************************" + RESETEO);

                System.out.println("Es el turno de " + nombreEnemigo);

                //calculamos el porcentaje de vida del enemigo
                double porcentajeVida = ((double) hpEnemigo / hpInicialEnemigo) * 100;

                //si es mayor a 15 esta en fase uno, si es menor esta en fase 2, cada una con su metodo correspondiente
                if (porcentajeVida > 15) {
                    faseUno(turno);
                } else {
                    faseDos();
                }

                //tras el turno del enemigo si nuestra vida es menor qeu 1 perdemos y se cierra el bucle, recordemos que por defecto victoria==false
                if (hpJugador < 1) {
                    break;
                }

                //si la batalla continua se suma un turno al contador
                turno++;

            } //fin de combate

            System.out.println(MORADO + "********************************************************" + RESETEO);

            //si se ha perdido se sale del bucle que permite usar el personaje en la siguiente batalla
            if (!victoria) {

                System.out.println(AZUL + "Has perdido :(" + RESETEO);
                break;

            } else {

                //en caso de victoria
                System.out.println(AMARILLO + "¡Has ganado!" + RESETEO);

                puntuacion++;

                System.out.println("Tu puntuación actual es: " + ROJO + puntuacion + RESETEO);

                //El jugador elige si quiere otro combate con el mismo personaje
                System.out.println("Si deseas enfrentarte al siguiente enemigo escribe SI, en caso contrario pulse cualquier otra tecla");

                String f = scL.nextLine();

                //si decide combatir puede elegir una mejora para su personaje
                if (f.equalsIgnoreCase("SI")) {

                    System.out.println(MORADO + "********************************************************" + RESETEO);

                    System.out.println("_______________________________________");
                    System.out.println("| Elige una mejora para tu personaje: |");
                    System.out.println("| 1.Aumentar el ataque                |");
                    System.out.println("| 2.Aumentar la defensa               |");
                    System.out.println("| 3.Aumentar la vida máxima           |");
                    System.out.println("| 4.Recuperar un punto de habilidad   |");
                    System.out.println("|_____________________________________|");

                    int mejora = 0;

                    while (true) {
                        try {
                            while (!(mejora>0 && mejora<5)) {
                                mejora = scN.nextInt();
                                if (mejora > 0 && mejora < 5) break;
                                else System.out.println("Introduzca un número valido");
                            }


                            System.out.println(MORADO + "********************************************************" + RESETEO);


                            switch (mejora) {
                                case 1:

                                    System.out.println("¡Aumentas tu ataque!");
                                    atkJugador += 4;

                                    break;

                                case 2:

                                    System.out.println("¡Aumentas tu defensa!");
                                    defJugador += 4;
                                    break;

                                case 3:

                                    System.out.println("¡Aumentas tu vida!");
                                    hpMax += 20;
                                    hpJugador += 20;

                                    break;

                                case 4:

                                    System.out.println("¡Tu habilidad se recupera!");
                                    usosHabilidadEspecial++;
                                    System.out.println("Te quedan " + usosHabilidadEspecial + " usos de la habilidad");

                                    break;
                            }

                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Introduzca un número valido");
                            scN.next();
                        }
                    }

                    mostrarEstadoJugador();

                    //como ha decidico continuar, las estadisticas minimas con las que se genera el enemigo aumentan
                    hpMinEnemigo += 10;
                    defMinEnemigo += 3;
                    atkMinEnemigo += 2;
                    critMinEnemigo+=(int)(Math.random()*2);

                } else {
                    //si decide no continuar con el personaje se sale del bucle
                    break;
                }
            }
        } while (true);

        //en caso de que el jugador pierda o elija no jugar con un personaje se ejecuta el siguiente codigo

        System.out.println(MORADO + "********************************************************" + RESETEO);

        System.out.println("Has recibido un daño total de: " + ROJO + acumuladorHp + RESETEO);
        System.out.println("Has realizado un daño total de: " + ROJO + acumuladorDanio+ RESETEO);
        System.out.println("Tu puntuación con este personaje ha sido: " + ROJO + puntuacion + RESETEO);
        puntuacionMax = Math.max(puntuacionMax, puntuacion);
        System.out.println("La puntuación máxima es: " + ROJO + puntuacionMax + RESETEO);

        System.out.println(MORADO + "********************************************************" + RESETEO);

        //El jugador tiene la opcion de volver a comenzar con otro personaje o terminar de jugar
        System.out.println("Si desea volver a comenzar con otro personaje escriba SI, en caso contrario pulse cualquier otra tecla");

         continuar = scL.nextLine();

    } while(continuar.equalsIgnoreCase("SI"));

        //fin de la partida

        System.out.println(MORADO + "********************************************************" + RESETEO);

        System.out.println(AMARILLO + "¡Gracias por haber jugado!" + RESETEO);
        System.out.println("La puntuación máxima ha sido: " + ROJO + puntuacionMax + RESETEO);

        System.out.println(MORADO + "********************************************************" + RESETEO);

    }

    //funcion para que el jugador elija una clase
    static void elegirPersonaje(){
        int n ;
        //El jugador elige una clase entre 3 opciones
        System.out.println("__________________________________________");
        System.out.println("| Elija la clase con la que desea jugar: |");
        System.out.println("| 1." + MORADO + "Mago" + RESETEO +"                                 |");
        System.out.println("| 2." + ROJO + "Guerrero" + RESETEO +"                             |");
        System.out.println("| 3." + VERDE + "Arquero" + RESETEO + "                              |");
        System.out.println("|________________________________________|");

        try {
            n = scN.nextInt();
            while (!(n>0 && n<4)){
                System.out.println("Introduzca un valor válido");
                n = scN.nextInt();
            }

            System.out.println(MORADO + "********************************************************" + RESETEO);

            //segun la clase que elija se le asignan unas estadisticas iniciales y se hace llamada a la funcion especifica que permite elegir armas en cada clase
            switch (n) {

                case 1:
                    hpJugador = 65;
                    defJugador = 6;
                    atkJugador = 16;
                    critJugador = 1;
                    nombreClase = MORADO + "mago" + RESETEO;
                    idClase = 1;
                    usosHabilidadEspecial = 3;
                    elegirArmaMago();
                    break;

                case 2:
                    hpJugador = 100;
                    defJugador = 8;
                    atkJugador = 13;
                    critJugador = 2;
                    nombreClase = ROJO + "guerrero" + RESETEO;
                    idClase = 2;
                    usosHabilidadEspecial = 3;
                    elegirArmaGuerrero();
                    break;

                case 3:
                    hpJugador = 80;
                    defJugador = 6;
                    atkJugador = 11;
                    critJugador = 3;
                    nombreClase = VERDE + "arquero" + RESETEO;
                    idClase = 3;
                    usosHabilidadEspecial = 3;
                    elegirArmaArquero();
                    break;
            }

            System.out.println(MORADO + "********************************************************" + RESETEO);
        } catch (InputMismatchException e){
            System.out.println("Introduzca un valor válido");
            scN.next();

            elegirPersonaje();

        }
    }

    //funciones para que el jugador elija un arma segun la clase
    static void elegirArmaMago(){

        int n;

        //el jugador elige entre 1 de tres armas que alteran sus estadisticas

        System.out.println("________________________");
        System.out.println("| Ahora elija un arma: |");
        System.out.println("| 1. Bastón de fuego   |");
        System.out.println("| 2. Varita de magia   |");
        System.out.println("| 3. Varita moderna    |");
        System.out.println("|______________________|");

        try {
            n = scN.nextInt();

            while (!(n>0 && n<4)){
                System.out.println("Introduzca un valor válido");
                n = scN.nextInt();
            }


            switch (n) {

                case 1:
                    System.out.println(ROJO + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣤⣄⣀⣀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡾⠟⠛⣛⣻⣿⣿⣿⣿⣶⣤⡀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⡿⠁⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⡟⢀⣾⠟⢫⣿⠟⢉⣉⣉⠙⠻⣿⣿⢿⣿⡆⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣇⣾⡏⢠⡿⠁⣴⣿⣿⣿⣿⣆⠘⣿⠀⣿⡇⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠀⢸⡇⢸⣿⣿⣿⠛⠿⠟⢀⣿⠀⣿⡇⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⠀⢸⣧⠈⣿⣿⣿⣷⣶⣶⣟⣃⣴⠟⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⡿⠀⣿⡿⠀⠈⠻⢿⣿⣿⣿⡿⠟⠃⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⠃⣸⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⢀⣴⡟⢩⣿⡿⢃⣼⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⣠⡿⠋⣠⣿⣿⣷⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⣠⡾⠋⢀⣾⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⣠⡾⠋⣀⣴⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠋⣠⣾⡿⢻⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠛⠛⠁⠐⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + RESETEO);
                    nombreArma = ROJO + "el bastón de fuego" + RESETEO;
                    atkJugador += 3;
                    break;

                case 2:
                    System.out.println(MORADO + "              .:.^.  *\n" +
                            "  *.    *   .::'.*.>\n" +
                            "    `:.    '':.  |\n" +
                            "      `:.  .::'  |  *\n" +
                            "  *     `:::'    |\n" +
                            "         `*'     |" + RESETEO);
                    nombreArma = MORADO + "la varita de magia" + RESETEO;
                    atkJugador += 2;
                    defJugador += 1;
                    break;

                case 3:
                    System.out.println(VERDE + " +--^----------,--------,-----,--------^-,\n" +
                            " | |||||||||   `--------'     |          O\n" +
                            " `+---------------------------^----------|\n" +
                            "   `\\_,---------,---------,--------------'\n" +
                            "     / XXXXXX /'|       /'\n" +
                            "    / XXXXXX /  `\\    /'\n" +
                            "   / XXXXXX /`-------'\n" +
                            "  / XXXXXX /\n" +
                            " / XXXXXX /\n" +
                            "(________(                \n" +
                            " `------'              " + RESETEO);
                    nombreArma = VERDE + "la varita moderna" + RESETEO;
                    critJugador += 2;
                    break;
            }
        } catch (InputMismatchException e){
            scN.next();
            elegirArmaMago();
        }
    }
    static void elegirArmaGuerrero(){

        int n;

        //el jugador elige entre 1 de tres armas que alteran sus estadisticas

        System.out.println("________________________");
        System.out.println("| Ahora elija un arma: |");
        System.out.println("| 1. Espadón de fuego  |");
        System.out.println("| 2. Hoja gigante      |");
        System.out.println("| 3. Katana de hielo   |");
        System.out.println("|______________________|");

        try {
            n = scN.nextInt();

            while (!(n > 0 && n < 4)) {
                System.out.println("Introduzca un valor válido");
                n = scN.nextInt();
            }

            switch (n) {

                case 1:
                    System.out.println(ROJO + "              />\n" +
                            " ()          //---------------------------------------------------------(\n" +
                            "(*)OXOXOXOXO(*>                                                          \\\n" +
                            " ()          \\\\-----------------------------------------------------------)\n" +
                            "              \\>" + RESETEO);
                    nombreArma = ROJO + "el espadón de fuego" + RESETEO;
                    atkJugador += 3;
                    break;

                case 2:
                    System.out.println(AMARILLO + " _         | |\n" +
                            "| | _______| |---------------------------------------------\\\n" +
                            "|:-)_______|==[]============================================>\n" +
                            "|_|        | |---------------------------------------------/\n" +
                            "           |_|" + RESETEO);
                    nombreArma = AMARILLO + "la hoja gigante" + RESETEO;
                    atkJugador += 2;
                    defJugador += 1;
                    break;

                case 3:
                    System.out.println(CIAN + "                _\n" +
                            "               /\\)\n" +
                            "              /\\/\n" +
                            "             /\\/\n" +
                            "           _/L/\n" +
                            "          (/\\_)\n" +
                            "          /%/  \n" +
                            "         /%/  \n" +
                            "        /%/\n" +
                            "       /%/\n" +
                            "      /%/\n" +
                            "     /%/\n" +
                            "    /%/\n" +
                            "   /%/\n" +
                            "  /%/\n" +
                            " /%/ \n" +
                            "/,' \n" +
                            "\"" + RESETEO);
                    nombreArma = CIAN + "la katana de hielo" + RESETEO;
                    critJugador += 2;
                    break;
            }
        } catch (InputMismatchException e){
            scN.next();
            elegirArmaGuerrero();
        }
    }
    static void elegirArmaArquero(){

        int n;

        //el jugador elige entre 1 de tres armas que alteran sus estadisticas

        System.out.println("_____________________________");
        System.out.println("| Ahora elija unas flechas: |");
        System.out.println("| 1. Flechas de fuego       |");
        System.out.println("| 2. Flechas de rayo        |");
        System.out.println("| 3. Flechas de hielo       |");
        System.out.println("|___________________________|");

        try {
            n = scN.nextInt();

            while (!(n > 0 && n < 4)) {
                System.out.println("Introduzca un valor válido");
                n = scN.nextInt();
            }

            switch (n) {

                case 1:
                    System.out.println(ROJO + ">>>>>----------------------->" + RESETEO);
                    nombreArma = ROJO + "las flechas de fuego" + RESETEO;
                    atkJugador += 3;
                    break;

                case 2:
                    System.out.println(AMARILLO + ">>>>>>>_____________________\\`-._\n" +
                            ">>>>>>>                     /.-'" + RESETEO);
                    nombreArma = AMARILLO + "las flechas de rayo" + RESETEO;
                    atkJugador += 2;
                    defJugador += 1;
                    break;

                case 3:
                    System.out.println(CIAN + "    _\n" +
                            ".-'` |___________________________//////\n" +
                            "`'-._|                           \\\\\\\\\\\\" + RESETEO);
                    nombreArma = CIAN + "las flechas de hielo" + RESETEO;
                    critJugador += 2;
                    break;
            }
        } catch (InputMismatchException e){
            scN.next();
            elegirArmaArquero();
        }
    }

    //funcion para que el jugador elija una armadura
    static void elegirArmadura(){

        int n;

        //El jugador elige una de tres armaduras que cambian sus estadisticas

        System.out.println("_____________________________");
        System.out.println("| Ahora elija una armadura: |");
        System.out.println("| 1. Armadura de placas     |");
        System.out.println("| 2. Armadura de guardián   |");
        System.out.println("| 3. Armadura de espinas    |");
        System.out.println("|___________________________|");

        try {


            n = scN.nextInt();

            while (!(n > 0 && n < 4)) {
                System.out.println("Introduzca un valor válido");
                n = scN.nextInt();
            }

            switch (n) {

                case 1:
                    defJugador += 3;
                    nombreArmadura = "la armadura de placas";
                    break;

                case 2:
                    defJugador += 1;
                    hpJugador += 15;
                    nombreArmadura = "la armadura de guardián";
                    break;

                case 3:
                    defJugador += 2;
                    atkJugador += 1;
                    nombreArmadura = "la armadura de espinas";
                    break;
            }
        } catch (InputMismatchException e){
            scN.next();
            elegirArmadura();
        }
    }

    //funcion que guarda los sprites de los personajes
    static String imagenPersonaje(int n){

        //a esta funcion se la llama con el idClase para devolver una string con el sprite del personaje correspondiente

        switch(n){
            case 1:
                return  "        __/\\__\n" +
                        "     _  \\\\''//\n" +
                        "   -( )-/_||_\\\n" +
                        "    .'. \\_()_/\n" +
                        "     |   | . \\\n" +
                        "     |   | .  \\\n" +
                        "    .'. ,\\_____'.";
            case 2:
                return  "       ! \n" +
                        "      .-. \n" +
                        "    __|=|__ \n" +
                        "   (_/`-`\\_) \n" +
                        "   //\\___/\\\\ \n" +
                        "   <>/   \\<> \n" +
                        "    \\|_._|/ \n" +
                        "     <_I_> \n" +
                        "      ||| \n" +
                        "     /_|_\\ ";
            case 3:
                return  "       (\n" +
                        "    () |\\       - _   \n" +
                        "    <==|=@        _ >>>--->\n" +
                        "    [\\ |/       -   \n" +
                        "    ||`(              \n" +
                        "    LL ";
        }

        /* la funcion siempre tiene que devolver algo, aunque por como esta diseñado siempre
        sera uno de los sprites anteriores
         */
        return "";
    }

    //funcion que muestra las caracteristicas del jugador
    static void mostrarEstadoJugador(){

        //se llama a la funcion de sprites con el idClase para imprimir el sprite correspondiente
        System.out.println(imagenPersonaje(idClase));

        //se muestra numericamente la vida del jugador, si vale menos que 0 se cambia a 0
        System.out.println("HP: " + (hpJugador<0?0:hpJugador) + "/" + hpMax);

        /*se muestra una barra de vida, donde cada muesca son 5 de vida
        el bucle se repite una vez menos de las que deberia y luego se muestra una muesca,
        para que aunque la vida sea menor de 5 se muestre 1 siempre que se siga vivo
         */
        for (int i = 0; i < (hpJugador/5)-1; i++) {
            System.out.print(ROJO + "█" + RESETEO);
        }
        if (hpJugador>0) {
            System.out.print(ROJO + "█" + RESETEO);
        }

        /*la vida vacia se muestra como el contrario a la vida actual, restantole la vida actual a la total
        para las ocasiones en las que la division no sea exacta se muestra una muesca adicional para que se representen
        todas las correspondientes a la vida maxima del jugador
         */
        for (int i = 0; i < (hpMax-hpJugador)/5; i++) {
            System.out.print("█");
        }
        if ((hpMax-hpJugador)%5!=0 && hpJugador>4){
            System.out.print("█");
        }
        System.out.println();

        //se muestran el ataque y la defensa actuales del jugador
        System.out.println("Ataque: " + AMARILLO + atkJugador + RESETEO + " Defensa: " + AZUL + defJugador + RESETEO);
    }

    //funcion que crea un enemigo aleatorio
    static void generarEnemigo(){

        //se genera un nombre al azar
        nombreEnemigo="";

        //primero la cantidad de letras es al azar
        int numeroLetras= (int) (Math.random()*8+3);

        /*el programa ejecuta un bucle el numero de letras que se haya determinado veces
        generando una letra minuscula en cada pasada y añadiendola al nombre
         */
        for (int i = 0; i < numeroLetras; i++) {
            int caracter = (int) (Math.random()*26+97);
            nombreEnemigo+=(char)caracter;
        }

        //se le pone color al nombre
        nombreEnemigo = AMARILLO + nombreEnemigo + RESETEO;

        //ataque, vida y defensa se generan aleatoriamente en un rango a partir del minimo
        atkEnemigo=(int) (Math.random()*7+atkMinEnemigo);
        defEnemigo=(int) (Math.random()*7+defMinEnemigo);
        hpEnemigo = (int) (Math.random()*21+hpMinEnemigo);
        hpInicialEnemigo = hpEnemigo;

        //el id al azar selecciona una de tres imagenes al azar
        idEnemigo=(int) (Math.random()*3+1);

        //el ataque al azar selecciona uno de tres ataques al azar
        idAtaqueEspecial=(int) (Math.random()*3);
    }

    //funcion que devuelve una string con el sprite segun el id del enemigo
    static String imagenEnemigo(int n){

        switch(n){

            case 1:
                return AZUL + "                              ______________                               \n" +
                        "                        ,===:'.,            `-._                           \n" +
                        "                             `:.`---.__         `-._                       \n" +
                        "                               `:.     `--.         `.                     \n" +
                        "                                 \\.        `.         `.                   \n" +
                        "                         (,,(,    \\.         `.   ____,-`.,                \n" +
                        "                      (,'     `/   \\.   ,--.___`.'                         \n" +
                        "                  ,  ,'  ,--.  `,   \\.;'         `                         \n" +
                        "                   `{D, {    \\  :    \\;                                    \n" +
                        "                     V,,'    /  /    //                                    \n" +
                        "                     j;;    /  ,' ,-//.    ,---.      ,                    \n" +
                        "                     \\;'   /  ,' /  _  \\  /  _  \\   ,'/                    \n" +
                        "                           \\   `'  / \\  `'  / \\  `.' /                     \n" +
                        "                            `.___,'   `.__,'   `.__,' " + RESETEO;
                case 2:
                    return ROJO + " <>=======() \n" +
                            "(/\\___   /|\\\\          ()==========<>_\n" +
                            "      \\_/ | \\\\        //|\\   ______/ \\)\n" +
                            "        \\_|  \\\\      // | \\_/\n" +
                            "          \\|\\/|\\_   //  /\\/\n" +
                            "           (oo)\\ \\_//  /\n" +
                            "          //_/\\_\\/ /  |\n" +
                            "         @@/  |=\\  \\  |\n" +
                            "              \\_=\\_ \\ |\n" +
                            "                \\==\\ \\|\\_ \n" +
                            "             __(\\===\\(  )\\\n" +
                            "            (((~) __(_/   |\n" +
                            "                 (((~) \\  /\n" +
                            "                 ______/ /\n" +
                            "                 '------'" + RESETEO;
                    case 3:
                        return
                                VERDE +
                                "                ^    ^\n" +
                                "               / \\  //\\\n" +
                                " |\\___/|      /   \\//  .\\\n" +
                                " /O  O  \\__  /    //  | \\ \\\n" +
                                "/     /  \\/_/    //   |  \\  \\\n" +
                                "@___@'    \\/_   //    |   \\   \\ \n" +
                                "   |       \\/_ //     |    \\    \\ \n" +
                                "   |        \\///      |     \\     \\ \n" +
                                "  _|_ /   )  //       |      \\     _\\\n" +
                                " '/,_ _ _/  ( ; -.    |    _ _\\.-~        .-~~~^-.\n" +
                                " ,-{        _      `-.|.-~-.           .~         `.\n" +
                                "  '/\\      /                 ~-. _ .-~      .-~^-.  \\\n" +
                                "     `.   {            }                   /      \\  \\\n" +
                                "   .----~-.\\        \\-'                 .~         \\  `. \\^-.\n" +
                                "  ///.----..>    c   \\             _ -~             `.  ^-`   ^-_\n" +
                                "    ///-._ _ _ _ _ _ _}^ - - - - ~                     ~--,   .-~\n" +
                                "                                                          /.-'\n" + RESETEO
                                ;
        }

        /*la funcion siempre tiene que devolver un valor, pero por como
        se ha planteado el programa siempre devolvera una de las anteriores
         */
        return "";
    }

    //funcion que muestra caracteristicas del enemigo
    static void mostrarEnemigo(){

        //se llama a la imagen del enemigo segun el id y se muestra
        System.out.println(imagenEnemigo(idEnemigo));

        /* se muestra la vida solo en barras, cada muesca son 5 de vida,
        el bucle se ejecuta una vez menos de la que deberia en caso de que
        tenga menos de 5 de vida pero mas que 0, por ello se muestra a continuacion
         */
        System.out.println("HP: ");
        for (int i = 0; i < (hpEnemigo/5)-1; i++) {
            System.out.print(ROJO + "█" + RESETEO);
        }
        if (hpEnemigo>0) {
            System.out.print(ROJO + "█" + RESETEO);
        }
        for (int i = 0; i < (hpInicialEnemigo-hpEnemigo)/5; i++) {
            System.out.print("█");
        }
        if ((hpInicialEnemigo-hpEnemigo)%5!=0 && hpEnemigo>4){
            System.out.print("█");
        }
        System.out.println();

    }

    //funcion que permite determinar lo que hará el jugador en su turno
    static void turnoJugador(){

        int n;

        //el jugador elige 1 de 3 acciones
        System.out.println("_____________________");
        System.out.println("| Elige una acción: |");
        System.out.println("| 1. Atacar         |");
        System.out.println("| 2. Defenderse     |");
        System.out.println("| 3. Curarse        |");
        System.out.println("| 4. Habilidad Esp. |");
        System.out.println("|___________________|");

        try {
            n = scN.nextInt();

            while (!(n > 0 && n < 5)) {
                System.out.println("Introduzca un valor válido");
                n = scN.nextInt();
            }

            System.out.println(MORADO + "********************************************************" + RESETEO);

            int danio;

            switch (n) {

                case 1:

                    System.out.println("Has atacado a " + nombreEnemigo);

                    //el daño se genera al azar a partir del ataque del jugador
                    danio = (int) (Math.random() * 4 + atkJugador);

                    //se genera un numero del 1 al 10 y se le suma el critico del jugador, si es 10 o mayor se duplica el daño
                    if ((int) (Math.random() * 10 + 1) + critJugador >= 10) {
                        danio *= 2;
                        System.out.println(ROJO + "¡Has hecho un golpe crítico!" + RESETEO);
                    }

                    //al daño se le resta la defensa del enemigo, el daño minimo siempre sera 1
                    danio -= defEnemigo;

                    if (danio < 1) {
                        danio = 1;
                    }

                    //se suma el daño al contador y se le resta a la vida del enemigo
                    acumuladorDanio += danio;
                    hpEnemigo -= danio;

                    //mostramos al enemigo tras haberle atacado
                    mostrarEnemigo();

                    break;

                case 2:

                    System.out.println("Aumentas tu defensa");
                    //se le añade 1 punto a la defensa del jugador
                    defJugador++;

                    //se muestra su estado ahora actualizado
                    mostrarEstadoJugador();

                    break;

                case 3:

                    System.out.println("Recuperas vida");

                    //se aumenta la vida del jugador
                    hpJugador += 25;

                    if (hpJugador >= hpMax) {
                        System.out.println("¡Tu vida está al máximo!");
                        hpJugador = hpMax;
                    }

                    //se muestra su estado ahora actualizado
                    mostrarEstadoJugador();

                    break;
                case 4:

                    if (usosHabilidadEspecial > 0) {
                        switch (idClase) {
                            case 1:

                                System.out.println(MORADO + "¡Concentración Arcana!" + RESETEO);
                                System.out.println(MORADO + "         /\\/\\\n" +
                                        "        / /  \\ \n" +
                                        "       / / /\\ \\\n" +
                                        "       \\ \\/ / /\n" +
                                        "        \\  / /\n" +
                                        "         \\/\\/" + RESETEO);
                                System.out.println(ROJO + "¡Tus ataques se vuelven más poderosos!" + RESETEO);

                                atkJugador += 5;
                                mostrarEstadoJugador();

                                break;

                            case 2:

                                System.out.println(AMARILLO + "¡Doble Empuñadura!" + RESETEO);
                                System.out.println(AMARILLO + "      O                                     O\n" +
                                        "{o)xxx|===============-  *  -===============|xxx(o}\n" +
                                        "      O                                     O" + RESETEO);
                                System.out.println(ROJO + "¡Realizas un ataque muy poderoso!" + RESETEO);

                                danio = (int) (Math.random() * 4 + atkJugador);

                                if ((int) (Math.random() * 10 + 1) + critJugador >= 10) {
                                    danio *= 2;
                                    System.out.println(ROJO + "¡Has hecho un golpe crítico!" + RESETEO);
                                }

                                danio *= 2;

                                danio -= defEnemigo;

                                if (danio < 1) {
                                    danio = 1;
                                }

                                acumuladorDanio += danio;
                                hpEnemigo -= danio;

                                mostrarEnemigo();


                                break;

                            case 3:
                                System.out.println(AMARILLO + "¡LLuvia de flechas!" + RESETEO);
                                System.out.println(AMARILLO + "             >>>>>----------------------->" + RESETEO);
                                System.out.println(CIAN + ">>>>>----------------------->" + RESETEO);
                                System.out.println(ROJO + "      >>>>>----------------------->" + RESETEO);

                                for (int i = 0; i < 3; i++) {
                                    danio = (int) (Math.random() * 4 + atkJugador);

                                    if ((int) (Math.random() * 10 + 1) + critJugador >= 10) {
                                        danio *= 2;
                                        System.out.println(ROJO + "¡Has hecho un golpe crítico!" + RESETEO);
                                    }

                                    danio -= defEnemigo;

                                    if (danio < 1) {
                                        danio = 1;
                                    }

                                    acumuladorDanio += danio;
                                    hpEnemigo -= danio;
                                }
                                mostrarEnemigo();

                                break;
                        }
                        usosHabilidadEspecial--;
                        System.out.println("Te quedan " + usosHabilidadEspecial + " usos de la habilidad");
                    } else {
                        System.out.println("¡No te quedan usos de la habilidad!");
                        turnoJugador();
                    }
            }
        } catch (InputMismatchException e){
            scN.next();
            turnoJugador();
        }
    }

    //funcion que determina la accion del enemigo en base al turno si tiene mas de 15% de vida
    static void faseUno(int turno){

        //si el turno es primo
        if (esPrimo(turno)){

            //el enemigo ataca
            System.out.println(nombreEnemigo + " te ha atacado");

            //daño al azar en base a su ataque
            int danio =(int) (Math.random()*4+atkEnemigo);

            //1 a 10 de hacer critico mas el critico del enemigo, duplica el daño
            if ((int) (Math.random()*10+1)+critMinEnemigo>=10){
                danio*=2;
                System.out.println( ROJO + "¡" + nombreEnemigo + ROJO + " ha hecho un crítico!" + RESETEO);
            }

            //al daño se le resta la defensa del jugador
            danio-=defJugador;

            //el daño siempre sera de 1 minimo
            if (danio<1){
                danio=1;
            }

            //se le resta la vida al jugador y se suma al contador de daño recibido
            hpJugador-=danio;
            acumuladorHp+=danio;

            //se muestra el estado del jugador actualizado
            mostrarEstadoJugador();

        } else if(turno%2==0){ //si el turno es par y no primo

            //el enemigo aumenta su defensa
            System.out.println(nombreEnemigo + " se ha defendido");
            defEnemigo++;

        } else { //si el turno es impar y no primo

            //el enemigo realiza su ataque especial y se llama a la funcion con el id del ataque
            System.out.println(MORADO + "¡El enemigo realiza su ataque especial!" + RESETEO);
            ataqueEspecial(idAtaqueEspecial);
        }
    }

    //funcion a la que se le introduce un entero y devuelve true si es primo y false si no lo es
    static boolean esPrimo(int n){
        for (int i = 2; i <n ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //funcion en la que el enemigo hace su ataque especial segun el id que le haya tocado
    static void ataqueEspecial(int n){

        //todas son variaciones en la forma de hacer daño, para ver funcionamiento del daño ir a faseUno()
        int danio;

        //se aumenta el ataque del enemigo para evitar un combate infinito
        atkEnemigo+=3;

        switch (n){

            case 0:

                System.out.println(ROJO + "¡LLuvia de meteoritos!" + RESETEO);
                System.out.println(ROJO+"         _ ._  _ , _ ._\n" +
                        "        (_ ' ( `  )_  .__)\n" +
                        "      ( (  (    )   `)  ) _)\n" +
                        "     (__ (_   (_ . _) _) ,__)\n" +
                        "         `~~`\\ ' . /`~~`\n" +
                        "              ;   ;\n" +
                        "              /   \\\n" +
                        "_____________/_ __ \\_____________"+RESETEO);

                for (int i = 0; i < 3; i++) {

                     danio =(int) (Math.random()*4+atkEnemigo);

                    if ((int) (Math.random()*10+1)+critMinEnemigo>=10){
                        danio*=2;
                        System.out.println(ROJO + "¡" + nombreEnemigo + ROJO + " ha hecho un crítico!" + RESETEO);
                    }

                    danio-=defJugador;

                    if (danio<1){
                        danio=1;
                    }

                    hpJugador-=danio;
                    acumuladorHp+=danio;
                }

                mostrarEstadoJugador();

                break;

            case 1:

                System.out.println(AMARILLO + "¡Golpe demoledor!" + RESETEO);

                System.out.println(AMARILLO+"⠀⣤⣤⣤⣤⣤⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⣤⡤⢤⣄⡀⠀⠀⠀⠀⠀\n" +
                        "⠀⠛⢿⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⠋⠀⢀⣀⡈⢻⡄⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠙⢿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⣰⣿⣿⣿⣷⡿⠛⠛⠛⠻⢿⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣷⣦⣶⣾⣿⣿⠟⠋⠉⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣟⣁⣀⣀⣤⣴⣶⣿⡶⠤⣤⣄⡀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣀⣀⡀⠉⢿⡄⠀\n" +
                        "⠀⠀⠀⢀⣀⣤⣶⣾⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠉⠛⠿⠿⠟⠛⠻⢦⣸⡇⠀\n" +
                        "⠀⠀⣰⣿⣿⣿⣿⣿⠋⠁⠀⠉⠙⠻⣿⣿⣶⣦⣤⣤⣄⡀⠀⠀⠀⠀⠈⢿⠃⠀\n" +
                        "⠀⢰⡟⠉⢻⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⠿⢿⣄⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⣿⠁⠀⡟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣅⠀⠀⠹⣧⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠻⣧⡀⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⡄⠀⣿⡆⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠈⠛⠿⢷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣠⡿⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⠋⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀"+RESETEO);

                 danio =(int) (Math.random()*4+atkEnemigo);

                if ((int) (Math.random()*10+1)+critMinEnemigo>=10){
                    danio*=2;
                    System.out.println(ROJO + "¡" + nombreEnemigo + ROJO + " ha hecho un crítico!" + RESETEO);
                }

                danio*=3;
                danio-=defJugador;

                if (danio<1){
                    danio=1;
                }

                hpJugador-=danio;
                acumuladorHp+=danio;

                mostrarEstadoJugador();

                break;

            case 2:

                System.out.println(CIAN + "¡Aliento de fuego!" + RESETEO);

                System.out.println(ROJO+"⠀⠀⠀⠀⠀⠀⢱⣆⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠈⣿⣷⡀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢸⣿⣿⣷⣧⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⡀⢠⣿⡟⣿⣿⣿⡇⠀⠀\n" +
                        "⠀⠀⠀⠀⣳⣼⣿⡏⢸⣿⣿⣿⢀⠀\n" +
                        "⠀⠀⠀⣰⣿⣿⡿⠁⢸⣿⣿⡟⣼⡆\n" +
                        "⢰⢀⣾⣿⣿⠟⠀⠀⣾⢿⣿⣿⣿⣿\n" +
                        "⢸⣿⣿⣿⡏⠀⠀⠀⠃⠸⣿⣿⣿⡿\n" +
                        "⢳⣿⣿⣿⠀⠀⠀⠀⠀⠀⢹⣿⡿⡁\n" +
                        "⠀⠹⣿⣿⡄⠀⠀⠀⠀⠀⢠⣿⡞⠁\n" +
                        "⠀⠀⠈⠛⢿⣄⠀⠀⠀⣠⠞⠋⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀"+RESETEO);

                for (int i = 0; i < 6; i++) {

                     danio =(int) (Math.random()*4+atkEnemigo);

                    if ((int) (Math.random()*10+1)+critMinEnemigo>=10){
                        danio*=2;
                        System.out.println(ROJO + "¡" + nombreEnemigo + ROJO +  " ha hecho un crítico!" + RESETEO);
                    }

                    danio/=2;
                    danio-=defJugador;

                    if (danio<1){
                        danio=1;
                    }

                    hpJugador-=danio;
                    acumuladorHp+=danio;
                }

                mostrarEstadoJugador();

                break;
        }
}

    //funcion a la que se llama cuando el enemigo tiene 15% de vida o menos
    static void faseDos(){

        //segun donde se encuentre el contador de la fase 2
        switch (contadorFase2){

            case 1:

                //el enemigo aumenta su vida
                System.out.println(nombreEnemigo + " se cura");
                hpEnemigo+=10;

                //se muestra el estado actualizado
                mostrarEnemigo();

                break;

            case 2:

                //numero al azar 0 o 1, segun resultado se defiende o ataca
                if ((int) (Math.random()*2)==0){

                    //ataque enemigo, para ver funcionamiento ir a faseUno()
                    System.out.println(nombreEnemigo + " te ha atacado");

                    int danio =(int) (Math.random()*4+atkEnemigo);

                    if ((int) (Math.random()*10+1)+critMinEnemigo>=10){
                        danio*=2;
                        System.out.println(ROJO + "¡" + nombreEnemigo + ROJO +  " ha hecho un crítico!" + RESETEO);
                    }

                    danio-=defJugador;

                    if (danio<1){
                        danio=1;
                    }

                    hpJugador-=danio;
                    acumuladorHp+=danio;

                    mostrarEstadoJugador();

                } else {

                    //el enemigo aumenta su defensa
                    System.out.println(nombreEnemigo + " se ha defendido");
                    defEnemigo++;
                }

                break;

            case 3:

                //el enemigo realiza su ataque especial y lo llama con el id que le haya tocado
                System.out.println(MORADO + "¡El enemigo realiza su ataque especial!" + RESETEO);

                ataqueEspecial(idAtaqueEspecial);

                break;
        }

        //tras la accion en fase 2 se suma 1 al contador, si es mayor que 3 se reinicia
        contadorFase2++;

        if (contadorFase2>3){
            contadorFase2=1;
        }
    }
}
