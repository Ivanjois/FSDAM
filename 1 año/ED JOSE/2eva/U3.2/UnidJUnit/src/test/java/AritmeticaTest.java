import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AritmeticaTest {

    Aritmetica aritmetica = new Aritmetica();

    @Test
    void testDivision() {
        // Probamos 10 / 2 = 5.0.
        // El 0.001f es el margen de error permitido para decimales.
        assertEquals(5.0f, aritmetica.Division(10f, 2f), 0.001f);

        // Prueba extra: 10 / 3 = 3.3333...
        assertEquals(3.333f, aritmetica.Division(10f, 3f), 0.001f);
    }

    @Test
    void testPrimerosTresDivisores() {
        // Caso 1: Tiene más de 3 divisores (ej: 6 -> 1, 2, 3)
        assertArrayEquals(new int[]{1, 2, 3}, aritmetica.PrimerosTresDivisores(6)); // [cite: 13]

        // Caso 2: Tiene pocos divisores (ej: 1 -> 1, -1, -1)
        assertArrayEquals(new int[]{1, -1, -1}, aritmetica.PrimerosTresDivisores(1)); // [cite: 12]

        // Caso 3: Número primo (ej: 5 -> 1, 5, -1)
        assertArrayEquals(new int[]{1, 5, -1}, aritmetica.PrimerosTresDivisores(5));
    }
}