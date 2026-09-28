package U5.ActividadesInicio;

public class Cancion {
    private String titulo;
    private String autor;
    private int duracion;
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setDuracion(int duracion){
        if (duracion<0){
            duracion = 0;
            System.out.println("Error: Duración negativa");
        }
        this.duracion = duracion;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public int getDuracion(){
        return duracion;
    }
}

