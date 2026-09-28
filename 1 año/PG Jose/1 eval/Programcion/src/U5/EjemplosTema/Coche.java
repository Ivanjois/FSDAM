package U5.EjemplosTema;

public class Coche {
       private String marca;
       private String modelo;
       private int velocidad;

    public String getMarca(){
        return this.marca;
    }
    public String getModelo(){
        return this.modelo;
    }
    public int getVelocidad(){
        return this.velocidad;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }
    public void infoCoche(){
        System.out.println("Marca: "+this.marca);
        System.out.println("Modelo: "+this.modelo);
    }
    public void acelerar(int cantidad){
        this.velocidad+=cantidad;
        System.out.println("El coche esta circulando a: "+velocidad);
    }
    public void frenar(int cantidad){
        if(cantidad<=0){
            velocidad=0;
            System.out.println("El coche esta quieto");
        }
        else {
            velocidad-=cantidad;
            System.out.println("El coche esta circulando a: "+velocidad);
        }
        this.velocidad-=cantidad;
    }
}
