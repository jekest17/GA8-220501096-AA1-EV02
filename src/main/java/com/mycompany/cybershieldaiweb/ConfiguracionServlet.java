/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.cybershieldaiweb;

import com.mycompany.cybershieldaiweb.dao.ConfiguracionDAO;
import com.mycompany.cybershieldaiweb.model.Configuracion;
import com.mycompany.cybershieldaiweb.model.Usuario; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/guardarConfiguracion")
public class ConfiguracionServlet extends HttpServlet {

    private ConfiguracionDAO configuracionDAO;

    public ConfiguracionServlet() {
        this.configuracionDAO = new ConfiguracionDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String alertas = request.getParameter("alertas");
        String frecuencia = request.getParameter("frecuencia");
        String idioma = request.getParameter("idioma");

        // Obtener la sesión actual del usuario
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario"); // Asumiendo que el usuario está guardado en la sesión

        if (usuario != null && alertas != null && frecuencia != null && idioma != null) {
            // Obtener la configuración del usuario
            Configuracion configuracion = configuracionDAO.getConfiguracionByUsuarioId(usuario.getIdUsuario());

            if (configuracion != null) {
                // Si existe la configuración, se actualiza
                configuracion.setAlertas(alertas);
                configuracion.setFrecuencia(frecuencia);
                configuracion.setIdioma(idioma);

                configuracionDAO.actualizarConfiguracion(configuracion); // Actualizar en la base de datos
            } else {
                // Si no existe la configuración, se crea una nueva
                Configuracion nuevaConfiguracion = new Configuracion();
                nuevaConfiguracion.setAlertas(alertas);
                nuevaConfiguracion.setFrecuencia(frecuencia);
                nuevaConfiguracion.setIdioma(idioma);
                nuevaConfiguracion.setUsuario_idUsuario(usuario.getIdUsuario());

                configuracionDAO.insertarConfiguracion(nuevaConfiguracion); // Insertar en la base de datos
            }

            response.sendRedirect("configuracion.jsp"); // Redirigir a la página de configuración
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h3>Error: Parámetros inválidos. Por favor, complete todos los campos.</h3>");
        }
    }
}

