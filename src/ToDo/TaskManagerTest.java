package ToDo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskManagerTest {

    private TaskManager gestor;

    @BeforeEach
    void setUp() {
        gestor = new TaskManager();
    }

    @Test
    void testAñadirTarea() {
        gestor.añadirTarea("Test JUnit", "Probar el gestor");
        
        assertEquals(1, gestor.getListaTareas().size(), "La lista debería tener 1 tarea");
        
        Task tareaGuardada = gestor.getListaTareas().get(0);
        assertEquals("Test JUnit", tareaGuardada.getTitulo());
        assertFalse(tareaGuardada.isCompletada(), "La tarea nueva debería estar pendiente por defecto");
    }

    @Test
    void testMarcarComoCompletada() {
        gestor.añadirTarea("Tarea a completar", "Prueba");
        
        boolean resultado = gestor.marcarComoCompletada(0);
        
        assertTrue(resultado, "El método debería devolver true al completarse con éxito");
        assertTrue(gestor.getListaTareas().get(0).isCompletada(), "El atributo completada debería ser true");
    }
}