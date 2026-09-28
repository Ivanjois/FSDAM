package U8.Entregables.view;

import U8.Entregables.database.NotaDAO;
import U8.Entregables.database.UsuarioDAO;
import U8.Entregables.model.Nota;
import U8.Entregables.model.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        NotaDAO notaDAO = new NotaDAO();

        System.out.println("=== BIENVENIDO AL BLOC DE NOTAS REGIONAL ===");

        while (true) {
            Usuario usuarioActivo = null;

            while (usuarioActivo == null) {
                System.out.println("--- INICIO DE SESIÓN ---");
                System.out.print("Email: ");
                String email = teclado.nextLine();
                System.out.print("Contraseña: ");
                String password = teclado.nextLine();

                usuarioActivo = usuarioDAO.login(email, password);

                if (usuarioActivo != null) {
                    System.out.println("¡Hola de nuevo, " + usuarioActivo.getEmail() + "!");
                    registrarAcceso(usuarioActivo.getEmail());
                } else {
                    System.out.println("Credenciales incorrectas. Inténtalo de nuevo.");
                    System.out.print("¿Deseas salir del programa por completo? (si/no): ");
                    if (teclado.nextLine().equalsIgnoreCase("si")) {
                        System.out.println("Apagando el sistema. ¡Hasta pronto!");
                        teclado.close();
                        return;
                    }
                }
            }

            boolean sesionActiva = true;
            while (sesionActiva) {
                System.out.println("--- MI TABLÓN DE NOTAS ---");
                System.out.println("1. Ver mis notas");
                System.out.println("2. Crear nueva nota");
                System.out.println("3. Eliminar nota");
                System.out.println("4. Cerrar Sesión");
                System.out.print("> Elige una opción: ");

                int opcion = leerEntero(teclado);

                switch (opcion) {
                    case 1:
                        System.out.println("--- TUS NOTAS GUARDADAS ---");
                        ArrayList<Nota> misNotas = notaDAO.obtenerNotasPorUsuario(usuarioActivo.getIdUsuario());
                        if (misNotas.isEmpty()) {
                            System.out.println("No tienes ninguna nota aún.");
                        } else {
                            for (Nota n : misNotas) {
                                System.out.println(n);
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Escribe el texto de tu nueva nota: ");
                        String texto = teclado.nextLine();

                        Nota nuevaNota = new Nota(usuarioActivo.getIdUsuario(), texto, LocalDate.now());

                        if (notaDAO.insertar(nuevaNota)) {
                            System.out.println("Nota guardada correctamente.");
                        } else {
                            System.out.println("La nota no se ha podido guardar.");
                        }
                        break;

                    case 3:
                        System.out.print("ID de la nota que deseas borrar: ");
                        int idBorrar = leerEntero(teclado);

                        if (notaDAO.eliminar(idBorrar, usuarioActivo.getIdUsuario())) {
                            System.out.println("Nota eliminada.");
                        } else {
                            System.out.println("No se pudo borrar. Asegúrate de que el ID es correcto y la nota es tuya.");
                        }
                        break;

                    case 4:
                        System.out.println("Cerrando sesión de " + usuarioActivo.getEmail() + "...");
                        sesionActiva = false;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }
    }

    private static void registrarAcceso(String email) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("accesos.log", true))) {
            LocalDateTime ahora = LocalDateTime.now();
            pw.println("Acceso: " + email + " | Fecha y Hora: " + ahora);
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el log de accesos.");
        }
    }

    private static int leerEntero(Scanner teclado) {
        while (true) {
            try {
                return Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("¡Error! Introduce un número válido: ");
            }
        }
    }
}