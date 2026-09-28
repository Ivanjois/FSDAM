package U6.ActividadesInicio;

public class Television extends  Electrodomestico{
    private int resolucion;
    public Television() {
        super();
        this.resolucion = 20;
    }

    public Television(double precio, double peso, String color, int resolucion) {
        super(precio, peso, color);
        this.resolucion = resolucion;
    }

    public int getResolucion() {
        return this.resolucion;
    }

    @Override
    public void consumirEnergia() {
        System.out.println("Televisión consumiendo energía... ");
    }

}
