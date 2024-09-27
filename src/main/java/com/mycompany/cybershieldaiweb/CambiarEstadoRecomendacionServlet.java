/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb;

import com.mycompany.cybershieldaiweb.dao.RecomendacionDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/cambiarEstadoRecomendacion")
public class CambiarEstadoRecomendacionServlet extends HttpServlet {

    private RecomendacionDAO recomendacionDAO;

    public CambiarEstadoRecomendacionServlet() {
        this.recomendacionDAO = new RecomendacionDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idRecomendacion = Integer.parseInt(request.getParameter("idRecomendacion"));
        String nuevoEstado = "Completado"; // El nuevo estado siempre será "Completado"
        Date fechaCompletado = new Date(System.currentTimeMillis()); // La fecha actual

        // Actualizar el estado en la base de datos
        recomendacionDAO.actualizarEstado(idRecomendacion, nuevoEstado, fechaCompletado);

        // Redirigir a la página de recomendaciones después de cambiar el estado
        response.sendRedirect("mostrarRecomendaciones.jsp");
    }
}
