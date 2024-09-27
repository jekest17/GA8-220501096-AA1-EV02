<%-- 
    Document   : analisisPredictivo
    Created on : 9/09/2024, 4:01:24 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.cybershieldaiweb.model.Analisis" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Análisis Predictivo</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
        /* Estilos específicos para esta página */
        .container {
            display: flex;
            height: 100vh;
            background-color: #0d0d2b; /* Fondo oscuro para la aplicación */
        }

        .sidebar {
            width: 250px;
            background-color: #131336;
            padding: 20px 0; /* Asegura que el padding sea uniforme */
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 10px; /* Ajusta este valor para igualar el espacio entre los elementos */
            height: 100%;
            position: fixed;
        }

        .sidebar a {
            color: #fff;
            text-decoration: none;
            margin: 10px 0; /* Asegúrate de que los márgenes sean iguales */
            padding: 10px;
            width: 100%;
            text-align: left;
            font-size: 18px;
            transition: 0.3s;
            display: flex;
            align-items: center;
            justify-content: center;
            line-height: 1.5; /* Ajusta el line-height para un espaciado uniforme */
        }

        .sidebar a i {
            margin-right: 10px; /* Espacio uniforme entre el icono y el texto */
        }

        .sidebar a:hover {
            background-color: #bb86fc;
            color: #fff;
        }

        .content {
            margin-left: 250px; /* Mueve el contenido a la derecha de la barra lateral */
            padding: 30px;
            display: flex;
            flex-direction: column;
            overflow-y: auto;
            width: calc(100% - 250px); /* Ajusta el ancho del contenido */
            background-color: #0d0d2b; /* Fondo oscuro para la sección de contenido */
            color: #fff; /* Color del texto en el contenido */
        }

        .header {
            display: flex;
            flex-direction: column; /* Cambiado para alineación */
            align-items: flex-start; /* Alineación a la izquierda */
            margin-bottom: 20px;
            width: 100%;
        }

        .header h1 {
            margin: 0; /* Sin margen para mejor alineación */
            margin-bottom: 10px; /* Espacio entre el título y los botones */
        }

        .button-container {
            display: flex;
            gap: 10px; /* Espaciado entre los botones */
        }

        .refresh-button, .predictive-button {
            padding: 10px 20px;
            background-color: #bb86fc;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .refresh-button:hover, .predictive-button:hover {
            background-color: #9f60db;
        }

        .analysis-table-container {
            width: 100%;
            max-width: 1000px; /* Limitar el ancho para mejorar la legibilidad */
            margin-top: 20px;
        }

        .analysis-table {
            width: 100%;
            border-collapse: collapse;
            background-color: #1a1a3b;
            color: #fff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        
        .analysis-table th, .analysis-table td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #333;
        }

        .analysis-table th {
            background-color: #131336;
            color: #fff;
        }
        
        .analysis-table tr:hover {
            background-color: #2a2d3e;
        }
    </style>
    <script>
        function cargarAnalisis() {
            $.ajax({
                url: 'analisis',  // URL del servlet
                method: 'GET',
                success: function(data) {
                    $('#analisisTableBody').html($(data).find('#analisisTableBody').html());
                }
            });
        }

        $(document).ready(function() {
            cargarAnalisis();
            setInterval(cargarAnalisis, 60000);  // Actualizar cada 60 segundos
        });
    </script>
    
</head>
<body>
    <div class="container">
        <!-- Sidebar -->
        <div class="sidebar">
            <a href="bienvenido.jsp" title="Dashboard"><i class="fas fa-home"></i> Inicio</a>
            <a href="detallesAnalisis.jsp" title="Detalles de Análisis"><i class="fas fa-chart-line"></i> Detalles de Análisis</a>
            <a href="configuracion.jsp" title="Configuración"><i class="fas fa-cogs"></i> Configuración</a>
            <a href="gestionIdentidades.jsp" title="Gestión de Identidades"><i class="fas fa-user-cog"></i> Gestión de Identidades</a>
        </div>

        <!-- Contenido Principal -->
        <div class="content">
            <!-- Encabezado -->
            <div class="header">
                <h1>Análisis Predictivo</h1>
                <div class="button-container">
                    <!-- Botón para ir a Detalles de Sistemas -->
                    <button class="predictive-button" onclick="window.location.href='sistemas.jsp'">Detalles de Sistemas</button>
                    <!-- Botón para ir a Recomendaciones-->
                    <button class="predictive-button" onclick="window.location.href='mostrarRecomendaciones.jsp'">Recomendaciones</button>
                </div>
            </div>

            <!-- Contenedor de la tabla de amenazas -->
            <div class="analysis-table-container">
                <div id="amenazasContainer">
                    <table class="analysis-table" id="amenazasTable">
                        <tr>
                            <th>ID Análisis</th>
                            <th>Fecha</th>
                            <th>Resultado</th>
                            <th>Usuario</th>
                            <th>Sistema</th>
                            <th>Nivel de Criticidad</th>
                            <th>Detalles</th>
                        </tr>
                        <tbody id="analisisTableBody">
                        <% 
                            List<Analisis> listaAnalisis = (List<Analisis>) request.getAttribute("analisis");
                            if (listaAnalisis != null) {
                                for (Analisis analisis : listaAnalisis) {
                        %>
                            <tr>
                                <td><%= analisis.getIdAnalisis() %></td>
                                <td><%= analisis.getFecha() %></td>
                                <td><%= analisis.getResultado() %></td>
                                <td><%= analisis.getUsuario_idUsuario() %></td>
                                <td><%= analisis.getSistema_idSistema() %></td>
                                <td><%= analisis.getNivelCriticidad() %></td>
                                <td><%= analisis.getDetalle() %></td>
                            </tr>
                        <% 
                                }
                            }
                        %>
                    </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
