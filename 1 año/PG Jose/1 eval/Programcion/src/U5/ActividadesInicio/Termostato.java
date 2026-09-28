package U5.ActividadesInicio;

public class Termostato {
    private double temperaturaActual;
    private boolean estaEncendido;

    public Termostato() {
        this.setTemperaturaActual(20.0);
        this.setEstaEncendido(false);
    }

    public void setTemperaturaActual(double temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
    }

    public double getTemperaturaActual() {
        return this.temperaturaActual;
    }

    public void setEstaEncendido(boolean estaEncendido) {
        this.estaEncendido = estaEncendido;
    }

    public boolean getEstaEncendido() {
        return this.estaEncendido;
    }

    public void enceder() {
        this.estaEncendido = true;
    }

    public void apagar() {
        this.estaEncendido = true;
    }

    public void subirTemperatura(double temperatura) {
        if  (this.estaEncendido) {
            this.temperaturaActual += temperatura;
        }
    }

    public void bajarTemperatura(double temperatura) {
        if (this.estaEncendido) {
            this.temperaturaActual -= temperatura;
        }
    }
}
