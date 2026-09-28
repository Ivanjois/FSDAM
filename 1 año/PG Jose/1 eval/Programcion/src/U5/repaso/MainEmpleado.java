package U5.repaso;

import java.util.*;

public class MainEmpleado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Empleado> empleados = new HashMap<>();
        int opcion;
        do{
            System.out.println("--- GESTIÓN DE EMPLEADOS ---");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Buscar por puesto");
            System.out.println("3. Aumentar Salario");
            System.out.println("4. Estadísticas");
            System.out.println("5. Ordenar");
            System.out.println("6. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    registrarEmpleado(sc, empleados);
                    break;
                case 2:
                    buscarPuesto(sc, empleados);
                    break;
                case 3:
                    aumentarSalario(sc, empleados);
                    break;
                case 4:
                    estadisticas(empleados);
                    break;
                case 5:
                    ordenarSalarios(empleados);
                    break;
                case 6:
                    System.out.println("Cerrando programa...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }while(opcion != 6);
    }
    public static void buscarPuesto(Scanner sc, HashMap<Integer, Empleado> empleados){
        System.out.println("Ingresa el puesto a buscar:");
        String puesto = sc.nextLine();
        boolean encontrado = false;
        for(Map.Entry<Integer, Empleado> entry: empleados.entrySet()){
            Empleado e = entry.getValue();
            if(e.getPuesto().equals(puesto)){
                System.out.println(e.toString());
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("Ningún empleado encontrado con ese puesto");
        }
    }
    public static void aumentarSalario(Scanner sc, HashMap<Integer, Empleado> empleados){
        System.out.println("Ingresa el ID a buscar");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresa el porcentaje a aumentar");
        int aumento = sc.nextInt();
        sc.nextLine();
        boolean encontrado = false;
        for(Map.Entry<Integer, Empleado> entry: empleados.entrySet()){
            Empleado e = entry.getValue();
            if(e.getId() == id){
                int salario = e.getSalario();
                aumento = (salario/100)*aumento;
                e.setSalario(salario + aumento);
                System.out.println("Salario aumentado a " + e.getSalario() + "€");
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("ID no encontrado");
        }
    }
    public static void estadisticas(HashMap<Integer, Empleado> empleados){
        int salarioMayor = 0;
        int idMayor = 0;
        for(Map.Entry<Integer, Empleado> entry: empleados.entrySet()){
            Empleado e = entry.getValue();
            if(e.getSalario()>salarioMayor){
                salarioMayor = e.getSalario();
                idMayor = e.getId();
            }
        }
        Empleado emp = empleados.get(idMayor);
        System.out.println(emp.toString());
    }
    public static void ordenarSalarios(HashMap<Integer, Empleado> empleados){
        List<Empleado> lista = new ArrayList<>(empleados.values());
        lista.sort(Comparator.comparingInt(Empleado::getSalario));
        for (Empleado e : lista) {
            System.out.println(e);
        }

    }
    public static void registrarEmpleado(Scanner sc, HashMap<Integer, Empleado> empleados){
        System.out.println("Introduce el nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce el puesto del empleado: ");
        String puesto = sc.nextLine();
        System.out.println("Introduce el salario del empleado: ");
        int salario = sc.nextInt();
        sc.nextLine();
        Empleado empleado = new Empleado(nombre, puesto, salario);
        empleados.put(empleado.getId(), empleado);
    }
}