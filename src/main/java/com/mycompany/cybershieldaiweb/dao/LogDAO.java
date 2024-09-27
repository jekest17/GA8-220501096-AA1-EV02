/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.dao;

import com.mycompany.cybershieldaiweb.util.DatabaseUtil;
import com.mycompany.cybershieldaiweb.model.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogDAO {
    public List<Log> getAllLogs() {
        List<Log> logs = new ArrayList<>();
        String sql = "SELECT * FROM logs";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Log log = new Log(
                    rs.getInt("idLog"),
                    rs.getString("Accion"),
                    rs.getString("FechaAccion"),
                    rs.getInt("Usuario_idUsuario")
                );
                logs.add(log);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return logs;
    }
}
