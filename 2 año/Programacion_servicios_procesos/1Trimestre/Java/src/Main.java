import consolas.Consola;
import consolas.IConsola;
import enums.Genero;
import enums.Plataforma;
import excepciones.JuegoNoCompatibleException;
import videojuegos.VideojuegoDigital;
import videojuegos.VideojuegoFisico;
import videojuegos.Videojuegos;

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

        System.out.println("=== PRUEBAS CON CONSOLAS Y EXCEPCIONES ===");
        IConsola miPlay = new Consola(Plataforma.PLAYSTATION);
        miPlay.switchOn();

        try {
            miPlay.installGame(spiderman);
            miPlay.playGame();

            System.out.println("-- Prueba de sobrecarga playGame(titulo) --");
            miPlay.playGame("Spider-Man 2");
            miPlay.playGame("God of War");
        } catch (JuegoNoCompatibleException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        System.out.println("-- Prueba de incompatibilidad (Excepción) --");
        try {
            System.out.println("Intentando instalar Zelda (Switch) en PlayStation...");
            miPlay.installGame(zelda);
        } catch (JuegoNoCompatibleException e) {
            System.out.println("¡Excepción capturada con éxito!: " + e.getMessage());
        }

        miPlay.switchOff();
        System.out.println("-- Prueba de intentar jugar con la consola apagada --");
        miPlay.playGame();

        System.out.println("=== PRUEBA DE CONSOLA XBOX Y JUEGO DIGITAL ===");
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
