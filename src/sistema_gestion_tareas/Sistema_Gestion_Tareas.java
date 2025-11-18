// Archivo: Sistema_Gestion_Tareas.java
// Paquete: sistema_gestion_tareas

package sistema_gestion_tareas;

import sistema_gestion_tareas.gui.Formulario_Login;
import sistema_gestion_tareas.conexion; // Este import es correcto ahora
import javax.swing.SwingUtilities;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Sistema_Gestion_Tareas {

    public static void main(String[] args) {
        // 1. Inicializar la base de datos (crear tablas si no existen)
        initializeDatabase();

        // 2. Ejecutar la interfaz gráfica en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            Formulario_Login loginForm = new Formulario_Login();
            loginForm.setVisible(true);
        });
    }

    /**
     * Inicializa la base de datos, creando las tablas necesarias si no existen.
     */
    private static void initializeDatabase() {
        try (Connection conn = conexion.getConnection(); // La llamada a getConnection() es correcta
             Statement stmt = conn.createStatement()) {

            // Tabla de Usuarios
            String createUserTableSQL = "CREATE TABLE IF NOT EXISTS usuarios ("
                                      + "id_usuario INT AUTO_INCREMENT PRIMARY KEY,"      // Corregido para MySQL
                                      + "nombre_usuario VARCHAR(100) NOT NULL UNIQUE,"    // Corregido de TEXT a VARCHAR
                                      + "password_hash VARCHAR(255) NOT NULL,"            // Corregido de TEXT a VARCHAR
                                      + "email VARCHAR(255)"                              // Corregido de TEXT a VARCHAR
                                      + ");";
            stmt.execute(createUserTableSQL);

            // Tabla de Tareas
            String createTaskTableSQL = "CREATE TABLE IF NOT EXISTS tareas ("
                                      + "id_tarea INT AUTO_INCREMENT PRIMARY KEY,"        // Corregido para MySQL
                                      + "titulo VARCHAR(255) NOT NULL,"                   // Corregido de TEXT a VARCHAR
                                      + "descripcion TEXT,"                               // TEXT es aceptable aquí
                                      + "fecha_vencimiento DATE,"                         // Corregido de TEXT a DATE
                                      + "prioridad VARCHAR(50) NOT NULL,"                 // Corregido de TEXT a VARCHAR
                                      + "estado VARCHAR(50) NOT NULL,"                    // Corregido de TEXT a VARCHAR
                                      + "fecha_creacion DATE NOT NULL,"                   // Corregido de TEXT a DATE
                                      + "id_usuario INT NOT NULL,"
                                      + "FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE" // Añadido CASCADE para buena práctica
                                      + ");";
            stmt.execute(createTaskTableSQL);

            System.out.println("Tablas de la base de datos verificadas/creadas.");

        } catch (SQLException e) {
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
            e.printStackTrace();
            // Considera salir de la aplicación o mostrar un mensaje de error crítico
        }
    }
}