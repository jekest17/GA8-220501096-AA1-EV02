<%-- 
    Document   : confirmarCorreo
    Created on : 12/09/2024, 2:51:57 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmar Correo Electrónico - CyberShield AI</title>
    <link rel="stylesheet" href="css/style.css"> <!-- Reutiliza el mismo archivo CSS -->
    <link rel="icon" href="images/favicon.png"> <!-- Icono de la página -->
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- Contenedor Principal -->
    <div class="login-container">
        <!-- Sección Información -->
        <div class="info-section">
            <h1>Confirmación de Correo Electrónico</h1>
            <p>Hemos enviado un código de confirmación a tu correo electrónico. Por favor, ingrésalo a continuación para completar tu registro.</p>

            <!-- Formulario de Confirmación -->
            <form action="confirmarCodigo" method="post">
                <div class="input-group">
                    <label for="codigo">Código de Confirmación:</label>
                    <input type="text" id="codigo" name="codigo" placeholder="Ingrese su código" required>
                </div>

                <button type="submit" class="btn-submit">Confirmar</button>
            </form>
        </div>
    </div>
</body>
</html>

