// Archivo: conexion.java
// Paquete: sistema_gestion_tareas

package sistema_gestion_tareas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    // --- CONFIGURACIÓN PARA MySQL/MariaDB EN XAMPP ---
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Driver para MySQL 8+ (MariaDB es compatible)
    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/gestion_tareas"; // La URL de tu DB en XAMPP
    private static final String USER = "root"; // Usuario por defecto de MySQL en XAMPP (sin contraseña)
    private static final String PASSWORD = ""; // Contraseña por defecto (vacía) de MySQL en XAMPP
    // --- FIN DE CONFIGURACIÓN ---


    /**
     * Establece y devuelve una conexión a la base de datos MySQL/MariaDB.
     *
     * @return Una instancia de Connection a la base de datos.
     * @throws SQLException Si ocurre un error al intentar conectar a la base de datos.
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            // Cargar el driver JDBC de MySQL/MariaDB.
            // Es buena práctica, aunque en Java modernos no siempre es estrictamente necesario
            // si el driver está en el classpath y se auto-registra.
            Class.forName(DRIVER);

            conn = DriverManager.getConnection(URL_DATABASE, USER, PASSWORD);
            System.out.println("Conexión a la base de datos MySQL/MariaDB establecida exitosamente.");
            return conn;
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos MySQL/MariaDB: " + e.getMessage());
            throw e; // Relanza la excepción
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC de MySQL/MariaDB no encontrado. Asegúrate de que 'mysql-connector-java.jar' esté en el classpath.");
            e.printStackTrace();
            throw new SQLException("Driver JDBC de MySQL/MariaDB no encontrado.", e);
        }
    }

    /**
     * Cierra una conexión a la base de datos.
     * @param conn La conexión a cerrar.
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                // System.out.println("Conexión a la base de datos cerrada."); // Opcional: comentar para menos logs
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}