package Actividad2;

public class Socio extends Comprador {
    String nombre;

    public Socio(String dni, String email, String nombre) {
        super(dni, email);
        this.nombre = nombre;
    }
}
