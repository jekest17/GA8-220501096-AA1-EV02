/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.logs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.cybershieldaiweb.conexion.conexion;
import com.mycompany.cybershieldaiweb.model.Log;  // Importa la clase Log desde el paquete correcto

public class consultarLog {

    public List<Log> obtenerLogs() {
        List<Log> listaLogs = new ArrayList<>();
        String sql = "SELECT * FROM logs"; // Nombre correcto de la tabla

        try (Connection conn = new conexion().getConection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Log log = new Log();
                log.setIdLog(rs.getInt("idLog"));  // Nombre correcto del campo
                log.setAccion(rs.getString("Accion"));  // Nombre correcto del campo
                log.setFechaAccion(rs.getString("FechaAccion")); // Nombre correcto del campo
                log.setUsuario_idUsuario(rs.getInt("Usuario_idUsuario")); // Nombre correcto del campo
                listaLogs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaLogs;
    }
}
