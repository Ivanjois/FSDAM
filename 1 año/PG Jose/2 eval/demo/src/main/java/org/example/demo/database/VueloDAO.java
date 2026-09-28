package org.example.demo.database;

import org.example.demo.model.Vuelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VueloDAO {

    public ArrayList<Vuelo> obtenerTodos() {
        ArrayList<Vuelo> lista = new ArrayList<>();
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String sql = "SELECT * FROM flight";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Vuelo(
                            rs.getInt("id_flight"),
                            rs.getString("num_flight"),
                            rs.getString("destination"),
                            rs.getDate("departure").toLocalDate(),
                            rs.getInt("duration")));
                }
            } catch (SQLException e) {
                System.out.println("Error al cargar vuelos: " + e.getMessage());
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                }
            }
        }
        return lista;
    }

    public boolean insertar(Vuelo vuelo) throws SQLException {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String sql = "INSERT INTO flight (num_flight, destination, departure, duration) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setString(1, vuelo.getNumFlight());
                pstmt.setString(2, vuelo.getDestination());
                pstmt.setDate(3, java.sql.Date.valueOf(vuelo.getDeparture()));
                pstmt.setInt(4, vuelo.getDuration());
                pstmt.executeUpdate();
                return true;
            } finally {
                conexion.close();
            }
        }
        return false;
    }

    public boolean eliminar(int idFlight) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String sql = "DELETE FROM flight WHERE id_flight = ?";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setInt(1, idFlight);
                return pstmt.executeUpdate() > 0;
            } catch (SQLException e) {
                System.out.println("Error al eliminar: " + e.getMessage());
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                }
            }
        }
        return false;
    }

    public ArrayList<Vuelo> filtrarPorDuracion() {
        ArrayList<Vuelo> lista = new ArrayList<>();
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String sql = "SELECT * FROM flight WHERE duration > 180";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Vuelo(
                            rs.getInt("id_flight"), rs.getString("num_flight"),
                            rs.getString("destination"), rs.getDate("departure").toLocalDate(),
                            rs.getInt("duration")));
                }
            } catch (SQLException e) {
            }
        }
        return lista;
    }

    public ArrayList<Vuelo> filtrarPorDestino(String ciudad) {
        ArrayList<Vuelo> lista = new ArrayList<>();
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            String sql = "SELECT * FROM flight WHERE destination = ?";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setString(1, ciudad);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        lista.add(new Vuelo(
                                rs.getInt("id_flight"), rs.getString("num_flight"),
                                rs.getString("destination"), rs.getDate("departure").toLocalDate(),
                                rs.getInt("duration")));
                    }
                }
            } catch (SQLException e) {
            }
        }
        return lista;
    }
}