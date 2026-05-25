package ToDo;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    // Lista dinámica para almacenar los objetos de tipo Task
    private List<Task> listaTareas;

    // Constructor que inicializa la lista vacía
    public TaskManager() {
        this.listaTareas = new ArrayList<>();
    }

    // Método para añadir una nueva tarea
    public void añadirTarea(String titulo, String descripcion) {
        Task nuevaTarea = new Task(titulo, descripcion);
        listaTareas.add(nuevaTarea);
    }

    // Método para obtener todas las tareas (útil para el menú y los futuros tests)
    public List<Task> getListaTareas() {
        return listaTareas;
    }

    // Método para mostrar las tareas por consola
    public void mostrarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas en la lista.");
            return;
        }
        
        for (int i = 0; i < listaTareas.size(); i++) {
            // Mostramos el índice (i + 1) para que el usuario elija de forma natural (1, 2, 3...)
            System.out.println((i + 1) + ". " + listaTareas.get(i).toString());
        }
    }

    // Método para marcar una tarea como completada usando su posición en la lista
    public boolean marcarComoCompletada(int indice) {
        // Validación para evitar que el programa reviente (IndexOutOfBoundsException)
        if (indice >= 0 && indice < listaTareas.size()) {
            listaTareas.get(indice).setCompletada(true);
            return true; // Operación correcta
        }
        return false; // Índice no válido
    }
}