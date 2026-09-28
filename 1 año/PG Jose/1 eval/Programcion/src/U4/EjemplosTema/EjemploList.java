package U4.EjemplosTema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EjemploList {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<String> Videojuegos = new ArrayList<>();
            String elementoAñadir;
            // 1. Operaciones CRUD (Create, Read, Update, Delete).
            // CREATE: Añadir elementos
            Videojuegos.add("Minecraft");
            Videojuegos.add("Fly simulator");
            System.out.println("Que elemento quieres añadir a  la lista?");
            elementoAñadir = sc.nextLine();
            Videojuegos.add(elementoAñadir);
            // READ: Acceso posicional
            System.out.println("Elemento en índice 2: " + Videojuegos.get(2));

            // UPDATE: Modificar elementos
            Videojuegos.set(2, "Counter Strike(CS2)"); // Reemplaza "el elemento que añade el usuario"

            // DELETE: Eliminar elementos
            Videojuegos.remove("Fly simulator"); // Por objeto
            Videojuegos.remove(0);// Por índice ("Sierra")

            // 2. Operaciones de Utilidad
            System.out.println("¿Está vacío? " + Videojuegos.isEmpty());
            System.out.println("Total de artículos: " + Videojuegos.size());

            if (Videojuegos.contains("Fly simulator")) {
                System.out.println("El inventario contiene Fly simulator.");
            } else {
                System.out.println("El inventario no contiene Fly simulator.");
                System.out.println("Quieres añadirlo?S/N");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("S")) {
                    Videojuegos.add("Fly simulator");
                } else {
                    System.out.println("El inventario no contiene Fly simulator.");
                }
            }

            // Ordenación (usando la clase de utilidad Collections)
            Collections.sort(Videojuegos);

            // 3. Iteración
            System.out.println("\n--- Inventario Actualizado ---");
            for (String articulo : Videojuegos) {
                System.out.println("- " + articulo);
            }
        }
    }
}