package U6.ActividadesAvanzadas.model;

public class Item {
    private  String nombre;
    private int aumentoAtaque, aumentoDefensa;

    public Item(String nombre, int aumentoAtaque, int aumentoDefensa) {
        this.nombre = nombre;
        this.aumentoAtaque = aumentoAtaque;
        this.aumentoDefensa = aumentoDefensa;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getAumentoAtaque() {
        return this.aumentoAtaque;
    }

    public int getAumentoDefensa() {
        return this.aumentoDefensa;
    }
    public  void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public  void  setAumentoAtaque(int aumentoAtaque) {
        this.aumentoAtaque = aumentoAtaque;
    }
    public  void  setAumentoDefensa(int aumentoDefensa) {
        this.aumentoDefensa = aumentoDefensa;
    }


}
