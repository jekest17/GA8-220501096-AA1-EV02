/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.dao;

import com.mycompany.cybershieldaiweb.model.Analisis;
import com.mycompany.cybershieldaiweb.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnalisisDAO {

    public List<Analisis> getAllAnalisis() {
        List<Analisis> listaAnalisis = new ArrayList<>();
        String sql = "SELECT * FROM analisis";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Analisis analisis = new Analisis();
                analisis.setIdAnalisis(rs.getInt("idAnalisis"));
                analisis.setFecha(rs.getTimestamp("Fecha"));
                analisis.setResultado(rs.getString("Resultado"));
                analisis.setUsuario_idUsuario(rs.getInt("Usuario_idUsuario"));
                analisis.setSistema_idSistema(rs.getInt("Sistema_idSistema"));
                analisis.setDetalle(rs.getString("detalle"));
                analisis.setNivelCriticidad(rs.getString("nivelCriticidad"));

                listaAnalisis.add(analisis);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaAnalisis;
    }

    public Analisis getAnalisisById(int idAnalisis) {
        Analisis analisis = null;
        String sql = "SELECT * FROM analisis WHERE idAnalisis = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idAnalisis);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    analisis = new Analisis();
                    analisis.setIdAnalisis(rs.getInt("idAnalisis"));
                    analisis.setFecha(rs.getTimestamp("Fecha"));
                    analisis.setResultado(rs.getString("Resultado"));
                    analisis.setUsuario_idUsuario(rs.getInt("Usuario_idUsuario"));
                    analisis.setSistema_idSistema(rs.getInt("Sistema_idSistema"));
                    analisis.setDetalle(rs.getString("detalle"));
                    analisis.setNivelCriticidad(rs.getString("nivelCriticidad"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return analisis;
    }

    public void addAnalisis(Analisis analisis) {
        String sql = "INSERT INTO analisis (Fecha, Resultado, Usuario_idUsuario, Sistema_idSistema, detalle, nivelCriticidad) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, analisis.getFecha());
            stmt.setString(2, analisis.getResultado());
            stmt.setInt(3, analisis.getUsuario_idUsuario());
            stmt.setInt(4, analisis.getSistema_idSistema());
            stmt.setString(5, analisis.getDetalle());
            stmt.setString(6, analisis.getNivelCriticidad());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAnalisis(Analisis analisis) {
        String sql = "UPDATE analisis SET Fecha = ?, Resultado = ?, Usuario_idUsuario = ?, Sistema_idSistema = ?, detalle = ?, nivelCriticidad = ? WHERE idAnalisis = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, analisis.getFecha());
            stmt.setString(2, analisis.getResultado());
            stmt.setInt(3, analisis.getUsuario_idUsuario());
            stmt.setInt(4, analisis.getSistema_idSistema());
            stmt.setString(5, analisis.getDetalle());
            stmt.setString(6, analisis.getNivelCriticidad());
            stmt.setInt(7, analisis.getIdAnalisis());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAnalisis(int idAnalisis) {
        String sql = "DELETE FROM analisis WHERE idAnalisis = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idAnalisis);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

