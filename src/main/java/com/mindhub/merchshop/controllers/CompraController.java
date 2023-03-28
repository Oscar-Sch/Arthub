package com.mindhub.merchshop.controllers;

import com.mindhub.merchshop.models.Usuario;
import com.mindhub.merchshop.servicios.ServicioEmail;
import com.mindhub.merchshop.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompraController {

    @Autowired
    ServicioUsuario servicioUsuario;

    @Autowired
    ServicioEmail servicioEmail;

    @PostMapping("/api/email/pdf")
    public void enviarEmailPdf(Authentication authentication){
        Usuario usuario = servicioUsuario.findByEmail(authentication.getName());
        servicioEmail.EnviarEmail(usuario.getEmail());
    }
}
