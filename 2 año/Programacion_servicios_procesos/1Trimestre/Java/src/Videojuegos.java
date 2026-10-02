public abstract class Videojuegos {
    private final String titulo;
    private final double precioBase;
    private final Genero genero;
    private final Plataforma plataforma;

    public Videojuegos(String titulo, double precioBase, Genero genero, Plataforma plataforma) {
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.genero = genero;
        this.plataforma = plataforma;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public Genero getGenero() {
        return genero;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public boolean isCompatible(IConsola consola) {
        return this.plataforma == consola.getPlataforma();
    }

    public abstract double calcularPrecioFinal();
}
