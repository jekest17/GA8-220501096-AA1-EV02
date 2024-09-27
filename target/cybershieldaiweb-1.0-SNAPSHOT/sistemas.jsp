<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.cybershieldaiweb.model.Sistema" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sistemas - CyberShield AI</title>
        <link rel="stylesheet" href="css/style.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <style>
            /* Añade el estilo según lo que necesitas */
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

            .system-table-container {
                width: 100%;
                max-width: 1000px; /* Limitar el ancho para mejorar la legibilidad */
                margin-top: 20px;
            }
            .system-table {
                width: 100%;
                border-collapse: collapse;
                background-color: #1a1a3b;
                color: #fff;
                border-radius: 10px;
                overflow: hidden;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }
            .system-table th, .system-table td {
                padding: 15px;
                text-align: left;
                border-bottom: 1px solid #333;
            }
            .system-table th {
                background-color: #131336;
                color: #fff;
            }
            .system-table tr:hover {
                background-color: #2a2d3e;
            }
        </style>
        <script>
            function cargarSistemas() {
                $.ajax({
                    url: 'mostrarSistemas', // URL del servlet
                    method: 'GET',
                    success: function (data) {
                        $('#sistemasTableBody').html($(data).find('#sistemasTableBody').html());
                    }
                });
            }

            $(document).ready(function () {
                cargarSistemas();  // Carga inicial
                setInterval(cargarSistemas, 60000);  // Actualizar cada 60 segundos
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
                <h1>Detalles de Sistemas</h1>
                
            </div>
                
                <table class="system-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                        </tr>
                    </thead>
                    <tbody id="sistemasTableBody">
                        <% 
                            List<Sistema> listaSistemas = (List<Sistema>) request.getAttribute("sistemas");
                            if (listaSistemas != null) {
                                for (Sistema sistema : listaSistemas) {
                        %>
                        <tr>
                            <td><%= sistema.getidSistema() %></td>
                            <td><%= sistema.getNombre() %></td>
                            <td><%= sistema.getDescripcion() %></td>
                        </tr>
                        <% 
                                }
                            } else {
                        %>
                        <tr>
                            <td colspan="3">No hay sistemas disponibles.</td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div> 
        </div>
    </body>
</html>

