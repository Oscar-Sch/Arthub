
package com.mindhub.merchshop.servicios.Impl;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mindhub.merchshop.Utilidades.Utilidades;
import com.mindhub.merchshop.models.Compra;
import com.mindhub.merchshop.models.PaqueteDeProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.awt.*;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
@Transactional
public class ServicioEmail implements com.mindhub.merchshop.servicios.ServicioEmail {
    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String email;

    @Override
    public void EnviarEmail(String emailA, Compra compra) {
        MimeMessage mensaje = javaMailSender.createMimeMessage();

        try {

            // Generar PDF de la compra

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document documento = new Document(PageSize.A4);
            PdfWriter.getInstance(documento, baos);

            documento.open();

            Paragraph titulo = new Paragraph("N de compra 136751223");
            titulo.setSpacingAfter(10);
            documento.add(titulo);

            // Agrega una tabla con información de la compra

            PdfPTable infoTable = new PdfPTable(1);
            infoTable.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            infoTable.addCell("ID de compra: " + compra.getId());
            infoTable.addCell("Fecha de compra: " + compra.getFecha());
            infoTable.addCell("Nombre de usuario: " + compra.getUsuario().getNombre());
            documento.add(infoTable);

            // Agrega un espacio en blanco antes de la tabla principal

            documento.add(new Paragraph(" "));

            // Agrega la tabla principal con los detalles de la compra

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100f);
            tabla.setSpacingBefore(10);

            cabeceraTabla(tabla);

            // Recorre la lista de paquetes de productos de la compra
            for (PaqueteDeProductos paquete : compra.getProductos()) {
                tabla.addCell(paquete.getProducto().getNombre());
                tabla.addCell(paquete.getProducto().getDescripcion());
                tabla.addCell(paquete.getCantidad().toString());
                tabla.addCell(paquete.getProducto().getPrecio().toString());
                tabla.addCell(paquete.getMontoTotal().toString());
            }

            pieTabla(tabla, compra);

            documento.add(tabla);
            documento.close();

            // Adjuntar PDF al correo electrónico

            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);
            helper.setFrom(email);
            helper.setTo(emailA);
            helper.setSubject("Ticket de Compra");
            helper.setText("Estimado cliente adjuntamos el ticket de compra");

            ByteArrayDataSource fuente = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
            helper.addAttachment("TicketCompra.pdf", fuente);

            javaMailSender.send(mensaje);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

}

    @Override
    public void exportar(HttpServletResponse response, Compra compra) throws IOException {

    }

    @Override
    public void cuerpoTabla(PdfPTable tabla, Compra compra) {

    }

    @Override
    public void cabeceraTabla(PdfPTable tabla) {

    }

    @Override
    public void pieTabla(PdfPTable tabla, Compra compra) {

    }
}
