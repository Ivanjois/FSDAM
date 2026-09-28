package U5.ActividadesInicio;

public class mainTermostato {
    public static void main(String[] args) {
        Termostato gemini = new Termostato();
        gemini.bajarTemperatura(22);
        System.out.println(gemini.getTemperaturaActual());
        gemini.enceder();
        gemini.bajarTemperatura(22);
        System.out.println(gemini.getTemperaturaActual());
    }
}
