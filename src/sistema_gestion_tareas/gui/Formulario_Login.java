// Archivo: gui/Formulario_Login.java
// Paquete: sistema_gestion_tareas.gui

package sistema_gestion_tareas.gui;

import sistema_gestion_tareas.dao.UsuarioDao;
import sistema_gestion_tareas.modulos.Usuario;
import javax.swing.JOptionPane;
import java.awt.Color; // Importa la clase Color
import java.awt.Font; // Importa la clase Font
import java.sql.SQLException; // Para manejar excepciones SQL

public class Formulario_Login extends javax.swing.JFrame {

    // Constructor de la clase
    public Formulario_Login() {
        initComponents();
        // Opcional: Centrar la ventana al iniciar
        setLocationRelativeTo(null);
        // Opcional: Establecer el color de fondo del content pane directamente aquí
        getContentPane().setBackground(new Color(45, 45, 45)); // Un gris oscuro para el fondo

        // Ajustar placeholder para Usuario
        txtUsuario.setForeground(Color.GRAY);
        txtUsuario.setText("Introduce tu nombre de usuario");
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtUsuario.getText().equals("Introduce tu nombre de usuario")) {
                    txtUsuario.setText("");
                    txtUsuario.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtUsuario.getText().isEmpty()) {
                    txtUsuario.setForeground(Color.GRAY);
                    txtUsuario.setText("Introduce tu nombre de usuario");
                }
            }
        });

        // Ajustar placeholder para Contraseña
        pwdContrasena.setForeground(Color.GRAY);
        pwdContrasena.setText("Introduce tu contraseña");
        pwdContrasena.setEchoChar((char) 0); // Para mostrar el texto placeholder
        pwdContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (new String(pwdContrasena.getPassword()).equals("Introduce tu contraseña")) {
                    pwdContrasena.setText("");
                    pwdContrasena.setForeground(Color.WHITE);
                    pwdContrasena.setEchoChar('*'); // Volver a ocultar al escribir
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (new String(pwdContrasena.getPassword()).isEmpty()) {
                    pwdContrasena.setForeground(Color.GRAY);
                    pwdContrasena.setText("Introduce tu contraseña");
                    pwdContrasena.setEchoChar((char) 0); // Mostrar placeholder
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // Renombrado a lblTituloLogin
        lblTituloLogin = new javax.swing.JLabel();
        // Renombrado y tipo cambiado a JPasswordField
        pwdContrasena = new javax.swing.JPasswordField();
        // Renombrado a txtUsuario
        txtUsuario = new javax.swing.JTextField();
        // Renombrado y tipo cambiado a JButton
        btnIngresar = new javax.swing.JButton();
        // Etiqueta para mensajes de error (nueva)
        lblMensajeError = new javax.swing.JLabel();
        // Botón de registro (opcional, nuevo)
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión"); // Añadido título de la ventana
        setResizable(false); // Hacemos la ventana no redimensionable

        // Propiedades de lblTituloLogin (antes jLabel1)
        lblTituloLogin.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // Fuente más grande
        lblTituloLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloLogin.setText("Iniciar Sesión"); // Texto cambiado

        // Propiedades de txtUsuario (antes jTextField2)
        txtUsuario.setBackground(new java.awt.Color(51, 51, 51));
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16));
        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        // El texto "Usuario" se gestiona con el FocusListener
        txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Padding interno
        txtUsuario.setCaretColor(Color.WHITE); // Color del cursor

        // Propiedades de pwdContrasena (antes jTextField3, ahora JPasswordField)
        pwdContrasena.setBackground(new java.awt.Color(51, 51, 51));
        pwdContrasena.setFont(new java.awt.Font("Segoe UI", 0, 16));
        pwdContrasena.setForeground(new java.awt.Color(153, 153, 153));
        // El texto "Contraseña" se gestiona con el FocusListener
        pwdContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Padding interno
        pwdContrasena.setCaretColor(Color.WHITE); // Color del cursor

        // Propiedades de btnIngresar (antes jTextField1, ahora JButton)
        btnIngresar.setBackground(new java.awt.Color(0, 102, 255));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // Fuente más apropiada para un botón
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorderPainted(false); // Quitar borde
        btnIngresar.setFocusPainted(false); // Quitar recuadro de foco
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt); // Nuevo nombre de método para el evento
            }
        });

        // Propiedades de lblMensajeError (nuevo JLabel para errores)
        lblMensajeError.setFont(new java.awt.Font("Segoe UI", 0, 12)); // Fuente más pequeña
        lblMensajeError.setForeground(new java.awt.Color(255, 51, 51)); // Color rojo para errores
        lblMensajeError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensajeError.setText(""); // Inicialmente vacío
        lblMensajeError.setVisible(false); // Inicialmente invisible

        // Propiedades de btnRegistrar (nuevo JButton opcional)
        btnRegistrar.setBackground(new java.awt.Color(80, 80, 80)); // Un gris más oscuro
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 14));
        btnRegistrar.setForeground(new java.awt.Color(200, 200, 200));
        btnRegistrar.setText("¿No tienes cuenta? Regístrate");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setContentAreaFilled(false); // Hacerlo parecer un enlace
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });


        // --- Diseño con GroupLayout ---
        // Se ha ajustado el layout para una mejor organización visual
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTituloLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(pwdContrasena)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMensajeError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTituloLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pwdContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMensajeError)
                .addGap(18, 18, 18)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack(); // Ajusta el tamaño de la ventana a sus componentes preferidos.
    }// </editor-fold>//GEN-END:initComponents

    // --- Métodos de eventos de los componentes (aquí irá la lógica) ---

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {
        String username = txtUsuario.getText();
        String password = new String(pwdContrasena.getPassword());

        if (username.isEmpty() || password.isEmpty() ||
            username.equals("Introduce tu nombre de usuario") ||
            password.equals("Introduce tu contraseña")) {
            lblMensajeError.setText("Por favor, introduce usuario y contraseña.");
            lblMensajeError.setVisible(true);
            return;
        }

        UsuarioDao usuarioDao = new UsuarioDao();
        try {
            java.util.Optional<Usuario> optionalUsuario = usuarioDao.obtenerUsuarioPorNombreUsuario(username);

            if (optionalUsuario.isPresent()) {
                Usuario usuario = optionalUsuario.get();
                // TODO: En una app real, aquí usarías un hash seguro (ej. BCrypt) para verificar la contraseña
                // boolean passwordCorrecta = BCrypt.checkpw(password, usuario.getPasswordHash());
                // Por ahora, una verificación simple (¡NO USAR EN PRODUCCIÓN!)
                boolean passwordCorrecta = usuario.getPasswordHash().equals(password); // ¡Esto es inseguro!

                if (passwordCorrecta) {
                    JOptionPane.showMessageDialog(this, "¡Bienvenido, " + usuario.getNombreUsuario() + "!", "Inicio de Sesión Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    lblMensajeError.setVisible(false);

                    // TODO: Aquí deberías pasar el usuario autenticado al siguiente formulario (Gestion_Tareas)
                    // y luego ocultar o cerrar este formulario.
                    Gestion_Tareas gestionTareas = new Gestion_Tareas(usuario); // Pasa el usuario logueado
                    gestionTareas.setVisible(true);
                    this.dispose(); // Cierra el formulario de login

                } else {
                    lblMensajeError.setText("Usuario o contraseña incorrectos.");
                    lblMensajeError.setVisible(true);
                }
            } else {
                lblMensajeError.setText("Usuario o contraseña incorrectos.");
                lblMensajeError.setVisible(true);
            }
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        // Ocultar el formulario de login temporalmente
        this.setVisible(false);

        // Crear y mostrar el formulario de registro
        Formulario_Registro registroForm = new Formulario_Registro();
        registroForm.setVisible(true);

        // Añadir un listener para cuando el formulario de registro se cierre
        registroForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Cuando el formulario de registro se cierra, mostramos de nuevo el de login
                setVisible(true);
                // Opcional: Limpiar campos del login si el usuario se registró o simplemente canceló
                txtUsuario.setText("Introduce tu nombre de usuario");
                txtUsuario.setForeground(Color.GRAY);
                pwdContrasena.setText("Introduce tu contraseña");
                pwdContrasena.setForeground(Color.GRAY);
                pwdContrasena.setEchoChar((char) 0);
                lblMensajeError.setVisible(false);
            }
        });
    }

    // El main method debe permanecer en Sistema_Gestion_Tareas.java
    // Este método main es para pruebas directas del JFrame si lo ejecutas solo.
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Login().setVisible(true);
            }
        });
    }

    // --- Variables de componentes (renombradas y tipos cambiados) ---
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar; // Antes jTextField1
    private javax.swing.JButton btnRegistrar; // Nuevo botón de registro
    private javax.swing.JLabel lblMensajeError; // Nueva etiqueta para mensajes de error
    private javax.swing.JLabel lblTituloLogin; // Antes jLabel1
    private javax.swing.JPasswordField pwdContrasena; // Antes jTextField3, ahora JPasswordField
    private javax.swing.JTextField txtUsuario; // Antes jTextField2
    // End of variables declaration//GEN-END:variables
}