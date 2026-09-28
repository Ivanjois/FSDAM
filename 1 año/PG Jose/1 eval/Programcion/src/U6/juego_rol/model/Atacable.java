package U6.juego_rol.model;

public interface Atacable {
    void recibirDano(int cantidad);

    String getNombre();

    boolean estaVivo();
}
