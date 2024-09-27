<%-- 
    Document   : gestionIdentidades
    Created on : 9/09/2024, 4:00:34 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.cybershieldaiweb.model.Usuario" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Gestión de Identidades - CyberShield AI</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
        .table-container {
            background-color: #1a1a3b;
            padding: 20px;
            border-radius: 10px;
            margin-top: 20px;
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

        .action-buttons {
            display: flex;
            gap: 10px;
        }

        .add-button,
        .edit-button,
        .delete-button {
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .add-button {
            background-color: #4caf50;
            color: #fff;
        }

        .edit-button {
            background-color: #2196f3;
            color: #fff;
        }

        .delete-button {
            background-color: #f44336;
            color: #fff;
        }
    </style>
    <script>
        function cargarUsuarios() {
            $.ajax({
                url: 'gestionIdentidades',  // URL del servlet
                method: 'GET',
                success: function(data) {
                    $('#usuariosTableBody').html($(data).find('#usuariosTableBody').html()); // Actualiza solo el cuerpo de la tabla
                }
            });
        }

        $(document).ready(function() {
            cargarUsuarios();
            setInterval(cargarUsuarios, 60000);
        });

        function eliminarUsuario(idUsuario) {
            if (confirm("¿Está seguro de que desea eliminar este usuario?")) {
                window.location.href = 'eliminarUsuario?id=' + idUsuario;
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
            <!-- Otros enlaces... -->
        </div>

        <!-- Contenido Principal -->
        <div class="content">
            <!-- Encabezado -->
            <div class="header">
                <h1>Gestión de Identidades</h1>
                <button class="add-button" onclick="window.location.href='agregarUsuario.jsp'">Agregar Usuario</button>
            </div>

            <!-- Tabla de Usuarios -->
            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>ID Usuario</th>
                            <th>Nombre</th>
                            <th>Correo Electrónico</th>
                            <th>Rol</th>
                            <th>Fecha de Creación</th>
                            <th>Fecha de Modificación</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody id="usuariosTableBody">
                        <% 
                            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                            if (usuarios != null) {
                                for (Usuario usuario : usuarios) {
                        %>
                            <tr>
                                <td><%= usuario.getIdUsuario() %></td>
                                <td><%= usuario.getNombre() %></td>
                                <td><%= usuario.getCorreoElectronico() %></td>
                                <td><%= usuario.getRol() %></td>
                                <td><%= usuario.getFechaCreacion() %></td>
                                <td><%= usuario.getFechaModificacion() %></td>
                                <td><%= usuario.getEstado() %></td>
                                <td class="action-buttons">
                                    <button class="edit-button" onclick="window.location.href='editarUsuario.jsp?id=<%= usuario.getIdUsuario() %>'">Editar</button>
                                    <button class="delete-button" onclick="eliminarUsuario(<%= usuario.getIdUsuario() %>)">Eliminar</button>
                                </td>
                            </tr>
                        <% 
                                }
                            } else {
                        %>
                            <tr>
                                <td colspan="8" style="text-align:center;">No se encontraron usuarios.</td>
                            </tr>
                        <% 
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>

</html>
