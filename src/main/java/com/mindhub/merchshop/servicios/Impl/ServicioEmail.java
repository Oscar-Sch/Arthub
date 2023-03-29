//package com.mindhub.merchshop.servicios.Impl;
//
//import com.lowagie.text.*;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//import com.mindhub.merchshop.Utilidades.Utilidades;
//import com.mindhub.merchshop.models.Compra;
//import com.mindhub.merchshop.models.PaqueteDeProductos;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//import javax.mail.internet.MimeMessage;
//import javax.servlet.http.HttpServletResponse;
//import javax.transaction.Transactional;
//import java.awt.*;
//import java.awt.Font;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//
//@Service
//@Transactional
//public class ServicioEmail implements com.mindhub.merchshop.servicios.ServicioEmail {
//    @Autowired
//    JavaMailSender javaMailSender;
//
//    @Value("${spring.mail.username}")
//    private String email;
//
//
//    public void EnviarEmail (String emailA, Authentication authentication, HttpServletResponse response, Compra compra){
//        MimeMessage mensaje = javaMailSender.createMimeMessage();
//
//        try {
//            MimeMessageHelper helper =new MimeMessageHelper(mensaje, true);
//
//            Utilidades.generarPDF(authentication, response, compra);
//            helper.setFrom(email);
//            helper.setTo(emailA);
//            helper.setSubject("Ticket de Compra");
//            helper.setText("Estimado cliente adjuntamos el ticket de compra");
//
//            javaMailSender.send(mensaje);
//        }
//        catch (Exception exception){
//            throw new RuntimeException(exception);
//        }
//    }
//
//    public void exportar(HttpServletResponse response, Compra compra ) throws IOException {
//
//        Document documento =  new Document(PageSize.A4);
//        PdfWriter.getInstance(documento, response.getOutputStream());
//
//        documento.open();
//
//        Paragraph titulo = new Paragraph("Detalles de tu Compra");
//        titulo.setSpacingAfter(10);
//        documento.add(titulo);
//
//        // Agrega una tabla con información de la compra
//        PdfPTable infoTable = new PdfPTable(1);
//        infoTable.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
//        infoTable.addCell("ID de compra: " + compra.getId());
//        infoTable.addCell("Fecha de compra: " + compra.getFecha());
//        infoTable.addCell("Nombre de usuario: " + compra.getUsuario().getNombre());
//        documento.add(infoTable);
//
//        // Agrega un espacio en blanco antes de la tabla principal
//        documento.add(new Paragraph(" "));
//
//
//        PdfPTable tabla = new PdfPTable(5);
//        tabla.setWidthPercentage(100f);
//        tabla.setSpacingBefore(10);
//
//        cabeceraTabla(tabla);
//        cuerpoTabla(tabla, compra);
//        pieTabla(tabla, compra);
//
//
//        documento.add(tabla);
//        documento.close();
//
//    }
//    public void cuerpoTabla(PdfPTable tabla, Compra compra){
//
//        ArrayList<PaqueteDeProductos> listaCompra = new ArrayList<PaqueteDeProductos>(compra.getProductos());
//        com.lowagie.text.Font fuente = FontFactory.getFont(FontFactory.HELVETICA, 8);
//
//
//        listaCompra.forEach(producto -> {
//            tabla.addCell(new Phrase(producto.getId().toString(), fuente));
//            tabla.addCell(new Phrase(producto.getProductoIlustracion().getNombre(), fuente));
//            tabla.addCell(new Phrase(producto.getCantidad().toString(), fuente));
//            tabla.addCell(new Phrase(producto.getProductoIlustracion().getPrecio().toString(), fuente));
//            tabla.addCell(new Phrase(producto.getMontoTotal().toString(), fuente));
//        });
//
//
//    }
//    public void cabeceraTabla(PdfPTable tabla){
//        PdfPCell celda = new PdfPCell();
//        celda.setBackgroundColor(Color.ORANGE);
//        celda.setPadding(5);
//
//        com.lowagie.text.Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//        fuente.setSize(13);
//        fuente.setColor(Color.WHITE);
//
//        celda.setPhrase(new Phrase("ID", fuente));
//        tabla.addCell(celda);
//        celda.setPhrase(new Phrase("Nombre", fuente));
//        tabla.addCell(celda);
//        celda.setPhrase(new Phrase("Monto Total", fuente));
//        tabla.addCell(celda);
//        celda.setPhrase(new Phrase("Usuario nombre", fuente));
//        tabla.addCell(celda);
//        celda.setPhrase(new Phrase("Usuario mail", fuente));
//        tabla.addCell(celda);
//    }
//    public void pieTabla(PdfPTable tabla, Compra compra){
//        // pie de la tabla
//        PdfPCell celdaTotal = new PdfPCell(new Phrase("Monto Total: "));
//        celdaTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
//        celdaTotal.setColspan(4);
//        tabla.addCell(celdaTotal);
//
//        PdfPCell celdaMontoTotal = new PdfPCell(new Phrase(compra.getMontoTotal().toString()));
//        celdaMontoTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
//        tabla.addCell(celdaMontoTotal);
//    }
//


//    public void EnviarEmail (String emailA){
//        MimeMessage mensaje = javaMailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper =new MimeMessageHelper(mensaje, true);
//  File file = pdfService.(METODO DE CAMERON)
//              helper.setFrom(email);
//              helper.setTo(emailA);
//              helper.setSubject("Ticket de Compra");
//              helper.setText("Estimado cliente adjuntamos el ticket de compra");
 //  helper.addAttachment("Ticket",file); Esperar al pdf
//              javaMailSender.send(mensaje);
//        }
//        catch (Exception exception){
//            throw new RuntimeException(exception);
//        }
//    }
//}
