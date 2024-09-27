<%-- 
    Document   : registro
    Created on : 5/09/2024, 1:29:09 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario - CyberShield AI</title>
    <link rel="stylesheet" href="css/style.css"> <!-- Reutiliza el mismo archivo CSS -->
    <link rel="icon" href="images/favicon.png"> <!-- Icono de la página -->
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- Contenedor Principal -->
    <div class="login-container">
        <!-- Sección Izquierda (Formulario) -->
        <div class="login-form">
            <h1>Registro de Usuario</h1>
            <p>Crea tu cuenta para acceder a CyberShield AI.</p>

            <!-- Mostrar mensajes de error si existen -->
            <%
                String mensajeError = (String) request.getAttribute("mensajeError");
                if (mensajeError != null) {
                    out.println("<div class='error-message'>" + mensajeError + "</div>");
                }
            %>

            <!-- Formulario de Registro -->
            <form action="registrarUsuario" method="post">
                <div class="input-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" value="<%= request.getAttribute("nombre") != null ? request.getAttribute("nombre") : "" %>" placeholder="Tu Nombre" required>
                </div>

                <div class="input-group">
                    <label for="correo">Correo Electrónico:</label>
                    <input type="email" id="correo" name="correo" value="<%= request.getAttribute("correo") != null ? request.getAttribute("correo") : "" %>" placeholder="correo@company.com" required>
                </div>

                <div class="input-group">
                    <label for="clave">Contraseña:</label>
                    <input type="password" id="clave" name="clave" placeholder="Mínimo 8 caracteres" required>
                </div>

                <button type="submit" class="btn-submit">Registrar</button>
            </form>

            <p>¿Ya tienes cuenta? <a href="index.html" class="create-account-link">Inicia sesión aquí</a></p>
        </div>

        <!-- Sección Derecha (Información) -->
        <div class="info-section">
            <img src="images/logo.png" alt="Logo CyberShield AI">
            <p>Conoce más de CyberShield AI en <a href="https://cybershieldai.com" target="_blank">cybershieldai.com</a></p>
        </div>
    </div>
</body>
</html>
