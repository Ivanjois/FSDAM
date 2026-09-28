package database;

import model.Temperatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TemperaturaDAO {



    public void insertar(Temperatura temp) {
        String sql = "INSERT INTO temperatura (min_temp, max_temp) VALUES (?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setDouble(1, temp.getMinTemp());
            pstmt.setDouble(2, temp.getMaxTemp());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    public void actualizar(Temperatura temp) {
        String sql = "UPDATE temperatura SET min_temp = ?, max_temp = ? WHERE id_reg = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setDouble(1, temp.getMinTemp());
            pstmt.setDouble(2, temp.getMaxTemp());
            pstmt.setInt(3, temp.getIdReg());

            int actualizadas = pstmt.executeUpdate();
            System.out.println("UPDATE -> Filas modificadas: " + actualizadas);
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void borrar(int idReg) {
        String sql = "DELETE FROM temperatura WHERE id_reg = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idReg);
            int borradas = pstmt.executeUpdate();
            System.out.println("DELETE -> Filas borradas: " + borradas);
        } catch (SQLException e) {
            System.err.println("Error al borrar: " + e.getMessage());
        }
    }
    public ArrayList<Temperatura> mayorQue(double temp) {
        ArrayList<Temperatura> lista = new ArrayList<>();
        String sql = "SELECT id_reg, poblacion, min_temp, max_temp, fecha FROM temperatura WHERE max_temp > ? ORDER BY poblacion, max_temp";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Temperatura a = new Temperatura(
                        rs.getString("poblacion"),
                        rs.getDouble("min_temp"),
                        rs.getDouble("max_temp"),
                        rs.getDate("fecha").toLocalDate()
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }


    public ArrayList<Temperatura> obtenerTodos() {
        ArrayList<Temperatura> lista = new ArrayList<>();
        String sql = "SELECT * FROM temperatura";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Temperatura a = new Temperatura(
                        rs.getString("poblacion"),
                        rs.getDouble("min_temp"),
                        rs.getDouble("max_temp"),
                        rs.getDate("fecha").toLocalDate()
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}

