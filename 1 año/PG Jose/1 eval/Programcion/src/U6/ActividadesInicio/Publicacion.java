package U6.ActividadesInicio;

public class Publicacion {
    protected String usuario, fecha;
    protected int likes;

    public Publicacion(String usuario, String fecha) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.likes = 0;
    }
    public void darLike() {
        this.likes++;
    }
    public int getLikes() {
        return this.likes;
    }

}
