package TRIVIAL_C_S_MODELO.CLASES;


public class User {
    private int id; // En caso de que el ID sea necesario
    private String username;
    private String password;
    private String name;

    // Constructor con nombre completo
    public User(String username, String password, String name) {
        if (username == null || username.isBlank() ||
                password == null || password.isBlank() ||
                name == null || name.isBlank()) {
            throw new IllegalArgumentException("Username, password y name no pueden ser nulos o vacíos.");
        }
        this.username = username;
        this.password = password;
        this.name = name;
    }

    // Constructor con ID
    public User(int id, String username, String password) {
        this(username, password, ""); // Por defecto, el nombre puede ser vacío
        this.id = id;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username no puede ser nulo o vacío.");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password no puede ser nulo o vacío.");
        }
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name no puede ser nulo o vacío.");
        }
        this.name = name;
    }
}