<%-- 
    Document   : agregarUsuario
    Created on : 18/09/2024, 3:46:53 p. m.
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
    <title>Agregar Usuario - CyberShield AI</title>
</head>
<body>
    <h1>Agregar Nuevo Usuario</h1>
    <form action="agregarUsuario" method="post">
        Nombre: <input type="text" name="nombre"><br>
        Correo Electrónico: <input type="email" name="correoElectronico"><br>
        Contraseña: <input type="password" name="contraseña"><br>
        Rol: <select name="rol">
            <option value="Usuario">Usuario</option>
            <option value="Administrador">Administrador</option>
        </select><br>
        Estado: <select name="estado">
            <option value="Activo">Activo</option>
            <option value="Inactivo">Inactivo</option>
        </select><br>
        <input type="submit" value="Agregar Usuario">
    </form>
</body>
</html>

