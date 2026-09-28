package U8.Entregables.model;

import java.time.LocalDate;

public class Nota {

    private int idNota;
    private String texto;
    private LocalDate fechaCreacion;
    private int idUsuario;

    public Nota(int idNota, int idUsuario, String texto, LocalDate fechaCreacion) {
        this.idNota = idNota;
        this.idUsuario = idUsuario;
        this.texto = texto;
        this.fechaCreacion = fechaCreacion;
    }

    public Nota(int idUsuario, String texto, LocalDate fechaCreacion) {
        this.idUsuario = idUsuario;
        this.texto = texto;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdNota() { return idNota; }
    public void setIdNota(int idNota) { this.idNota = idNota; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    @Override
    public String toString() {
        return "Nota [" + idNota + "] - Fecha: " + fechaCreacion + "\n   \"" + texto + "\"\n";
    }
}