package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.validador_usuario_REGEX;
public class Usuario {
    private String nombre;
    private String email;
    private String contra;

    public Usuario(String nombre, String email, String contra) {
        this.nombre = nombre;
        this.email = email;
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContra() {
        return contra;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contra='" + contra + '\'' +
                '}';
    }
}
