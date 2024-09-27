/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cybershieldaitest;

import com.mycompany.cybershieldaiweb.AmenazasServlet;
import com.mycompany.cybershieldaiweb.dao.AmenazaDAO;
import com.mycompany.cybershieldaiweb.dao.AnalisisDAO;
import com.mycompany.cybershieldaiweb.model.Amenaza;
import com.mycompany.cybershieldaiweb.model.Analisis;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class AmenazasServletTest {

    @Mock
    private AmenazaDAO amenazaDAO;

    @Mock
    private AnalisisDAO analisisDAO;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    private AmenazasServlet amenazasServlet;

    @Before
    public void setUp() throws Exception {
        // Inicializar los mocks
        MockitoAnnotations.openMocks(this);

        // Simular el RequestDispatcher
        when(request.getRequestDispatcher("detallesAnalisis.jsp")).thenReturn(requestDispatcher);

        // Crear una nueva instancia del servlet con los DAOs simulados
        amenazasServlet = new AmenazasServlet(amenazaDAO, analisisDAO);
    }

    @Test
    public void testDoGet() throws Exception {
        // Simular el comportamiento del AmenazaDAO
        Amenaza amenaza1 = new Amenaza();
        amenaza1.setAnalisis_idAnalisis(1);
        Amenaza amenaza2 = new Amenaza();
        amenaza2.setAnalisis_idAnalisis(2);

        List<Amenaza> amenazasCriticas = Arrays.asList(amenaza1, amenaza2);

        when(amenazaDAO.getAmenazasCriticas()).thenReturn(amenazasCriticas);

        // Simular el comportamiento del AnalisisDAO
        Analisis analisis1 = new Analisis();
        Analisis analisis2 = new Analisis();
        when(analisisDAO.getAnalisisById(1)).thenReturn(analisis1);
        when(analisisDAO.getAnalisisById(2)).thenReturn(analisis2);

        // Ejecutar el método doGet del servlet
        amenazasServlet.doGet(request, response);

        // Verificar que el mock del DAO fue invocado
        verify(amenazaDAO, times(1)).getAmenazasCriticas();

        // Capturar la lista de amenazas que fue pasada al JSP
        ArgumentCaptor<List<Amenaza>> captor = ArgumentCaptor.forClass(List.class);
        verify(request).setAttribute(eq("amenazas"), captor.capture());

        // Verificar que hay al menos dos amenazas en la lista
        List<Amenaza> amenazasCapturadas = captor.getValue();
        assertTrue(amenazasCapturadas.size() >= 2);

        // Verificar que el RequestDispatcher se invocó correctamente
        verify(requestDispatcher).forward(request, response);
    }
}

