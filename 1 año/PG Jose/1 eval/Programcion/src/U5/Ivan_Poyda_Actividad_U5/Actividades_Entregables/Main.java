//package U5.Actividades_Entregables;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        char opcion;
//        int numeroSala, posicion, numSala, fila, columna;
//        boolean bandera = true;
//        ArrayList<Sala> Salas = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        do {
//            System.out.println("Opciones: ");
//            System.out.println("A) Crear sala (Añadir una nueva sala al cine).");
//            System.out.println("B) Ver cartelera (Listar salas con su información básica).");
//            System.out.println("C) Ver sala (Mostrar butacas de una sala específica).");
//            System.out.println("D) Vender entrada (Pedir sala, fila y columna, validando disponibilidad).");
//            System.out.println("E) Ver recaudación de sala (Muestra el dinero recaudado por una sala).");
//            System.out.println("F) Recaudación total del cine (Recaudación de todas las salas).");
//            System.out.println("G) Salir.");
//            System.out.print("> Seleccione opción: ");
//            opcion = sc.next().toLowerCase().charAt(0);
//            switch (opcion) {
//                case 'a':
//                    System.out.print("Ingrese el número de sala: ");
//                    numSala = sc.nextInt();
//                    sc.nextLine();
//                    System.out.print("Ingrese título película: ");
//                    String pelicula = sc.next();
//                    System.out.print("Ingrese hora: ");
//                    String horaProyeccion = sc.next();
//                    crearSala(numSala, pelicula, horaProyeccion, Salas);
//                    break;
//                case 'b':
//                    verCartelera(Salas);
//                    break;
//                case 'c':
//                    System.out.print("Dime el numero de la sala: ");
//                    System.out.println("--- ESTADO SALA 1 ---");
//                    numeroSala = sc.nextInt();
//                    sc.nextLine();
//                    verSala(Salas, numeroSala);
//                    break;
//                case 'd':
//                    System.out.print("Ingrese número de sala: ");
//                    numeroSala = sc.nextInt();
//                    sc.nextLine();
//                    posicion = existeSala(Salas, numeroSala);
//                    if (posicion > -1) {
//                        System.out.print("Ingrese fila: ");
//                        fila = sc.nextInt();
//                        sc.nextLine();
//                        System.out.print("Ingrese columna: ");
//                        columna = sc.nextInt();
//                        sc.nextLine();
//                        venderEntrada(Salas, posicion, fila, columna);
//                    }
//                    break;
//                case 'e':
//                    System.out.print("Ingrese número de sala: ");
//                    numeroSala = sc.nextInt();
//                    sc.nextLine();
//                    verRecaudacionSala(Salas, numeroSala);
//                    break;
//                case 'f':
//                    recaudacionTotal();
//                    break;
//                case 'g':
//                    System.out.println("Hasta la próxima");
//                    bandera = false;
//                    break;
//                default:
//                    System.out.println("No opción valida");
//            }
//        } while (bandera);
//
//    }
//
//    public static int existeSala(ArrayList<Sala> salas, int numeroSala) {
//        for (Sala sala : salas) {
//            if (sala.getNumSala() == numeroSala) {
//                return salas.indexOf(sala);
//            }
//        }
//        System.out.println("No existe la sala " + numeroSala);
//        return -1;
//    }
//
//    public static void recaudacionTotal() {
//        System.out.println("Recaudación total del cine: " + Sala.getRecaudacionTotal());
//    }
//
//    private static void verRecaudacionSala(ArrayList<Sala> salas, int numeroSala) {
//        for (Sala sala : salas) {
//            if (sala.getNumSala() == numeroSala) {
//                System.out.println("[INFO] La sala 1 ha recaudado: " + sala.getRecaudacionSala());
//            }
//        }
//    }
//
//    public static void venderEntrada(ArrayList<Sala> salas, int posicion, int fila, int columna) {
//        salas.get(posicion).venderEntrada(fila, columna);
//    }
//
//    public static void verSala(ArrayList<Sala> salas, int numeroSala) {
//        for (Sala sala : salas) {
//            if (sala.getNumSala() == numeroSala) {
//                sala.mostrarSala();
//            }
//        }
//    }
//
//    public static void verCartelera(ArrayList<Sala> salas) {
//        System.out.println("--- CARTELERA ---");
//        for (Sala sala : salas) {
//            System.out.println(sala);
//        }
//    }
//
//    public static void crearSala(int numSala, String pelicula, String horaProyeccion, ArrayList<Sala> Salas) {
//        if (numSala>0){
//            Sala sala = new Sala(numSala, pelicula, horaProyeccion);
//            System.out.println("Sala " + sala.getNumSala() + " creada con éxito");
//            Salas.add(sala);
//        }else {
//            System.out.println("El numero de sala tiene que ser mayor a 0");
//        }
//    }
//}