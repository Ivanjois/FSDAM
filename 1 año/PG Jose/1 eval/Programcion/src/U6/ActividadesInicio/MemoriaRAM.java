package U6.ActividadesInicio;

public class MemoriaRAM {
    private int capacidad;
    private double precio;

    public MemoriaRAM(int capacidad, double precio) {
        this.capacidad = capacidad;
        this.precio = precio;
    }
    public double getPrecio() {
        return  this.precio;
    }
    public int getCapacidad() {
        return this.capacidad;
    }
    @Override
    public String toString() {
        return this.capacidad + "GB (" + this.precio + "€)";
    }

}
