package U6.ActividadesInicio.Abstractos;

public class Main {
    public static void main(String[] args) {
        Circulo c = new Circulo();
        // Nota: El radio no está inicializado en la clase Circulo proporcionada,
        // pero siguiendo la estructura de las clases abstractas:

        Rectangulo r = new Rectangulo(5, 10);

        System.out.println(c);
        System.out.println(r);
    }

}
