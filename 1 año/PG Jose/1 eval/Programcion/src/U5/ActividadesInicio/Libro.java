package U5.ActividadesInicio;

public class Libro {
    String titulo;
    String autor;
    int numPaginas;
    int valoracion;

    void mostrarInfo(){
        System.out.println("El libro '"+this.titulo+"' de "+this.autor+" tiene "+this.numPaginas+" páginas...\"). Su valoracion: "+this.valoracion);
    }
}
