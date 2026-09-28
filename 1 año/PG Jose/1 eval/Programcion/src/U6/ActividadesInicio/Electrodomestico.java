package U6.ActividadesInicio;

import java.util.Iterator;

public class Electrodomestico {
    private double precio;
    private String color;
    private double peso;

    public Electrodomestico() {
        this.precio = 100;
        this.color = "blanco";
        this.peso = 5;
    }

    public Electrodomestico(double precio, double peso, String color) {
        this.color = color;
        this.precio = precio;
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public String getColor() {
        return color;
    }

    public void consumirEnergia() {
        System.out.println("Electrodomestico consumido energía... ");
    }

    public double getPeso() {
        return peso;
    }

}
