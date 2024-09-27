<%-- 
    Document   : configuracion
    Created on : 6/09/2024, 1:00:10 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mycompany.cybershieldaiweb.model.Configuracion" %>
<%@ page import="com.mycompany.cybershieldaiweb.model.Usuario" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Configuración</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
        /* Estilos Generales Mejorados */
        body {
            margin: 0;
            padding: 0;
            font-family: 'Roboto', sans-serif;
            background-color: #0d0d2b;
            color: #fff;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .container {
            display: flex;
            flex: 1;
            overflow: hidden;
        }
        .sidebar {
            width: 250px;
            background-color: #131336;
            padding: 20px 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            position: fixed;
            height: 100vh;
        }
        .sidebar a {
            color: #fff;
            text-decoration: none;
            margin: 15px 0;
            padding: 10px;
            width: 100%;
            text-align: center;
            font-size: 18px;
            transition: 0.3s;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .sidebar a i {
            margin-right: 10px; /* Espacio entre el icono y el texto */
        }
        .sidebar a:hover {
            background-color: #bb86fc;
            color: #fff;
        }
        .content {
            flex: 1;
            padding: 30px;
            display: flex;
            flex-direction: column;
            overflow-y: auto;
            margin-left: 250px;
        }
        .header {
            margin-bottom: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        /* Formulario alineado a la izquierda */
        #configuracionForm {
            max-width: 500px;
            padding: 20px;
            background-color: #1a1a3b;
            border-radius: 10px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group select {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: none;
            background-color: #2d2d4f;
            color: #fff;
        }
        /* Botón de Guardar Cambios con el mismo estilo que Cerrar Sesión */
        #guardarCambiosBtn {
            background-color: #bb86fc;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1rem;
            width: 100%; /* Para que el botón ocupe todo el ancho del formulario */
        }
        #guardarCambiosBtn:hover {
            background-color: #9f60db;
        }
        .footer {
            text-align: center;
            padding: 10px 0;
            color: #666;
            font-size: 0.8rem;
            background-color: #131336;
            width: 100%;
        }
    </style>

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
            <div class="header">
                <h1>Configuración</h1>
            </div>

            <form id="configuracionForm">
                <div class="form-group">
                    <label for="alertas">Configuración de Alertas:</label>
                    <select name="alertas" id="alertas">
                        <option value="email">Correo Electrónico</option>
                        <option value="app">Aplicación</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="frecuencia">Frecuencia de Escaneo Automático:</label>
                    <select name="frecuencia" id="frecuencia">
                        <option value="diario">Diario</option>
                        <option value="semanal">Semanal</option>
                        <option value="mensual">Mensual</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="idioma">Idioma de la Interfaz:</label>
                    <select name="idioma" id="idioma">
                        <option value="es">Español</option>
                        <option value="en">Inglés</option>
                    </select>
                </div>

                <button type="button" id="guardarCambiosBtn">Guardar Cambios</button>
            </form>

            <div id="resultado" style="margin-top: 20px;"></div>
        </div>
    </div>

    <script>
        // Cargar la configuración al cargar la página
        function cargarConfiguracion() {
            $.ajax({
                url: 'cargarConfiguracion',  // URL del servlet para cargar configuración
                method: 'GET',
                success: function (data) {
                    if (data) {
                        $('#alertas').val(data.alertas);
                        $('#frecuencia').val(data.frecuencia);
                        $('#idioma').val(data.idioma);
                    }
                }
            });
        }

        // Guardar la configuración al hacer clic en el botón
        $('#guardarCambiosBtn').on('click', function () {
            var formData = {
                alertas: $('#alertas').val(),
                frecuencia: $('#frecuencia').val(),
                idioma: $('#idioma').val()
            };

            $.ajax({
                url: 'guardarConfiguracion',  // URL del servlet para guardar configuración
                method: 'POST',
                data: formData,
                success: function (response) {
                    $('#resultado').html('<p>Configuración guardada exitosamente.</p>');
                },
                error: function () {
                    $('#resultado').html('<p>Error al guardar la configuración.</p>');
                }
            });
        });

        // Llamar a la función para cargar la configuración al cargar la página
        $(document).ready(function () {
            cargarConfiguracion();
        });
    </script>
</body>
</html>
