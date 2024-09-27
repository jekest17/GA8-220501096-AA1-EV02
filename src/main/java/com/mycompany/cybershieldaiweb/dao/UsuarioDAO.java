/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.dao;

import com.mycompany.cybershieldaiweb.util.DatabaseUtil;
import com.mycompany.cybershieldaiweb.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setCorreoElectronico(rs.getString("Correo_Electronico"));
                usuario.setContraseña(rs.getString("Contraseña"));
                usuario.setRol(rs.getString("Rol"));
                usuario.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
                usuario.setFechaModificacion(rs.getTimestamp("fechaModificacion"));
                usuario.setEstado(rs.getString("estado"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
// Nuevo método agregado para obtener un usuario por ID
    public Usuario getUsuarioById(int idUsuario) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setNombre(rs.getString("Nombre"));
                    usuario.setCorreoElectronico(rs.getString("Correo_Electronico"));
                    usuario.setContraseña(rs.getString("Contraseña"));
                    usuario.setRol(rs.getString("Rol"));
                    usuario.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
                    usuario.setFechaModificacion(rs.getTimestamp("fechaModificacion"));
                    usuario.setEstado(rs.getString("estado"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
    
    // Métodos adicionales para agregar, actualizar y eliminar usuarios
    public void agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (Nombre, Correo_Electronico, Contraseña, Rol, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreoElectronico());
            stmt.setString(3, usuario.getContraseña());
            stmt.setString(4, usuario.getRol());
            stmt.setString(5, usuario.getEstado());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET Nombre = ?, Correo_Electronico = ?, Contraseña = ?, Rol = ?, estado = ? WHERE idUsuario = ?";

        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreoElectronico());
            stmt.setString(3, usuario.getContraseña());
            stmt.setString(4, usuario.getRol());
            stmt.setString(5, usuario.getEstado());
            stmt.setInt(6, usuario.getIdUsuario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void eliminarUsuario(int idUsuario) {
    String sql = "DELETE FROM usuario WHERE idUsuario = ?";

    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idUsuario);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
// Método para obtener el total de usuarios
    public int getTotalUsuarios() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM usuario";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    System.out.println("Total de Usuarios: " + total);
    
    return total;
    }
}
