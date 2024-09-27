<%-- 
    Document   : editarUsuario
    Created on : 18/09/2024, 3:48:02 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mycompany.cybershieldaiweb.dao.UsuarioDAO" %>
<%@ page import="com.mycompany.cybershieldaiweb.model.Usuario" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuario - CyberShield AI</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        /* Estilos Generales */
        body {
            margin: 0;
            padding: 0;
            font-family: 'Roboto', sans-serif;
            background-color: #0d0d2b;
            color: #fff;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .container {
            display: flex;
            flex: 1;
            overflow: hidden;
        }
        .sidebar {
            width: 250px;
            background-color: #131336;
            padding: 20px 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            position: fixed;
            height: 100vh;
        }
        .sidebar a {
            color: #fff;
            text-decoration: none;
            margin: 15px 0;
            padding: 10px;
            width: 100%;
            text-align: center;
            font-size: 18px;
            transition: 0.3s;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .sidebar a i {
            margin-right: 10px;
        }
        .sidebar a:hover {
            background-color: #bb86fc;
            color: #fff;
        }
        .content {
            flex: 1;
            padding: 30px;
            display: flex;
            flex-direction: column;
            overflow-y: auto;
            margin-left: 250px;
        }
        .header {
            margin-bottom: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        #editarUsuarioForm {
            max-width: 500px;
            padding: 20px;
            background-color: #1a1a3b;
            border-radius: 10px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: none;
            background-color: #2d2d4f;
            color: #fff;
        }
        /* Botón de Actualizar Usuario */
        #actualizarUsuarioBtn {
            background-color: #bb86fc;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1rem;
            width: 100%;
        }
        #actualizarUsuarioBtn:hover {
            background-color: #9f60db;
        }
        .footer {
            text-align: center;
            padding: 10px 0;
            color: #666;
            font-size: 0.8rem;
            background-color: #131336;
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Barra lateral -->
        <div class="sidebar">
            <a href="bienvenido.jsp" title="Dashboard"><i class="fas fa-home"></i> Inicio</a>
            <a href="detallesAnalisis.jsp" title="Detalles de Análisis"><i class="fas fa-chart-line"></i> Detalles de Análisis</a>
            <a href="configuracion.jsp" title="Configuración"><i class="fas fa-cogs"></i> Configuración</a>
            <a href="deteccionAmenazas.jsp" title="Detección de Amenazas"><i class="fas fa-shield-alt"></i> Detección de Amenazas</a>
            <a href="gestionIdentidades.jsp" title="Gestión de Identidades"><i class="fas fa-user-cog"></i> Gestión de Identidades</a>
        </div>

        <!-- Contenido Principal -->
        <div class="content">
            <div class="header">
                <h1>Editar Usuario</h1>
            </div>

            <%
                // Obtener el ID del usuario de la solicitud
                String idUsuarioStr = request.getParameter("id");
                int idUsuario = Integer.parseInt(idUsuarioStr);

                // Obtener los detalles del usuario de la base de datos
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.getUsuarioById(idUsuario);
            %>

            <form id="editarUsuarioForm" action="editarUsuario" method="post">
                <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>">
                
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" name="nombre" id="nombre" value="<%= usuario.getNombre() %>">
                </div>

                <div class="form-group">
                    <label for="correoElectronico">Correo Electrónico:</label>
                    <input type="email" name="correoElectronico" id="correoElectronico" value="<%= usuario.getCorreoElectronico() %>">
                </div>

                <div class="form-group">
                    <label for="contraseña">Contraseña:</label>
                    <input type="password" name="contraseña" id="contraseña" value="<%= usuario.getContraseña() %>">
                </div>

                <div class="form-group">
                    <label for="rol">Rol:</label>
                    <select name="rol" id="rol">
                        <option value="Usuario" <%= "Usuario".equals(usuario.getRol()) ? "selected" : "" %>>Usuario</option>
                        <option value="Administrador" <%= "Administrador".equals(usuario.getRol()) ? "selected" : "" %>>Administrador</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="estado">Estado:</label>
                    <select name="estado" id="estado">
                        <option value="Activo" <%= "Activo".equals(usuario.getEstado()) ? "selected" : "" %>>Activo</option>
                        <option value="Inactivo" <%= "Inactivo".equals(usuario.getEstado()) ? "selected" : "" %>>Inactivo</option>
                    </select>
                </div>

                <button type="submit" id="actualizarUsuarioBtn">Actualizar Usuario</button>
            </form>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        CyberShield 2024 - Desarrollado por JESSICA E
    </div>
</body>
</html>
