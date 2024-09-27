<%-- 
    Document   : ajustesParametros
    Created on : 10/09/2024, 1:13:58 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajustes de Parámetros - CyberShield AI</title>
    <style>
        /* Estilos Generales */
        body {
            margin: 0;
            padding: 0;
            font-family: 'Roboto', sans-serif;
            background-color: #0d0d2b;
            color: #fff;
        }

        .container {
            display: flex;
            height: 100vh;
        }

        .sidebar {
            width: 80px;
            background-color: #131336;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px 0;
            gap: 8px;
            height: 100%;
            overflow-y: auto;
            scrollbar-width: none;
        }

        .sidebar a {
            color: #fff;
            text-decoration: none;
            font-size: 24px;
            margin-bottom: 20px;
        }

        .sidebar a:hover {
            color: #bb86fc;
        }

        .content {
            flex: 1;
            padding: 30px;
            overflow-y: auto;
        }

        .header {
            margin-bottom: 20px;
        }

        .form-container {
            background-color: #1a1a3b;
            padding: 20px;
            border-radius: 10px;
        }

        .form-container label,
        .form-container input {
            display: block;
            width: 100%;
            margin-bottom: 10px;
            color: #fff;
        }

        .form-container input[type="text"],
        .form-container input[type="email"],
        .form-container input[type="password"],
        .form-container select {
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #0d0d2b;
            color: #fff;
        }

        .form-container button {
            padding: 10px 20px;
            background-color: #bb86fc;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .form-container button:hover {
            background-color: #9c6cc4;
        }
        
          /* Estilo para el mensaje de confirmación */
        .confirmation-message {
            color: #bb86fc;
            font-size: 0.9rem;
            display: none; /* Oculto por defecto */
        }
    </style>
</head>

<body>
    <div class="container">
        <!-- Sidebar -->
         <div class="sidebar">
            <a href="bienvenido.jsp" title="Dashboard">🏠</a>
            <a href="detallesAnalisis.jsp" title="Detalles de Análisis">📊</a>
            <a href="configuracion.jsp" title="Configuración">⚙️</a>
            <a href="deteccionAmenazas.jsp" title="Detección de Amenazas">🛡️</a>
            <a href="analisisComportamiento.jsp" title="Análisis del Comportamiento">📈</a>
            <a href="gestionIdentidades.jsp" title="Gestión de Identidades">👥</a>
            <a href="analisisPredictivo.jsp" title="Análisis Predictivo">🔮</a>
            <a href="auditoriaCumplimiento.jsp" title="Auditoría y Cumplimiento">📜</a>
            <a href="comunicacionSegura.jsp" title="Comunicación Segura">✉️</a>
            <a href="personalizacionConfiguracion.jsp" title="Personalización y Configuración">🔧</a>
            <a href="ajustesParametros.jsp" title="Ajustes de Parámetros">⚙️</a>
        </div>

        <!-- Contenido Principal -->
        <div class="content">
            <!-- Encabezado -->
            <div class="header">
                <h1>Ajustes de Parámetros</h1>
            </div>

            <!-- Formulario de Ajustes de Parámetros -->
            <div class="form-container">
                <form>
                    <label for="sensitivity">Sensibilidad del sistema de detección:</label>
                    <select id="sensitivity" name="sensitivity">
                        <option value="high">Alta</option>
                        <option value="medium">Media</option>
                        <option value="low">Baja</option>
                    </select>

                    <label for="anomaly-threshold">Umbral de alerta para comportamiento anómalo:</label>
                    <input type="text" id="anomaly-threshold" name="anomaly-threshold" value="90%" />

                    <label for="malware-signatures">Lista de firmas de malware actualizada:</label>
                    <input type="text" id="malware-signatures" name="malware-signatures" value="Hace 1 hora" />

                    <button type="button" onclick="guardarParametros()">Guardar Parámetros</button>
                    <span class="confirmation-message" id="confirmMessage">Cambios guardados</span>
                </form>
            </div>
        </div>
    </div>

<script>
        function guardarParametros() {
            // Mostrar el mensaje de confirmación
            document.getElementById('confirmMessage').style.display = 'inline';
            
            // Ocultar el mensaje después de 3 segundos
            setTimeout(() => {
                document.getElementById('confirmMessage').style.display = 'none';
            }, 3000);
        }
    </script>
    
</body>

</html>

