package ToDo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializamos el gestor de tareas y el escáner para leer la consola
        TaskManager gestor = new TaskManager();
        Scanner deTeclado = new Scanner(System.in);
        int opcion = 0;

        System.out.println("=== Bienvenido a la aplicación ToDo ===");

        // Bucle del menú principal
        while (opcion != 4) {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Añadir tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            
            // Leemos la opción elegida por el usuario
            opcion = deTeclado.nextInt();
            deTeclado.nextLine(); // Limpiamos el buffer del escáner

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el título de la tarea: ");
                    String titulo = deTeclado.nextLine();
                    System.out.print("Introduce la descripción: ");
                    String desc = deTeclado.nextLine();
                    
                    gestorAñadirTarea(gestor, titulo, desc);
                    System.out.println("¡Tarea añadida con éxito!");
                    break;

                case 2:
                    System.out.println("\n--- Lista de tareas ---");
                    gestor.mostrarTareas();
                    break;

                case 3:
                    System.out.println("\n--- Marcar como completada ---");
                    gestor.mostrarTareas();
                    System.out.print("Introduce el número de la tarea a completar: ");
                    int numTarea = deTeclado.nextInt();
                    
                    // Restamos 1 porque el usuario ve la lista empezando en 1, pero los arrays empiezan en 0
                    boolean exito = gestor.marcarComoCompletada(numTarea - 1);
                    if (exito) {
                        System.out.println("¡Tarea marcada como completada!");
                    } else {
                        System.out.println("Error: El número de tarea introducido no existe.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo de la aplicación... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
        
        deTeclado.close(); // Cerramos el recurso del escáner al terminar
    }

    // Método auxiliar (Hará falta para la parte de refactorización del bloque 4)
    private static void gestorAñadirTarea(TaskManager gestor, String titulo, String desc) {
        gestor.añadirTarea(titulo, desc);
    }
}