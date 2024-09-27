<%-- 
    Document   : confirmarEliminacionUsuario
    Created on : 18/09/2024, 3:48:24 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Confirmar Eliminación de Usuario - CyberShield AI</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Confirmar Eliminación de Usuario</h1>

    <%
        // Obtener el ID del usuario de la solicitud
        String idUsuarioStr = request.getParameter("id");
        int idUsuario = Integer.parseInt(idUsuarioStr);
    %>

    <p>¿Está seguro de que desea eliminar el usuario con ID <strong><%= idUsuario %></strong>?</p>

    <!-- Botones para confirmar o cancelar la eliminación -->
    <form action="eliminarUsuario" method="get" style="display: inline-block;">
        <input type="hidden" name="id" value="<%= idUsuario %>">
        <input type="submit" value="Confirmar Eliminación" class="delete-button">
    </form>
    <a href="gestionIdentidades.jsp" class="cancel-button">Cancelar</a>

    <style>
        .delete-button {
            background-color: #f44336;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            margin-right: 10px;
        }

        .cancel-button {
            background-color: #2196f3;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
        }
    </style>
</body>
</html>
