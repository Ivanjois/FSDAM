package U5.ActividadesInicio;

// int numBicis = Bicicleta.getConta...

public class Bicicleta {
    private String marca;
    private String modelo;
    private static int contadorDeBicicletas;

    public Bicicleta(String marca, String modelo) {
        this.setMarca(marca);
        this.setModelo(modelo);
        Bicicleta.contadorDeBicicletas++;
    }

    public String toString() {
        return "Marca: " + this.getMarca() + "\nModelo: " + this.getModelo()+")";
    }

    public static int getContadorDeBicicletas() {
        return Bicicleta.contadorDeBicicletas;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
