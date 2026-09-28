package model;

import java.time.LocalDate;

public class Temperatura {
    private int idReg = 0;
    private String poblacion;
    private double minTemp, maxTemp;
    private LocalDate fecha;

    public Temperatura(){}

    public Temperatura(String poblacion, double minTemp, double maxTemp, LocalDate fecha) {
        this.idReg = getIdReg();
        this.poblacion = poblacion;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.fecha = fecha;
        this.idReg++;
    }

    public int getIdReg() {
        return idReg;
    }

    public void setIdReg(int idReg) {
        this.idReg = idReg;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "[" + poblacion + "  (" + fecha + ")" + "  MAX: " + maxTemp + "º  MIN: " + minTemp + "º";
    }
}
