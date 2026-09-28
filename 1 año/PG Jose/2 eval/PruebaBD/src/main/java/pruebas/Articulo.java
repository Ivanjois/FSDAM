package pruebas;

// Archivo: Articulo.java
public class Articulo {
    private int idArticulo;
    private String nombre;
    private double precio;
    private int idFabricante;


    //POR defecto
    public Articulo(){
        this.idArticulo = 0;
        this.nombre = "";
        this.precio = 0;
        this.idFabricante = 0;
    }
    // Constructor
    public Articulo(int idArticulo, String nombre, double precio, int idFabricante) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.precio = precio;
        this.idFabricante = idFabricante;
    }

    // Getters y Setters
    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }
}
