package U6.EjemplosTema.Reto;

import java.util.Objects;

public class Perro extends Animal implements Trucos {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerTruco() {
        System.out.println("¡Da la patita y rueda!");
        this.energia -= 5;
    }

    @Override
    public void comer(String comida) {
        if (comida.equalsIgnoreCase("Carne")) {
            this.energia += 50;
            System.out.println(nombre + " está comiendo " + comida + " le suma 50 de energía");
        } else if (comida.equalsIgnoreCase("Pienso")) {
            this.energia += 30;
            System.out.println(nombre + " está comiendo " + comida + " le suma 30 de energía");
        } else {
            System.out.println(" " + comida + " no le gusta la comida");
        }
    }
}