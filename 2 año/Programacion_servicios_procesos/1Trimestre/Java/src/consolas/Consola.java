package consolas;

import enums.Plataforma;
import excepciones.JuegoNoCompatibleException;
import videojuegos.Videojuegos;

import java.util.ArrayList;
import java.util.List;

public class Consola implements IConsola {
    private Plataforma plataforma;
    private boolean encendida;
    private List<Videojuegos> juegosInstalados;

    public Consola(Plataforma plataforma) {
        this.plataforma = plataforma;
        this.encendida = false;
        this.juegosInstalados = new ArrayList<>();
    }

    @Override
    public void switchOn() {
        this.encendida = true;
        System.out.println(plataforma + " encendida.");
    }

    @Override
    public void switchOff() {
        this.encendida = false;
        System.out.println(plataforma + " apagada.");
    }

    @Override
    public void installGame(Videojuegos game) throws JuegoNoCompatibleException {
        if (!game.isCompatible(this)) {
            throw new JuegoNoCompatibleException("El juego '" + game.getTitulo() + "' (" + game.getPlataforma() + ") no es compatible con " + plataforma);
        }
        juegosInstalados.add(game);
        System.out.println("Juego '" + game.getTitulo() + "' instalado con éxito en " + plataforma + ".");
    }

    @Override
    public void playGame() {
        if (!encendida) {
            System.out.println("No se puede jugar: " + plataforma + " está apagada.");
            return;
        }
        if (juegosInstalados.isEmpty()) {
            System.out.println("No hay juegos instalados en " + plataforma + ".");
            return;
        }
        System.out.println("Jugando a: " + juegosInstalados.get(0).getTitulo());
    }

    @Override
    public void playGame(String titulo) {
        if (!encendida) {
            System.out.println("No se puede jugar: " + plataforma + " está apagada.");
            return;
        }
        for (Videojuegos game : juegosInstalados) {
            if (game.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Iniciando: " + game.getTitulo() + " en " + plataforma);
                return;
            }
        }
        System.out.println("El juego '" + titulo + "' no está instalado en " + plataforma + ".");
    }

    @Override
    public Plataforma getPlataforma() {
        return plataforma;
    }
}
