/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.dao;

import com.mycompany.cybershieldaiweb.model.Amenaza;
import com.mycompany.cybershieldaiweb.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AmenazaDAO {
    public List<Amenaza> getAmenazasCriticas() {
        List<Amenaza> amenazas = new ArrayList<>();
        String sql = "SELECT * FROM amenaza";

        try (Connection conn = DatabaseUtil.getConnection();  // Corregido: Llamada estática a getConnection()
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Amenaza amenaza = new Amenaza(
                    rs.getInt("idAmenaza"),
                    rs.getString("Descripcion"),
                    rs.getString("NivelRiesgo"),
                    rs.getInt("Analisis_idAnalisis"),
                    rs.getString("tipoAmenaza")
                );
                amenazas.add(amenaza);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return amenazas;
    }
// Método para obtener el total de amenazas
    public int getTotalAmenazas() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM amenaza";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         System.out.println("Total de Amenazas: " + total);
    
    return total;
    }
}


