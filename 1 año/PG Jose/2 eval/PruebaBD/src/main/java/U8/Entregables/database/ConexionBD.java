package U8.Entregables.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:postgresql://localhost:5432/bloc_notas_db";
    private static final String USUARIO = "postgres";
    private static final String PASSWORD = "qwerty2";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexión a PostgreSQL establecida.");
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos.");
            System.out.println("Motivo: " + e.getMessage());
        }
        return conexion;
    }
}