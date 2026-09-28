package U6.ActividadesInicio;

public class Procesador {
    private String modelo;
    private double precio;
    public Procesador(String modelo, double precio){
        this.modelo = modelo;
        this.precio = precio;
    }
    public double getPrecio() {
        return  this.precio;
    }
    public String getProcesador() {
        return this.modelo;
    }
    @Override
    public String toString() {
        // Devuelve el modelo y el precio, no la dirección de memoria
        return this.modelo + " (" + this.precio + "€)";
    }

}
