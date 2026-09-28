import java.util.Scanner;

public class RN3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        boolean salir_seguro = false;
        do {
            int numeroUsuario = 0, numerointentos = 0, intentosrestantes, opcion, intentos, intentosreales;
            int numeroSecreto = (int) (Math.random() * 100) + 1;

            System.out.println("Veremos si aciertas el número");
            System.out.println("Ingrese un número entre 1 y 3 para decidir el juego");
            System.out.println("Opción 1: Decides cuántos intentos tienes");
            System.out.println("Opción 2: Intentos infinitos");
            System.out.println("Opción 3: Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el número de intentos:");
                    intentos = sc.nextInt();
                    sc.nextLine();
                    boolean jugando1 = true;
                    while (salir && jugando1 && numerointentos < intentos) {
                        numerointentos++;
                        intentosreales = intentos - numerointentos;
                        intentosreales = (intentos - numerointentos)+1;
                        System.out.println("Intento " + numerointentos + " — te quedan " + intentosreales);
                        System.out.print("Introduce tu número: ");
                        numeroUsuario = sc.nextInt();
                        sc.nextLine();
                        if (numeroUsuario == numeroSecreto) {
                            System.out.println("¡Has ganado! El número era " + numeroSecreto);
                            jugando1 = false;
                            salir = false;
                            salir_seguro = true;
                        } else if (numeroSecreto > numeroUsuario && numerointentos < intentos) {
                            System.out.println("El número secreto es mayor.");
                        } else if (numeroSecreto < numeroUsuario && numerointentos < intentos) {
                            System.out.println("El número secreto es menor.");
                        } else {
                            System.out.println("Has perdido. El número secreto era " + numeroSecreto);
                            salir_seguro = true;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Tienes intentos infinitos");
                    boolean jugando2 = true;
                    while (salir && jugando2) {
                        System.out.print("Introduce tu número: ");
                        numeroUsuario = sc.nextInt();
                        sc.nextLine();

                        if (numeroUsuario == numeroSecreto) {
                            System.out.println("¡Correcto! El número era " + numeroSecreto);
                            jugando2 = false;
                            salir = false;
                            salir_seguro = true;
                        } else if (numeroSecreto > numeroUsuario) {
                            System.out.println("El número secreto es mayor.");
                        } else {
                            System.out.println("El número secreto es menor.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Es una pena que no quieras jugar.");
                    salir = false;
                    salir_seguro = true;
                    break;

                default:
                    System.out.println("Opción no permitida.");
            }
            if (salir_seguro) {
                System.out.print("¿Quieres volver a jugar? (S/N): ");
                if (!sc.nextLine().equalsIgnoreCase("S")) {
                }
                else {
                    salir_seguro = false;
                }
            }

        }
        while (!salir_seguro);
        System.out.println("Hasta pronto.");
        sc.close();
    }
}