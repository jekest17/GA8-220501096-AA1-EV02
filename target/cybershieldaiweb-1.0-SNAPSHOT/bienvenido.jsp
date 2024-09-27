<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mycompany.cybershieldaiweb.model.Usuario" %>
<%@ page import="com.mycompany.cybershieldaiweb.dao.AmenazaDAO" %>
<%@ page import="com.mycompany.cybershieldaiweb.dao.UsuarioDAO" %>
<%@ page import="com.mycompany.cybershieldaiweb.dao.RecomendacionDAO" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard - CyberShield AI</title>
        <!-- Importación de Librerías -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
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
                margin-left: 250px; /* Mueve el contenido a la derecha de la barra lateral */
            }
            .header {
                margin-bottom: 20px;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .logout-button {
                background-color: #bb86fc;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
                font-size: 1rem;
            }
            .logout-button:hover {
                background-color: #9f60db;
            }
            .cards-grid {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                gap: 20px;
            }
            .card {
                background-color: #1a1a3b;
                border-radius: 10px;
                padding: 20px;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                text-align: center;
                position: relative;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                transition: transform 0.2s;
            }
            .card:hover {
                transform: scale(1.05);
            }
            .card h3 {
                margin-bottom: 10px;
                font-size: 1.2rem;
                color: #bb86fc;
            }
            .card span {
                font-size: 3rem;
                font-weight: bold;
                color: #bb86fc;
            }
            .card a.btn-link {
                color: #bb86fc; /* Mismo color que "Ver Detalles" */
                text-decoration: none; /* Sin subrayado */
                margin-top: 10px;
                transition: color 0.3s;
            }
            .card a.btn-link:hover {
                color: #9f60db; /* Color de hover */
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
            <!-- Sidebar Actualizada -->
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
                    <div>
                        <h1>Bienvenid@ 
                            <%
                                Usuario usuario = (Usuario) session.getAttribute("usuario");
                                if (usuario != null && usuario.getNombre() != null && !usuario.getNombre().isEmpty()) {
                                    out.print(" " + usuario.getNombre());
                                } else {
                                    out.print("Invitado");
                                }
                            %>
                        </h1>
                        <p>Dashboard</p>
                    </div>
                    <!-- Botón de Cerrar Sesión -->
                    <a href="index.html" class="logout-button">Cerrar Sesión</a>
                </div>

                <!-- Obtener datos para las tarjetas -->
                <%
                    AmenazaDAO amenazaDAO = new AmenazaDAO();
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    RecomendacionDAO recomendacionDAO = new RecomendacionDAO();

                    // Obtener el total de amenazas
                    int totalAmenazas = amenazaDAO.getTotalAmenazas();

                    // Obtener el total de usuarios
                    int totalUsuarios = usuarioDAO.getTotalUsuarios();

                    // Obtener el cumplimiento normativo (recomendaciones completadas)
                    int totalRecomendaciones = recomendacionDAO.getTotalRecomendaciones();
                    int recomendacionesCompletadas = recomendacionDAO.getRecomendacionesCompletadas();
                    int porcentajeCumplimiento = (int) ((recomendacionesCompletadas * 100.0) / totalRecomendaciones);
                %>

                <!-- Cuadrícula de Tarjetas -->
                <div class="cards-grid">
                    <!-- Total Amenazas -->
                    <div class="card">
                        <h3>Total de Amenazas Detectadas</h3>
                        <span><%= totalAmenazas %></span>
                        <a href="detallesAnalisis.jsp" class="btn-link">Ver Detalles</a>
                    </div>

                    <!-- Cumplimiento Normativo -->
                    <div class="card">
                        <h3>Cumplimiento Normativo</h3>
                        <span><%= porcentajeCumplimiento %>%</span>
                        <a href="mostrarRecomendaciones.jsp" class="btn-link">Ver Detalles</a>
                    </div>

                    <!-- Usuarios Autenticados -->
                    <div class="card">
                        <h3>Usuarios Autenticados</h3>
                        <span><%= totalUsuarios %></span>
                    </div>

                    <!-- Último Escaneo de Seguridad -->
                    <div class="card">
                        <h3>Último Escaneo de Seguridad</h3>
                        <p>Hace 1 hora</p>
                    </div>

                    <!-- Gestión de Identidades -->
                    <div class="card">
                        <h3>Gestión de Identidades</h3>
                        <p>Administrar usuarios y roles</p>
                        <a href="gestionIdentidades.jsp" class="btn-link">Ir a Gestión</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <div class="footer">
            CyberShield 2024 - Desarrollado por JESSICA E
        </div>
    </body>
</html>
