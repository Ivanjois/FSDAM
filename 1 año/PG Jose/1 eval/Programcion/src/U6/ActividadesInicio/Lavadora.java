package U6.ActividadesInicio;

public class Lavadora extends Electrodomestico {
    private double carga;

    public Lavadora() {
        super();
        this.carga = 5;
    }

    public Lavadora(double precio, double peso, String color, double carga) {
        super(precio, peso, color);
        this.carga = carga;
    }

    public double getCarga() {
        return this.carga;
    }

    @Override
    public void consumirEnergia() {
        System.out.println("Lavadora consumiendo energía... ");
    }

}
