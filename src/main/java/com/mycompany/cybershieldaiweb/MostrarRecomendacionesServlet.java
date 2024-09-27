/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb;

import com.mycompany.cybershieldaiweb.dao.RecomendacionDAO;
import com.mycompany.cybershieldaiweb.model.Recomendacion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mostrarRecomendaciones")
public class MostrarRecomendacionesServlet extends HttpServlet {

    private RecomendacionDAO recomendacionDAO;

    public MostrarRecomendacionesServlet() {
        this.recomendacionDAO = new RecomendacionDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener todas las recomendaciones desde el DAO
        List<Recomendacion> listaRecomendaciones = recomendacionDAO.getAllRecomendaciones();

        // Enviar la lista al JSP
        request.setAttribute("recomendaciones", listaRecomendaciones);
        request.getRequestDispatcher("mostrarRecomendaciones.jsp").forward(request, response);
    }
}
