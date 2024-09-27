/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb;

import com.mycompany.cybershieldaiweb.dao.LogDAO;
import com.mycompany.cybershieldaiweb.model.Log;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mostrarLogs")
public class MostrarLogsServlet extends HttpServlet {

    private LogDAO logDAO;

    public MostrarLogsServlet() {
        this.logDAO = new LogDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> logs = logDAO.getAllLogs();
        request.setAttribute("logs", logs);
        request.getRequestDispatcher("logs.jsp").forward(request, response);
    }
}

