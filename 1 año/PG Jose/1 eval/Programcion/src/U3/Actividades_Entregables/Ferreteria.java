package U3.Actividades_Entregables;

import java.util.Scanner;

/**
 * Actividad entregable: Gestor de Inventario de Ferretería. (Versión Corregida)
 * <p>
 * OBJETIVO: Implementar la lógica de las funciones para construir un programa
 * modular que gestione un inventario.
 */
public class Ferreteria {

    //!% Variable estática para acumular el total de ventas.
    private static double totalVentas = 0.0;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("¿Cuántas piezas únicas quieres gestionar? ");
        int numPiezas = teclado.nextInt();
        teclado.nextLine(); //!% Limpiar buffer

        //  !% Creación de arrays paralelos
        String[] nombres = new String[numPiezas];
        int[] cantidades = new int[numPiezas];
        double[] precios = new double[numPiezas];

        int opcion;
        do {
            System.out.println("\n--- FERRETERÍA DAM ---"); // Añadido \n para espaciar
            System.out.println("1. Gestionar Almacén (Rellenar Inventario)");
            System.out.println("2. Mostrar Almacén");
            System.out.println("3. Vender Producto");
            System.out.println("4. Mostrar Informe Comercial");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: "); // Añadido para seguir el ejemplo
            opcion = teclado.nextInt();
            teclado.nextLine(); //!% Limpiar buffer

            switch (opcion) {
                case 1:
                    gestionarAlmacen(teclado, nombres, cantidades, precios);
                    break;
                case 2:
                    mostrarAlmacen(nombres, cantidades, precios);
                    break;
                case 3:
                    venderProducto(teclado, nombres, cantidades, precios);
                    break;
                case 4:
                    mostrarInformeComercial(nombres, cantidades, precios, totalVentas);
                    break;
                case 5:
                    System.out.println("Cerrando programa. Ventas totales del día: " +
                            String.format("%.2f", totalVentas) + " €");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 5);

        teclado.close();
    } //!% Fin del main

    // ############### FUNCIONES Y PROCEDIMIENTOS ###################

    /**
     * Procedimiento para registrar los productos en el Programa
     * @param teclado Scanner para guarda lo que escriba
     * @param nombres array String es donde se guardaran los nombres de los productos
     * @param cantidades array int es donde se guardara cuanto hay de ese producto en el almacen
     * @param precios array double es donde se guardara los precios de cada producto
     */
    private static void gestionarAlmacen(Scanner teclado, String[] nombres, int[] cantidades, double[] precios) {
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("DATOS DEL PRODUCTO [" + (i + 1) + "]");
            System.out.print("Nombre del producto : "); // Ajustado al formato del ejemplo
            nombres[i] = teclado.nextLine();
            System.out.print("Cantidad del producto: "); // Ajustado al formato del ejemplo
            cantidades[i] = teclado.nextInt();
            teclado.nextLine();
            System.out.print("Precio del producto: "); // Ajustado al formato del ejemplo
            precios[i] = teclado.nextDouble();
            teclado.nextLine();
        }
    }

    /**
     * Procedimiento para mostrar lo que tiene registrado en el Almacen
     * @param nombres array de String para guardar los nombres de cada nombre de cada producto
     * @param cantidades array de int para lass cantidades de cada producto
     * @param precios array de int para los precios de cada producto
     */
    private static void mostrarAlmacen(String[] nombres, int[] cantidades, double[] precios) {
        System.out.println("ALMACÉN DE PRODUCTOS");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("-" + nombres[i] + " " + cantidades[i] + " " + precios[i] + "€");
        }
    }

    /**
     * Este procedimiento buscará el producto, si lo tiene pidiera la cantidad que quiere,
     * el descuento a aplicar y finalmente veremos que se ha realizado la venta correctamente
     * por lo contrarió si no puede le saltará un mensaje donde le muestre porque no se puede
     * @param teclado Scanner para que le pueda escribir que es lo que busca
     * @param nombres array de String para buscar el producto
     * @param cantidades array de int par ver si hay stock
     * @param precios array de double para calcular de cuanto será la venta
     */
    private static void venderProducto(Scanner teclado, String[] nombres, int[] cantidades, double[] precios) {
        System.out.println("Producto a buscar:");
        String producto = teclado.nextLine();

        // 1. Llamar a la función de búsqueda
        int posicion = buscarProducto(producto, nombres);

        // 2. Vemos si hemos encontrado el producto.
        if (posicion == -1) {
            System.out.println("Producto no encontrado");
            return; // Termina la función
        }

        // 3. Pedir cantidad
        System.out.println("¿Cuántas unidades quieres?");
        int quieres = teclado.nextInt();
        teclado.nextLine();

        // 4. Vemos si hay cantidad suficiente y si es mayor que 0, tipo si ha pedido algo
        if (quieres > 0 && quieres <= cantidades[posicion]) {
            // 5. Pedir descuento
            System.out.println("¿Qué descuento se aplica?");
            double descuento = teclado.nextDouble();
            teclado.nextLine();

            // 6. CORRECCIÓN: Llamar a la función auxiliar con los parámetros correctos
            double precioFinalVenta = calcularPrecioVenta(precios[posicion], quieres, descuento);

            // 7. Actualizar stock
            cantidades[posicion] -= quieres;
            // 8. Actualizar total de ventas
            totalVentas += precioFinalVenta;

            //9. Mensaje de venta
            System.out.println("Venta realizada. Precio final: " + String.format("%.2f", precioFinalVenta) + " €");
            // No hay cantidad suficiente
        } else if (quieres > cantidades[posicion]) {
            System.out.println("No hay stock suficiente del producto.");
        } else {
            // Control por si se introduce 0 o un número negativo
            System.out.println("La cantidad a vender debe ser positiva.");
        }
    }

    /**
     * Esta función buscará la recorra el array nombres para buscar el producto
     * que te ha puesto y guardar su posición
     * @param nombreBuscado String que es el nombre que nos ha escrito para buscar
     * @param nombres array de String que se recorre para buscar si coincide con algún nombre, no importa si en minuscula o en mayuscula, los espacios sí que importan.
     * @return devuelve la posicion de donde está la palabra que nos a puesto en el array.
     */
    public static int buscarProducto(String nombreBuscado, String[] nombres) {
        for (int i = 0; i < nombres.length; i++) {
            // Usar equalsIgnoreCase para que no importe si buscamos la palabra en mayúscula o en minúscula
            if (nombreBuscado.equalsIgnoreCase(nombres[i])) {
                return i; // Devuelve la posición en cuanto lo encuentra
            }
        }
        return -1; // Devuelve -1 si termina el bucle sin encontrarlo
    }

    /**
     * Función que nos calcula el precio de lo que quiere comprar con el descuento que nos ha puesto.
     * Sí nos pone 100% de descuento, le saldra gratis
     * @param precioUnitario variable int que almacena el precio del un solo producto
     * @param cantidad variable int que guarda la cantidad que quiere el usuario
     * @param descuentoPorcentaje variable double que tiene guardado el descuento que le va a aplicar al producto
     * @return devuelve lo que le va a costar en total teniendo en cuenta el descuento
     */
    public static double calcularPrecioVenta(double precioUnitario, int cantidad, double descuentoPorcentaje) {
        double precioTotal = precioUnitario * cantidad;

        if (descuentoPorcentaje > 0) {
            double descuento = precioTotal * (descuentoPorcentaje / 100);
            return precioTotal - descuento;
        } else {
            return precioTotal; // Sin descuento
        }
    }

    /**
     * Procedimiento que mostrara una serie de información
     * @param nombres array de String que contiene los nombres de los productos
     * @param cantidades array int que tiene las cantidades para mostrar el que tiene más
     * @param precios array double que tiene los precios de cada producto
     * @param totalVentas variable double que tiene el total de lo que se ha gastado hasta ahora.
     */
    private static void mostrarInformeComercial(String[] nombres, int[] cantidades, double[] precios, double totalVentas) {

        int indiceMasCaro = encontrarIndiceMaxPrecio(precios);
        int indiceMasStock = encontrarIndiceMaxCantidad(cantidades);
        double mediaPrecio = calcularPrecioMedio(precios);

        System.out.println("INFORME COMERCIAL");
        System.out.println("-----------------");
        System.out.println("- Producto de mayor precio : " + nombres[indiceMasCaro] + " - Precio: " + String.format("%.2f", precios[indiceMasCaro]) + " €");
        System.out.println("- Producto con mayor cantidad : " + nombres[indiceMasStock] + " - Cantidad: " + cantidades[indiceMasStock] + " uds.");
        System.out.println("- Precio medio : " + String.format("%.2f", mediaPrecio) + " €");
        System.out.println("- TOTAL VENTAS: " + String.format("%.2f", totalVentas) + " €");
    }

    /**
     * Función calcula la media de los precios
     * @param precios array de double que contiene todos los precios
     * @return devuelve la media de los precios
     */
    private static double calcularPrecioMedio(double[] precios) {
        double suma = 0;
        for (int i=0; i < precios.length; i++) {
            suma += precios[i];
        }
        return suma / precios.length;
    }

    /**
     * Busca la posicion del precio maximo
     * @param precios array de double que contiene todos los precios
     * @return devuelve la posicion del precio más alto
     */
    private static int encontrarIndiceMaxPrecio(double[] precios) {
        int posicionMax = 0;
        for (int i = 1; i < precios.length; i++) {
            if (precios[i] > precios[posicionMax]) {
                posicionMax = i;
            }
        }
        return posicionMax;
    }

    /**
     * Función para buscar la cantidad del producto que queda más
     * @param cantidad array int que contiene las cantidades de cada producto
     * @return devuelve la posición de la cantidad del producto que hay más
     */
    private static int encontrarIndiceMaxCantidad(int[] cantidad) {
        int posicionMax = 0;
        for (int i = 1; i < cantidad.length; i++) {
            if (cantidad[i] > cantidad[posicionMax]) {
                posicionMax = i;
            }
        }
        return posicionMax;
    }

}