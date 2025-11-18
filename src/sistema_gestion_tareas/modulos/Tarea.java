package sistema_gestion_tareas.modulos;

import java.time.LocalDate; // Para manejar fechas

public class Tarea {

    private int idTarea;
    private String titulo;
    private String descripcion;
    private LocalDate fechaVencimiento;
    private Prioridad prioridad; // Usamos el enum Prioridad
    private Estado estado;       // Usamos el enum Estado
    private LocalDate fechaCreacion;
    private int idUsuario;       // Clave foránea para relacionar con el Usuario

    // Constructor vacío
    public Tarea() {
        this.fechaCreacion = LocalDate.now(); // Por defecto, la fecha de creación es hoy
        this.estado = Estado.PENDIENTE;     // Por defecto, una tarea nueva está Pendiente
        this.prioridad = Prioridad.MEDIA;  // Por defecto, prioridad media
    }

    // Constructor con campos esenciales (para crear una nueva tarea)
    public Tarea(String titulo, String descripcion, LocalDate fechaVencimiento, Prioridad prioridad, int idUsuario) {
        this(); // Llama al constructor vacío para inicializar fechaCreacion, estado y prioridad por defecto
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.idUsuario = idUsuario;
    }

    // --- Getters y Setters ---

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Tarea{" +
               "idTarea=" + idTarea +
               ", titulo='" + titulo + '\'' +
               ", fechaVencimiento=" + fechaVencimiento +
               ", prioridad=" + prioridad +
               ", estado=" + estado +
               ", idUsuario=" + idUsuario +
               '}';
    }

}
