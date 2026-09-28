package U6.ActividadesInicio;

public class MainPublicacion {
    public static void main(String[] args) {
        Tweet dos = new Tweet("Hola", "Ivan", "22/02/2023");
        Foto tres = new Foto("www.aSSas.es", "gris", "Ivan", "22/02/2023");
        dos.darLike();
        tres.darLike();
        System.out.println(dos.getLikes());
        System.out.println(tres.getLikes());
    }
}
