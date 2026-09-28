import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // [cite: 240]

class MayorTest {

    @Test
    void mayor() {
        // En lugar de líneas sueltas, las agrupamos:
        assertAll("Escenarios de prueba para método Mayor",
                // Escenario 1: Segundo número mayor
                () -> assertEquals(4, Mayor.Mayor(3, 4), "No pasado"),

                // Escenario 2: Primer número mayor
                () -> assertEquals(4, Mayor.Mayor(4, 3), "No pasado"),

                // Escenario 3: Iguales
                () -> assertEquals(4, Mayor.Mayor(4, 4), "No pasado"),

                // Escenario 4: Negativos
                () -> assertEquals(-3, Mayor.Mayor(-3, -4), "No pasado")
        );
    }

    // Puedes hacer lo mismo para el método esMayor
    @Test
    void esMayor() {
        assertAll("Escenarios booleanos",
                () -> assertTrue(Mayor.EsMayor(4, 3)),
                () -> assertTrue(Mayor.EsMayor(-3, -4)),
                () -> assertFalse(Mayor.EsMayor(3, 4)),
                () -> assertFalse(Mayor.EsMayor(4, 4)),
                () -> assertFalse(Mayor.EsMayor(-4, -3))
        );
    }
}