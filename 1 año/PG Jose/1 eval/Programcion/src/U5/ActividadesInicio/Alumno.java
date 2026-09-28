package U5.ActividadesInicio;

public class Alumno {
    private String nombre;
    private int edad;
    private int curso;

    public Alumno(String nombre, int edad, int curso) {
        this.setNombre(nombre);//this.nombre = "Ivan";
        this.setEdad(edad);
        this.setCurso(curso);
    }

    public Alumno(Alumno a2) {
//        this.setNombre(a2.getNombre());
//        this.setEdad(a2.getEdad());
//        this.setCurso(a2.getCurso());
        /*Mas eficiente*/this(a2.getNombre(), a2.getEdad(), a2.getCurso());
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getCurso() {
        return curso;
    }
}
