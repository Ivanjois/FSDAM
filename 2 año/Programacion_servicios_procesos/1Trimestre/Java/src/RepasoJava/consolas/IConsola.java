package RepasoJava.consolas;

import RepasoJava.enums.Plataforma;
import RepasoJava.excepciones.JuegoNoCompatibleException;
import RepasoJava.videojuegos.Videojuegos;

public interface IConsola {
    void switchOn();
    void switchOff();
    void installGame(Videojuegos game) throws JuegoNoCompatibleException;
    void playGame();
    void playGame(String titulo);
    Plataforma getPlataforma();
}
