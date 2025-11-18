package sistema_gestion_tareas.dao;

import sistema_gestion_tareas.modulos.Tarea;
import sistema_gestion_tareas.modulos.Prioridad;
import sistema_gestion_tareas.modulos.Estado;
import sistema_gestion_tareas.conexion; // Este import es CORRECTO
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate; // Para manejar fechas en Java 8+
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TareaDao {

    /**
     * Guarda una nueva tarea en la base de datos.
     * @param tarea El objeto Tarea a guardar. Su ID será autogenerado.
     * @return true si la tarea se guardó exitosamente, false en caso contrario.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public boolean guardarTarea(Tarea tarea) throws SQLException { // Método renombrado
        String sql = "INSERT INTO tareas (titulo, descripcion, fecha_vencimiento, prioridad, estado, fecha_creacion, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexion.getConnection(); // ¡CORREGIDO AQUÍ!
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, tarea.getTitulo());
            pstmt.setString(2, tarea.getDescripcion());
            pstmt.setString(3, tarea.getFechaVencimiento() != null ? tarea.getFechaVencimiento().toString() : null);
            pstmt.setString(4, tarea.getPrioridad().name());
            pstmt.setString(5, tarea.getEstado().name());
            pstmt.setString(6, tarea.getFechaCreacion().toString());
            pstmt.setInt(7, tarea.getIdUsuario());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        tarea.setIdTarea(generatedKeys.getInt(1)); // Asigna el ID generado
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Busca una tarea por su ID.
     * @param idTarea El ID de la tarea.
     * @return Un Optional que contiene la Tarea si se encuentra, o un Optional vacío.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public Optional<Tarea> obtenerTareaPorId(int idTarea) throws SQLException { // Método renombrado
        String sql = "SELECT id_tarea, titulo, descripcion, fecha_vencimiento, prioridad, estado, fecha_creacion, id_usuario FROM tareas WHERE id_tarea = ?";
        try (Connection conn = conexion.getConnection(); // ¡CORREGIDO AQUÍ!
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idTarea);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToTarea(rs));
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Obtiene todas las tareas para un usuario específico.
     * @param idUsuario El ID del usuario.
     * @return Una lista de tareas del usuario. Puede estar vacía si no hay tareas.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public List<Tarea> obtenerTareasPorIdUsuario(int idUsuario) throws SQLException { // Método renombrado
        List<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT id_tarea, titulo, descripcion, fecha_vencimiento, prioridad, estado, fecha_creacion, id_usuario FROM tareas WHERE id_usuario = ?";
        try (Connection conn = conexion.getConnection(); // ¡CORREGIDO AQUÍ!
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    tareas.add(mapResultSetToTarea(rs));
                }
            }
        }
        return tareas;
    }

    /**
     * Actualiza la información de una tarea existente.
     * @param tarea El objeto Tarea con la información actualizada.
     * @return true si la tarea se actualizó exitosamente, false en caso contrario.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public boolean actualizarTarea(Tarea tarea) throws SQLException { // Método renombrado
        String sql = "UPDATE tareas SET titulo = ?, descripcion = ?, fecha_vencimiento = ?, prioridad = ?, estado = ? WHERE id_tarea = ? AND id_usuario = ?";
        try (Connection conn = conexion.getConnection(); // ¡CORREGIDO AQUÍ!
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarea.getTitulo());
            pstmt.setString(2, tarea.getDescripcion());
            pstmt.setString(3, tarea.getFechaVencimiento() != null ? tarea.getFechaVencimiento().toString() : null);
            pstmt.setString(4, tarea.getPrioridad().name());
            pstmt.setString(5, tarea.getEstado().name());
            pstmt.setInt(6, tarea.getIdTarea());
            pstmt.setInt(7, tarea.getIdUsuario());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    /**
     * Elimina una tarea de la base de datos.
     * @param idTarea El ID de la tarea a eliminar.
     * @param idUsuario El ID del usuario al que pertenece la tarea (para seguridad).
     * @return true si la tarea se eliminó exitosamente, false en caso contrario.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public boolean eliminarTarea(int idTarea, int idUsuario) throws SQLException { // Método renombrado
        String sql = "DELETE FROM tareas WHERE id_tarea = ? AND id_usuario = ?";
        try (Connection conn = conexion.getConnection(); // ¡CORREGIDO AQUÍ!
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idTarea);
            pstmt.setInt(2, idUsuario);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    /**
     * Método auxiliar para mapear un ResultSet a un objeto Tarea.
     */
    private Tarea mapResultSetToTarea(ResultSet rs) throws SQLException {
        Tarea tarea = new Tarea();
        tarea.setIdTarea(rs.getInt("id_tarea"));
        tarea.setTitulo(rs.getString("titulo"));
        tarea.setDescripcion(rs.getString("descripcion"));

        String fechaVencimientoStr = rs.getString("fecha_vencimiento");
        if (fechaVencimientoStr != null) {
            tarea.setFechaVencimiento(LocalDate.parse(fechaVencimientoStr));
        }

        tarea.setPrioridad(Prioridad.valueOf(rs.getString("prioridad")));
        tarea.setEstado(Estado.valueOf(rs.getString("estado")));
        tarea.setFechaCreacion(LocalDate.parse(rs.getString("fecha_creacion")));
        tarea.setIdUsuario(rs.getInt("id_usuario"));
        return tarea;
    }
}