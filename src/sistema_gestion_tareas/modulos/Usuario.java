package sistema_gestion_tareas.modulos;

public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String passwordHash; // Contraseña hasheada (¡importante!)
    private String email;

    // Constructor vacío (necesario para algunas operaciones de frameworks o para instanciación simple)
    public Usuario() {
    }

    // Constructor con todos los campos (excepto ID, que será autogenerado)
    public Usuario(String nombreUsuario, String passwordHash, String email) {
        this.nombreUsuario = nombreUsuario;
        this.passwordHash = passwordHash;
        this.email = email;
    }

    // --- Getters y Setters ---

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "idUsuario=" + idUsuario +
               ", nombreUsuario='" + nombreUsuario + '\'' +
               ", email='" + email + '\'' +
               '}';
    }    

}
