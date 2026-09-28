package U4.Actividades_Entregables;

import java.util.*;

public class LaLogisticaDeSantaClaus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> poblaciones = new HashMap<>();
        HashSet<String> poblacionesVisitadas = new HashSet<>();
        boolean bandera = true;
        String poblacion = "";
        int numero = 0;
        char opcion;

        //Un bucle que se ejecuta al menos una vez y que seguirá ejecutándose hasta que el boolean bandera sea false.
        do {
            bienvenida();
            opcion = sc.next().toLowerCase().charAt(0);
            //esto gestiona la entrada de la opcion que ha elegido.
            switch (opcion) {
                case 'a':
                    nuevaPoblacion(poblaciones, sc);
                    break;
                case 'b':
                    visitarPoblacion(poblacionesVisitadas, poblaciones, sc);
                    break;
                case 'c':
                    calcularRuta(poblaciones, poblacionesVisitadas);
                    break;
                case 'd':
                    resumenReparto(poblacionesVisitadas, poblaciones);
                    break;
                case 'e':
                    System.out.println("Adios");
                    bandera = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (bandera);
    }


    /**
     * Procedimiento que da la bienvenida en el algoritmo cada vez que tiene que elegir una opcion del menu hasta que decida salir.
     */
    public static void bienvenida() {
        System.out.println("--- Bienvenido ---");
        System.out.println("--- A la logística de Santa Claus ---");
        System.out.println("--- SANTA MAPS ---");
        System.out.println();
        System.out.println("Que opción eliges?");
        System.out.println("A) Añadir población");
        System.out.println("B) Visitar población");
        System.out.println("C) Calcular ruta");
        System.out.println("D) Resumen reparto");
        System.out.println("E) Salir");
        System.out.print("- Escoge una opción [A-E]: ");
    }

    /**
     * Procedimiento que al elegir la opcion a se llamara a este procedimiento que es para crear una población.
     *
     * @param poblacionMap las poblaciones creadas se guardarán aquí tendran un nombre y unos ms de tiempo que se tarda en llegar a ellas.
     * @param sc           esto es el escaner para poner preguntar que poblacion, y los ms que tendra y que los pueda guardar dentro del HashMap.
     */
    private static void nuevaPoblacion(HashMap<String, Integer> poblacionMap, Scanner sc) {
        String nombrePoblacion = "";
        int tiempoMs = 0;
        boolean nombreValido = false;
        boolean tiempoValido = false;

        System.out.println("--- AÑADIR POBLACIÓN ---");

        while (!nombreValido) {
            System.out.println("- Indica el nombre de la población (Solo letras): ");
            if (sc.hasNext("[a-zA-ZñÑáéíóúÁÉÍÓÚ]+")) {
                nombrePoblacion = sc.next();
                nombreValido = true;
            } else {
                System.out.println("Error: El nombre no puede contener números ni símbolos.");
                sc.next();
            }
        }
        while (!tiempoValido) {
            System.out.println("- Indica el tiempo de reparto (ms): ");
            if (sc.hasNextInt()) {
                tiempoMs = sc.nextInt();
                tiempoValido = true;
            } else {
                System.out.println("Error: Debes introducir un número entero válido.");
                sc.next();
            }
        }

        if (poblacionMap.containsKey(nombrePoblacion.toLowerCase())) {
            System.out.println("Error: Esta población ya existe.");
        } else {
            poblacionMap.put(nombrePoblacion.toLowerCase(), tiempoMs);
            System.out.println("[MENSAJE] Población añadida con éxito");
            sc.nextLine();
        }
    }

    /**
     * Procedimiento para saber qué poblaciones ya han sido visitadas.
     *
     * @param visitadas   en la collection visitadas se guardarán aquellas poblaciones que ya hemos visitado. Además, con este comprobamos si la poblacion ya ha sido visitada.
     * @param poblaciones con este Mapa podemos mirar si la poblacion existe o no.
     * @param sc          con el scanner podemos preguntarle al usuario las cosas y usar lo que nos ponga para poder visitar esa poblacion o no.
     */
    private static void visitarPoblacion(HashSet<String> visitadas, HashMap<String, Integer> poblaciones, Scanner sc) {
        System.out.println("--- VISITAR POBLACIÓN ---");
        System.out.println("¿Qué población deseas visitar?");
        String poblacion = sc.next().toLowerCase();

        if (!poblaciones.containsKey(poblacion)) {
            System.out.println("Error: Esta población NO existe: " + poblacion);
            System.out.println();
        } else if (visitadas.contains(poblacion)) {
            System.out.println("Aviso: Ya habías visitado " + poblacion + " anteriormente.");
            System.out.println();
        } else {
            visitadas.add(poblacion);
            System.out.println("[MENSAJE] Población visitada con éxito");
            System.out.println();
        }
    }

    /**
     * Procedimiento para saber qué poblaciones faltan por visitar y cuanto se tarda en conseguirlo.
     *
     * @param poblaciones          con este Mapa tenía las poblaciones que existen.
     * @param poblacionesVisitadas con esta collection sé qué poblaciones ya se han visitado.
     */
    private static void calcularRuta(HashMap<String, Integer> poblaciones, HashSet<String> poblacionesVisitadas) {
        ArrayList<Map.Entry<String, Integer>> listaParaOrdenar = new ArrayList<>();
        int tiempoTotal = 0;

        for (Map.Entry<String, Integer> entrada : poblaciones.entrySet()) {
            if (!poblacionesVisitadas.contains(entrada.getKey())) {
                listaParaOrdenar.add(entrada);
                tiempoTotal += entrada.getValue();
            }
        }

        listaParaOrdenar.sort(Map.Entry.<String, Integer>comparingByValue()
                .thenComparing(Map.Entry.comparingByKey())
        );

        System.out.println("--- RUTA DE SANTA ---");
        if (listaParaOrdenar.isEmpty()) {
            System.out.println("¡Ruta completada o sin destinos pendientes!");
            System.out.println(" ");
            return;
        }

        for (int i = 0; i < listaParaOrdenar.size(); i++) {
            System.out.print("[" + listaParaOrdenar.get(i).getKey() + "]");

            if (i < listaParaOrdenar.size() - 1) {
                System.out.print("->");
            }
        }

        System.out.println("\n- Tiempo estimado: " + tiempoTotal + " ms");
        System.out.println(" ");
    }

    /**
     * Este procedimiento es para ver las poblaciones que ya hemos visitado y cuanto hemos tardado en visitarlas.
     *
     * @param poblacionesVisitadas con esta Collection sabemos que poblaciones hemos visitado y si esta vacia no hemos visitado ninguna y hay un mensaje para eso.
     * @param poblaciones          con este Mapa podemos saber qué ms tiene cada poblacion visitada e ir sumando los ms.
     */
    private static void resumenReparto(HashSet<String> poblacionesVisitadas, HashMap<String, Integer> poblaciones) {
        int recorrido = 0;
        System.out.println("--- RESUMEN REPARTO ---");

        if (poblacionesVisitadas.isEmpty()) {
            System.out.println("Aún no has visitado ninguna población.");
            System.out.println(" ");
            return;
        }

        int tiempoGastado = 0;
        System.out.println("- Poblaciones visitadas:");

        for (String ciudad : poblacionesVisitadas) {
            if (poblaciones.containsKey(ciudad)) {
                recorrido += 1;
                System.out.print("(" + ciudad + ") ");
                tiempoGastado += poblaciones.get(ciudad);
                if (recorrido < poblacionesVisitadas.size() - 1) {
                    System.out.print("->");
                }
            }
        }
        System.out.println("\n- Tiempo total empleado: " + tiempoGastado + " ms");
        System.out.println(" ");
    }
}