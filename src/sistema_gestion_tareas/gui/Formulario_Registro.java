// Archivo: gui/Formulario_Registro.java
// Paquete: sistema_gestion_tareas.gui

package sistema_gestion_tareas.gui;

import sistema_gestion_tareas.dao.UsuarioDao;
import sistema_gestion_tareas.modulos.Usuario;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

public class Formulario_Registro extends javax.swing.JFrame {

    public Formulario_Registro() {
        initComponents();
        setLocationRelativeTo(null); // Centrar la ventana
        getContentPane().setBackground(new Color(45, 45, 45)); // Fondo oscuro

        // --- Configuración de Placeholders y FocusListeners para campos ---
        // Placeholder para Usuario
        txtUsuarioRegistro.setForeground(Color.GRAY);
        txtUsuarioRegistro.setText("Define un nombre de usuario");
        txtUsuarioRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtUsuarioRegistro.getText().equals("Define un nombre de usuario")) {
                    txtUsuarioRegistro.setText("");
                    txtUsuarioRegistro.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtUsuarioRegistro.getText().isEmpty()) {
                    txtUsuarioRegistro.setForeground(Color.GRAY);
                    txtUsuarioRegistro.setText("Define un nombre de usuario");
                }
            }
        });

        // Placeholder para Contraseña
        pwdContrasenaRegistro.setForeground(Color.GRAY);
        pwdContrasenaRegistro.setText("Define una contraseña");
        pwdContrasenaRegistro.setEchoChar((char) 0);
        pwdContrasenaRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (new String(pwdContrasenaRegistro.getPassword()).equals("Define una contraseña")) {
                    pwdContrasenaRegistro.setText("");
                    pwdContrasenaRegistro.setForeground(Color.WHITE);
                    pwdContrasenaRegistro.setEchoChar('*');
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (new String(pwdContrasenaRegistro.getPassword()).isEmpty()) {
                    pwdContrasenaRegistro.setForeground(Color.GRAY);
                    pwdContrasenaRegistro.setText("Define una contraseña");
                    pwdContrasenaRegistro.setEchoChar((char) 0);
                }
            }
        });

        // Placeholder para Confirmar Contraseña
        pwdConfirmarContrasena.setForeground(Color.GRAY);
        pwdConfirmarContrasena.setText("Confirma tu contraseña");
        pwdConfirmarContrasena.setEchoChar((char) 0);
        pwdConfirmarContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (new String(pwdConfirmarContrasena.getPassword()).equals("Confirma tu contraseña")) {
                    pwdConfirmarContrasena.setText("");
                    pwdConfirmarContrasena.setForeground(Color.WHITE);
                    pwdConfirmarContrasena.setEchoChar('*');
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (new String(pwdConfirmarContrasena.getPassword()).isEmpty()) {
                    pwdConfirmarContrasena.setForeground(Color.GRAY);
                    pwdConfirmarContrasena.setText("Confirma tu contraseña");
                    pwdConfirmarContrasena.setEchoChar((char) 0);
                }
            }
        });

        // Placeholder para Email
        txtEmailRegistro.setForeground(Color.GRAY);
        txtEmailRegistro.setText("Introduce tu email (opcional)");
        txtEmailRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtEmailRegistro.getText().equals("Introduce tu email (opcional)")) {
                    txtEmailRegistro.setText("");
                    txtEmailRegistro.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtEmailRegistro.getText().isEmpty()) {
                    txtEmailRegistro.setForeground(Color.GRAY);
                    txtEmailRegistro.setText("Introduce tu email (opcional)");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloRegistro = new javax.swing.JLabel();
        txtUsuarioRegistro = new javax.swing.JTextField();
        pwdContrasenaRegistro = new javax.swing.JPasswordField();
        pwdConfirmarContrasena = new javax.swing.JPasswordField();
        txtEmailRegistro = new javax.swing.JTextField();
        btnRegistrarUsuario = new javax.swing.JButton();
        lblMensajeErrorRegistro = new javax.swing.JLabel();
        btnVolverLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
        setTitle("Registro de Usuario");
        setResizable(false);

        lblTituloRegistro.setFont(new java.awt.Font("Segoe UI Black", 1, 24));
        lblTituloRegistro.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloRegistro.setText("Registro de Usuario");

        txtUsuarioRegistro.setBackground(new java.awt.Color(51, 51, 51));
        txtUsuarioRegistro.setFont(new java.awt.Font("Segoe UI", 0, 16));
        txtUsuarioRegistro.setForeground(new java.awt.Color(153, 153, 153));
        txtUsuarioRegistro.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        txtUsuarioRegistro.setCaretColor(new java.awt.Color(255, 255, 255));

        pwdContrasenaRegistro.setBackground(new java.awt.Color(51, 51, 51));
        pwdContrasenaRegistro.setFont(new java.awt.Font("Segoe UI", 0, 16));
        pwdContrasenaRegistro.setForeground(new java.awt.Color(153, 153, 153));
        pwdContrasenaRegistro.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pwdContrasenaRegistro.setCaretColor(new java.awt.Color(255, 255, 255));

        pwdConfirmarContrasena.setBackground(new java.awt.Color(51, 51, 51));
        pwdConfirmarContrasena.setFont(new java.awt.Font("Segoe UI", 0, 16));
        pwdConfirmarContrasena.setForeground(new java.awt.Color(153, 153, 153));
        pwdConfirmarContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pwdConfirmarContrasena.setCaretColor(new java.awt.Color(255, 255, 255));

        txtEmailRegistro.setBackground(new java.awt.Color(51, 51, 51));
        txtEmailRegistro.setFont(new java.awt.Font("Segoe UI", 0, 16));
        txtEmailRegistro.setForeground(new java.awt.Color(153, 153, 153));
        txtEmailRegistro.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        txtEmailRegistro.setCaretColor(new java.awt.Color(255, 255, 255));

        btnRegistrarUsuario.setBackground(new java.awt.Color(0, 153, 51));
        btnRegistrarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18));
        btnRegistrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarUsuario.setText("Registrar");
        btnRegistrarUsuario.setBorderPainted(false);
        btnRegistrarUsuario.setFocusPainted(false);
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });

        lblMensajeErrorRegistro.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblMensajeErrorRegistro.setForeground(new java.awt.Color(255, 51, 51));
        lblMensajeErrorRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensajeErrorRegistro.setText("");
        lblMensajeErrorRegistro.setVisible(false);

        btnVolverLogin.setBackground(new java.awt.Color(80, 80, 80));
        btnVolverLogin.setFont(new java.awt.Font("Segoe UI", 0, 14));
        btnVolverLogin.setForeground(new java.awt.Color(200, 200, 200));
        btnVolverLogin.setText("Volver al Login");
        btnVolverLogin.setBorderPainted(false);
        btnVolverLogin.setFocusPainted(false);
        btnVolverLogin.setContentAreaFilled(false);
        btnVolverLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVolverLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTituloRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuarioRegistro, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pwdContrasenaRegistro, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pwdConfirmarContrasena, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmailRegistro, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(lblMensajeErrorRegistro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTituloRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtUsuarioRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pwdContrasenaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pwdConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtEmailRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMensajeErrorRegistro)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolverLogin)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // --- Lógica del botón de registro ---
    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        lblMensajeErrorRegistro.setVisible(false); // Ocultar mensaje de error anterior

        String username = txtUsuarioRegistro.getText();
        String password = new String(pwdContrasenaRegistro.getPassword());
        String confirmPassword = new String(pwdConfirmarContrasena.getPassword());
        String email = txtEmailRegistro.getText();

        // Validaciones básicas de campos
        if (username.isEmpty() || username.equals("Define un nombre de usuario") ||
            password.isEmpty() || password.equals("Define una contraseña") ||
            confirmPassword.isEmpty() || confirmPassword.equals("Confirma tu contraseña")) {
            lblMensajeErrorRegistro.setText("Todos los campos obligatorios deben llenarse.");
            lblMensajeErrorRegistro.setVisible(true);
            return;
        }
        if (!password.equals(confirmPassword)) {
            lblMensajeErrorRegistro.setText("Las contraseñas no coinciden.");
            lblMensajeErrorRegistro.setVisible(true);
            return;
        }
        if (password.length() < 6) { // Mínimo de 6 caracteres para la contraseña
            lblMensajeErrorRegistro.setText("La contraseña debe tener al menos 6 caracteres.");
            lblMensajeErrorRegistro.setVisible(true);
            return;
        }

        // Si el email es el placeholder, se considera vacío (opcional)
        if (email.equals("Introduce tu email (opcional)")) {
            email = "";
        }

        // TODO: En una aplicación real, aquí deberías hashear la contraseña de forma segura (ej. con BCrypt).
        // Por simplicidad, por ahora la almacenamos como texto plano (¡INSEGURO EN PRODUCCIÓN!).
        String passwordHash = password; // Esto es solo un placeholder, ¡NO ES UN HASH SEGURO!

        Usuario nuevoUsuario = new Usuario(username, passwordHash, email);
        UsuarioDao usuarioDao = new UsuarioDao();

        try {
            if (usuarioDao.guardarUsuario(nuevoUsuario)) {
                JOptionPane.showMessageDialog(this, "Usuario '" + username + "' registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose(); // Cierra la ventana de registro
                // Opcional: Volver al formulario de login para que el usuario inicie sesión
                // new Formulario_Login().setVisible(true);
            } else {
                lblMensajeErrorRegistro.setText("Error al registrar usuario. Intenta de nuevo.");
                lblMensajeErrorRegistro.setVisible(true);
            }
        } catch (SQLException e) {
            // Error común: nombre de usuario duplicado (UNIQUE constraint)
            if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("for key 'usuarios.nombre_usuario'")) {
                lblMensajeErrorRegistro.setText("El nombre de usuario ya existe. Elige otro.");
                lblMensajeErrorRegistro.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    private void btnVolverLoginActionPerformed(java.awt.event.ActionEvent evt) {
        // Al hacer clic en "Volver al Login", simplemente cierra esta ventana
        // El Formulario_Login que la abrió seguirá abierto o deberá ser relanzado si se cerró.
        this.dispose();
    }


    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Formulario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JButton btnVolverLogin;
    private javax.swing.JLabel lblMensajeErrorRegistro;
    private javax.swing.JLabel lblTituloRegistro;
    private javax.swing.JPasswordField pwdConfirmarContrasena;
    private javax.swing.JPasswordField pwdContrasenaRegistro;
    private javax.swing.JTextField txtEmailRegistro;
    private javax.swing.JTextField txtUsuarioRegistro;
    // End of variables declaration//GEN-END:variables
}