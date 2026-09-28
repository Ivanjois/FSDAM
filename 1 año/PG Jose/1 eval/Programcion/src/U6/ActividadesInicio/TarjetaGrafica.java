package U6.ActividadesInicio;

public class TarjetaGrafica {
    private String modelo;
    private double precio;

    public TarjetaGrafica(String modelo, double precio) {
        this.modelo = modelo;
        this.precio = precio;
    }
    public double getPrecio() {
        return  this.precio;
    }
    public String getModelo() {
        return this.modelo;
    }

    @Override
    public String toString() {
        return this.modelo + " (" + this.precio + "€)";
    }
}
