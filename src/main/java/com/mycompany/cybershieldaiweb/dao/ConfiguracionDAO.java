/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.dao;

import com.mycompany.cybershieldaiweb.model.Configuracion;
import com.mycompany.cybershieldaiweb.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfiguracionDAO {

    // Obtener la configuración por ID de usuario
    public Configuracion getConfiguracionByUsuarioId(int usuarioId) {
        Configuracion configuracion = null;
        String sql = "SELECT * FROM configuracion WHERE Usuario_idUsuario = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    configuracion = new Configuracion();
                    configuracion.setId(rs.getInt("id"));
                    configuracion.setAlertas(rs.getString("alertas"));
                    configuracion.setFrecuencia(rs.getString("frecuencia"));
                    configuracion.setIdioma(rs.getString("idioma"));
                    configuracion.setUsuario_idUsuario(rs.getInt("Usuario_idUsuario"));
                    
                    System.out.println("Configuración obtenida para Usuario_idUsuario: " + usuarioId);
                } else {
                    System.out.println("No se encontró configuración para Usuario_idUsuario: " + usuarioId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener la configuración de la base de datos para Usuario_idUsuario: " + usuarioId);
        }

        return configuracion;
    }

    // Actualizar la configuración existente
    public void actualizarConfiguracion(Configuracion configuracion) {
        String sql = "UPDATE configuracion SET alertas = ?, frecuencia = ?, idioma = ? WHERE Usuario_idUsuario = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Agregar verificaciones de campos nulos
            if (configuracion.getAlertas() == null || configuracion.getFrecuencia() == null || configuracion.getIdioma() == null) {
                System.out.println("Uno o más campos son nulos.");
                return;
            }

            stmt.setString(1, configuracion.getAlertas());
            stmt.setString(2, configuracion.getFrecuencia());
            stmt.setString(3, configuracion.getIdioma());
            stmt.setInt(4, configuracion.getUsuario_idUsuario());

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Configuración actualizada para Usuario_idUsuario: " + configuracion.getUsuario_idUsuario());
            System.out.println("Filas afectadas: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar la configuración para Usuario_idUsuario: " + configuracion.getUsuario_idUsuario());
        }
    }

    // Insertar nueva configuración
    public void insertarConfiguracion(Configuracion configuracion) {
        String sql = "INSERT INTO configuracion (alertas, frecuencia, idioma, Usuario_idUsuario) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Agregar verificaciones de campos nulos
            if (configuracion.getAlertas() == null || configuracion.getFrecuencia() == null || configuracion.getIdioma() == null) {
                System.out.println("Uno o más campos son nulos.");
                return;
            }

            stmt.setString(1, configuracion.getAlertas());
            stmt.setString(2, configuracion.getFrecuencia());
            stmt.setString(3, configuracion.getIdioma());
            stmt.setInt(4, configuracion.getUsuario_idUsuario());

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Nueva configuración insertada para Usuario_idUsuario: " + configuracion.getUsuario_idUsuario());
            System.out.println("Filas afectadas: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar la nueva configuración para Usuario_idUsuario: " + configuracion.getUsuario_idUsuario());
        }
    }
}
