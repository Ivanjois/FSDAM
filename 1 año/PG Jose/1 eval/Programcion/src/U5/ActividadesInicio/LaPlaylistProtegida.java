package U5.ActividadesInicio;

public class LaPlaylistProtegida {
    public static void main(String[] args) {
        Cancion cancion1 = new Cancion();
        Cancion cancion2 = new Cancion();

        cancion1.setTitulo("La Cancion 1");
        cancion2.setTitulo("La Cancion 2");
        cancion1.setAutor("Ivan");
        cancion2.setAutor("Yono");
        cancion1.setDuracion(-1);
        cancion2.setDuracion(3);
        System.out.println(cancion1.getTitulo()+" + "+cancion1.getAutor()+" + "+cancion1.getDuracion());
        System.out.println(cancion2.getTitulo()+" + "+cancion2.getAutor()+" + "+cancion2.getDuracion());
    }
}
