<%-- 
    Document   : mostrarRecomendaciones
    Created on : 20/09/2024, 12:32:29 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.cybershieldaiweb.model.Recomendacion" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Recomendaciones - CyberShield AI</title>
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
        function cargarRecomendaciones() {
            $.ajax({
                url: 'mostrarRecomendaciones',  // URL del servlet
                method: 'GET',
                success: function(data) {
                    $('#recomendacionesTableBody').html($(data).find('#recomendacionesTableBody').html());
                }
            });
        }

        $(document).ready(function() {
            cargarRecomendaciones();
            setInterval(cargarRecomendaciones, 60000);  // Actualizar cada 60 segundos
        });

        function confirmarCambio(idRecomendacion) {
            if (confirm("¿Está seguro de que desea marcar esta recomendación como completada?")) {
                document.getElementById('form-cambiar-' + idRecomendacion).submit();
            }
        }
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
        
    <div class="content">
        <div class="header">
        <h1>Lista de Recomendaciones</h1>
        </div>
        <!-- Botón para generar el informe en PDF -->
        <div class="button-container">
        <!-- Botón para generar el informe en PDF -->
        <button class="predictive-button" onclick="window.location.href='generarInformePDF'">Generar Informe PDF</button>
        <div style="text-align: left; margin-bottom: 20px;">
        </div>
        </div>
        <!-- Tabla de recomendaciones -->
        <div class="analysis-table-container">
          <div id="recomendacionesContainer">  
        <table class="analysis-table" id="recomendacionesTable">
                <tr>
                    <th>ID Recomendación</th>
                    <th>Descripción</th>
                    <th>Nivel de Urgencia</th>
                    <th>Amenaza</th> <!-- Nueva columna para la amenaza -->
                    <th>Estado de Implementación</th>
                    <th>Fecha de Completado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody id="recomendacionesTableBody">
                <% 
                    List<Recomendacion> listaRecomendaciones = (List<Recomendacion>) request.getAttribute("recomendaciones");
                    if (listaRecomendaciones != null) {
                        for (Recomendacion recomendacion : listaRecomendaciones) {
                %>
                    <tr>
                        <td><%= recomendacion.getidRecomendacion() %></td>
                        <td><%= recomendacion.getDescripcion() %></td>
                        <td><%= recomendacion.getNivelUrgencia() %></td>
                        <td><%= recomendacion.getAmenaza_idAmenaza() %></td> <!-- Mostrar el ID de la amenaza -->
                        <td><%= recomendacion.getestadoImplementacion() %></td>
                        <td>
                            <%= (recomendacion.getestadoImplementacion().equals("Completado")) 
                                ? recomendacion.getfechaCompletado() 
                                : "N/A" %>
                        </td>
                        <td>
                            <% if (recomendacion.getestadoImplementacion().equals("Pendiente")) { %>
                                <form id="form-cambiar-<%= recomendacion.getidRecomendacion() %>" 
                                      action="cambiarEstadoRecomendacion" method="post">
                                    <input type="hidden" name="idRecomendacion" value="<%= recomendacion.getidRecomendacion() %>">
                                    <button type="button" class="complete-btn" 
                                            onclick="confirmarCambio(<%= recomendacion.getidRecomendacion() %>)">
                                        Marcar como Completado
                                    </button>
                                </form>
                            <% } else { %>
                                <span>Completado</span>
                            <% } %>
                        </td>
                    </tr>
                <% 
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="7">No hay recomendaciones disponibles.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
