package TRIVIAL.TRIVIAL.models;

public class Administrador {
    private String usuario;
    private String contrasena;
    private String nombre;

    public Administrador(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = usuario; // Nombre puede ser el usuario por simplicidad
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }
}