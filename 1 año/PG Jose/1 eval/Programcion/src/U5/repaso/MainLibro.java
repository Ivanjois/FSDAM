import java.util.ArrayList;
import java.util.Scanner;
public class MainLibro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Libro> biblioteca = new ArrayList<Libro>();
        int opcion, isbn;
        do{
            menu();
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    anyadirLibro(sc,biblioteca);
                    break;
                case 2:
                    mostrarLibros(biblioteca);
                    break;
                case 3:
                    System.out.println("Introduce el ISBN");
                    isbn = sc.nextInt();
                    sc.nextLine();
                    buscarISBN(isbn, biblioteca);
                    break;
                case 4:
                    System.out.println("Introduce el ISBN a eliminar");
                    isbn = sc.nextInt();
                    sc.nextLine();
                    eliminarISBN(isbn, biblioteca);
                    break;
                case 5:
                    vaciarLista(biblioteca);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }while(opcion!=6);
    }
    public static void menu(){
        System.out.println("--- MENÚ LIBRERÍA ---");
        System.out.println("1. Añadir Libro");
        System.out.println("2. Mostrar Libros");
        System.out.println("3. Buscar por ISBN");
        System.out.println("4. Eliminar por ISBN");
        System.out.println("5. Vaciar Lista");
        System.out.println("6. Salir");
        System.out.println("Seleccione opción: ");
    }
    public static void mostrarLibros(ArrayList<Libro> biblioteca){
        System.out.println("Listado actual:");
        for(Libro l: biblioteca){
            System.out.println(l.toString());
        }
    }
    public static void buscarISBN(int isbn, ArrayList<Libro> biblioteca){
        boolean encontrado = false;
        for(Libro l: biblioteca){
            if(l.getIsbn() == isbn){
                System.out.println(l.toString());
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("El ISBN no fue encontrado");
        }
    }
    public static void eliminarISBN(int isbn, ArrayList<Libro> biblioteca){
        boolean encontrado = false;
        for(Libro l: biblioteca){
            if(l.getIsbn() == isbn){
                biblioteca.remove(l);
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("El ISBN no fue encontrado");
        }
    }
    public static void vaciarLista(ArrayList<Libro> biblioteca){
        biblioteca.clear();
        System.out.println("Biblioteca vaciada");
    }
    public static void anyadirLibro(Scanner sc,ArrayList<Libro> biblioteca){
        Libro libro = new Libro();
        System.out.println("ISBN del libro");
        libro.setIsbn(sc.nextInt());
        sc.nextLine();
        System.out.println("Titulo del libro");
        libro.setTitulo(sc.nextLine());
        System.out.println("Autor del libro");
        libro.setAutor(sc.nextLine());
        System.out.println("Numero de paginas del libro");
        libro.setNumPaginas(sc.nextInt());
        sc.nextLine();
        biblioteca.add(libro);
    }
}