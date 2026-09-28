import java.util.Scanner;

public class A4U2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        // 1. Mostrar el menú de opciones
        System.out.println("--- MENÚ DEL GUERRERO ---");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Usar Poción");
        System.out.println("4. Salir del juego");
        System.out.print("Elige una acción (1-4): ");
        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("El guerrero lanza un ataque devastador: ¡Espadazo!");
                // La instrucción 'break' es crucial para salir del switch [5]
                break;

            case 2:
                System.out.println("El guerrero levanta su escudo, preparándose para el impacto.");
                break;

            case 3:
                System.out.println("El guerrero usa una poción y recupera salud.");
                break;

            case 4:
                System.out.println("Abandonando la aventura. ¡Hasta pronto!");
                break;

            default:
                // El bloque 'default' se ejecuta si la opción no coincide con ningún 'case' [5]
                System.out.println("Opción no válida. Por favor, elige entre 1 y 4.");
                break;
        }

        sc.close();
    }
}
