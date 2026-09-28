package U2.Retos;

import java.util.Scanner;

public class MiniReto2_Ivan_Poyda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int ESPACIOS = 5;
        String[] pueblos = new String[ESPACIOS];
        double[] temperaturasaltas = new double[ESPACIOS];
        double temperaturamedia, sumatemp = 0, tempmax, tempmin;
        int nmax = 0, nmin = 0;
        tempmax = temperaturasaltas[0];
        tempmin = temperaturasaltas[0];
        for (int i = 0; i < ESPACIOS; i++) {
            System.out.println("Dame el nombre del pueblo: ");
            pueblos[i] = sc.nextLine();
            System.out.println("Dame la temperatura máxima: ");
            temperaturasaltas[i] = sc.nextFloat();
            sc.nextLine();
            sumatemp += temperaturasaltas[i];
            if (temperaturasaltas[i] > tempmax) {
                nmax = i;
            }
            if (temperaturasaltas[i] < tempmin) {
                nmin = i;
            }
        }
        temperaturamedia = sumatemp / ESPACIOS;

        System.out.println("--- INFORME DE LA COMARCA ---");
        for (int i = 0; i < ESPACIOS; i++) {
            System.out.println(pueblos[i] + "        - Temp: " + (float) temperaturasaltas[i] + " ªC");
        }
        System.out.println("* La temperatura máxima es " + (float) temperaturasaltas[nmax] + " ªC");
        System.out.println("* La temperatura mínima es " + (float) temperaturasaltas[nmin] + " ªC");
        System.out.println("* La temperatura media es " + (float) temperaturamedia + " ªC");
        System.out.println("La localidad con la temperatura máxima es la " + (nmax + 1) + ": " + pueblos[nmax] + ".");
        System.out.println("La localidad con la temperatura mínima es la " + (nmin + 1) + ": " + pueblos[nmin] + ".");
    }
}

