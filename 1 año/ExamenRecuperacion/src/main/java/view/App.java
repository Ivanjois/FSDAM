package view;

import database.TemperaturaDAO;
import model.Temperatura;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        LocalDate momentoActual = LocalDate.now();
        TemperaturaDAO dao = new TemperaturaDAO();
        Temperatura tep1 = new Temperatura("Valencia", 23.3, 36.3, momentoActual);
        dao.insertar(tep1);
        dao.borrar(1);
        System.out.println("--- Listado de Temperaturas ---");
        ArrayList<Temperatura> temperaturas= dao.obtenerTodos();
        for (Temperatura temperatura : temperaturas) {
            System.out.println(temperatura);
        }
        System.out.println("--- Listado de Temperaturas mayores que 23---");
        ArrayList<Temperatura> temperaturasMayores= dao.mayorQue(23.0);
        for (Temperatura temperaturasMayore : temperaturasMayores) {
            System.out.println(temperaturasMayore);
        }
        try {
            guardarTemperaturas(temperaturasMayores);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void guardarTemperaturas(ArrayList<Temperatura> temperaturas) throws FileNotFoundException {
        File archivoLog = new File("temperaturas.txt");

        FileOutputStream puente = new FileOutputStream(archivoLog, true);
        PrintStream escritor = new PrintStream(puente);
        System.out.println("--- REGISTRANDO EVENTOS EN EL DISCO ---");
        escritor.println("=====================================");
        escritor.println("NUEVA SESIÓN DE JUEGO INICIADA");
        Iterator<Temperatura> it2 = temperaturas.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
            escritor.println(it2);
        }
        escritor.close();
        System.out.println("=====================================");
        System.out.println("Eventos guardados correctamente en el registro.");
    }

}
