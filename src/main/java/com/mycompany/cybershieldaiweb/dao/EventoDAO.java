/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.dao;

import com.mycompany.cybershieldaiweb.util.DatabaseUtil;
import com.mycompany.cybershieldaiweb.model.Evento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    public List<Evento> getEventosRecientes() {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM evento";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Evento evento = new Evento(
                    rs.getInt("idEvento"),
                    rs.getString("Descripcion"),
                    rs.getString("FechaEvento"),
                    rs.getString("Tipo")
                );
                eventos.add(evento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventos;
    }
}
