// Archivo: gui/Gestion_Tareas.java
// Paquete: sistema_gestion_tareas.gui

package sistema_gestion_tareas.gui;

import sistema_gestion_tareas.modulos.Usuario;
import sistema_gestion_tareas.modulos.Tarea;
import sistema_gestion_tareas.modulos.Prioridad;
import sistema_gestion_tareas.modulos.Estado;
import sistema_gestion_tareas.dao.TareaDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.SwingUtilities;


public class Gestion_Tareas extends javax.swing.JFrame {

    private Usuario usuarioActual;
    private DefaultTableModel tablaModelo;
    private TareaDao tareaDao;

    public Gestion_Tareas(Usuario usuario) {
        this.usuarioActual = usuario;
        this.tareaDao = new TareaDao();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Gestión de Tareas - " + usuarioActual.getNombreUsuario());
        getContentPane().setBackground(new Color(45, 45, 45));
        lblBienvenidaUsuario.setText("Bienvenido, " + usuarioActual.getNombreUsuario() + "!");

        configurarTablaTareas();
        cargarTareasUsuario();
    }

    public Gestion_Tareas() {
        this(new Usuario("DemoUser", "testpass", "invitado@example.com"));
    }

    private void configurarTablaTareas() {
        tablaModelo = new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Título", "Descripción", "Fecha Vencimiento", "Prioridad", "Estado"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblTareas.setModel(tablaModelo);
    }

    private void cargarTareasUsuario() {
        tablaModelo.setRowCount(0);
        try {
            List<Tarea> tareas = tareaDao.obtenerTareasPorIdUsuario(usuarioActual.getIdUsuario());
            for (Tarea tarea : tareas) {
                String fechaVencimientoStr = tarea.getFechaVencimiento() != null ?
                                             tarea.getFechaVencimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) :
                                             "N/A";

                tablaModelo.addRow(new Object[]{
                    tarea.getIdTarea(),
                    tarea.getTitulo(),
                    tarea.getDescripcion(),
                    fechaVencimientoStr,
                    tarea.getPrioridad().name(),
                    tarea.getEstado().name()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar tareas: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTareas = new javax.swing.JTable();
        lblBienvenidaUsuario = new javax.swing.JLabel();
        btnAgregarTarea = new javax.swing.JButton();
        btnEditarTarea = new javax.swing.JButton();
        btnEliminarTarea = new javax.swing.JButton();
        btnMarcarCompletada = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuTareas = new javax.swing.JMenu();
        jMenuItemAgregar = new javax.swing.JMenuItem();
        jMenuItemVerTodas = new javax.swing.JMenuItem();
        jMenuItemVerPendientes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Tareas");
        setMinimumSize(new java.awt.Dimension(800, 600));


        // Panel Principal (para el fondo oscuro y organizar componentes)
        panelPrincipal.setBackground(new java.awt.Color(45, 45, 45));
        panelPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        // --- CAMBIO CLAVE AQUÍ: Usamos null layout y luego setBounds() ---
        panelPrincipal.setLayout(null); // Usar null layout

        // Label de Bienvenida al usuario
        lblBienvenidaUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblBienvenidaUsuario.setForeground(new java.awt.Color(204, 204, 204));
        lblBienvenidaUsuario.setText("Bienvenido, [Nombre de Usuario]!");
        // --- CAMBIO CLAVE AQUÍ: Usamos setBounds() ---
        lblBienvenidaUsuario.setBounds(20, 20, 400, 30); // Posición y tamaño manual
        panelPrincipal.add(lblBienvenidaUsuario); // Añadir sin restricciones de layout

        // JTable para mostrar las tareas
        tblTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Título", "Descripción", "Fecha Vencimiento", "Prioridad", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTareas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTareas.setBackground(new java.awt.Color(60, 63, 65));
        tblTareas.setForeground(new java.awt.Color(255, 255, 255));
        tblTareas.setRowHeight(25);
        tblTareas.setGridColor(new java.awt.Color(70, 73, 75));
        tblTareas.setFillsViewportHeight(true);
        tblTareas.getTableHeader().setBackground(new java.awt.Color(30, 30, 30));
        tblTareas.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        tblTareas.getTableHeader().setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));

        jScrollPane1.setViewportView(tblTareas);
        // --- CAMBIO CLAVE AQUÍ: Usamos setBounds() ---
        jScrollPane1.setBounds(20, 70, 760, 400); // Posición y tamaño manual
        panelPrincipal.add(jScrollPane1); // Añadir sin restricciones de layout


        // Botones de acción para las tareas
        btnAgregarTarea.setBackground(new java.awt.Color(0, 102, 255));
        btnAgregarTarea.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnAgregarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarTarea.setText("Añadir Tarea");
        btnAgregarTarea.setBorderPainted(false);
        btnAgregarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTareaActionPerformed(evt);
            }
        });
        // --- CAMBIO CLAVE AQUÍ: Usamos setBounds() ---
        btnAgregarTarea.setBounds(20, 500, 150, 40);
        panelPrincipal.add(btnAgregarTarea);

        btnEditarTarea.setBackground(new java.awt.Color(255, 153, 0));
        btnEditarTarea.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnEditarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarTarea.setText("Editar Tarea");
        btnEditarTarea.setBorderPainted(false);
        btnEditarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTareaActionPerformed(evt);
            }
        });
        // --- CAMBIO CLAVE AQUÍ: Usamos setBounds() ---
        btnEditarTarea.setBounds(180, 500, 150, 40);
        panelPrincipal.add(btnEditarTarea);

        btnEliminarTarea.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarTarea.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnEliminarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarTarea.setText("Eliminar Tarea");
        btnEliminarTarea.setBorderPainted(false);
        btnEliminarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTareaActionPerformed(evt);
            }
        });
        // --- CAMBIO CLAVE AQUÍ: Usamos setBounds() ---
        btnEliminarTarea.setBounds(340, 500, 150, 40);
        panelPrincipal.add(btnEliminarTarea);

        btnMarcarCompletada.setBackground(new java.awt.Color(0, 153, 51));
        btnMarcarCompletada.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnMarcarCompletada.setForeground(new java.awt.Color(255, 255, 255));
        btnMarcarCompletada.setText("Marcar Completada");
        btnMarcarCompletada.setBorderPainted(false);
        btnMarcarCompletada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarCompletadaActionPerformed(evt);
            }
        });
        // --- CAMBIO CLAVE AQUÍ: Usamos setBounds() ---
        btnMarcarCompletada.setBounds(500, 500, 180, 40);
        panelPrincipal.add(btnMarcarCompletada);


        // Layout para el JFrame principal que contiene el panelPrincipal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        // Menú Superior (sin cambios, ya que no usaba AbsoluteLayout)
        jMenuArchivo.setText("Archivo");
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemSalir);
        jMenuBar1.add(jMenuArchivo);

        jMenuTareas.setText("Tareas");
        jMenuItemAgregar.setText("Agregar Nueva Tarea");
        jMenuItemAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgregarActionPerformed(evt);
            }
        });
        jMenuTareas.add(jMenuItemAgregar);

        jMenuItemVerTodas.setText("Ver Todas las Tareas");
        jMenuItemVerTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerTodasActionPerformed(evt);
            }
        });
        jMenuTareas.add(jMenuItemVerTodas);

        jMenuItemVerPendientes.setText("Ver Tareas Pendientes");
        jMenuItemVerPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerPendientesActionPerformed(evt);
            }
        });
        jMenuTareas.add(jMenuItemVerPendientes);

        jMenuBar1.add(jMenuTareas);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // --- Métodos para manejar eventos de los componentes (sin cambios en la lógica) ---
    private void btnAgregarTareaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Implementar la lógica para abrir un formulario de agregar tarea
        // Antes: JOptionPane.showMessageDialog(this, "Abrir formulario para añadir tarea.", "Información", JOptionPane.INFORMATION_MESSAGE);

        // Crear y mostrar el formulario de tarea en modo "nueva tarea"
        // Pasamos el usuario actual y 'null' para indicar que es una tarea nueva
        Formulario_Tarea tareaForm = new Formulario_Tarea(usuarioActual, null);
        tareaForm.setVisible(true);

        // Añadir un WindowListener para saber cuándo se cierra el Formulario_Tarea
        tareaForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Cuando el Formulario_Tarea se cierra (ya sea por guardar o cancelar),
                // recargamos la tabla de tareas para mostrar cualquier cambio.
                cargarTareasUsuario();
            }
        });
    }

    private void btnEditarTareaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = tblTareas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una tarea para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener el ID de la tarea seleccionada de la primera columna de la tabla
        // Asumimos que la columna 0 contiene el ID de la tarea
        int idTarea = (int) tablaModelo.getValueAt(filaSeleccionada, 0);
        try {
            // Buscar la tarea completa en la base de datos usando su ID
            java.util.Optional<Tarea> optionalTarea = tareaDao.obtenerTareaPorId(idTarea);
            if (optionalTarea.isPresent()) {
                Tarea tareaAEditar = optionalTarea.get();
                // Antes: JOptionPane.showMessageDialog(this, "Abrir formulario para editar tarea: " + tareaAEditar.getTitulo(), "Información", JOptionPane.INFORMATION_MESSAGE);

                // Crear y mostrar el formulario de tarea en modo "editar tarea"
                // Pasamos el usuario actual y el objeto Tarea para pre-rellenar los campos
                Formulario_Tarea tareaForm = new Formulario_Tarea(usuarioActual, tareaAEditar);
                tareaForm.setVisible(true);

                // Añadir un WindowListener para recargar la tabla cuando se cierre el formulario de edición
                tareaForm.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        cargarTareasUsuario(); // Recargar tareas para reflejar los cambios
                    }
                });

            } else {
                // Esto no debería ocurrir si el ID se obtuvo de la tabla,
                // pero es una buena práctica manejar el caso.
                JOptionPane.showMessageDialog(this, "No se pudo encontrar la tarea seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener la tarea de la base de datos: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void btnEliminarTareaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = tblTareas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una tarea para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres eliminar esta tarea?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            int idTarea = (int) tablaModelo.getValueAt(filaSeleccionada, 0);
            try {
                boolean eliminado = tareaDao.eliminarTarea(idTarea, usuarioActual.getIdUsuario());
                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "Tarea eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarTareasUsuario();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la tarea.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar tarea: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    private void btnMarcarCompletadaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = tblTareas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una tarea para marcar como completada.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idTarea = (int) tablaModelo.getValueAt(filaSeleccionada, 0);
        try {
            java.util.Optional<Tarea> optionalTarea = tareaDao.obtenerTareaPorId(idTarea);
            if (optionalTarea.isPresent()) {
                Tarea tarea = optionalTarea.get();
                if (tarea.getEstado() == Estado.COMPLETADA) {
                    JOptionPane.showMessageDialog(this, "La tarea ya está completada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                tarea.setEstado(Estado.COMPLETADA);
                boolean actualizado = tareaDao.actualizarTarea(tarea);
                if (actualizado) {
                    JOptionPane.showMessageDialog(this, "Tarea marcada como completada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarTareasUsuario();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo marcar la tarea como completada.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar tarea: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres cerrar la aplicación?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void jMenuItemAgregarActionPerformed(java.awt.event.ActionEvent evt) {
        btnAgregarTareaActionPerformed(evt);
    }

    private void jMenuItemVerTodasActionPerformed(java.awt.event.ActionEvent evt) {
        cargarTareasUsuario();
    }

    private void jMenuItemVerPendientesActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Funcionalidad para filtrar tareas pendientes no implementada aún.", "Información", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(Gestion_Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_Tareas(new Usuario("DemoUser", "testpass", "demo@example.com")).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarTarea;
    private javax.swing.JButton btnEditarTarea;
    private javax.swing.JButton btnEliminarTarea;
    private javax.swing.JButton btnMarcarCompletada;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuItem jMenuItemAgregar;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemVerPendientes;
    private javax.swing.JMenuItem jMenuItemVerTodas;
    private javax.swing.JMenu jMenuTareas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBienvenidaUsuario;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tblTareas;
    // End of variables declaration//GEN-END:variables
}