package U8.Entregables.database;

import U8.Entregables.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private int obtenerSiguienteId(Connection conexion) {
        int siguienteId = 1;
        String sql = "SELECT MAX(id) AS max_id FROM usuarios";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                if (maxId > 0) {
                    siguienteId = maxId + 1;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al calcular el siguiente ID: " + e.getMessage());
        }
        return siguienteId;
    }

    public boolean registrarUsuario(Usuario nuevoUsuario) {
        Connection conexion = ConexionBD.conectar();

        if (conexion != null) {
            try {
                int idQueToca = obtenerSiguienteId(conexion);

                String sql = "INSERT INTO usuarios (id, email, password) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conexion.prepareStatement(sql);

                pstmt.setInt(1, idQueToca);
                pstmt.setString(2, nuevoUsuario.getEmail());
                pstmt.setString(3, nuevoUsuario.getPassword());

                pstmt.executeUpdate();
                System.out.println("Usuario registrado con éxito. Te ha tocado el ID: " + idQueToca);

                conexion.close();
                return true;

            } catch (SQLException e) {
                System.out.println("Error al registrar en la base de datos.");
                System.out.println("Detalles: " + e.getMessage());
                return false;
            }
        }
        return false;
    }
    public Usuario login(String email, String password) {
        Usuario usuarioLogueado = null;
        Connection conexion = ConexionBD.conectar();

        if (conexion != null) {
            String sql = "SELECT id, email, password FROM usuarios WHERE email = ? AND password = ?";

            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {

                pstmt.setString(1, email);
                pstmt.setString(2, password);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int idBD = rs.getInt("id");
                        String emailBD = rs.getString("email");
                        String passwordBD = rs.getString("password");

                        usuarioLogueado = new Usuario(idBD, emailBD, passwordBD);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error al intentar hacer login: " + e.getMessage());
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión.");
                }
            }
        }
        return usuarioLogueado;
    }
}