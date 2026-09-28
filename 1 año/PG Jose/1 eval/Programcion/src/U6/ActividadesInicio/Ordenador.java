package U6.ActividadesInicio;

public class Ordenador {
    private Procesador procesador;
    private MemoriaRAM memoria;
    private TarjetaGrafica tarjetaGrafica;

    public Ordenador(Procesador procesador, MemoriaRAM ram, TarjetaGrafica grafica) {
        this.procesador = procesador;
        this.memoria = ram;
        this.tarjetaGrafica = grafica;
    }

    public double getPrecioTotal() {
        return this.procesador.getPrecio() + this.memoria.getPrecio() + this.tarjetaGrafica.getPrecio();
    }

    @Override
    public String toString() {
        return "Ordenador tiene procesador "+this.procesador+ " capacidad de la ram "+this.memoria+ " y tarjeta grafica "+this.tarjetaGrafica+". El precio total es de "+getPrecioTotal()+"€";
    }

}
