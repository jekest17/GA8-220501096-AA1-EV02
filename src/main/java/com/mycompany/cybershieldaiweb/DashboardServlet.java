/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.cybershieldaiweb;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.mycompany.cybershieldaiweb.dao.AmenazaDAO;
import com.mycompany.cybershieldaiweb.model.Amenaza;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el nombre del usuario de la sesión
        String nombreUsuario = (String) request.getSession().getAttribute("nombreUsuario");

        // Verifica si el usuario está logueado
        if (nombreUsuario == null) {
            response.sendRedirect("index.html"); // Redirigir al login si no hay sesión
            return;
        }

        // Cargar otros datos necesarios para el Dashboard
        AmenazaDAO amenazaDAO = new AmenazaDAO();
        List<Amenaza> amenazas = amenazaDAO.getAmenazasCriticas(); // Ejemplo de datos a cargar

        // Pasar el nombre del usuario y otros datos al JSP
        request.setAttribute("nombreUsuario", nombreUsuario);
        request.setAttribute("amenazas", amenazas);

        request.getRequestDispatcher("bienvenido.jsp").forward(request, response);
    }
}

