package U5.ActividadesInicio;

public class Plato {
    String nombre;
    double precio;
    boolean esVegano;
    int calorias;
    Plato(String nombre, double precio, boolean esVegano,  int calorias) {
        this.nombre = nombre;
        this.precio = precio;
        this.esVegano = esVegano;
        this.calorias = calorias;
    }
    public void imprimirDetalle() {

        String vegano = "Vegano";
        if(!this.esVegano) { vegano = "No es vegano"; }

        System.out.println("Nombre: " + nombre+", Precio: " + precio+", ("+ vegano + "), calorias: "+ calorias);
    }
}
