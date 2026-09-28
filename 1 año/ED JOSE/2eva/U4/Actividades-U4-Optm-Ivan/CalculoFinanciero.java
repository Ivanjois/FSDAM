/**
 * Clase de utilidad para realizar cálculos financieros básicos.
 */
public class CalculoFinanciero {
    //Renombrar constante a UPPER_SNAKE_CASE
    public static final double INTERES_ESTANDAR = 0.05;

    /**
     * Calcula el monto total a devolver de un préstamo tras aplicar el interés simple.
     *
     * @param montoPrincipal Cantidad solicitada en el préstamo (en euros).
     * @param tiempoAnios    Duración del préstamo (en años).
     * @return El monto total acumulado (Principal + Intereses) que se debe devolver.
     * @throws IllegalArgumentException Si el monto principal es negativo.
     */
    public double calcularTotalPrestamo(double montoPrincipal, int tiempoAnios) {
        //Validación con excepción
        if (montoPrincipal < 0) {
            // Esto lanza la excepción y corta el programa
            throw new IllegalArgumentException("El monto del préstamo no puede ser negativo.");
        }
        // Fórmula del interés simple: Monto + (Monto * Interés * Tiempo)
       return montoPrincipal + (montoPrincipal * INTERES_ESTANDAR * tiempoAnios);
    }
}