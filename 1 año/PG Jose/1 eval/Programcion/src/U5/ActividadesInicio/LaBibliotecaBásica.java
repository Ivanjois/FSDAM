package U5.ActividadesInicio;

import java.util.Scanner;

public class LaBibliotecaBásica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Libro l = new Libro();
        l.titulo = "Quijote";
        l.autor = "Cervantes";
        l.numPaginas = 500;
        boolean bandera = true;
        do {
            System.out.println("Ingrese la valoracion del libro: " + l.titulo + ": ");
            l.valoracion = sc.nextInt();
            if (l.valoracion >= 0 && l.valoracion <= 10) {
                l.mostrarInfo();
                bandera = false;
            }
            else {
                System.out.println("Ingrese la valoracion del libro valida entre 0 y 10");
            }
        } while (bandera);
    }
}
