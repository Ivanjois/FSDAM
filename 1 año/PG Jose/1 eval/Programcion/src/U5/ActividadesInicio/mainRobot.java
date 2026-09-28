package U5.ActividadesInicio;

public class mainRobot {
    public static void main(String[] args) {
        Robot primero = new Robot("Terminator");
        Robot segundo = new Robot("Segundo");
        Robot tercero = new Robot("Tercero");
        primero.mostrarInfo();
        segundo.mostrarInfo();
        tercero.mostrarInfo();
        System.out.println(Robot.contadorRobots);
    }
}
