package U5.repaso;

public class Paciente {
    private String sip;
    private String nombre;
    private int edad;
    private int gravedad; // 1 (Leve) a 5 (Vital)

    public Paciente(String sip, String nombre, int edad) {
        this.sip = sip;
        this.nombre = nombre;
        this.edad = edad;
        this.gravedad = 1; // Por defecto entran leves hasta que pasen Triaje
    }

    // --- Getters y Setters ---

    public String getSip() { return sip; }

    public String getNombre() { return nombre; }

    public int getGravedad() { return gravedad; }

    public void setGravedad(int gravedad) {
        // Validación importante para el examen
        if (gravedad < 1 || gravedad > 5) {
            System.out.println("Error: La gravedad debe estar entre 1 y 5.");
        } else {
            this.gravedad = gravedad;
        }
    }

    @Override
    public String toString() {
        return "Paciente [SIP=" + sip + ", Nombre=" + nombre +
                ", Edad=" + edad + ", GRAVEDAD=" + gravedad + "]";
    }
}