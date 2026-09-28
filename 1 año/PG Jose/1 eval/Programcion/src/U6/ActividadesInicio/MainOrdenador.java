package U6.ActividadesInicio;

public class MainOrdenador {
    public static void main(String[] args) {
        Procesador procesador = new Procesador("Intel", 35.4);
        MemoriaRAM memoria = new MemoriaRAM(500, 168.3);
        TarjetaGrafica tarjetaGrafica = new TarjetaGrafica("Nvidia", 335.45);
        // Forma más limpia
        Ordenador ord = new Ordenador(procesador, memoria, tarjetaGrafica);
        System.out.println(ord.toString());
    }
}
