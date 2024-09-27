/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.cybershieldaiweb;

import com.mycompany.cybershieldaiweb.dao.UsuarioDAO;
import com.mycompany.cybershieldaiweb.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/gestionIdentidades")
public class GestionIdentidadesServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    public GestionIdentidadesServlet() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la lista de usuarios de la base de datos
        List<Usuario> listaUsuarios = usuarioDAO.getAllUsuarios();
        
        // Establecer la lista de usuarios como atributo de la solicitud
        request.setAttribute("usuarios", listaUsuarios);
        
        // Redirigir a la página gestionIdentidades.jsp con la información de los usuarios
        request.getRequestDispatcher("gestionIdentidades.jsp").forward(request, response);
    }
    
}
