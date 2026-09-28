package U6.ActividadesInicio.Abstractos;

public class Circulo extends Figura2D{
  private double radio;


  @Override
    public double calcularArea(){
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro(){
        return 2 * Math.PI * radio;
  }
  @Override
    public String toString(){
      return "Circulo tiene de area "+calcularArea()+" y de perimetro "+calcularPerimetro();
    }
}
