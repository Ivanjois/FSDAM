package U4.Actidades;

import java.util.*;


public class U4EjArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> colores = new ArrayList<String>();
        ArrayList<String> colores2 = new ArrayList<String>();
        ArrayList<String> ColoresUnidos = new ArrayList<String>();
        ArrayList<String> ColoresU2 = new ArrayList<String>();
        int[] numeros = new int[7];

        colores2.add("Red");
        colores2.add("Blue");
        colores2.add("Green");
        colores.add("Rojo");
        colores.add("Verde");
        colores.add("Azul");
        for (String articulo : colores) {
            System.out.println(articulo);
        }

        System.out.println("--Uno nuevo--");
        colores.add(0, "Amarillo");
        System.out.println(colores);
        System.out.println("--Mostrar uno en concreto--");
        System.out.println(colores.get(2));
        System.out.println("--Actualización de Elementos--");
        System.out.println("Cambiamos el del indice 2");
        colores.set(2, "Azul Claro");
        System.out.println(colores);
        System.out.println("--Elimanación--");
        System.out.println(colores);
        colores.remove(3);
        System.out.println("despues de eliminar");
        System.out.println(colores);
        System.out.println("busqueda de elemento");
        System.out.println(colores.contains("Rojo"));
        System.out.println("8. Búsqueda y Eliminación");
        Iterator<String> it = colores.iterator();
        while (it.hasNext()) {
            String palabra = it.next();
            if (palabra.equals("Rojo")) {
                it.remove();
                System.out.println("Este es el que se elimina: " + palabra);
                System.out.println(colores);
            }
        }
        System.out.println("9. Ordenación de Listas");
        Collections.sort(colores);
        System.out.println(colores);
        System.out.println("10. Copia de Listas");
        System.out.println("Antes:");
        System.out.println("Colores: " + colores + " y la de: " + colores2);
        System.out.println("Despues:");
        UnirDosListas(colores, colores2, ColoresUnidos);
        System.out.println("Colores: " + ColoresUnidos);
        System.out.println("11. Mezcla de Elementos (Shuffle)");
        System.out.println("Antes:");
        System.out.println("Colores: " + ColoresUnidos);
        System.out.println("Despues:");
        baraja(ColoresUnidos);
        System.out.println("Colores: " + ColoresUnidos);
        System.out.println("12. Inversión de la Lista");
        System.out.println("Antes:");
        System.out.println("Colores: " + ColoresUnidos);
        System.out.println("Despues:");
        Collections.reverse(ColoresUnidos);
        System.out.println("Colores: " + ColoresUnidos);
        System.out.println("13. Extracción de Sublistas");
        System.out.println("Antes:");
        System.out.println("Colores: " + colores2);
        System.out.println("Despues:");
        List<String> sub = colores2.subList(1, 3);
        System.out.println(sub);
        System.out.println("14. Comparación de Listas");
        if (CompararListas(colores, colores2)) {
            System.out.println("Si que son iguales");
        } else {
            System.out.println("Si no son iguales");
        }
        System.out.println("15. Intercambio de Elementos (Swap)");
        System.out.println("Antes:");
        System.out.println("Colores: " + ColoresUnidos);
        System.out.println("Despues:");
        Collections.swap(ColoresUnidos, 0, 2);
        System.out.println("Colores: " + ColoresUnidos);
        System.out.println("16. Unión de Listas");
        System.out.println("Antes:");
        System.out.println("Colores: " + ColoresUnidos);
        System.out.println("Despues:");
        colores.addAll(ColoresU2);
        System.out.println("Colores: " + ColoresU2);
        System.out.println("17. Clonación de Listas");
        System.out.println("Antes:");
        System.out.println("Colores: " + colores);
        System.out.println("Despues:");
        Object copia = colores.clone();
        System.out.println("Copia: " + copia);
        System.out.println("18. Vaciado de la Lista");
        System.out.println("Antes:");
        System.out.println("Colores: " + colores);
        System.out.println("Despues:");
        eliminarTodo(colores);
        System.out.println("19. Comprobación de Lista Vacía");
        System.out.println("Antes:");
        System.out.println("Colores: " + colores);
        System.out.println("Despues:");
        Vacio(colores);

    }

    public static void UnirDosListas(ArrayList<String> colores,
                                     ArrayList<String> colores2,
                                     ArrayList<String> ColoresUnidos) {
        for (String articulo : colores) {
            ColoresUnidos.add(articulo);
        }
        for (String articulo : colores2) {
            ColoresUnidos.add(articulo);
        }
    }

    public static void baraja(ArrayList<String> ColoresUnidos) {
        Collections.shuffle(ColoresUnidos);
    }

    public static boolean CompararListas(ArrayList<String> colores, ArrayList<String> colores2) {
        int i = 0;
        if (colores.size() == colores2.size()) {
            for (int j = 0; j < colores.size(); j++) {
                if (colores.get(j) != colores2.get(j)) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void eliminarTodo(ArrayList<String> Lista) {
        Iterator<String> it = Lista.iterator();

        while (it.hasNext()) {

            // 2. Lo imprimimos (si quieres ver qué borras)
            System.out.println("Eliminando: " + it.next());

            // 3. Ahora sí podemos eliminar el elemento que acabamos de pasar
            it.remove();
        }
        System.out.println("Lista eliminada " + Lista);
    }

    public static void Vacio(ArrayList<String> Lista) {
        if (Lista.isEmpty()) {
            System.out.println("Esta vacia");
            return;
        }
        System.out.println("No esta vacio");
    }
}

