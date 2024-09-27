/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.recomendacion;

import com.mycompany.cybershieldaiweb.dao.RecomendacionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/eliminarRecomendacion")
public class EliminarRecomendacionServlet extends HttpServlet {
    private RecomendacionDAO recomendacionDAO;

    public EliminarRecomendacionServlet() {
        this.recomendacionDAO = new RecomendacionDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID de la recomendación a eliminar
        int idRecomendacion = Integer.parseInt(request.getParameter("idRecomendacion"));

        // Eliminar la recomendación de la base de datos
        recomendacionDAO.eliminarRecomendacion(idRecomendacion);

        // Redirigir a la página de gestión de recomendaciones
        response.sendRedirect("mostrarRecomendaciones.jsp");
    }
}
