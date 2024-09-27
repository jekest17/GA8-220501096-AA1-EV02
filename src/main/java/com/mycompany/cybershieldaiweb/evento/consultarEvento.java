/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.evento;

import com.mycompany.cybershieldaiweb.model.Evento;
import com.mycompany.cybershieldaiweb.conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class consultarEvento {

    public List<Evento> obtenerEventos() {
        List<Evento> listaEventos = new ArrayList<>();
        String sql = "SELECT * FROM evento";

        try (Connection conn = new conexion().getConection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Evento evento = new Evento();
                evento.setIdEvento(rs.getInt("idEvento"));
                evento.setDescripcion(rs.getString("Descripcion")); // Usar el nombre correcto del campo
                evento.setFechaEvento(rs.getString("FechaEvento")); // Usar el nombre correcto del campo
                evento.setTipo(rs.getString("Tipo")); // Usar el nombre correcto del campo
                listaEventos.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaEventos;
    }
}
