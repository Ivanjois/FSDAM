package U5.ActividadesInicio;

public class Robot {
    private int id;
    private String modelo;
    public static int contadorRobots=1;
    public Robot(String modelo) {
        this.modelo = modelo;
        this.id = contadorRobots;
        contadorRobots++;
    }
    public void mostrarInfo(){
        System.out.println("Modelo: " + modelo+", Id: " + id);
    }
}
