package Tema0.miniterminal;

import java.util.Scanner;

public class MiniTerminal {

    private static void mostrarAyuda() {
        System.out.println("Comandos disponibles:");
        System.out.println("  pwd              - Muestra la carpeta actual.");
        System.out.println("  cd <DIR>         - Cambia la carpeta actual a DIR (usa '..' para subir).");
        System.out.println("  ls               - Lista directorios y archivos ordenados alfabeticamente.");
        System.out.println("  ll               - Como ls, mostrando tamano y fecha de ultima modificacion.");
        System.out.println("  mkdir <DIR>      - Crea el directorio DIR en la carpeta actual.");
        System.out.println("  rm <FILE>        - Borra el archivo o carpeta (si tiene subcarpetas, avisa).");
        System.out.println("  mv <FILE1> <F2>  - Mueve o renombra FILE1 a F2.");
        System.out.println("  help             - Muestra esta ayuda.");
        System.out.println("  exit             - Sale de la MiniTerminal.");
    }

    public static void main(String[] args) {
        MiniFileManager manager = new MiniFileManager();
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        System.out.println("=== MiniTerminal Java (escribe 'help' para ver comandos) ===");

        while (ejecutando) {
            try {
                System.out.print(manager.getPWD() + " > ");
                if (!scanner.hasNextLine()) {
                    break;
                }
                String linea = scanner.nextLine().trim();
                if (linea.isEmpty()) {
                    continue;
                }

                String[] partes = linea.split("\\s+");
                String comando = partes[0].toLowerCase();

                switch (comando) {
                    case "pwd":
                        System.out.println(manager.getPWD());
                        break;
                    case "cd":
                        if (partes.length < 2) {
                            System.out.println("Uso: cd <DIR>");
                        } else {
                            String dir = linea.substring(3).trim();
                            manager.changeDir(dir);
                        }
                        break;
                    case "ls":
                        manager.printList(false);
                        break;
                    case "ll":
                        manager.printList(true);
                        break;
                    case "mkdir":
                        if (partes.length < 2) {
                            System.out.println("Uso: mkdir <DIR>");
                        } else {
                            manager.makeDir(partes[1]);
                            System.out.println("Directorio creado: " + partes[1]);
                        }
                        break;
                    case "rm":
                        if (partes.length < 2) {
                            System.out.println("Uso: rm <FILE>");
                        } else {
                            manager.removeFile(partes[1]);
                        }
                        break;
                    case "mv":
                        if (partes.length < 3) {
                            System.out.println("Uso: mv <FILE1> <FILE2>");
                        } else {
                            manager.moveFile(partes[1], partes[2]);
                            System.out.println("Movido/renombrado correctamente.");
                        }
                        break;
                    case "help":
                        mostrarAyuda();
                        break;
                    case "exit":
                        ejecutando = false;
                        System.out.println("Saliendo de MiniTerminal...");
                        break;
                    default:
                        System.out.println("Comando no reconocido: '" + comando + "'. Escribe 'help' para ayuda.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
