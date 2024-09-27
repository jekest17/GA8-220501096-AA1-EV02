/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.cybershieldaiweb;

import com.mycompany.cybershieldaiweb.conexion.conexion; // Importa la clase que maneja la conexión
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/registrarUsuario")
public class RegistrarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");

        // Variable para almacenar mensajes de error
        StringBuilder mensajeError = new StringBuilder();

        try (Connection conn = new conexion().getConection()) {
            // Verificar si el correo ya está registrado
            String sqlCheck = "SELECT * FROM usuario WHERE Correo_Electronico = ?";
            PreparedStatement stmtCheck = conn.prepareStatement(sqlCheck);
            stmtCheck.setString(1, correo);
            ResultSet rs = stmtCheck.executeQuery();

            if (rs.next()) {
                // Si el correo ya existe, mostrar mensaje y regresar al formulario
                mensajeError.append("El correo electrónico ya está registrado. Por favor, inicie sesión.<br>");
                request.setAttribute("mensajeError", mensajeError.toString());
                request.setAttribute("nombre", nombre); // Mantener el valor ingresado
                request.setAttribute("correo", correo); // Mantener el valor ingresado
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                return;
            }
            
            // Validar el formato del correo electrónico (debe ser de @ejentidad.com)
            if (!correo.endsWith("@ejentidad.com")) {
                mensajeError.append("El correo electrónico debe ser de la entidad @ejentidad.com.<br>");
            }

            // Validar la complejidad de la contraseña
            if (!isPasswordValid(clave)) {
                mensajeError.append("La contraseña debe tener al menos 8 caracteres, incluir una mayúscula, una minúscula, un número y un carácter especial.<br>");
            }

            // Si hay errores de validación, mostrar en la misma página de registro
            if (mensajeError.length() > 0) {
                request.setAttribute("mensajeError", mensajeError.toString());
                request.setAttribute("nombre", nombre); // Mantener el valor ingresado
                request.setAttribute("correo", correo); // Mantener el valor ingresado
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                return;
            }

            // Si el correo no existe y las validaciones son correctas, registrar el usuario
            String sqlInsert = "INSERT INTO usuario (Nombre, Correo_Electronico, Contraseña, Rol) VALUES (?, ?, ?, 'Usuario')";
            PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
            stmtInsert.setString(1, nombre);
            stmtInsert.setString(2, correo);
            stmtInsert.setString(3, clave); // Nota: en un sistema real, la contraseña debe estar cifrada.
            stmtInsert.executeUpdate();

            // Redirigir al usuario a la página de confirmación de correo electrónico
            response.sendRedirect("confirmarCorreo.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("<h3>Error al conectar con la base de datos: " + e.getMessage() + "</h3>");
        }
    }

    // Método para validar la contraseña
    private boolean isPasswordValid(String password) {
        if (password.length() < 8) return false;

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
