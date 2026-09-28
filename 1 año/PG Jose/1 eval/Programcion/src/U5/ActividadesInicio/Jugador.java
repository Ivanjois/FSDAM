package U5.ActividadesInicio;

public class Jugador {
    private String name;
    private int number;
    private String position;
    public Jugador(String name, int number, String position) {
        this.setName(name);
        this.setNumber(number);
        this.setPosition(position);
    }
    public Jugador(String name, String position) {
        this.setName(name);
        this.setNumber(-1);
        this.setPosition(position);
    }
    public void datos() {
        System.out.println("Dorsal: " + this.getNumber());
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumber() {
        return this.number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getPosition() {
        return this.position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}
