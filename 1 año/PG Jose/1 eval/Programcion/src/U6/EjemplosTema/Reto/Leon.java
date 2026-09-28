package U6.EjemplosTema.Reto;

public class Leon extends  Animal implements Trucos {
    public Leon(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerTruco() {
        System.out.println("El león salta a través de un aro de fuego");
    }

    @Override
    public void comer(String comida) {
        if (comida.equalsIgnoreCase("Carne")) {
            this.energia += 100;
            System.out.println(nombre + " está devorando " + comida + ". Energía aumentada en 60.");
        } else {
            this.energia -= 10;
            System.out.println(nombre + " intenta comer " + comida + " pero no le gusta mucho. Le resta en 5 de energía.");
        }
    }


}
