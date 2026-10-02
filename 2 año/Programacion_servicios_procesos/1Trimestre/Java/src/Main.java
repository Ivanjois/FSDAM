import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CATÁLOGO Y CÁLCULO DE PRECIOS ===");
        Videojuegos zelda = new VideojuegoFisico("The Legend of Zelda", 60.0, Genero.RPG, Plataforma.SWITCH, 4.99);
        Videojuegos halo = new VideojuegoDigital("Halo Infinite", 70.0, Genero.ACCION, Plataforma.XBOX, 20.0);
        Videojuegos spiderman = new VideojuegoFisico("Spider-Man 2", 70.0, Genero.ACCION, Plataforma.PLAYSTATION, 3.50);

        List<Videojuegos> tienda = new ArrayList<>();
        tienda.add(zelda);
        tienda.add(halo);
        tienda.add(spiderman);

        for (Videojuegos v : tienda) {
            System.out.println(v.getTitulo() + " (" + v.getPlataforma() + ") - Precio final: " + v.calcularPrecioFinal() + "€");
        }

        System.out.println("\n=== PRUEBAS CON CONSOLAS Y EXCEPCIONES ===");
        IConsola miPlay = new Consola(Plataforma.PLAYSTATION);
        miPlay.switchOn();

        try {
            miPlay.installGame(spiderman);
            miPlay.playGame();
        } catch (JuegoNoCompatibleException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        System.out.println();

        try {
            System.out.println("Intentando instalar Zelda (Switch) en PlayStation...");
            miPlay.installGame(zelda);
        } catch (JuegoNoCompatibleException e) {
            System.out.println("¡Excepción capturada con éxito!: " + e.getMessage());
        }

        miPlay.switchOff();
    }
}
