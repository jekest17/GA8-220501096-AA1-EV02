/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.logs;

import com.mycompany.cybershieldaiweb.conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class editarLog {

    public boolean editar(int idLog, String accion, String descripcion, int usuarioId) {
        String sql = "UPDATE logs SET accion = ?, descripcion = ?, usuario_idUsuario = ? WHERE idLog = ?";

        try (Connection conn = new conexion().getConection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, accion);
            stmt.setString(2, descripcion);
            stmt.setInt(3, usuarioId);
            stmt.setInt(4, idLog);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

