import java.util.Scanner;

public class Ej37B3U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean salir = false;

        // Bucle principal: se repite mientras 'salir' sea false
        do {
            // 1. Mostrar el menú
            System.out.println("\n---- CALCULADORA DE FIGURAS ----");
            System.out.println("1. Círculo");
            System.out.println("2. Rectángulo");
            System.out.println("3. Cuadrado");
            System.out.println("4. Rombo");
            System.out.println("5. Triángulo");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            // 2. Validar que la entrada sea un número
            while (!sc.hasNextInt()) {
                System.out.println("Error: Introduce un número (1-6).");
                sc.next(); // Limpia la entrada incorrecta
                System.out.print("Elige una opción: ");
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer (el "Enter")

            // 3. Ejecutar la opción elegida
            switch (opcion) {
                case 1:
                    // --- CÍRCULO ---
                    System.out.print("Introduce el radio del círculo: ");
                    double radio = sc.nextDouble();
                    sc.nextLine(); // Limpiar buffer

                    double areaCirculo = Math.PI * Math.pow(radio, 2);
                    double perimetroCirculo = 2 * Math.PI * radio;

                    System.out.println("Área del círculo: " + areaCirculo);
                    System.out.println("Perímetro (Circunferencia): " + perimetroCirculo);
                    break;

                case 2:
                    // --- RECTÁNGULO ---
                    System.out.print("Introduce la base del rectángulo: ");
                    double baseRect = sc.nextDouble();
                    System.out.print("Introduce la altura del rectángulo: ");
                    double alturaRect = sc.nextDouble();
                    sc.nextLine(); // Limpiar buffer

                    double areaRect = baseRect * alturaRect;
                    double perimetroRect = 2 * (baseRect + alturaRect);

                    System.out.println("Área del rectángulo: " + areaRect);
                    System.out.println("Perímetro del rectángulo: " + perimetroRect);
                    break;

                case 3:
                    // --- CUADRADO ---
                    System.out.print("Introduce el lado del cuadrado: ");
                    double ladoCuadrado = sc.nextDouble();
                    sc.nextLine(); // Limpiar buffer

                    double areaCuadrado = ladoCuadrado * ladoCuadrado;
                    double perimetroCuadrado = 4 * ladoCuadrado;

                    System.out.println("Área del cuadrado: " + areaCuadrado);
                    System.out.println("Perímetro del cuadrado: " + perimetroCuadrado);
                    break;

                case 4:
                    // --- ROMBO ---
                    System.out.print("Introduce la diagonal mayor (D): ");
                    double dMayor = sc.nextDouble();
                    System.out.print("Introduce la diagonal menor (d): ");
                    double dMenor = sc.nextDouble();
                    System.out.print("Introduce un lado (para el perímetro): ");
                    double ladoRombo = sc.nextDouble();
                    sc.nextLine(); // Limpiar buffer

                    double areaRombo = (dMayor * dMenor) / 2;
                    double perimetroRombo = 4 * ladoRombo;

                    System.out.println("Área del rombo: " + areaRombo);
                    System.out.println("Perímetro del rombo: " + perimetroRombo);
                    break;

                case 5:
                    // --- TRIÁNGULO ---
                    System.out.println("--- Cálculo del Área (con base y altura) ---");
                    System.out.print("Introduce la base del triángulo: ");
                    double baseTri = sc.nextDouble();
                    System.out.print("Introduce la altura del triángulo: ");
                    double alturaTri = sc.nextDouble();
                    double areaTri = (baseTri * alturaTri) / 2;
                    System.out.println("Área del triángulo: " + areaTri);

                    System.out.println("\n--- Cálculo del Perímetro (con los 3 lados) ---");
                    System.out.print("Introduce el lado 1: ");
                    double lado1 = sc.nextDouble();
                    System.out.print("Introduce el lado 2: ");
                    double lado2 = sc.nextDouble();
                    System.out.print("Introduce el lado 3: ");
                    double lado3 = sc.nextDouble();
                    sc.nextLine(); // Limpiar buffer

                    double perimetroTri = lado1 + lado2 + lado3;
                    System.out.println("Perímetro del triángulo: " + perimetroTri);
                    break;

                case 6:
                    // --- SALIR ---
                    salir = true;
                    System.out.println("¡Gracias por usar la calculadora!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige entre 1 y 6.");
            }

            // Pequeña pausa antes de volver a mostrar el menú (si no salimos)
            if (!salir) {
                System.out.println("\nPulsa [Enter] para continuar...");
                sc.nextLine();
            }

        } while (!salir); // El bucle se repite si 'salir' es 'false'

        sc.close(); // Cerramos el scanner al final del programa
    }
}