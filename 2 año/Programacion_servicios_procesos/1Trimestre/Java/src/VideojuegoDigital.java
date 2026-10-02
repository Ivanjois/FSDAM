public class VideojuegoDigital extends Videojuegos {
    private double porcentajeDescuento;

    public VideojuegoDigital(String titulo, double precioBase, Genero genero, Plataforma plataforma, double porcentajeDescuento) {
        super(titulo, precioBase, genero, plataforma);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() - (getPrecioBase() * (porcentajeDescuento / 100.0));
    }
}
