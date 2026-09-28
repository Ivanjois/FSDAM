package U6.ActividadesInicio;

public class Habitacion {
    private String nombre;
    private int metrosCuadrados;

    Habitacion(String nombre, int metrosCuadrados) {
        this.nombre = nombre;
        this.metrosCuadrados = metrosCuadrados;
    }

    public String getHabitacion() {
        return this.nombre;
    }

    public int getMetrosCuadrados() {
        return this.metrosCuadrados;
    }

}
