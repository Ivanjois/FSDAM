package U6.EjemplosTema.Reto;

public abstract class Animal {
    protected String nombre;
    protected int energia = 50;
    public Animal(String nombre) {
        this.nombre = nombre;
    }


    public void jugar(int gasto) {
        this.energia -= gasto;
        System.out.println(nombre + " está jugando.... energía restada: " + gasto);
    }

    public abstract void comer(String comida);
}