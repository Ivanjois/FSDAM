package U8.Entregables.database;

import U8.Entregables.model.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class NotaDAO {

    private int obtenerSiguienteId(Connection conexion) {
        int siguienteId = 1;
        String sql = "SELECT MAX(id) AS max_id FROM notas";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                if (maxId > 0) {
                    siguienteId = maxId + 1;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al calcular el ID de la nota: " + e.getMessage());
        }
        return siguienteId;
    }

    public boolean insertar(Nota nota) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            try {
                int idQueToca = obtenerSiguienteId(conexion);
                String sql = "INSERT INTO notas (id, id_usuario, contenido, fecha_creacion) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conexion.prepareStatement(sql);

                pstmt.setInt(1, idQueToca);
                pstmt.setInt(2, nota.getIdUsuario());
                pstmt.setString(3, nota.getTexto());

                pstmt.setDate(4, java.sql.Date.valueOf(nota.getFechaCreacion()));

                pstmt.executeUpdate();

                pstmt.close();
                conexion.close();
                return true;

            } catch (SQLException e) {
                System.out.println("ERROR AL CREAR LA NOTA EN LA BD:");
                System.out.println(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public ArrayList<Nota> obtenerNotasPorUsuario(int idUsuario) {
        ArrayList<Nota> listaNotas = new ArrayList<>();
        Connection conexion = ConexionBD.conectar();

        if (conexion != null) {
            String sql = "SELECT id, id_usuario, contenido, fecha_creacion FROM notas WHERE id_usuario = ?";

            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setInt(1, idUsuario);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        int idNotaBD = rs.getInt("id");
                        int idUsuBD = rs.getInt("id_usuario");
                        String textoBD = rs.getString("contenido");
                        LocalDate fechaBD = rs.getDate("fecha_creacion").toLocalDate();

                        Nota n = new Nota(idNotaBD, idUsuBD, textoBD, fechaBD);
                        listaNotas.add(n);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error al cargar las notas: " + e.getMessage());
            } finally {
                try { conexion.close(); } catch (SQLException e) {}
            }
        }
        return listaNotas;
    }

    public boolean eliminar(int idNota, int idUsuario) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String sql = "DELETE FROM notas WHERE id = ? AND id_usuario = ?";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setInt(1, idNota);
                pstmt.setInt(2, idUsuario);

                int filasAfectadas = pstmt.executeUpdate();
                conexion.close();

                return filasAfectadas > 0;

            } catch (SQLException e) {
                System.out.println("Error al intentar eliminar la nota: " + e.getMessage());
                return false;
            }
        }
        return false;
    }
}