package Juego;

import Users.Admin;
import Ficheros.GestionaFicheros;
import Users.User;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @AUTHOR Juan Jose Tornero
 * @DESCRPTION
 *  Permite al usuario con rango de adminitrador realizar laboras de tipo administrativo
 *     como listar las partidas y usuarios registrados.
 *
 */


public class TrivialAdmin {
    //ATRIBUTOS//
    private Admin admin;

    //CONSTRUCTOR//
    public TrivialAdmin(Admin admin) {
        this.admin = admin;
    }
    /** METODO ADMINISTRAR
     * Gestiona la lectura de datos desde archivo y presentacioón de la información por consola
     */
    public void administrar() {
        ArrayList<String> partidas = GestionaFicheros.leePartidas();
        System.out.println("Partidas:");
        for (String partida : partidas) {
            System.out.println(partida);
        }

        ArrayList<String> nombres = new ArrayList<>();
        for (User user : TrivialMain.users) {
            nombres.add(user.getNombre());
        }
        Collections.sort(nombres);
        System.out.println("Usuarios registrados:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}
