<%-- 
    Document   : auditoriaCumplimiento
    Created on : 10/09/2024, 1:08:57 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Auditoría y Cumplimiento - CyberShield AI</title>
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
                <h1>Auditoría y Cumplimiento</h1>
            </div>

            <!-- Tabla de Auditoría -->
            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Acción</th>
                            <th>Usuario</th>
                            <th>Fecha y Hora</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Cambio de contraseña de usuario</td>
                            <td>Administrador</td>
                            <td>2024-05-10 10:15:32</td>
                        </tr>
                        <tr>
                            <td>Acceso a recurso restringido</td>
                            <td>Usuario E</td>
                            <td>2024-05-09 14:20:18</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>

</html>
