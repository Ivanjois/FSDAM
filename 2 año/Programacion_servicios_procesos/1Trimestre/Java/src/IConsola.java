public interface IConsola {
    void switchOn();
    void switchOff();
    void installGame(Videojuegos game) throws JuegoNoCompatibleException;
    void playGame();
    void playGame(String titulo);
    Plataforma getPlataforma();
}
