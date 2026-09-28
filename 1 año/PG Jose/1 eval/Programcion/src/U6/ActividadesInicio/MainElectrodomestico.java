package U6.ActividadesInicio;

public class MainElectrodomestico {
    public static void main(String[] args) {
        Electrodomestico[] listaElectrodomesticos = new Electrodomestico[5];

        listaElectrodomesticos[0] = new Lavadora(200, 50, "blanco", 8);
        listaElectrodomesticos[1] = new Television(450, 15, "negro", 50);
        listaElectrodomesticos[2] = new Lavadora();
        listaElectrodomesticos[3] = new Television();
        listaElectrodomesticos[4] = new Electrodomestico(150, 20, "gris");

        double precioTotalLavadoras = 0;
        double precioTotalTelevisiones = 0;
        double precioTotalElectrodomesticos = 0;
        double pesoTotal = 0;

        for (Electrodomestico e : listaElectrodomesticos) {
            e.consumirEnergia();
            precioTotalElectrodomesticos += e.getPrecio();
            pesoTotal += e.getPeso();

            if (e instanceof Lavadora) {
                precioTotalLavadoras += e.getPrecio();
            } else if (e instanceof Television) {
                precioTotalTelevisiones += e.getPrecio();
            }
        }

        System.out.println("\n--- RESUMEN DE PRECIOS ---");
        System.out.println("Precio total Lavadoras: " + precioTotalLavadoras + "€");
        System.out.println("Precio total Televisiones: " + precioTotalTelevisiones + "€");
        System.out.println("Precio total Electrodomésticos: " + precioTotalElectrodomesticos + "€");
        System.out.println("Peso total: " + pesoTotal + "kg");
    }

}
