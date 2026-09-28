import java.util.ArrayList;

public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private int numPaginas;


    public void setIsbn(int isbn){this.isbn = isbn;}
    public void setTitulo(String titulo){this.titulo = titulo;}
    public void setAutor(String autor){this.autor = autor;}
    public void setNumPaginas(int numPaginas){this.numPaginas = numPaginas;}

    public int getIsbn(){return this.isbn;}
    public String getTitulo(){return this.titulo;}
    public String getAutor(){return this.autor;}
    public int getNumPaginas(){return this.numPaginas;}

    public String toString(){return "- " + this.titulo + " (ISBN: " + this.isbn + ") - " + this.autor + ". " + this.numPaginas + " págs.";}
}
