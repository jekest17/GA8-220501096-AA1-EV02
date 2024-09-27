/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cybershieldaitest;

import com.mycompany.cybershieldaiweb.AnalisisServlet;
import com.mycompany.cybershieldaiweb.dao.AnalisisDAO;
import com.mycompany.cybershieldaiweb.model.Analisis;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class AnalisisServletTest {

    @InjectMocks
    private AnalisisServlet analisisServlet;

    @Mock
    private AnalisisDAO analisisDAO;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(request.getRequestDispatcher("analisisPredictivo.jsp")).thenReturn(requestDispatcher);
    }

    // Prueba para el método doGet
    @Test
    public void testDoGet() throws Exception {
        // Simular los análisis que serán devueltos por el DAO
        Analisis analisis1 = new Analisis();
        Analisis analisis2 = new Analisis();
        List<Analisis> listaAnalisis = Arrays.asList(analisis1, analisis2);

        when(analisisDAO.getAllAnalisis()).thenReturn(listaAnalisis);

        // Ejecutar el método doGet
        analisisServlet.doGet(request, response);

        // Verificar que se invocó el método correcto del DAO
        verify(analisisDAO, times(1)).getAllAnalisis();

        // Verificar que el servlet agregó la lista de análisis al request
        ArgumentCaptor<List<Analisis>> captor = ArgumentCaptor.forClass(List.class);
        verify(request).setAttribute(eq("analisis"), captor.capture());

        // Verificar que se pasó la lista correcta al JSP
        List<Analisis> analisisCapturados = captor.getValue();
        assertTrue(analisisCapturados.size() == 2);

        // Verificar que se llamó al RequestDispatcher y se redirigió al JSP correcto
        verify(requestDispatcher).forward(request, response);
    }

    // Prueba para el método doPost
    @Test
    public void testDoPost() throws Exception {
        // Simular los parámetros del request
        when(request.getParameter("Fecha")).thenReturn("2024-09-26 12:00:00");
        when(request.getParameter("Resultado")).thenReturn("Aprobado");
        when(request.getParameter("Usuario_idUsuario")).thenReturn("1");
        when(request.getParameter("Sistema_idSistema")).thenReturn("2");
        when(request.getParameter("detalle")).thenReturn("Detalles del análisis");
        when(request.getParameter("nivelCriticidad")).thenReturn("Alta");

        // Ejecutar el método doPost
        analisisServlet.doPost(request, response);

        // Capturar el análisis que fue pasado al DAO
        ArgumentCaptor<Analisis> captor = ArgumentCaptor.forClass(Analisis.class);
        verify(analisisDAO).addAnalisis(captor.capture());

        // Verificar que el análisis fue correctamente construido
        Analisis analisisCapturado = captor.getValue();
        assertTrue(analisisCapturado.getResultado().equals("Aprobado"));
        assertTrue(analisisCapturado.getUsuario_idUsuario() == 1);
        assertTrue(analisisCapturado.getSistema_idSistema() == 2);

        // Verificar que se redirigió al endpoint correcto
        verify(response).sendRedirect("analisis");
    }
}
