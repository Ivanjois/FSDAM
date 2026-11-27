package Actividad1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Actividad 1.2: Ejecucion de procesos externos mediante ProcessBuilder.
 * Forma moderna y recomendada en Java para interactuar con el Sistema Operativo.
 */
public class ListFilesUsingProcessBuilder {
    public static void main(String[] args) {
        try {
            // Detectamos si el sistema operativo es Windows o Linux/Mac
            boolean esWindows = System.getProperty("os.name").toLowerCase().contains("win");

            ProcessBuilder processBuilder;
            if (esWindows) {
                // En Windows llamamos a cmd.exe con /c para ejecutar el comando interno dir
                processBuilder = new ProcessBuilder("cmd", "/c", "dir");
            } else {
                // En Linux / Mac ejecutamos ls -l
                processBuilder = new ProcessBuilder("ls", "-l");
            }

            // 1. INICIAR EL PROCESO EXTERNO
            Process process = processBuilder.start();

            // 2. CONECTAR LA TUBERIA PARA LEER LA SALIDA DEL PROCESO
            // getInputStream() captura el texto que el comando escribe en pantalla
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 3. ESPERAR A QUE EL PROCESO TERMINE
            // waitFor() detiene la ejecucion de Java hasta que el comando del SO finaliza
            int exitCode = process.waitFor();

            // 4. CODIGO DE SALIDA (0 = Exito, distinto de 0 = Error)
            System.out.println("\n------------------------------------------------");
            System.out.println("El proceso ha finalizado con codigo de salida: " + exitCode);
            System.out.println("------------------------------------------------");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
