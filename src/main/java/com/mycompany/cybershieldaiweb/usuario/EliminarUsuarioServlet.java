/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.usuario;
    

import com.mycompany.cybershieldaiweb.dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/eliminarUsuario")
public class EliminarUsuarioServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    public EliminarUsuarioServlet() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID del usuario a eliminar
        int idUsuario = Integer.parseInt(request.getParameter("id"));

        // Eliminar el usuario de la base de datos
        usuarioDAO.eliminarUsuario(idUsuario);

        // Redirigir a la página de gestión de identidades
        response.sendRedirect("gestionIdentidades.jsp");
    }
}

