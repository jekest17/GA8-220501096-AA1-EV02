/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.cybershieldaiweb;

import com.mycompany.cybershieldaiweb.util.DatabaseUtil;  // Ahora importa DatabaseUtil en lugar de conexion
import com.mycompany.cybershieldaiweb.model.Usuario;
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
import jakarta.servlet.http.HttpSession;

/**
 * Servlet que maneja el procesamiento del formulario de inicio de sesión.
 * Redirige al usuario a la página correspondiente en función de la autenticación.
 */
@WebServlet("/procesarFormulario")
public class FormularioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirigir a la página de inicio de sesión si se accede por GET
        response.sendRedirect("index.html");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera los parámetros 'usuario' y 'clave' del formulario
        String email = request.getParameter("usuario");
        String password = request.getParameter("clave");
        // Conectar a la base de datos para verificar credenciales usando DatabaseUtil
        try (Connection conn = DatabaseUtil.getConnection()) {  // Aquí cambia conexion por DatabaseUtil
            String sql = "SELECT * FROM usuario WHERE Correo_Electronico = ? AND Contraseña = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Credenciales correctas, crear un objeto Usuario y almacenarlo en la sesión
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setCorreoElectronico(rs.getString("Correo_Electronico"));
                usuario.setRol(rs.getString("Rol"));
                
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario); // Guardar el objeto completo del usuario en la sesión

                // Redirige a la página 'bienvenido.jsp'
                request.getRequestDispatcher("bienvenido.jsp").forward(request, response);
            } else {
                // Credenciales incorrectas, redirige a 'error.jsp'
                request.setAttribute("error", "Usuario o Clave incorrectos");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>Error al conectar con la base de datos: " + e.getMessage() + "</h3>");
        }
    }
}
