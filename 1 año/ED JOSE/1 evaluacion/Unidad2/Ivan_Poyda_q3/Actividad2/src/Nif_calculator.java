public class Nif_calculator {
    private int dni;
    private String nombre;

    public Nif_calculator(int dni_solicitado, String nombre_solicitado) {
        dni = dni_solicitado;
        nombre = nombre_solicitado;
    }

    public char calcularLetra() {
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = dni % 23;
        return caracteres.charAt(resto);
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }
}