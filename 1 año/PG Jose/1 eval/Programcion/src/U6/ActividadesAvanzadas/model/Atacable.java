package U6.ActividadesAvanzadas.model;

public interface Atacable {
    void recibirDano(int cantidad, int getAumentoDefensa);
    String getNombre();
    boolean estaVivo();
}
