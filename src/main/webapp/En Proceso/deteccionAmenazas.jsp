<%-- 
    Document   : deteccionAmenazas
    Created on : 9/09/2024, 3:55:18 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detección de Amenazas - CyberShield AI</title>
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

        .table-container {
            background-color: #1a1a3b;
            padding: 20px;
            border-radius: 10px;
        }

        .table-container table {
            width: 100%;
            border-collapse: collapse;
            color: #fff;
        }

        .table-container th,
        .table-container td {
            padding: 10px;
            text-align: left;
        }

        .table-container th {
            background-color: #0d0d2b;
            color: #bb86fc;
        }

        .table-container td {
            background-color: #131336;
        }

        .table-container tr:hover td {
            background-color: #292948;
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
                <h1>Detección de Amenazas</h1>
            </div>

            <!-- Tabla de Amenazas -->
            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Amenaza</th>
                            <th>Descripción</th>
                            <th>Gravedad</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Amenaza 1</td>
                            <td>Malware detectado en equipo de usuario A</td>
                            <td>Alta</td>
                            <td>Cuarentena del equipo, notificación al administrador</td>
                        </tr>
                        <tr>
                            <td>Amenaza 2</td>
                            <td>Intento de intrusión en servidor web</td>
                            <td>Media</td>
                            <td>Bloqueo de IP, registro de actividad</td>
                        </tr>
                        <tr>
                            <td>Amenaza 3</td>
                            <td>Ataque de phishing detectado en correo electrónico corporativo</td>
                            <td>Alta</td>
                            <td>Bloqueo del remitente, advertencia a los usuarios</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>

</html>
