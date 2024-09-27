<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - CyberShield AI</title>
    <style>
        /* Mantén todos tus estilos aquí */
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

        .sidebar::-webkit-scrollbar {
            display: none;
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
            display: flex;
            flex-direction: column;
        }

        .main-content {
            flex: 1;
            display: flex;
            flex-direction: column;
            gap: 30px;
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
            text-decoration: none;
        }

        .logout-button:hover {
            background-color: #9f60db;
        }

        .cards-grid {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 30px;
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
        }

        .card h3 {
            margin-bottom: 10px;
            font-size: 1.2rem;
            color: #bb86fc;
        }

        .card p {
            font-size: 2rem;
            color: #fff;
        }

        .card span {
            font-size: 3rem;
            font-weight: bold;
            color: #bb86fc;
        }

        .chart-container {
            width: 100%;
            height: 250px;
            display: flex;
            justify-content: center;
            align-items: center;
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
            <!-- Enlaces del sidebar -->
            <a href="bienvenido.jsp" title="Dashboard">🏠</a>
            ...
        </div>

        <!-- Contenido Principal -->
        <div class="content">
            <!-- Encabezado -->
            <div class="header">
                <div>
                    <h1>Bienvenid@ <%= request.getAttribute("nombreUsuario") %></h1> <!-- Mostrar nombre del usuario -->
                    <p>Dashboard</p>
                </div>
                <!-- Botón de Cerrar Sesión -->
                <a href="index.html" class="logout-button">Cerrar Sesión</a>
            </div>

            <!-- Contenido Principal -->
            <div class="main-content">
                <!-- Cuadrícula de Tarjetas -->
                <div class="cards-grid">
                    <!-- Total Amenazas -->
                    <div class="card">
                        <h3>Total de Amenazas Detectadas</h3>
                        <span><%= request.getAttribute("totalAmenazas") %></span>
                    </div>

                    <!-- Cumplimiento Normativo -->
                    <div class="card">
                        <h3>Cumplimiento Normativo</h3>
                        <span><%= request.getAttribute("cumplimientoNormativo") %>%</span>
                    </div>

                    <!-- Usuarios Autenticados -->
                    <div class="card">
                        <h3>Total de Logs Registrados</h3>
                        <span><%= request.getAttribute("totalLogs") %></span>
                    </div>

                    <!-- Eventos Recientes -->
                    <div class="card large">
                        <h3>Eventos Recientes</h3>
                        <ul>
                            <% 
                                List<Evento> eventosRecientes = (List<Evento>) request.getAttribute("eventosRecientes");
                                for (Evento evento : eventosRecientes) {
                            %>
                                <li><%= evento.getNombre() %>: <%= evento.getDescripcion() %></li>
                            <% } %>
                        </ul>
                    </div>

                    <!-- Logs Recientes -->
                    <div class="card large">
                        <h3>Logs Recientes</h3>
                        <ul>
                            <% 
                                List<Log> logsRecientes = (List<Log>) request.getAttribute("logsRecientes");
                                for (Log log : logsRecientes) {
                            %>
                                <li><%= log.getAccion() %>: <%= log.getDescripcion() %></li>
                            <% } %>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        CyberShield 2024 - Desarrollado por JESSICA E
    </div>

    <!-- Librería Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        const ctxAmenazas = document.getElementById('chartAmenazas').getContext('2d');
        const chartAmenazas = new Chart(ctxAmenazas, {
            type: 'bar',
            data: {
                labels: ['Ene', 'Feb', 'Mar', 'Abr', 'May'],
                datasets: [{
                    label: 'Amenazas Detectadas',
                    data: [5, 10, 8, 15, 9],
                    backgroundColor: '#bb86fc'
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        labels: {
                            color: '#fff'
                        }
                    }
                },
                scales: {
                    x: {
                        ticks: {
                            color: '#fff'
                        }
                    },
                    y: {
                        ticks: {
                            color: '#fff'
                        }
                    }
                }
            }
        });
    </script>
</body>

</html>
