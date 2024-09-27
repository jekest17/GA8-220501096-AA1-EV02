/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb;

import com.mycompany.cybershieldaiweb.dao.SistemaDAO;
import com.mycompany.cybershieldaiweb.model.Sistema;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mostrarSistemas")
public class MostrarSistemasServlet extends HttpServlet {

    private SistemaDAO sistemaDAO;

    public MostrarSistemasServlet() {
        this.sistemaDAO = new SistemaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sistema> sistemas = sistemaDAO.getAllSistemas();
        request.setAttribute("sistemas", sistemas);
        request.getRequestDispatcher("sistemas.jsp").forward(request, response);
    }
}

