/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.dao;

import com.mycompany.cybershieldaiweb.model.Sistema;
import com.mycompany.cybershieldaiweb.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaDAO {

    // Obtener todos los sistemas
    public List<Sistema> getAllSistemas() {
        List<Sistema> listaSistemas = new ArrayList<>();
        String sql = "SELECT * FROM sistema";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sistema sistema = new Sistema();
                sistema.setidSistema(rs.getInt("idSistema"));
                sistema.setNombre(rs.getString("nombre"));
                sistema.setDescripcion(rs.getString("descripcion"));
                listaSistemas.add(sistema);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaSistemas;
    }

    // Método para agregar un nuevo sistema
    public void agregarSistema(Sistema sistema) {
        String sql = "INSERT INTO sistema (nombre, descripcion) VALUES (?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sistema.getNombre());
            stmt.setString(2, sistema.getDescripcion());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
