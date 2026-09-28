package U6.EjemplosTema;

public class MainAnimales {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal perro = new Perro();
        Animal gato = new Gato();
        animal.hacerSonido();
        perro.hacerSonido();
        gato.hacerSonido();
    }
}
