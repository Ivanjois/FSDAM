package Actividad1_2;

import java.io.File;
import java.io.IOException;

/**
 * Ejemplo oficial del PDF de Sergio Jimenez (Pagina 14):
 * Redirigir la salida del proceso directamente a un archivo de texto en disco
 * SIN necesidad de usar BufferedReader ni InputStreamReader.
 */
public class EjemploRedireccionFichero {
    public static void main(String[] args) {
        try {
            // 1. Preparamos el comando
            ProcessBuilder processBuilder = new ProcessBuilder("ping", "8.8.8.8");

            // 2. Definimos los archivos donde queremos guardar la salida y los errores
            File archivoSalida = new File("salida_ping.txt");
            File archivoError = new File("errores_ping.txt");

            // 3. Le decimos a ProcessBuilder que redirija todo directamente a disco
            processBuilder.redirectOutput(archivoSalida);
            processBuilder.redirectError(archivoError);

            System.out.println("Iniciando proceso y guardando la salida en: " + archivoSalida.getAbsolutePath());

            // 4. Arrancamos el proceso
            Process process = processBuilder.start();

            // 5. Esperamos a que finalice
            int exitCode = process.waitFor();

            System.out.println("------------------------------------------------");
            System.out.println("Comando finalizado con codigo: " + exitCode);
            System.out.println("Ya puedes abrir el archivo 'salida_ping.txt' para ver los resultados!");
            System.out.println("------------------------------------------------");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
