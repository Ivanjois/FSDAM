package U6.EjemplosTema.Reto;

import java.util.ArrayList;

public class MainAnimal {
    public static void main(String[] args) {
    ArrayList<Animal> animales = new ArrayList<>();
    animales.add(new Leon("Leon"));
    animales.add(new Delfin("Delfín"));
    animales.add(new Perro("Perro"));

    for (Animal animal : animales) {
        animal.jugar(20);
        animal.comer("Carne");
        if (animal instanceof Delfin) {
            ((Delfin) animal).hacerTruco();
        } else if (animal instanceof Perro) {
            ((Perro) animal).hacerTruco();
        }
    }
    }

}
