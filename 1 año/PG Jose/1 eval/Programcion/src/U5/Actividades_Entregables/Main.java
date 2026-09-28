package U5.Actividades_Entregables;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char opcion;
        int numeroSala, posicion, numSala, fila, columna;
        boolean bandera = true;
        ArrayList<Sala> Salas = new ArrayList<>();


    }

    public static int existeSala(ArrayList<Sala> salas, int numeroSala) {
        for (Sala sala : salas) {
            if (sala.getNumSala() == numeroSala) {
                return salas.indexOf(sala);
            }
        }
        System.out.println("No existe la sala " + numeroSala);
        return -1;
    }

    public static void recaudacionTotal() {
        System.out.println("Recaudación total del cine: " + Sala.getRecaudacionTotal());
    }

    private static void verRecaudacionSala(ArrayList<Sala> salas, int numeroSala) {
        for (Sala sala : salas) {
            if (sala.getNumSala() == numeroSala) {
                System.out.println("[INFO] La sala 1 ha recaudado: " + sala.getRecaudacionSala());
            }
        }
    }

    public static void venderEntrada(ArrayList<Sala> salas, int posicion, int fila, int columna) {
        salas.get(posicion).venderEntrada(fila, columna);
    }

    public static void verSala(ArrayList<Sala> salas, int numeroSala) {
        for (Sala sala : salas) {
            if (sala.getNumSala() == numeroSala) {
                sala.mostrarSala();
            }
        }
    }

    public static void verCartelera(ArrayList<Sala> salas) {
        System.out.println("--- CARTELERA ---");
        for (Sala sala : salas) {
            System.out.println(sala);
        }
    }

    public static void crearSala(int numSala, String pelicula, String horaProyeccion, ArrayList<Sala> Salas) {
        if (numSala>0){
            Sala sala = new Sala(numSala, pelicula, horaProyeccion);
            System.out.println("Sala " + sala.getNumSala() + " creada con éxito");
            Salas.add(sala);
        }else {
            System.out.println("El numero de sala tiene que ser mayor a 0");
        }
    }
}