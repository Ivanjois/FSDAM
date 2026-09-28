package U6.ActividadesAvanzadas.model;

public class Mago extends Personaje {
    private int mana;

    public Mago(int mana, String nombre, int vida, int nivel, int agilidad, int resistencia) {
        super(nombre, vida, nivel, agilidad, resistencia);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + ", Furia: " + this.mana;
    }
    @Override
    public void atarcar(Personaje enemigo) {
        System.out.println("El " + this.nombre + " ataca a " + enemigo.getNombre());
    }
}
