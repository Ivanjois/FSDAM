package U6.ActividadesAvanzadas.model;

public class Orco extends Personaje {
    private int fuerza;

    public Orco(int fuerza, String nombre, int vida, int nivel, int agilidad, int resistencia) {
        super(nombre, vida, nivel, agilidad, resistencia);
        this.fuerza = fuerza;
    }
    @Override
    public String toString() {
        return super.toString() + ", Furia: " + this.fuerza;
    }
    @Override
    public void atarcar(Personaje enemigo) {
        System.out.println("El " + this.nombre + " ataca a " + enemigo.getNombre());
    }


}
