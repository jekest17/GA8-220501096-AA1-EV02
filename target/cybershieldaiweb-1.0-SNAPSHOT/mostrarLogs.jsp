<%-- 
    Document   : mostrarLogs
    Created on : 21/09/2024, 7:29:49 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.cybershieldaiweb.model.Logs" %>
<!DOCTYPE html>
<html>
<head>
    <title>Logs - CyberShield AI</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Lista de Logs</h1>

    <table border="1">
        <tr>
            <th>ID Log</th>
            <th>ID Usuario</th>
            <th>Acción</th>
            <th>Fecha de Acción</th>
        </tr>
        <tbody>
            <%
                List<Logs> listaLogs = (List<Logs>) request.getAttribute("logs");
                if (listaLogs != null) {
                    for (Logs log : listaLogs) {
            %>
                <tr>
                    <td><%= log.getidLog() %></td>
                    <td><%= log.getUsuarioidUsuario() %></td>
                    <td><%= log.getAccion() %></td>
                    <td><%= log.getFechaAccion() %></td>
                </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>

