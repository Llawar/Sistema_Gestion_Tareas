package sistema_gestion_tareas.dao;

import sistema_gestion_tareas.modulos.Usuario; // Importa tu clase Usuario
import sistema_gestion_tareas.conexion; // ¡CORREGIDO AQUÍ! Importa la clase 'conexion'
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional; // Para manejar casos donde el usuario no se encuentra

public class UsuarioDao {

    /**
     * Guarda un nuevo usuario en la base de datos.
     * @param usuario El objeto Usuario a guardar. Su ID será autogenerado.
     * @return true si el usuario se guardó exitosamente, false en caso contrario.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public boolean guardarUsuario(Usuario usuario) throws SQLException { // Método renombrado
        String sql = "INSERT INTO usuarios (nombre_usuario, password_hash, email) VALUES (?, ?, ?)";
        try (Connection conn = conexion.getConnection(); // ¡CORREGIDO AQUÍ!
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, usuario.getNombreUsuario()); // Accede al nombre de usuario
            pstmt.setString(2, usuario.getPasswordHash());
            pstmt.setString(3, usuario.getEmail());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        usuario.setIdUsuario(generatedKeys.getInt(1)); // Asigna el ID generado
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un usuario por su ID.
     * @param idUsuario El ID del usuario.
     * @return Un Optional que contiene el Usuario si se encuentra, o un Optional vacío.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public Optional<Usuario> obtenerUsuarioPorId(int idUsuario) throws SQLException { // Método renombrado
        String sql = "SELECT id_usuario, nombre_usuario, password_hash, email FROM usuarios WHERE id_usuario = ?";
        try (Connection conn = conexion.getConnection(); // ¡CORREGIDO AQUÍ!
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario(); // Crea una nueva instancia de Usuario
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                    usuario.setPasswordHash(rs.getString("password_hash"));
                    usuario.setEmail(rs.getString("email"));
                    return Optional.of(usuario);
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Busca un usuario por su nombre de usuario.
     * @param nombreUsuario El nombre de usuario.
     * @return Un Optional que contiene el Usuario si se encuentra, o un Optional vacío.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public Optional<Usuario> obtenerUsuarioPorNombreUsuario(String nombreUsuario) throws SQLException { // Método renombrado
        String sql = "SELECT id_usuario, nombre_usuario, password_hash, email FROM usuarios WHERE nombre_usuario = ?";
        try (Connection conn = conexion.getConnection(); // ¡CORREGIDO AQUÍ!
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombreUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                    usuario.setPasswordHash(rs.getString("password_hash"));
                    usuario.setEmail(rs.getString("email"));
                    return Optional.of(usuario);
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Actualiza la información de un usuario existente.
     * @param usuario El objeto Usuario con la información actualizada.
     * @return true si el usuario se actualizó exitosamente, false en caso contrario.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public boolean actualizarUsuario(Usuario usuario) throws SQLException { // Método renombrado
        String sql = "UPDATE usuarios SET nombre_usuario = ?, password_hash = ?, email = ? WHERE id_usuario = ?";
        try (Connection conn = conexion.getConnection(); // ¡CORREGIDO AQUÍ!
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getPasswordHash());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setInt(4, usuario.getIdUsuario());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    /**
     * Elimina un usuario de la base de datos.
     * @param idUsuario El ID del usuario a eliminar.
     * @return true si el usuario se eliminó exitosamente, false en caso contrario.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public boolean eliminarUsuario(int idUsuario) throws SQLException { // Método renombrado
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (Connection conn = conexion.getConnection(); // ¡CORREGIDO AQUÍ!
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }
}