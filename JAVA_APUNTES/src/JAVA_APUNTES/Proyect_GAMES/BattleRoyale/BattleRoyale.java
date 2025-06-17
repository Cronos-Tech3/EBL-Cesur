package JAVA_APUNTES.Proyect_GAMES.BattleRoyale;
/**
 *
 * @author Enrique Benito López
 * @author Marcos López Salgado
 *
 * @param void main
 * @return esPrimo
 *
 * @version Final
 *
 * @exception Presenta 3 excepciones capturadas con un Try-Catch. InputMismatchException
 * Ocurre cuando el jugador introduce una letra para un siwtch con tipo numerico
 *
 */

//Clases importadas
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BattleRoyale {
    public static void main(String[] args) {   //Método static void main
        Scanner sc = new Scanner(System.in);   //Declaramos Scanner

        //Declaramos variables, eleccion y opcion del do-while, Estadisticas Personaje, Colores, Sprits

        int eleccion;
        int opcion;
        int puntosVidaJugador = 0;
        int puntosAtaqueJugador = 0;
        int puntosDefensaJugador = 0;
        int ataqueEspecialJugador = 0;
        int contadorAtaqueEspecial = 0;
        String rojo = "\033[31m";
        String black = "\033[30m";
        String reset = "\033[0m";
        String amarillo = "\033[33m";
        String verde = "\033[32m";
        String morado = "\033[35m";
        String azul = "\033[34m";
        String Cyan= "\033[36m";

        //Nombre del Jugador
        String Nombre;
        //Guardamos variable de String Personje como vacio.
        String Personaje = "";

        //Sprit de String Aventura
        String Aventura = "       /\\\n" +     "BattleRoyale" +
                "                              /\\  //\\\\\n" +
                "                       /\\    //\\\\///\\\\\\        /\\\n" +
                "                      //\\\\  ///\\////\\\\\\\\  /\\  //\\\\\n" +
                "         /\\          /  ^ \\/^ ^/^  ^  ^ \\/^ \\/  ^ \\\n" +
                "        / ^\\    /\\  / ^   /  ^/ ^ ^ ^   ^\\ ^/  ^^  \\\n" +
                "       /^   \\  / ^\\/ ^ ^   ^ / ^  ^    ^  \\/ ^   ^  \\       *\n" +
                "      /  ^ ^ \\/^  ^\\ ^ ^ ^   ^  ^   ^   ____  ^   ^  \\     /|\\\n" +
                "     / ^ ^  ^ \\ ^  _\\___________________|  |_____^ ^  \\   /||o\\\n" +
                "    / ^^  ^ ^ ^\\  /______________________________\\ ^ ^ \\ /|o|||\\\n" +
                "   /  ^  ^^ ^ ^  /________________________________\\  ^  /|||||o|\\\n" +
                "  /^ ^  ^ ^^  ^    ||___|___||||||||||||___|__|||      /||o||||||\\       |\n" +
                " / ^   ^   ^    ^  ||___|___||||||||||||___|__|||          | |           |\n" +
                "/ ^ ^ ^  ^  ^  ^   ||||||||||||||||||||||||||||||oooooooooo| |ooooooo  |\n" +
                "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooo";
        //Damos la Bienvenida y da comienzo en la interfaz Usuario y mostramos un spritt

        System.out.println( amarillo+"Bienvenidos Al mundo JavaBattleRoyale " + reset);
        System.out.println(amarillo+Aventura+reset);
        //Menu Seleccion Personaje
        do {
            System.out.println(amarillo+"\nElige un personaje para jugar"+reset);
            System.out.println(amarillo +"****************" + reset);
            System.out.println(morado +"*  1.Guerrero  *" + reset);
            System.out.println(azul +"*  2.Mago      *" + reset);
            System.out.println(verde +"*  3.Arquero   *" + reset);
            System.out.println(amarillo +"****************" + reset);

            while(true)
            try {               //Try-catch capturamos el error si el usuario ingresa una letra
                eleccion = sc.nextInt();
                break;
            } catch (InputMismatchException sE) {
                System.out.println(sE.getMessage());
                System.out.println(rojo+"Seleccione la opcion en numero"+reset);
                sc.nextLine();     //Vaciamos el buffer
            }



        } while (eleccion < 1 || eleccion > 3);
        // Este while limita a solo elegir las 3 opciones

        //Damos un nombre al Jugador
        System.out.println(amarillo +"**********************" + reset);
        System.out.println(verde +"* Ingrese su nombre: *" + reset);
        System.out.println(amarillo +"**********************" + reset);

        Nombre = sc.next();    //Se pide el nombre al usuario por Scanner

        // Switch de las opciones del do-while seleccion de personaje
        switch (eleccion) {
            case 1: //Guerrero
                puntosVidaJugador = 150;
                puntosAtaqueJugador = 35;
                puntosDefensaJugador = 20;
                ataqueEspecialJugador = 50;
                System.out.println(amarillo+"Has elegido Guerrero."+reset);
                Personaje = (morado+ """
                         /\\
                         ||
                         ||
                         ||
                         ||           {}
                         ||          .--.
                         ||         /.--.\\
                         ||         |====|
                         ||         |`::`|
                        _||_    .-;`\\..../`;_.-^-._
                         /\\\\   /  |...::..|`   :   `|
                         |:'\\ |   /'''::''|   .:.   |
                          \\ /\\;-,/\\   ::  |..:::::..|
                           \\ <` >  >._::_.| ':::::' |
                            `""`  /   ^^  |   ':'   |
                                  |       \\    :    /
                                  |        \\   :   /\s
                                  |___/\\___|`-.:.-`
                                   \\_ || _/    `
                                   <_ >< _>
                                   |  ||  |
                                   |  ||  |
                                  _\\.:||:./_
                                 /____/\\____\\"""+ reset);
                break;
            case 2: // Mago
                puntosVidaJugador = 120;
                puntosAtaqueJugador = 60;
                puntosDefensaJugador = 10;
                ataqueEspecialJugador = 85;
                System.out.println(amarillo+"Has elegido Mago."+reset);
                Personaje = (azul + """
                                     o
                                           O       /`-.__
                                                  /  \\�'^|
                                     o           T    l  *
                                                _|-..-|_
                                         O    (^ '----' `)
                                               `\\-....-/^
                                     O       o  ) "/ " (
                                               _( (-)  )_
                                           O  /\\ )    (  /\\
                                             /  \\(    ) |  \\
                                         o  o    \\)  ( /    \\
                                           /     |(  )|      \\
                                          /    o \\ \\( /       \\
                                    __.--'   O    \\_ /   .._   \\
                                   //|)\\      ,   (_)   /(((\\^)'\\
                                      |       | O         )  `  |
                                      |      / o___      /      /
                                     /  _.-''^^__O_^^''-._     /
                                   .'  /  -''^^    ^^''-  \\--'^
                                 .'   .`.  `'''----'''^  .`. \\
                               .'    /   `'--..____..--'^   \\ \\
                              /  _.-/                        \\ \\
                          .::'_/^   |                        |  `.
                                 .-'|                        |    `-.
                           _.--'`   \\                        /       `-.
                          /          \\                      /           `-._
                          `'---..__   `.                  .�_.._   __       \\
                                   ``'''`.              .'gnv   `'^  `''---'^
                                          `-..______..-'\
                        """+ reset);
                break;
            case 3: // Arquero
                puntosVidaJugador = 115;
                puntosAtaqueJugador = 45;
                puntosDefensaJugador = 15;
                ataqueEspecialJugador = 75;
                System.out.println(amarillo+"Has elegido Arquero."+reset);
                Personaje = (verde +"""
                                                                                |
                                                                                 \\.
                                                                                 /|.
                                                                               /  `|.
                                                                             /     |.
                                                                           /       |.
                                                                         /         `|.
                                                                       /            |.
                                                                     /              |.
                                                                   /                |.
                              __                                 /                  `|.
                               -\\                              /                     |.
                                 \\\\                          /                       |.
                                   \\\\                      /                         |.
                                    \\|                   /                           |\\
                                      \\#####\\          /                             ||
                                  ==###########>     /                               ||
                                   \\##==      \\    /                                 ||
                              ______ =       =|__/___                                ||
                          ,--' ,----`-,__ ___/'  --,-`-==============================##==========>
                         \\               '        ##_______ ______   ______,--,____,=##,__
                          `,    __==    ___,-,__,--'#'  ==='      `-'              | ##,-/
                            `-,____,---'       \\####\\              |        ____,--\\_##,/
                                #_              |##   \\  _____,---==,__,---'         ##
                                 #              ]===--==\\                            ||
                                 #,             ]         \\                          ||
                                  #_            |           \\                        ||
                                   ##_       __/'             \\                      ||
                                    ####='     |                \\                    |/
                                     ###       |                  \\                  |.
                                     ##       _'                    \\                |.
                                    ###=======]                       \\              |.
                                   ///        |                         \\           ,|.
                                   //         |                           \\         |.
                                                                            \\      ,|.
                                                                              \\    |.
                                                                                \\  |.
                                                                                  \\|.
                                                                                  /.
                                                                                 |\
                        """+ reset);
                break;

        }  //Finaliza el switch de menu de seleccion de personaje

        //Damos la bienvenida al Jugador y mostramos sus estadísticaas y barra de vida
        System.out.println(amarillo +"Bienvenido " + reset + verde + Nombre +reset );
        System.out.println(Personaje);
        System.out.println(amarillo+"*************************************"+reset);
        System.out.println(Cyan +"*     Estadísticas del Personaje    *"+reset);
        System.out.println("*  Puntos de vida: " + rojo + puntosVidaJugador +reset + "              *");
        System.out.println("*  Puntos de ataque: "+morado + puntosAtaqueJugador + reset+ "             *");
        System.out.println("*  Puntos de defensa: "+azul + puntosDefensaJugador + reset+ "            *");
        System.out.println("*  Puntos de ataque especial: "+amarillo + ataqueEspecialJugador + reset+ "    *");
        System.out.println(amarillo+"**************************************"+ reset);
        System.out.println(azul +"HP: "+reset+ verde + Nombre + reset);    //Barra de vida
        for (int i = 0; i < (puntosVidaJugador/2)-1; i++) {     //Imprime el sout representado en el valor i hasta la vida
            System.out.print(Cyan+"▒"+reset);                   //Dividido entre dos para reducir a la mitad la visualizacion de la barra
        }
        if (puntosVidaJugador>0) {
            System.out.println(Cyan+"▒"+reset);
        }

        //Presentamos al enemigo
        System.out.println(amarillo +"¡Cuidado!"+ reset);
        System.out.println(amarillo +"Ha aparecido un enemigo"+ reset);
        String Enemigo = (rojo+"                 ,-.\n" +
                "       ___,---.__          /'|`\\          __,---,___\n" +
                "    ,-'    \\`    `-.____,-'  |  `-.____,-'    //    `-.\n" +
                "  ,'        |           ~'\\     /`~           |        `.\n" +
                " /      ___//              `. ,'          ,  , \\___      \\\n" +
                "|    ,-'   `-.__   _         |        ,    __,-'   `-.    |\n" +
                "|   /          /\\_  `   .    |    ,      _/\\          \\   |\n" +
                "\\  |           \\ \\`-.___ \\   |   / ___,-'/ /           |  /\n" +
                " \\  \\           | `._   `\\\\  |  //'   _,' |           /  /\n" +
                "  `-.\\         /'  _ `---'' , . ``---' _  `\\         /,-'\n" +
                "     ``       /     \\    ,='/ \\`=.    /     \\       ''\n" +
                "             |__   /|\\_,--.,-.--,--._/|\\   __|\n" +
                "             /  `./  \\\\`\\ |  |  | /,//' \\,'  \\\n" +
                "eViL        /   /     ||--+--|--+-/-|     \\   \\\n" +
                "           |   |     /'\\_\\_\\ | /_/_/`\\     |   |\n" +
                "            \\   \\__, \\_     `~'     _/ .__/   /\n" +
                "             `-._,-'   `-._______,-'   `-._,-'"+reset);

        // Creamos un objeto random importando su clase
        // iniciamos los valores del enemigo para esta clase
        Random random = new Random();
        int puntosVidaEnemigo = random.nextInt(50) + 100; // entre 100 y 150
        int puntosAtaqueEnemigo = random.nextInt(30) + 20; // entre 10 y 50
        int puntosDefensaEnemigo = random.nextInt(15) + 10; // entre 10 y 25
        int puntosAtaqueEspecialEnemigo = puntosAtaqueEnemigo * 2; // Ataque especial del enemigo

        //Mostramos Enemigo Visualmente y un comentario y sus estadisticas y barra de vida
        System.out.println(Enemigo + morado +"MaTarrr!!"+reset);
        System.out.println(amarillo+"**************************************"+reset);
        System.out.println(Cyan +"*     Estadísticas del enemigo:      *"+reset);
        System.out.println("*  Puntos de Vida: " + rojo +puntosVidaEnemigo+reset + "               *");
        System.out.println("*  Puntos de Ataque: " + morado +puntosAtaqueEnemigo+reset + "              *");
        System.out.println("*  Puntos de Defensa: " + azul+puntosDefensaEnemigo+reset + "             *");
        System.out.println("*  Puntos de Ataque Especial: " + amarillo+puntosAtaqueEspecialEnemigo+reset + "     *");
        System.out.println(amarillo+"**************************************"+reset);

        System.out.println(rojo+"HP: " +reset + morado+" Enemigo "+reset);
        for (int i = 0; i < (puntosVidaEnemigo/2)-1; i++) {                   //Imprime el sout representado en el valor i hasta la vida
            System.out.print(rojo+"▒"+reset);                                 //Dividido entre dos para reducir a la mitad la visualizacion de la barra
        }
        if (puntosVidaEnemigo>0) {
            System.out.println(rojo+"▒"+reset);
        }

        //Presentamos un Pequeño menu con do-while, delimitando las opciones a 1. y 2.
        //Si se usa 1. entramos en modo batalla 2. Salimos y cerramos aplicacion

        do {
            System.out.println(amarillo+"\n**********************************"+reset);
            System.out.println(azul+"* 1. Entrar en modo batalla      *"+reset);
            System.out.println(amarillo+"* 2. Salir                       *"+reset);
            System.out.println(amarillo+"**********************************"+reset);

            while(true)
                try {                               //Capturamos la excepcion de meter letras
                    opcion = sc.nextInt();
                    break;
                } catch (InputMismatchException sE) {
                    System.out.println(sE.getMessage());
                    System.out.println(rojo+"Seleccione la opcion en numero"+reset);
                    sc.nextLine();
                }

            //Si elije la opcion 2 imprime lo siguiente
            if (opcion==2) {
                System.out.println(amarillo+"Has huido del combate"+reset);
                break;
            }
            //Limitamos las acciones a 1. y 2. de este menu
            //1. entrando en modo batalla y dando comienzo a la Fase de batalla
            //2. Sales, y huyes del combate
        } while (opcion < 1 || opcion > 2);
        switch (opcion) {
            case 1:                       //Case 1 esta vacio y se entraría en el bucle del modo batalla
                break;
            case 2:
                System.exit(2);    //Salir
                break;

        }
        //Si seleccionamos 2. salimos del bucle y entramo en el menu de batalla.
        //Menu de Acciones Modo Batalla, while. Presentamos un menu que muestre 4 opciones
        //1.Atacar 2.Defensa 3.Ataque especial 4.Curación

        //Contador de Turnos
        int turno = 1;

        //Bucle de Batalla
        while (puntosVidaJugador > 0 && puntosVidaEnemigo > 0)  {
            System.out.println(morado+"\nResolución del turno "+reset + amarillo+turno + ":"+reset);
            System.out.println(morado+"Seleccione una acción a realizar: "+reset);
            System.out.println(amarillo+"************************"+reset);
            System.out.println(morado+"*   1.Atacar 2.Defensa *"+reset);
            System.out.println(morado+"*   3.Ataque especial  *"+reset);
            System.out.println(morado+"*   4.Curación         *"+reset);
            System.out.println(amarillo+"************************"+reset);

            //Turno del Jugador

            int accion;
            while(true)
                try {                         //Capturamos la excepcion de las letras
                    accion = sc.nextInt();
                    break;
                } catch (InputMismatchException sE) {
                    System.out.println(sE.getMessage());
                    System.out.println(rojo+"Seleccione la opcion en numero"+reset);
                    sc.nextLine();
                }

            //Imprime el nombre del personaje
            System.out.println( verde+Nombre+reset );
            //imprime la imagen tirando de un string derivado de un switch y sus estadisticas
            System.out.println(Personaje);

            System.out.println(amarillo+"*************************************"+reset);
            System.out.println(Cyan +"*     Estadísticas del Personaje    *"+reset);
            System.out.println("*  Puntos de vida: " + rojo + puntosVidaJugador +reset + "              *");
            System.out.println("*  Puntos de ataque: "+morado + puntosAtaqueJugador + reset+ "             *");
            System.out.println("*  Puntos de defensa: "+azul + puntosDefensaJugador + reset+ "            *");
            System.out.println("*  Puntos de ataque especial: "+amarillo + ataqueEspecialJugador + reset+ "    *");
            System.out.println(amarillo+"**************************************"+ reset);

            //Si el turno es 7 subimos el ataque del jugador y el enemigo en su turno y lo mostramos cuando sea la accion
            if (turno == 7) {
                puntosAtaqueJugador += 20;
                System.out.println(morado+"El "+ reset +verde+ Nombre + reset + morado +" ha experimentado una mejora de experiencia en ataque"+reset);
                System.out.println(azul+"ataque mejorado a "+reset + morado+puntosAtaqueJugador+reset);
            }


            //se resuelve el turno para el jugador. Switch
            switch (accion) {
                case 1: // Atacar
                    int daniooInfligido = puntosAtaqueJugador - puntosDefensaEnemigo;
                    if (daniooInfligido < 0) daniooInfligido = 0;
                    puntosVidaEnemigo = puntosVidaEnemigo - daniooInfligido;
                    System.out.println(azul+"Se tomo la acción de atacar"+reset);
                    System.out.println(azul+"Se han infligido "+reset + rojo+daniooInfligido+reset + azul+" puntos de daño. Vida restante del enemigo: "+reset + rojo+puntosVidaEnemigo+reset);
                    break;
                case 2: // Defensa
                    int defensaJugador = 5;
                    puntosDefensaJugador = puntosDefensaJugador + defensaJugador;

                    System.out.println(azul+"Has aumentado tu defensa a: " + puntosDefensaJugador + reset);
                    System.out.println(azul+"Los puntos de vida del Enemigo son: "+reset + rojo+puntosVidaEnemigo+reset);
                    break;
                case 3: // Ataque Especial

                    int danioEspecial = ataqueEspecialJugador - puntosDefensaEnemigo;
                    if (danioEspecial < 0) danioEspecial = 0;
                    if (contadorAtaqueEspecial<3) {       //Contador de ataque especial. Limite 3 veces por partida
                        contadorAtaqueEspecial++;
                        puntosVidaEnemigo -= danioEspecial;
                        System.out.println(amarillo+"¡¡Has Lanzado el Ataque Especial!!"+ reset);
                        System.out.println(azul+" Has usado "+reset + amarillo+contadorAtaqueEspecial+reset + azul+" de 3 usos"+reset);
                        System.out.println(azul+"Se han infligido "+reset + amarillo+danioEspecial+reset + azul+" puntos de daño con el ataque especial. Vida restante del enemigo: "+reset + rojo+puntosVidaEnemigo+reset);

                    } else {                              //Si se supero el limite, se realizará un ataque normal
                         daniooInfligido = puntosAtaqueJugador - puntosDefensaEnemigo;
                        if (daniooInfligido < 0) daniooInfligido = 0;
                        puntosVidaEnemigo = puntosVidaEnemigo - daniooInfligido;
                        System.out.println(amarillo+"El ataque especial ya no se puede usar"+reset);
                        System.out.println(azul+"En su lugar se ha realizado un ataque normal"+reset);
                        System.out.println(azul+"Se han infligido "+reset + rojo+daniooInfligido+reset + azul+" puntos de daño. Vida restante del enemigo: "+reset + rojo+puntosVidaEnemigo+reset);

                    }

                    break;
                case 4: // Curarse y se suma a la vida
                    int curacion = 15;
                    puntosVidaJugador = puntosVidaJugador + curacion;
                    System.out.println(azul+"Has usado Curacion. Vida total: "+reset + Cyan+puntosVidaJugador+reset);
                    break;
            }
            //Mostramos la vida del jugador y enemigo despues de realizar la accion del jugador         //Imprime el sout representado en el valor i hasta la vida
            System.out.println(azul +"HP: "+reset+ verde + Nombre + reset);
            for (int i = 0; i < (puntosVidaJugador/2)-1; i++) {                                       //Dividido entre dos para reducir a la mitad la visualizacion de la barra
                System.out.print(Cyan+"▒"+reset);
            }
            if (puntosVidaJugador>0) {
                System.out.println(Cyan+"▒"+reset);
            }
            //Barra de vida Enemigo
            System.out.println(rojo+"HP: " +reset + morado+" Enemigo "+reset);
            for (int i = 0; i < (puntosVidaEnemigo/2)-1; i++) {
                System.out.print(rojo+"▒"+reset);
            }
            if (puntosVidaEnemigo>0) {
                System.out.println(rojo+"▒"+reset);
            }

            //Si el enemigo muere mostramos lo siguiente
            if (puntosVidaEnemigo <= 0) {
                System.out.println(amarillo+"¡Has derrotado al enemigo!"+reset);
                System.out.println(amarillo+
                        "██╗  ██╗ █████╗ ███████╗     ██████╗  █████╗ ███╗   ██╗ █████╗ ██████╗  ██████╗ \n" +
                        "██║  ██║██╔══██╗██╔════╝    ██╔════╝ ██╔══██╗████╗  ██║██╔══██╗██╔══██╗██╔═══██╗\n" +
                        "███████║███████║███████╗    ██║  ███╗███████║██╔██╗ ██║███████║██║  ██║██║   ██║\n" +
                        "██╔══██║██╔══██║╚════██║    ██║   ██║██╔══██║██║╚██╗██║██╔══██║██║  ██║██║   ██║\n" +
                        "██║  ██║██║  ██║███████║    ╚██████╔╝██║  ██║██║ ╚████║██║  ██║██████╔╝╚██████╔╝\n" +
                        "╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝     ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═════╝  ╚═════╝ "+reset);
                System.out.println(amarillo+Aventura+reset);
                System.out.println(azul+"Gracias por jugar con nosotros a BattleRoyalJava"+reset);
                break;
                //Fin de la patida.
            }

            // Turno del enemigo
            //mostramos sus estadisticas sobre las que se realiza la accion
            System.out.println(amarillo+"\nEl enemigo elige su acción..."+reset);

            System.out.println(Enemigo + morado +" A PeleaaA!!"+reset);
            System.out.println(amarillo+"**************************************"+reset);
            System.out.println(Cyan +"*     Estadísticas del enemigo:      *"+reset);
            System.out.println("*  Puntos de Vida: " + rojo +puntosVidaEnemigo+reset + "               *");
            System.out.println("*  Puntos de Ataque: " + morado +puntosAtaqueEnemigo+reset + "              *");
            System.out.println("*  Puntos de Defensa: " + azul+puntosDefensaEnemigo+reset + "             *");
            System.out.println("*  Puntos de Ataque Especial: " + amarillo+puntosAtaqueEspecialEnemigo+reset + "     *");
            System.out.println(amarillo+"**************************************"+reset);

            //Enemigo inteligente, programado por turnos y una funcion esPrimo. Metodo externo static booleano
            int accionEnemigo = 0;
            if (puntosVidaEnemigo > (puntosVidaEnemigo * 0.15)) { // Fase 1 mas del 15 % de vida
                if (esPrimo(turno)) {       //esPrimo metodo boolean
                    accionEnemigo = 1; // Ataque normal enemigo

                } else if (turno % 2 == 0) {
                    accionEnemigo = 2; // Defensa Enemigo   en turnos pares

                } else if (turno==3){
                    accionEnemigo = 4;
                }
                else if (turno == 5) {     //Turno 5 enemigo realiza ataque especial
                    accionEnemigo = 3;
                } else if (turno==7) {       //Turno 7 se bufan las estadisticas de daño y se realiza ataque
                    puntosAtaqueEnemigo += 20;
                    accionEnemigo = 1;
                    System.out.println(morado+"El enemigo experimento un aumento de experiencia de ataque"+reset);
                    System.out.println(azul+"el ataque subio a "+reset + morado+puntosAtaqueEnemigo+reset);
                } else if (turno == 9) {
                    accionEnemigo = 1;
                } else if (turno == 11) {
                    accionEnemigo = 1;
                }
                // Turno 13 Enemigo entra en modo Berserker. Game Over
                else if (turno ==13) {
                    accionEnemigo = 3;
                    puntosAtaqueEspecialEnemigo = 500;
                    System.out.println(rojo +"El enemigo entro en modo Berserker"+ reset);

                }
            } else { // Fase 2
                //Generamos un objeto random con numero aleatorio
                int rand = random.nextInt(100);
                if (rand < 33) {
                    accionEnemigo = 4; // Curar

                } else if (rand > 33 && rand < 66) {
                    accionEnemigo = (random.nextBoolean()) ? 1 : 2; // Ataque normal o Defensa (50% probabilidad)
                } else {
                    accionEnemigo = 3; // Ataque especial
                }
            }
            switch (accionEnemigo) {              //Switch de accion del enemigo
                case 1: // Atacar
                    int danioInfligidoE = puntosAtaqueEnemigo - puntosDefensaJugador;
                    if (danioInfligidoE < 0) danioInfligidoE = 0;
                    puntosVidaJugador -= danioInfligidoE;
                    System.out.println(azul +"Se tomo la acción de atacar"+ reset);
                    System.out.println(azul +"Se han infligido "+reset + rojo+danioInfligidoE+reset + azul+" puntos de daño. Vida restante del Jugador: "+reset + Cyan+puntosVidaJugador+reset);
                    break;
                case 2: // Defensa
                    int defensaEnemigo = 5;
                    if (puntosDefensaEnemigo >= 50) {    //Limitador de Defensa
                        System.out.println(azul+"La defensa esta subida al máximo"+reset);
                        danioInfligidoE = puntosAtaqueEnemigo - puntosDefensaJugador;        //Cambia a opcion de atacar reprogramada
                        if (danioInfligidoE < 0) danioInfligidoE = 0;
                        puntosVidaJugador -= danioInfligidoE;
                        System.out.println(azul+"Se tomo la acción de atacar"+reset);
                        System.out.println(azul +"Se han infligido "+reset + rojo+danioInfligidoE+reset + azul+" puntos de daño. Vida restante del Jugador: "+reset + Cyan+puntosVidaJugador+reset);
                        break;
                    }
                    puntosDefensaEnemigo += defensaEnemigo;
                    System.out.println(azul+"El Enemigo aumento su defensa a: " + puntosDefensaEnemigo + reset);
                    System.out.println(azul+"Los puntos de vida del Jugador son: "+reset + Cyan+puntosVidaJugador+reset);
                    break;
                case 3: // Ataque Especial
                    int dañoEspecialEnemigo = puntosAtaqueEspecialEnemigo - puntosDefensaJugador;
                    if (dañoEspecialEnemigo < 0) dañoEspecialEnemigo = 0;
                    puntosVidaJugador -= dañoEspecialEnemigo;
                    System.out.println(amarillo+"El Enemigo lanzo su ataque especial"+reset);
                    System.out.println(azul+"Se han infligido "+reset + amarillo+dañoEspecialEnemigo+reset + azul+" puntos de daño con el ataque especial. Vida restante del Jugador: "+reset + Cyan+puntosVidaJugador+reset);
                    break;
                case 4: // Curarse
                    int curacionE = 15;
                    puntosVidaEnemigo = puntosVidaEnemigo + curacionE;
                    System.out.println(morado+"ViiiiDaaaaaaa niam niam"+reset);
                    System.out.println(azul+"El enemigo uso Curacion. Vida total: "+reset + rojo+puntosVidaEnemigo+reset);
                    break;
            }   //Final del Switch de accion Enemigo

            //Mostramos barra de vida del enemigo
            System.out.println(rojo+"HP: " +reset + morado+" Enemigo "+reset);
            for (int i = 0; i < (puntosVidaEnemigo/2)-1; i++) {
                System.out.print(rojo+"▒"+reset);
            }
            if (puntosVidaEnemigo>0) {
                System.out.println(rojo+"▒"+reset);
            }

            //Mostramos la vida del Jugador
            System.out.println(azul +"HP: "+reset+ verde + Nombre + reset);
            for (int i = 0; i < (puntosVidaJugador/2)-1; i++) {
                System.out.print(Cyan+"▒"+reset);
            }
            if (puntosVidaJugador>0) {
                System.out.println(Cyan+"▒"+reset);
            }

            //Si el jugadoor muere mostramos lo siguiente
            if (puntosVidaJugador <= 0) {
                System.out.println(morado+"Has sido derrotado por el enemigo."+reset);
                System.out.println(rojo+
                        "██╗  ██╗ █████╗ ███████╗    ██████╗ ███████╗██████╗ ██████╗ ██╗██████╗  ██████╗ \n" +
                        "██║  ██║██╔══██╗██╔════╝    ██╔══██╗██╔════╝██╔══██╗██╔══██╗██║██╔══██╗██╔═══██╗\n" +
                        "███████║███████║███████╗    ██████╔╝█████╗  ██████╔╝██║  ██║██║██║  ██║██║   ██║\n" +
                        "██╔══██║██╔══██║╚════██║    ██╔═══╝ ██╔══╝  ██╔══██╗██║  ██║██║██║  ██║██║   ██║\n" +
                        "██║  ██║██║  ██║███████║    ██║     ███████╗██║  ██║██████╔╝██║██████╔╝╚██████╔╝\n" +
                        "╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝    ╚═╝     ╚══════╝╚═╝  ╚═╝╚═════╝ ╚═╝╚═════╝  ╚═════╝ "+reset);
                System.out.println(rojo+Aventura+reset);
                System.out.println(azul+"Gracias por jugar con nosotros a BattleRoyalJava"+reset);
                break;
                // Fin de la partida.
            }
            //Si no muere el jugador     Aumenta el turno y se vuelve al inicio del bucle
            turno++;

        }
    }
        //Metodo static boolean creado, con nombre esPrimo y con un valor int num
    public static boolean esPrimo(int num) {

        // Static sirve para crear miembros que pertenecen a la clase, y no a una instancia de la clase.
        // Esto implica, entre otras cosas, que no es necesario crear un objeto de la clase para poder acceder a estos atributos y métodos.
        //Un metodo static solo puede acceder a datos estaticos

        //El modificador static permite acceder a las variables y métodos aunque no tengamos una instancia del objeto que los contiene

        for (int i = 2; i <= num; i++) {    //Si el numero es Primo nos retorn verdadero
            if (num % i == 0) {             //Si numero dividido entre i es igual a 0, nos retorna es falso
                return false;
            }
        }
        return true;
    }
}
