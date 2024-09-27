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
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cargarConfiguracion")
public class CargarConfiguracionServlet extends HttpServlet {

    private ConfiguracionDAO configuracionDAO;

    public CargarConfiguracionServlet() {
        this.configuracionDAO = new ConfiguracionDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la sesión actual del usuario
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario"); // Asumiendo que el usuario está guardado en la sesión

        if (usuario != null) {
            // Obtener la configuración del usuario desde la base de datos
            Configuracion configuracion = configuracionDAO.getConfiguracionByUsuarioId(usuario.getIdUsuario());

            if (configuracion != null) {
                // Convertir la configuración a JSON para enviarla como respuesta
                Gson gson = new Gson();
                String json = gson.toJson(configuracion);

                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.print(json);
                out.flush();
            } else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT); // No hay configuración
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Usuario no autenticado
        }
    }
}
