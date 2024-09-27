/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.dao;

import com.mycompany.cybershieldaiweb.model.Recomendacion;
import com.mycompany.cybershieldaiweb.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecomendacionDAO {

    // Método para obtener todas las recomendaciones
    public List<Recomendacion> getAllRecomendaciones() {
        List<Recomendacion> listaRecomendaciones = new ArrayList<>();
        String sql = "SELECT * FROM recomendacion";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Recomendacion recomendacion = new Recomendacion();
                recomendacion.setidRecomendacion(rs.getInt("idRecomendacion"));
                recomendacion.setDescripcion(rs.getString("Descripcion"));
                recomendacion.setNivelUrgencia(rs.getString("NivelUrgencia"));
                recomendacion.setAmenaza_idAmenaza(rs.getInt("Amenaza_idAmenaza"));
                recomendacion.setestadoImplementacion(rs.getString("estadoImplementacion"));
                recomendacion.setfechaCompletado(rs.getDate("fechaCompletado"));

                listaRecomendaciones.add(recomendacion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Aquí agregamos el System.out.println para ver si se obtienen correctamente
        System.out.println("Recomendaciones obtenidas: " + listaRecomendaciones.size());

        return listaRecomendaciones;
    }

    // Método para agregar una nueva recomendación
    public void agregarRecomendacion(Recomendacion recomendacion) {
        String sql = "INSERT INTO recomendacion (Descripcion, NivelUrgencia, Amenaza_idAmenaza, estadoImplementacion) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, recomendacion.getDescripcion());
            stmt.setString(2, recomendacion.getNivelUrgencia());
            stmt.setInt(3, recomendacion.getAmenaza_idAmenaza());
            stmt.setString(4, recomendacion.getestadoImplementacion());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para actualizar una recomendación existente
    public void actualizarRecomendacion(Recomendacion recomendacion) {
        String sql = "UPDATE recomendacion SET Descripcion = ?, NivelUrgencia = ?, Amenaza_idAmenaza = ?, estadoImplementacion = ? WHERE idRecomendacion = ?";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, recomendacion.getDescripcion());
            stmt.setString(2, recomendacion.getNivelUrgencia());
            stmt.setInt(3, recomendacion.getAmenaza_idAmenaza());
            stmt.setString(4, recomendacion.getestadoImplementacion());
            stmt.setInt(5, recomendacion.getidRecomendacion());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar el estado de implementación y la fecha de completado
    public void actualizarEstado(int idRecomendacion, String nuevoEstado, Date fechaCompletado) {
        String sql = "UPDATE recomendacion SET estadoImplementacion = ?, fechaCompletado = ? WHERE idRecomendacion = ?";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevoEstado);
            stmt.setDate(2, fechaCompletado);
            stmt.setInt(3, idRecomendacion);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para eliminar una recomendación
    public void eliminarRecomendacion(int idRecomendacion) {
        String sql = "DELETE FROM recomendacion WHERE idRecomendacion = ?";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idRecomendacion);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 // Método para obtener el total de recomendaciones
    public int getTotalRecomendaciones() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM recomendacion";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         System.out.println("Total de Recomendaciones: " + total);
    
    return total;
    }

    // Método para obtener el número de recomendaciones completadas
    public int getRecomendacionesCompletadas() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM recomendacion WHERE estadoImplementacion = 'Completado'";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Total de Recomendaciones: " + total);
    
    System.out.println("Recomendaciones Completadas: " + total);
    
    return total;
    }
}
