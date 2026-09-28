package U6.ActividadesInicio;

import java.util.ArrayList;
import java.util.Iterator;

public class Casa {
    ArrayList<Habitacion> habitaciones;

    public Casa() {
        this.habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion h) {
        habitaciones.add(h);
    }

    public void borrarHabitacion(String habitacion) {
        Iterator<Habitacion> it = habitaciones.iterator();
        while (it.hasNext()) {
            Habitacion h = it.next();
            if (h.getHabitacion().equals(habitacion)) {
                it.remove(); // Usar el iterador para borrar evita ConcurrentModificationException
            }
        }
    }
    public int getMetrosTales() {
        int totales=0;
        for(Habitacion h:habitaciones){
            totales+=h.getMetrosCuadrados();
        }
        return totales;
    }

}