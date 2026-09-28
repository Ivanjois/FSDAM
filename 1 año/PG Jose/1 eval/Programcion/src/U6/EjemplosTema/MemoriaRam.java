package U6.EjemplosTema;

public class MemoriaRam {
    private String tecnologia;
    private int capacidad;

    public MemoriaRam(String tecnologia, int capacidad) {
        this.tecnologia = tecnologia;
        this.capacidad = capacidad;
    }
    public String getTecnologia() {
        return tecnologia;
    }
    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "MemoriaRam{" +
                "tecnología='" + tecnologia + '\'' +
                ", capacidad=" + capacidad +
                "GB}";
    }

}
