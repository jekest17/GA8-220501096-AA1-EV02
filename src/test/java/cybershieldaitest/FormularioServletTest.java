/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cybershieldaitest;

import com.mycompany.cybershieldaiweb.FormularioServlet;
import com.mycompany.cybershieldaiweb.model.Usuario;
import com.mycompany.cybershieldaiweb.util.DatabaseUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DatabaseUtil.class})  // Indicar que queremos preparar DatabaseUtil para los tests
public class FormularioServletTest {

    @InjectMocks
    private FormularioServlet formularioServlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private Connection conn;

    @Mock
    private PreparedStatement stmt;

    @Mock
    private ResultSet rs;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa los mocks
        PowerMockito.mockStatic(DatabaseUtil.class);  // Simular métodos estáticos
    }

    @Test
public void testDoPostCorrectCredentials() throws Exception {
    // Simular el RequestDispatcher
    RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

    // Configurar el request con credenciales correctas
    when(request.getParameter("usuario")).thenReturn("test@ejemplo.com");
    when(request.getParameter("clave")).thenReturn("password123");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("bienvenido.jsp")).thenReturn(requestDispatcher); // Simulación de la redirección

    // Simular la conexión a la base de datos
    when(DatabaseUtil.getConnection()).thenReturn(conn);
    when(conn.prepareStatement(anyString())).thenReturn(stmt);
    when(stmt.executeQuery()).thenReturn(rs);
    when(rs.next()).thenReturn(true); // Simula que se encontró un usuario

    // Ejecutar el método doPost
    formularioServlet.doPost(request, response);

    // Verificar que el usuario fue guardado en la sesión
    verify(session).setAttribute(eq("usuario"), any(Usuario.class));
    verify(requestDispatcher).forward(request, response); // Verificar que se llamó a forward
}

@Test
public void testDoPostInvalidCredentials() throws Exception {
    // Simular el RequestDispatcher
    RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

    // Configurar el request con credenciales incorrectas
    when(request.getParameter("usuario")).thenReturn("wrong@ejemplo.com");
    when(request.getParameter("clave")).thenReturn("wrongpassword");
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("error.jsp")).thenReturn(requestDispatcher); // Simulación de la redirección

    // Simular la conexión a la base de datos
    when(DatabaseUtil.getConnection()).thenReturn(conn);
    when(conn.prepareStatement(anyString())).thenReturn(stmt);
    when(stmt.executeQuery()).thenReturn(rs);
    when(rs.next()).thenReturn(false); // Simula que no se encontró un usuario

    // Ejecutar el método doPost
    formularioServlet.doPost(request, response);

    // Verificar que se estableció el atributo de error
    verify(request).setAttribute(eq("error"), eq("Usuario o Clave incorrectos"));
    verify(requestDispatcher).forward(request, response); // Verificar que se llamó a forward
}

}
