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
            System.out.println(v.getTitulo() + " [" + v.getGenero() + "] (" + v.getPlataforma() + ") - Precio final: " + v.calcularPrecioFinal() + "€");
        }

        System.out.println("\n=== PRUEBAS CON CONSOLAS Y EXCEPCIONES ===");
        IConsola miPlay = new Consola(Plataforma.PLAYSTATION);
        miPlay.switchOn();

        try {
            // Instalación y ejecución del primer juego
            miPlay.installGame(spiderman);
            miPlay.playGame();

            // Prueba de sobrecarga de playGame(String titulo)
            System.out.println("\n-- Prueba de sobrecarga playGame(titulo) --");
            miPlay.playGame("Spider-Man 2");
            miPlay.playGame("God of War"); // Juego no instalado
        } catch (JuegoNoCompatibleException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        System.out.println("\n-- Prueba de incompatibilidad (Excepción) --");
        try {
            System.out.println("Intentando instalar Zelda (Switch) en PlayStation...");
            miPlay.installGame(zelda);
        } catch (JuegoNoCompatibleException e) {
            System.out.println("¡Excepción capturada con éxito!: " + e.getMessage());
        }

        // Apagar consola y comprobar control de estado
        miPlay.switchOff();
        System.out.println("\n-- Prueba de intentar jugar con la consola apagada --");
        miPlay.playGame();

        // Prueba con otra consola y juego digital
        System.out.println("\n=== PRUEBA DE CONSOLA XBOX Y JUEGO DIGITAL ===");
        IConsola miXbox = new Consola(Plataforma.XBOX);
        miXbox.switchOn();
        try {
            miXbox.installGame(halo);
            miXbox.playGame();
        } catch (JuegoNoCompatibleException e) {
            System.out.println("Error: " + e.getMessage());
        }
        miXbox.switchOff();
    }
}
