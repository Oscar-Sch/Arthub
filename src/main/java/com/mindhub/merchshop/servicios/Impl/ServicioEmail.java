package com.mindhub.merchshop.servicios.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.File;

@Service
@Transactional
public class ServicioEmail implements com.mindhub.merchshop.servicios.ServicioEmail {
    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String email;


    public void EnviarEmail (String emailA){
        MimeMessage mensaje = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper =new MimeMessageHelper(mensaje, true);
            helper.setFrom(email);
            helper.setTo(emailA);
            helper.setSubject("Ticket de Compra");
            helper.setText("Estimado cliente adjuntamos el ticket de compra");

            javaMailSender.send(mensaje);
        }
        catch (Exception exception){
            throw new RuntimeException(exception);
        }
    }




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
}
