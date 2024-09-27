/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.cybershieldaiweb.dao.RecomendacionDAO;
import com.mycompany.cybershieldaiweb.model.Recomendacion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/generarInformePDF")
public class GenerarInformePDFServlet extends HttpServlet {

    private RecomendacionDAO recomendacionDAO;

    public GenerarInformePDFServlet() {
        this.recomendacionDAO = new RecomendacionDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"informe_recomendaciones.pdf\"");

        // Crear el documento PDF
        Document document = new Document();

        try {
            // Crear el escritor PDF
            PdfWriter.getInstance(document, response.getOutputStream());

            // Abrir el documento para escribir
            document.open();

            // Título del PDF
            document.add(new Paragraph("Informe de Recomendaciones de CyberShield AI"));

            // Tabla con las recomendaciones
            PdfPTable table = new PdfPTable(6); // 6 columnas: ID, Descripción, Nivel Urgencia, Amenaza, Estado, Fecha Completado

            // Encabezado de la tabla
            PdfPCell cell;
            cell = new PdfPCell(new Phrase("ID Recomendación"));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Descripción"));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Nivel Urgencia"));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Amenaza")); 
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Estado de Implementación"));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Fecha Completado"));
            table.addCell(cell);

            // Obtener la lista de recomendaciones
            List<Recomendacion> listaRecomendaciones = recomendacionDAO.getAllRecomendaciones();

            // Añadir cada recomendación a la tabla
            // Añadir cada recomendación a la tabla
for (Recomendacion recomendacion : listaRecomendaciones) {
                table.addCell(String.valueOf(recomendacion.getidRecomendacion()));
                table.addCell(recomendacion.getDescripcion());
                table.addCell(recomendacion.getNivelUrgencia());
                table.addCell(String.valueOf(recomendacion.getAmenaza_idAmenaza()));
                table.addCell(recomendacion.getestadoImplementacion());
                table.addCell(recomendacion.getfechaCompletado() != null
                        ? recomendacion.getfechaCompletado().toString()
                        : "N/A");
            }


            // Añadir la tabla al documento
            document.add(table);

            // Cerrar el documento
            document.close();

        } catch (DocumentException e) {
            throw new IOException(e.getMessage());
        }
    }
}
