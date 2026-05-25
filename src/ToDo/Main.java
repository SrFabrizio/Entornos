package ToDo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager gestor = new TaskManager();
        Scanner deTeclado = new Scanner(System.in);
        int opcion = 0;

        System.out.println("=== Bienvenido a la aplicación ToDo ===");

        while (opcion != 4) {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Añadir tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            
            opcion = deTeclado.nextInt();
            deTeclado.nextLine();

            switch (opcion) {
                case 1:
                    // SEPARACIÓN DE MÉTODOS: Se ha movido la lógica de captura de datos a un método propio
                    procesarAltaTarea(gestor, deTeclado);
                    break;

                case 2:
                    System.out.println("\n--- Lista de tareas ---");
                    gestor.mostrarTareas();
                    break;

                case 3:
                    // SEPARACIÓN DE MÉTODOS: Se ha extraído la lógica de completado para aligerar el switch
                    procesarCompletarTarea(gestor, deTeclado);
                    break;

                case 4:
                    System.out.println("Saliendo de la aplicación... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
        
        deTeclado.close();
    }

    // NUEVO MÉTODO SEPARADO: Gestiona de forma aislada la entrada de datos para una nueva tarea
    private static void procesarAltaTarea(TaskManager gestor, Scanner deTeclado) {
        System.out.print("Introduce el título de la tarea: ");
        String titulo = deTeclado.nextLine();
        System.out.print("Introduce la descripción: ");
        String desc = deTeclado.nextLine();
        
        gestor.añadirTarea(titulo, desc);
        System.out.println("¡Tarea añadida con éxito!");
    }

    // NUEVO MÉTODO SEPARADO: Controla de forma independiente la interacción para marcar tareas como completadas
    private static void procesarCompletarTarea(TaskManager gestor, Scanner deTeclado) {
        System.out.println("\n--- Marcar como completada ---");
        gestor.mostrarTareas();
        System.out.print("Introduce el número de la tarea a completar: ");
        
        // CAMBIO DE NOMBRE DE VARIABLE: 'numTarea' se ha renombrado a 'indiceUsuario'
        int indiceUsuario = deTeclado.nextInt();
        
        boolean exito = gestor.marcarComoCompletada(indiceUsuario - 1);
        if (exito) {
            System.out.println("¡Tarea marcada como completada!");
        } else {
            System.out.println("Error: El número de tarea introducido no existe.");
        }
    }
}