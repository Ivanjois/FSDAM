//package U5.Actividades_Entregables;
//
//public class Sala {
//    private int numSala = -1;
//    private String pelicula;
//    private String horaProyeccion;
//    private double recaudacionSala;
//    private static double recaudacionTotal;
//    private final double precioEntrada = 5.99;
//    private final int filas = 6;
//    private final int columnas = 10;
//    private char[][] asientos;
//
//    Sala() {
//        this.numSala = 0;
//        this.asientos = new char[filas][columnas];
//        this.pelicula = "";
//        this.horaProyeccion = "";
//        this.recaudacionSala = 0;
//        for (int i = 0; i < this.filas; i++) {
//            for (int j = 0; j < this.columnas; j++) {
//                this.asientos[i][j] = '.';
//            }
//        }
//    }
//
//    Sala(int numSala, String pelicula, String horaProyeccion) {
//        this.asientos = new char[filas][columnas];
//        this.recaudacionSala = 0;
//        this.setNumSala(numSala);
//        this.setPelicula(pelicula);
//        this.setHoraProyeccion(horaProyeccion);
//
//        for (int i = 0; i < this.filas; i++) {
//            for (int j = 0; j < this.columnas; j++) {
//                this.asientos[i][j] = '.';
//            }
//        }
//    }
//
//    public void mostrarSala() {
//        System.out.print("  ");
//        for (int j = 0; j < this.columnas; j++) {
//            System.out.print(j + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < this.filas; i++) {
//            System.out.print(i + " ");
//            for (int j = 0; j < this.columnas; j++) {
//                System.out.print(this.asientos[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public boolean asientoDisponible(int fila, int columna) {
//        return asientos[fila][columna] == '.';
//    }
//
//    public void venderEntrada(int fila, int columna) {
//        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas && asientoDisponible(fila, columna)) {
//            asientos[fila][columna] = 'X';
//            System.out.println("[OK] Entrada vendida (Precio: 5.99€).");
//            recaudacionSala += precioEntrada;
//            recaudacionTotal += precioEntrada;
//        } else {
//            System.out.println("[ASIENTO NO DISPONIBLE]");
//        }
//    }
//
//    public double getRecaudacionSala() {
//        return recaudacionSala;
//    }
//
//    public int getAsientosDisponible() {
//        int asientosDisponibles = 0;
//        for (int i = 0; i < this.filas; i++) {
//            for (int j = 0; j < this.columnas; j++) {
//                if (asientos[i][j] == '.') {
//                    asientosDisponibles++;
//                }
//            }
//        }
//        return asientosDisponibles;
//    }
//
//    public String toString() {
//        return "[Sala " + this.getNumSala() + "] " + getPelicula() + " (" + getHoraProyeccion() + ") - Asientos Libres: " + getAsientosDisponible();
//    }
//
//    public static double getRecaudacionTotal() {
//        return Sala.recaudacionTotal;
//    }
//
//    public void setHoraProyeccion(String horaProyeccion) {
//        this.horaProyeccion = horaProyeccion;
//    }
//
//    public String getHoraProyeccion() {
//        return this.horaProyeccion;
//    }
//
//    public void setPelicula(String pelicula) {
//        this.pelicula = pelicula;
//    }
//
//    public String getPelicula() {
//        return this.pelicula;
//    }
//
//    public void setNumSala(int numSala) {
//        this.numSala = numSala;
//    }
//
//    public int getNumSala() {
//        return this.numSala;
//    }
//
//}