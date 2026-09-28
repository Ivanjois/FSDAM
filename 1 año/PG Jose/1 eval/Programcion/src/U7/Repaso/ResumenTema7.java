package U7.Repaso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ResumenTema7 {

    public static void main(String[] args) {

        // 1. EL OBJETO FILE (El "mapa" hacia tu archivo)
        // Esto NO crea el archivo, solo le dice a Java dónde buscarlo o cómo se llamará.
        File miArchivo = new File("resumen_datos.csv");


        System.out.println("--- FASE 1: ESCRITURA (Guardar en el disco) ---");

        // 2. ESCRITURA CON TRY-WITH-RESOURCES (El método moderno)
        // Al poner el PrintStream dentro de los paréntesis del try(), le decimos a Java:
        // "Abre este flujo de datos y, pase lo que pase, CIÉRRALO automáticamente al terminar".
        // Así nos ahorramos el peligroso error de olvidarnos de poner '.close()'.
        try (PrintStream escritor = new PrintStream(miArchivo)) {

            // Escribimos un par de líneas simulando un formato CSV (separado por punto y coma)
            escritor.println("101;Ordenador Portátil;1200.50");
            escritor.println("102;Ratón Inalámbrico;25.99");
            System.out.println("¡Datos guardados con éxito en el archivo!");

        } catch (FileNotFoundException e) {
            // EXCEPCIÓN: Si por algún motivo Windows/Mac no nos deja crear el archivo 
            // (por ejemplo, falta de permisos), atrapamos el error aquí para no colapsar.
            System.out.println("Error grave: No se pudo crear el archivo para escribir.");
        }



        System.out.println("\n--- FASE 2: LECTURA (Cargar a la memoria) ---");

        // 3. LECTURA CON SCANNER Y SPLIT
        // Ahora usamos un try-catch normal para leer.
        try {
            // Le pasamos el File al Scanner en vez de System.in (teclado). 
            // Ahora lee del disco duro.
            Scanner lectorFichero = new Scanner(miArchivo);

            // Mientras el archivo tenga una línea siguiente por leer...
            while (lectorFichero.hasNextLine()) {

                String linea = lectorFichero.nextLine(); // Leemos la línea completa

                // EL TRUCO DEL SPLIT: Cortamos la línea de texto cada vez que haya un ";"
                // "101;Ordenador;1200" -> Se convierte en un array de 3 huecos: ["101", "Ordenador", "1200"]
                String[] trozos = linea.split(";");

                // Parseamos (traducimos) los trozos de texto a los tipos de datos reales
                int id = Integer.parseInt(trozos[0]);
                String nombre = trozos[1];
                double precio = Double.parseDouble(trozos[2]);

                // Imprimimos para demostrar que hemos recuperado los datos
                System.out.println("Producto cargado -> ID: " + id + " | Nombre: " + nombre + " | Precio: " + precio);
            }

            // OBLIGATORIO: Como no usamos try-with-resources aquí, hay que cerrar el Scanner a mano.
            lectorFichero.close();

        } catch (FileNotFoundException e) {
            // EXCEPCIÓN: ¿Qué pasa si intentamos leer un archivo que alguien ha borrado?
            // El Scanner lanza un FileNotFoundException, lo atrapamos y avisamos amablemente.
            System.out.println("Aviso: El archivo que intentas leer no existe.");
        } catch (NumberFormatException e) {
            // EXCEPCIÓN: ¿Qué pasa si el CSV tiene letras donde debería haber un número?
            // El Integer.parseInt fallaría. Lo atrapamos aquí.
            System.out.println("Error: El archivo contiene datos corruptos (no se pudo convertir a número).");
        }

        System.out.println("\n¡Programa finalizado de forma segura!");
    }
}