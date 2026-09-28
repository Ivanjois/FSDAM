package U6.ActividadesInicio;

public class Tweet extends Publicacion {
    private String texto;
    public Tweet(String texto, String usuario, String fecha) {
        super(usuario, fecha);
        this.texto = texto;
    }
    @Override
    public void darLike() {
        super.darLike();
        System.out.println("Has dado like a un tweet de " + this.usuario);
    }
}
