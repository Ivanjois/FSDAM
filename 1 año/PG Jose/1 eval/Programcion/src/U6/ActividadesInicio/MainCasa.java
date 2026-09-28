package U6.ActividadesInicio;

public class MainCasa {
    public static void main(String[] args) {
        Casa c = new Casa();
        Habitacion cocina= new Habitacion("Cocina", 12);
        Habitacion dormitorio= new Habitacion("dormitorio", 45);
        Habitacion salon= new Habitacion("salon", 23);
        c.agregarHabitacion(cocina);
        c.agregarHabitacion(dormitorio);
        c.agregarHabitacion(salon);
        System.out.println(c.getMetrosTales());
        c.borrarHabitacion("dormitorio");
        System.out.println(c.getMetrosTales());
    }
}
