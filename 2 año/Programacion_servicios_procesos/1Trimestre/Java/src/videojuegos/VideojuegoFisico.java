package videojuegos;

import enums.Genero;
import enums.Plataforma;

public class VideojuegoFisico extends Videojuegos {
    private final double costoEnvio;

    public VideojuegoFisico(String titulo, double precioBase, Genero genero, Plataforma plataforma, double costoEnvio) {
        super(titulo, precioBase, genero, plataforma);
        this.costoEnvio = costoEnvio;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() + costoEnvio;
    }
}
