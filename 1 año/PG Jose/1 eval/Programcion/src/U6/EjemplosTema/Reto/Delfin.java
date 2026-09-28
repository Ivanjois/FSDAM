package U6.EjemplosTema.Reto;

public class Delfin extends Animal implements Trucos {
    public Delfin(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerTruco() {
        System.out.println("¡Hace un salto mortal hacia atrás!");
        this.energia -= 10;
    }

    @Override
    public void comer(String comida) {
        if (comida.equalsIgnoreCase("Peces")) {
            this.energia += 50;
            System.out.println(nombre + " está comiendo " + comida + ". Le suma 50 de energía.");
        } else if (comida.equalsIgnoreCase("Calamar")) {
            this.energia += 80;
            System.out.println(nombre + " come " + comida + ". Le suma 80 de energía.");
        } else { System.out.println(comida+" no le gusta la comida."); }

    }
}
