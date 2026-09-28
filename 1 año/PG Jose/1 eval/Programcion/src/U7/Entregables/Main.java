package U7.Entregables;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> lproductos = new ArrayList<>();
        File archivoProductos = new File("productos.csv");

        try {
            Scanner sc = new Scanner(archivoProductos);
            System.out.println("Cargando inventario desde productos.csv...");
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(";");

                if (partes.length == 4) {
                    int idLeido = Integer.parseInt(partes[0]);
                    String nombreLeido = partes[1];
                    int stockLeido = Integer.parseInt(partes[2]);
                    double precioLeido = Double.parseDouble(partes[3]);

                    lproductos.add(new Producto(idLeido, nombreLeido, stockLeido, precioLeido));
                }
            }
            sc.close();
            mostrarInventario(lproductos);

        } catch (FileNotFoundException e) {
            System.out.println("AVISO: No hay productos previos. El archivo 'productos.csv' no existe todavía.");
        }

        Scanner teclado = new Scanner(System.in);
        boolean salir = false;

        do {
            System.out.println("\n--- MENÚ LOGISTIC ---");
            System.out.println("1. Mostrar todos los productos");
            System.out.println("2. Crear un nuevo producto");
            System.out.println("3. Buscar y modificar");
            System.out.println("4. Eliminar un producto");
            System.out.println("5. Ordenar por stock");
            System.out.println("6. Generar fichero de reposición");
            System.out.println("7. Guardar y Salir");
            System.out.println("8. Salir sin guardar");
            System.out.print("> Seleccione opción: ");

            int opcion = leerEntero(teclado);

            switch (opcion) {
                case 1:
                    System.out.println("\n--- INVENTARIO ---");
                    mostrarInventario(lproductos);
                    break;

                case 2:
                    System.out.println("\n--- CREAR NUEVO PRODUCTO ---");
                    int nuevoId = 1;
                    for (Producto p : lproductos) {
                        if (p.getId() >= nuevoId) {
                            nuevoId = p.getId() + 1;
                        }
                    }

                    System.out.print("Nombre del producto: ");
                    String nombreNuevo = teclado.nextLine();

                    System.out.print("Stock del producto: ");
                    int stockNuevo = leerEntero(teclado);

                    System.out.print("Precio del producto: ");
                    double precioNuevo = leerDouble(teclado);

                    lproductos.add(new Producto(nuevoId, nombreNuevo, stockNuevo, precioNuevo));
                    System.out.println("¡Producto añadido con éxito! ID asignado: " + nuevoId);
                    break;

                case 3:
                    System.out.println("\n--- BUSCAR Y MODIFICAR ---");
                    System.out.print("Introduce el ID del producto: ");
                    int idModificar = leerEntero(teclado);

                    Producto pMod = buscarProducto(idModificar, lproductos);
                    if (pMod != null) {
                        System.out.println("Producto encontrado: " + pMod);
                        System.out.print("¿Quieres modificar algo de este producto? (si/no): ");
                        String decision = teclado.nextLine().toLowerCase();

                        if (decision.equals("si")) {
                            System.out.print("Nuevo stock: ");
                            pMod.setStock(leerEntero(teclado));

                            System.out.print("Nuevo precio: ");
                            pMod.setPrecio(leerDouble(teclado));


                            System.out.println("¡Producto modificado con éxito!");
                        } else {
                            System.out.println("Operación de modificación cancelada.");
                        }
                    } else {
                        System.out.println("No se encontró ningún producto con ID " + idModificar);
                    }
                    break;

                case 4:
                    System.out.println("\n--- ELIMINAR PRODUCTO ---");
                    System.out.print("Introduce el ID a eliminar: ");
                    int idEliminar = leerEntero(teclado);

                    Producto pElim = buscarProducto(idEliminar, lproductos);
                    if (pElim != null) {
                        lproductos.remove(pElim);
                        System.out.println("¡El producto '" + pElim.getNombre() + "' ha sido eliminado!");
                    } else {
                        System.out.println("No se encontró ningún producto con ID " + idEliminar);
                    }
                    break;

                case 5:
                    System.out.println("\n--- ORDENAR POR STOCK ---");
                    Collections.sort(lproductos);
                    System.out.println("Inventario ordenado de menor a mayor stock:");
                    mostrarInventario(lproductos);
                    break;

                case 6:
                    System.out.println("\n--- FICHERO DE REPOSICIÓN ---");
                    System.out.print("Introduce el umbral de stock: ");
                    int umbral = leerEntero(teclado);

                    try (PrintStream psRepo = new PrintStream("reposición_productos.csv")) {
                        int count = 0;
                        for (Producto p : lproductos) {
                            if (p.getStock() < umbral) {
                                psRepo.println(p.getId() + ";" + p.getNombre() + ";" + p.getStock() + ";" + p.getPrecio());
                                count++;
                            }
                        }
                        System.out.println("¡Fichero de reposición generado con " + count + " productos y con un stock inferior a "+ umbral);
                    } catch (FileNotFoundException e) {
                        System.out.println("Error al crear el archivo de reposición.");
                    }
                    break;

                case 7:
                    System.out.println("\n--- GUARDANDO Y SALIENDO ---");
                    try (PrintStream psPrincipal = new PrintStream(archivoProductos)) {
                        for (Producto p : lproductos) {
                            psPrincipal.println(p.getId() + ";" + p.getNombre() + ";" + p.getStock() + ";" + p.getPrecio());
                        }
                        System.out.println("¡Todos los datos se han guardado en productos.csv!");
                    } catch (FileNotFoundException e) {
                        System.out.println("Error grave al intentar guardar el archivo principal.");
                    }
                    System.out.println("¡Hasta pronto!");
                    salir = true;
                    break;

                case 8:
                    System.out.println("\n--- SALIENDO SIN GUARDAR---");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige un número del 1 al 7.");
            }
        } while (!salir);

        teclado.close();
    }

    public static void mostrarInventario(ArrayList<Producto> lista) {
        if (lista.isEmpty()) {
            System.out.println("El almacén está completamente vacío.");
        } else {
            for (Producto p : lista) {
                System.out.println(p);
            }
        }
    }

    public static Producto buscarProducto(int idBuscado, ArrayList<Producto> lista) {
        for (Producto p : lista) {
            if (p.getId() == idBuscado) {
                return p;
            }
        }
        return null;
    }

    public static int leerEntero(Scanner teclado) {
        while (true) {
            try {
                int num = Integer.parseInt(teclado.nextLine().trim());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("¡Error! Introduce un número entero válido: ");
            }
        }
    }

    public static double leerDouble(Scanner teclado) {
        while (true) {
            try {
                String entrada = teclado.nextLine().trim().replace(",", ".");
                double num = Double.parseDouble(entrada);
                return num;
            } catch (NumberFormatException e) {
                System.out.print("¡Error! Introduce un número válido (ej: 15.5): ");
            }
        }
    }
}