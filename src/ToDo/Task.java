package ToDo;

public class Task {
    // Atributos privados
    private String titulo;
    private String descripcion;
    private boolean completada;

    // Constructor
    public Task(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false; 
    }

    // Métodos Getters y Setters
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

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    // Método toString para formatear la salida por consola
    @Override
    public String toString() {
        String estado = completada ? "[Completada]" : "[Pendiente]";
        return estado + " - " + titulo + ": " + descripcion;
    }
}