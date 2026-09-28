package U5.ActividadesInicio;

public class Electrodomestico {
    protected double precio, peso;
    protected String color;

  public Electrodomestico() {
      this.precio = 100;
      this.peso = 5;
      this.color = "Blanco";
  }
  public Electrodomestico(double precio, double peso, String color){
      this.precio = precio;
      this.peso = peso;
      this.color = color;
  }
  public void consumirEnergia(){
      System.out.println("El electrodoméstico consume energía...");
  }
}
