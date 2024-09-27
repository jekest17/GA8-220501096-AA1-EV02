/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb;

import com.mycompany.cybershieldaiweb.dao.AnalisisDAO;
import com.mycompany.cybershieldaiweb.model.Analisis;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/analisis")
public class AnalisisServlet extends HttpServlet {
    private AnalisisDAO analisisDAO;

    // Constructor para inyección de dependencias
    public AnalisisServlet(AnalisisDAO analisisDAO) {
        this.analisisDAO = analisisDAO;
    }

    // Constructor por defecto para uso en producción
    public AnalisisServlet() {
        this(new AnalisisDAO());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Analisis> listaAnalisis = analisisDAO.getAllAnalisis();
        request.setAttribute("analisis", listaAnalisis);
        request.getRequestDispatcher("analisisPredictivo.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear un nuevo análisis a partir de los parámetros del formulario
        Timestamp Fecha = Timestamp.valueOf(request.getParameter("Fecha"));
        String Resultado = request.getParameter("Resultado");
        int Usuario_idUsuario = Integer.parseInt(request.getParameter("Usuario_idUsuario"));
        int Sistema_idSistema = Integer.parseInt(request.getParameter("Sistema_idSistema"));
        String detalle = request.getParameter("detalle");
        String nivelCriticidad = request.getParameter("nivelCriticidad");

        Analisis analisis = new Analisis();
        analisis.setFecha(Fecha);
        analisis.setResultado(Resultado);
        analisis.setUsuario_idUsuario(Usuario_idUsuario);
        analisis.setSistema_idSistema(Sistema_idSistema);
        analisis.setDetalle(detalle);
        analisis.setNivelCriticidad(nivelCriticidad);

        analisisDAO.addAnalisis(analisis);
        response.sendRedirect("analisis");
    }
}
