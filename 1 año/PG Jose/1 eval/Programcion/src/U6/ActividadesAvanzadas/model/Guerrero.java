package U6.ActividadesAvanzadas.model;

public class Guerrero extends Personaje {
    private int furia;

    public Guerrero(int furia, String nombre, int vida, int nivel, int agilidad, int resistencia) {
        super(nombre, vida, nivel, agilidad, resistencia);
        this.furia = furia;
    }

    public int getFuria() {
        return this.furia;
    }

    public void setFuria(int furia) {
        this.furia = furia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Furia: " + this.furia;
    }

    @Override
    public void atarcar(Personaje enemigo) {
        int dano = this.nivel * 2 + this.furia;
        System.out.println("El " + this.nombre + " ataca a " + enemigo.getNombre());
    }
}
