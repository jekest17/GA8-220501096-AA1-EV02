/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.cybershieldaiweb;

import com.mycompany.cybershieldaiweb.conexion.conexion; // Importa la clase que maneja la conexión
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet para manejar el restablecimiento de contraseña.
 */
@WebServlet("/restablecerContrasena")
public class RestablecerContrasenaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el correo del formulario de restablecimiento de contraseña
        String correo = request.getParameter("correo");

        // Conectar a la base de datos para verificar si el correo existe
        try (Connection conn = new conexion().getConection()) {
            String sqlCheck = "SELECT * FROM usuario WHERE Correo_Electronico = ?";
            PreparedStatement stmtCheck = conn.prepareStatement(sqlCheck);
            stmtCheck.setString(1, correo);
            ResultSet rs = stmtCheck.executeQuery();

            if (rs.next()) {
                // Si el correo existe, redirigir a la página de confirmación
                response.sendRedirect("confirmacionRestablecer.jsp");
            } else {
                // Si el correo no existe, mostrar mensaje de error en la misma página
                request.setAttribute("mensajeError", "El correo electrónico no está registrado.");
                request.setAttribute("correo", correo); // Mantener el valor ingresado
                request.getRequestDispatcher("restablecerContrasena.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>Error al conectar con la base de datos: " + e.getMessage() + "</h3>");
        }
    }
}
