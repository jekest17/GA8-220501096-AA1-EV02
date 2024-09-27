/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.usuario;

import com.mycompany.cybershieldaiweb.dao.UsuarioDAO;
import com.mycompany.cybershieldaiweb.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editarUsuario")
public class EditarUsuarioServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    public EditarUsuarioServlet() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String nombre = request.getParameter("nombre");
        String correoElectronico = request.getParameter("correoElectronico");
        String contraseña = request.getParameter("contraseña");
        String rol = request.getParameter("rol");
        String estado = request.getParameter("estado");

        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        usuario.setNombre(nombre);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setContraseña(contraseña);
        usuario.setRol(rol);
        usuario.setEstado(estado);

        // Editar el usuario en la base de datos
        usuarioDAO.editarUsuario(usuario);

        // Redirigir a la página de gestión de identidades
        response.sendRedirect("gestionIdentidades.jsp");
    }
}
