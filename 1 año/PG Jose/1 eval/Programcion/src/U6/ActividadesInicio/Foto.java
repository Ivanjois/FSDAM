package U6.ActividadesInicio;

public class Foto extends Publicacion{
    private String urlImagen, filtro;

    public Foto(String urlImagen, String filtro, String usuario, String fecha) {
        super(usuario, fecha);
        this.urlImagen = urlImagen;
        this.filtro = filtro;
    }
    @Override
    public void darLike() {
        super.darLike();
        System.out.println("Has dado like a una foto de " + this.usuario);
    }
}
