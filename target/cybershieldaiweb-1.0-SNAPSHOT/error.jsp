<%-- 
    Document   : error
    Created on : 5/09/2024, 1:41:16 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error de Inicio de Sesión - CyberShield AI</title>
    <link rel="stylesheet" href="css/style.css"> <!-- Se usó el mismo archivo CSS para mantener el estilo -->
    <link rel="icon" href="images/favicon.png"> <!-- Icono de la página -->
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- Contenedor Principal -->
    <div class="login-container">
        <!-- Sección Izquierda (Mensaje de Error) -->
        <div class="login-form">
            <h1>Error de Inicio de Sesión</h1>
            
            <!-- Mostrar mensaje de error -->
            <c:if test="${errorExist}">
                <div class="error-message">${error}</div>
            </c:if>

            <p>Por favor, verifica tu usuario y contraseña e inténtalo de nuevo.</p>

            <!-- Botón para Volver a Intentar -->
            <a href="index.html" class="btn-submit">Volver a Intentar</a>
        </div>

        <!-- Sección Derecha (Información) -->
        <div class="info-section">
            <img src="images/logo.png" alt="Logo CyberShield AI">
            <p>Conoce más de CyberShield AI en <a href="https://cybershieldai.com" target="_blank">cybershieldai.com</a></p>
        </div>
    </div>

    <!-- JavaScript para Mostrar/Ocultar Contraseña -->
    <script>
        function togglePasswordVisibility() {
            const passwordInput = document.getElementById('clave');
            const type = passwordInput.type === 'password' ? 'text' : 'password';
            passwordInput.type = type;
        }
    </script>
</body>
</html>

