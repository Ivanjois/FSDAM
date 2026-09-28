import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

class TrianguloTest {

    Triangulo triangulo = new Triangulo();

    // TEST 1: Casos que deben dar TRUE (lee del CSV true)
    @ParameterizedTest
    @CsvFileSource(resources = "/test_es_triangulo_true.csv")
    void testEsTrianguloTrue(int a, int b, int c) {
        assertTrue(triangulo.EsTriangulo(a, b, c)); // [cite: 61]
    }

    // TEST 2: Casos que deben dar FALSE (lee del CSV false)
    @ParameterizedTest
    @CsvFileSource(resources = "/test_es_triangulo_false.csv")
    void testEsTrianguloFalse(int a, int b, int c) {
        assertFalse(triangulo.EsTriangulo(a, b, c)); // [cite: 61]
    }

    // TEST 3: Tipos de triángulo (lee a, b, c y el String esperado)
    @ParameterizedTest
    @CsvFileSource(resources = "/test_tipo_triangulo.csv")
    void testTipoTriangulo(int a, int b, int c, String esperado) {
        assertEquals(esperado, triangulo.TipoTriangulo(a, b, c)); // [cite: 66]
    }
}