/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.logs;

import com.mycompany.cybershieldaiweb.conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class eliminarLog {

    public boolean eliminar(int idLog) {
        String sql = "DELETE FROM logs WHERE idLog = ?";

        try (Connection conn = new conexion().getConection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idLog);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
