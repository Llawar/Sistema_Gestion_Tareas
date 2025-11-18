// Archivo: gui/Formulario_Tarea.java
// Paquete: sistema_gestion_tareas.gui

package sistema_gestion_tareas.gui;

import sistema_gestion_tareas.modulos.Usuario;
import sistema_gestion_tareas.modulos.Tarea;
import sistema_gestion_tareas.modulos.Prioridad;
import sistema_gestion_tareas.modulos.Estado;
import sistema_gestion_tareas.dao.TareaDao;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Formulario_Tarea extends javax.swing.JFrame {

    private Usuario usuarioActual; // El usuario dueño de la tarea
    private Tarea tareaAEditar; // Si es para editar, este objeto contendrá los datos actuales
    private boolean esNuevaTarea; // Bandera para saber si es una nueva tarea o se está editando

    /**
     * Constructor para Formulario_Tarea.
     * @param usuario El usuario logueado.
     * @param tarea Si se pasa una tarea (no null), es para editar. Si es null, es para añadir una nueva tarea.
     */
    public Formulario_Tarea(Usuario usuario, Tarea tarea) {
        this.usuarioActual = usuario;
        this.tareaAEditar = tarea;
        this.esNuevaTarea = (tarea == null);

        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(45, 45, 45)); // Fondo oscuro

        // Rellenar ComboBoxes de Prioridad y Estado
        for (Prioridad p : Prioridad.values()) {
            cmbPrioridad.addItem(p.name());
        }
        for (Estado e : Estado.values()) {
            cmbEstado.addItem(e.name());
        }

        // Si es una tarea existente (editar), cargar sus datos en los campos
        if (!esNuevaTarea) {
            lblTituloFormulario.setText("Editar Tarea");
            btnGuardarTarea.setText("Actualizar Tarea");
            cargarDatosTarea(tareaAEditar);
        } else {
            lblTituloFormulario.setText("Añadir Nueva Tarea");
            btnGuardarTarea.setText("Guardar Tarea");
            // Valores por defecto para nueva tarea
            txtTitulo.setText("Título de la tarea");
            txtTitulo.setForeground(Color.GRAY);
            txtDescripcion.setText("Descripción detallada de la tarea");
            txtDescripcion.setForeground(Color.GRAY);
            txtFechaVencimiento.setText(LocalDate.now().plusWeeks(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))); // Por defecto, una semana en el futuro
            txtFechaVencimiento.setForeground(Color.WHITE); // No es placeholder, es valor inicial
            cmbPrioridad.setSelectedItem(Prioridad.MEDIA.name());
            cmbEstado.setSelectedItem(Estado.PENDIENTE.name()); // Una nueva tarea siempre es Pendiente
        }
        
        // --- Placeholders y FocusListeners para campos de texto/área ---
        // Título
        txtTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtTitulo.getText().equals("Título de la tarea")) {
                    txtTitulo.setText("");
                    txtTitulo.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtTitulo.getText().isEmpty()) {
                    txtTitulo.setForeground(Color.GRAY);
                    txtTitulo.setText("Título de la tarea");
                }
            }
        });
        
        // Descripción
        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtDescripcion.getText().equals("Descripción detallada de la tarea")) {
                    txtDescripcion.setText("");
                    txtDescripcion.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtDescripcion.getText().isEmpty()) {
                    txtDescripcion.setForeground(Color.GRAY);
                    txtDescripcion.setText("Descripción detallada de la tarea");
                }
            }
        });
        // Fecha Vencimiento (no tiene placeholder como tal, sino un formato esperado)
        txtFechaVencimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaVencimiento.setForeground(Color.WHITE);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                // Validación básica de formato
                if (!txtFechaVencimiento.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
                     txtFechaVencimiento.setForeground(Color.RED);
                } else {
                    txtFechaVencimiento.setForeground(Color.WHITE);
                }
            }
        });

    }

    // Método para cargar los datos de una tarea existente
    private void cargarDatosTarea(Tarea tarea) {
        txtTitulo.setText(tarea.getTitulo());
        txtTitulo.setForeground(Color.WHITE);
        txtDescripcion.setText(tarea.getDescripcion());
        txtDescripcion.setForeground(Color.WHITE);
        if (tarea.getFechaVencimiento() != null) {
            txtFechaVencimiento.setText(tarea.getFechaVencimiento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            txtFechaVencimiento.setForeground(Color.WHITE);
        }
        cmbPrioridad.setSelectedItem(tarea.getPrioridad().name());
        cmbEstado.setSelectedItem(tarea.getEstado().name());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        lblTituloFormulario = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblFechaVencimiento = new javax.swing.JLabel();
        txtFechaVencimiento = new javax.swing.JTextField();
        lblPrioridad = new javax.swing.JLabel();
        cmbPrioridad = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        btnGuardarTarea = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblMensajeErrorTarea = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Tarea");
        setResizable(false);

        panelFondo.setBackground(new java.awt.Color(45, 45, 45));
        panelFondo.setLayout(null); // Usamos null layout para posicionamiento manual

        lblTituloFormulario.setFont(new java.awt.Font("Segoe UI Black", 1, 24));
        lblTituloFormulario.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloFormulario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloFormulario.setText("Añadir Nueva Tarea");
        lblTituloFormulario.setBounds(50, 20, 300, 35);
        panelFondo.add(lblTituloFormulario);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblTitulo.setForeground(new java.awt.Color(204, 204, 204));
        lblTitulo.setText("Título:");
        lblTitulo.setBounds(50, 70, 100, 20);
        panelFondo.add(lblTitulo);

        txtTitulo.setBackground(new java.awt.Color(51, 51, 51));
        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        txtTitulo.setCaretColor(new java.awt.Color(255, 255, 255));
        txtTitulo.setBounds(50, 95, 300, 35);
        panelFondo.add(txtTitulo);

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblDescripcion.setForeground(new java.awt.Color(204, 204, 204));
        lblDescripcion.setText("Descripción:");
        lblDescripcion.setBounds(50, 140, 100, 20);
        panelFondo.add(lblDescripcion);

        txtDescripcion.setBackground(new java.awt.Color(51, 51, 51));
        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setLineWrap(true); // Ajuste de línea
        txtDescripcion.setRows(5);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        txtDescripcion.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(txtDescripcion);
        jScrollPane1.setBounds(50, 165, 300, 90);
        panelFondo.add(jScrollPane1);

        lblFechaVencimiento.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblFechaVencimiento.setForeground(new java.awt.Color(204, 204, 204));
        lblFechaVencimiento.setText("Fecha Vencimiento (AAAA-MM-DD):");
        lblFechaVencimiento.setBounds(50, 270, 250, 20);
        panelFondo.add(lblFechaVencimiento);

        txtFechaVencimiento.setBackground(new java.awt.Color(51, 51, 51));
        txtFechaVencimiento.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtFechaVencimiento.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaVencimiento.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        txtFechaVencimiento.setCaretColor(new java.awt.Color(255, 255, 255));
        txtFechaVencimiento.setBounds(50, 295, 150, 35); // Tamaño más pequeño
        panelFondo.add(txtFechaVencimiento);

        lblPrioridad.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblPrioridad.setForeground(new java.awt.Color(204, 204, 204));
        lblPrioridad.setText("Prioridad:");
        lblPrioridad.setBounds(50, 340, 100, 20);
        panelFondo.add(lblPrioridad);

        cmbPrioridad.setBackground(new java.awt.Color(51, 51, 51));
        cmbPrioridad.setFont(new java.awt.Font("Segoe UI", 0, 14));
        cmbPrioridad.setForeground(new java.awt.Color(255, 255, 255));
        cmbPrioridad.setBounds(50, 365, 150, 35);
        panelFondo.add(cmbPrioridad);

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblEstado.setForeground(new java.awt.Color(204, 204, 204));
        lblEstado.setText("Estado:");
        lblEstado.setBounds(200, 340, 100, 20); // Al lado de Prioridad
        panelFondo.add(lblEstado);

        cmbEstado.setBackground(new java.awt.Color(51, 51, 51));
        cmbEstado.setFont(new java.awt.Font("Segoe UI", 0, 14));
        cmbEstado.setForeground(new java.awt.Color(255, 255, 255));
        cmbEstado.setBounds(200, 365, 150, 35); // Al lado de Prioridad
        panelFondo.add(cmbEstado);

        // El estado solo es editable para tareas existentes, no nuevas.
        if (esNuevaTarea) {
            cmbEstado.setEnabled(false); // Deshabilitar el ComboBox de estado para nuevas tareas
            cmbEstado.setSelectedItem(Estado.PENDIENTE.name()); // Asegurarse de que sea Pendiente
        }


        lblMensajeErrorTarea.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblMensajeErrorTarea.setForeground(new java.awt.Color(255, 51, 51));
        lblMensajeErrorTarea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensajeErrorTarea.setText("");
        lblMensajeErrorTarea.setVisible(false);
        lblMensajeErrorTarea.setBounds(50, 420, 300, 16); // Posición debajo de los ComboBoxes
        panelFondo.add(lblMensajeErrorTarea);


        btnGuardarTarea.setBackground(new java.awt.Color(0, 102, 255));
        btnGuardarTarea.setFont(new java.awt.Font("Segoe UI", 1, 18));
        btnGuardarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarTarea.setText("Guardar Tarea");
        btnGuardarTarea.setBorderPainted(false);
        btnGuardarTarea.setFocusPainted(false);
        btnGuardarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTareaActionPerformed(evt);
            }
        });
        btnGuardarTarea.setBounds(50, 450, 300, 50); // Posición manual
        panelFondo.add(btnGuardarTarea);

        btnCancelar.setBackground(new java.awt.Color(80, 80, 80));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14));
        btnCancelar.setForeground(new java.awt.Color(200, 200, 200));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.setBounds(50, 510, 300, 25); // Posición manual
        panelFondo.add(btnCancelar);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // --- Métodos de eventos de los componentes ---
    private void btnGuardarTareaActionPerformed(java.awt.event.ActionEvent evt) {
        lblMensajeErrorTarea.setVisible(false);

        String titulo = txtTitulo.getText();
        String descripcion = txtDescripcion.getText();
        String fechaVencimientoStr = txtFechaVencimiento.getText();
        String prioridadStr = (String) cmbPrioridad.getSelectedItem();
        String estadoStr = (String) cmbEstado.getSelectedItem();

        // Validaciones básicas
        if (titulo.isEmpty() || titulo.equals("Título de la tarea")) {
            lblMensajeErrorTarea.setText("El título de la tarea es obligatorio.");
            lblMensajeErrorTarea.setVisible(true);
            return;
        }
        if (descripcion.equals("Descripción detallada de la tarea")) {
            descripcion = ""; // Si es el placeholder, dejarlo vacío
        }

        LocalDate fechaVencimiento = null;
        if (!fechaVencimientoStr.isEmpty() && !fechaVencimientoStr.equals("AAAA-MM-DD")) {
            try {
                fechaVencimiento = LocalDate.parse(fechaVencimientoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                if (fechaVencimiento.isBefore(LocalDate.now()) && esNuevaTarea) {
                    lblMensajeErrorTarea.setText("La fecha de vencimiento no puede ser en el pasado.");
                    lblMensajeErrorTarea.setVisible(true);
                    return;
                }
            } catch (DateTimeParseException e) {
                lblMensajeErrorTarea.setText("Formato de fecha de vencimiento inválido (AAAA-MM-DD).");
                lblMensajeErrorTarea.setVisible(true);
                return;
            }
        }

        Prioridad prioridad = Prioridad.valueOf(prioridadStr);
        Estado estado = Estado.valueOf(estadoStr);

        TareaDao tareaDao = new TareaDao();
        boolean operacionExitosa = false;

        try {
            if (esNuevaTarea) {
                Tarea nuevaTarea = new Tarea(titulo, descripcion, fechaVencimiento, prioridad, usuarioActual.getIdUsuario());
                operacionExitosa = tareaDao.guardarTarea(nuevaTarea);
            } else {
                // Actualizar la tarea existente
                tareaAEditar.setTitulo(titulo);
                tareaAEditar.setDescripcion(descripcion);
                tareaAEditar.setFechaVencimiento(fechaVencimiento);
                tareaAEditar.setPrioridad(prioridad);
                tareaAEditar.setEstado(estado); // El estado sí se puede cambiar al editar
                operacionExitosa = tareaDao.actualizarTarea(tareaAEditar);
            }

            if (operacionExitosa) {
                JOptionPane.showMessageDialog(this, "Tarea " + (esNuevaTarea ? "añadida" : "actualizada") + " exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                this.dispose(); // Cierra el formulario después de guardar
            } else {
                lblMensajeErrorTarea.setText("Error al guardar la tarea. Intenta de nuevo.");
                lblMensajeErrorTarea.setVisible(true);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            lblMensajeErrorTarea.setText("Error de DB: " + e.getMessage());
            lblMensajeErrorTarea.setVisible(true);
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose(); // Simplemente cierra la ventana sin guardar
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
            java.util.logging.Logger.getLogger(Formulario_Tarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Tarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Tarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Tarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Para pruebas directas del formulario de tarea
                new Formulario_Tarea(new Usuario("TestUser", "hash", "test@example.com"), null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarTarea;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbPrioridad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaVencimiento;
    private javax.swing.JLabel lblMensajeErrorTarea;
    private javax.swing.JLabel lblPrioridad;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloFormulario;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFechaVencimiento;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}