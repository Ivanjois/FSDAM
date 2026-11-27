package Actividad1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ejemplo oficial del PDF de Sergio Jimenez (Paginas 15-16):
 * Ejecucion del comando 'ping 8.8.8.8' con ProcessBuilder.
 * Ademas muestra metodos avanzados: pid(), isAlive() y waitFor().
 */
public class EjemploPingProcessBuilder {
    public static void main(String[] args) {
        try {
            // 1. Crear el proceso con el comando ping y la IP de Google DNS (8.8.8.8)
            // Funciona de forma universal tanto en Windows como en Linux/Mac
            ProcessBuilder processBuilder = new ProcessBuilder("ping", "8.8.8.8");

            System.out.println("--- Lanzando ping a 8.8.8.8 ---");

            // 2. Iniciar el proceso
            Process process = processBuilder.start();

            // Metodos explicados por Sergio Jimenez (Paginas 12-13):
            System.out.println("ID del proceso (PID) en el sistema: " + process.pid());
            System.out.println("Esta el proceso vivo ahora mismo? " + process.isAlive());

            // 3. Capturar y leer la salida linea a linea
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(">> " + line);
            }

            // 4. Esperar a que el ping termine y obtener el codigo de salida
            int exitCode = process.waitFor();

            System.out.println("------------------------------------------------");
            System.out.println("Esta el proceso vivo tras finalizar? " + process.isAlive());
            System.out.println("El proceso termino con codigo de salida: " + exitCode);
            System.out.println("------------------------------------------------");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
