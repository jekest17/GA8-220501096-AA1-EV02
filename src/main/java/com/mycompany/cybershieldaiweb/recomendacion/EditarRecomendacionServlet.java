/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.recomendacion;

import com.mycompany.cybershieldaiweb.dao.RecomendacionDAO;
import com.mycompany.cybershieldaiweb.model.Recomendacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editarRecomendacion")
public class EditarRecomendacionServlet extends HttpServlet {
    private RecomendacionDAO recomendacionDAO;

    public EditarRecomendacionServlet() {
        this.recomendacionDAO = new RecomendacionDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        int idRecomendacion = Integer.parseInt(request.getParameter("idRecomendacion"));
        String descripcion = request.getParameter("descripcion");
        String nivelUrgencia = request.getParameter("nivelUrgencia");
        int amenazaId = Integer.parseInt(request.getParameter("amenazaId"));
        String estadoImplementacion = request.getParameter("estadoImplementacion");

        // Crear una recomendación actualizada
        Recomendacion recomendacion = new Recomendacion();
        recomendacion.setidRecomendacion(idRecomendacion);
        recomendacion.setDescripcion(descripcion);
        recomendacion.setNivelUrgencia(nivelUrgencia);
        recomendacion.setAmenaza_idAmenaza(amenazaId);
        recomendacion.setestadoImplementacion(estadoImplementacion);

        // Actualizar la recomendación en la base de datos
        recomendacionDAO.actualizarRecomendacion(recomendacion);

        // Redirigir a la página de gestión de recomendaciones
        response.sendRedirect("mostrarRecomendaciones.jsp");
    }
}
