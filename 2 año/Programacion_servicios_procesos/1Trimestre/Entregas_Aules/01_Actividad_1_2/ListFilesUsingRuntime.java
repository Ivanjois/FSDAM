package Actividad1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Actividad 1.2: Ejecucion de procesos externos mediante Runtime.
 * Forma clasica de interactuar con el Sistema Operativo en Java.
 */
public class ListFilesUsingRuntime {
    public static void main(String[] args) {
        try {
            // Detectamos si el sistema operativo es Windows o Linux/Mac
            boolean esWindows = System.getProperty("os.name").toLowerCase().contains("win");

            // En Runtime se pasa toda la linea de comandos como un unico String
            String comando = esWindows ? "cmd /c dir" : "ls -l";

            // 1. INICIAR EL PROCESO EXTERNO DIRECTAMENTE
            Process process = Runtime.getRuntime().exec(comando);

            // 2. CONECTAR LA TUBERIA PARA LEER LA SALIDA DEL PROCESO
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 3. ESPERAR A QUE EL PROCESO TERMINE
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
