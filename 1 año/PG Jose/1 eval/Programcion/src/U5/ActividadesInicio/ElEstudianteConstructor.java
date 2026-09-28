package U5.ActividadesInicio;

public class ElEstudianteConstructor {
    public static void main(String[] args) {
        Alumno A1= new Alumno("Juan", 22, 1);
        Alumno A2= new Alumno(A1);
        System.out.println("Nombre1: "+A1.getNombre());
        System.out.println("Nombre2: "+A2.getNombre());
    }
}
