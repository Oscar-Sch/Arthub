package com.mindhub.merchshop.controllers;

import com.mindhub.merchshop.dtos.UsuarioDTO;
import com.mindhub.merchshop.models.Usuario;
//import com.mindhub.merchshop.servicios.ServicioEmail;
import com.mindhub.merchshop.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class UsuarioController {


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ServicioUsuario serviciosUsuario;


    @GetMapping("/api/usuarios")
    public List<UsuarioDTO> getClients() {
        return serviciosUsuario.findAll().stream().map(UsuarioDTO::new).collect(toList());
    }

    @RequestMapping("/api/usuario/actual")
    public UsuarioDTO getUsuarioActual(Authentication authentication) {
        String email = authentication.getName();
        return new UsuarioDTO(serviciosUsuario.findByEmail(email));
    }

    @PatchMapping("/api/usuario/modificar")
    public ResponseEntity<Object> update(Authentication authentication,
                                         @RequestParam String nombre, @RequestParam String nick,
                                         @RequestParam String email, @RequestParam String contraseña) {

        Usuario usuarioModificado = serviciosUsuario.findByEmail(authentication.getName());


        if (nombre.isEmpty() && nick.isEmpty() && email.isEmpty() && contraseña.isEmpty()) {
            return new ResponseEntity<>("Los campos no pueden estar vacios",HttpStatus.FORBIDDEN);
        }

          if (nombre.isEmpty()) {
              return new ResponseEntity<>("El nombre no puede estar vacío", HttpStatus.BAD_REQUEST);
        }usuarioModificado.setNombre(nombre);

        if (nick.isEmpty()) {
            Usuario usuarioExistente = serviciosUsuario.findByNick(nick);
            if (usuarioExistente != null && !usuarioExistente.getNick().equals(usuarioModificado.getNick())) {
                return new ResponseEntity<>("El nick ya está en uso", HttpStatus.BAD_REQUEST);
            }
            usuarioModificado.setNick(nick);
        }

        if (email.isEmpty()) {
            Usuario usuarioExistente = serviciosUsuario.findByEmail(email);
            if (usuarioExistente != null && !usuarioExistente.getEmail().equals(usuarioModificado.getEmail())) {
                return new ResponseEntity<>("El correo electrónico ya está en uso", HttpStatus.BAD_REQUEST);
            }
            usuarioModificado.setEmail(email);
        }

        if (contraseña.isEmpty()) {
            return new ResponseEntity<>("La contraseña no puede estar vacía", HttpStatus.BAD_REQUEST);
        } usuarioModificado.setContraseña(contraseña);


        serviciosUsuario.save(usuarioModificado);
        return new ResponseEntity<>("Los datos han sido modificados con éxito", HttpStatus.OK);
    }


    @PostMapping("/api/usuario/registro")
    public ResponseEntity<Object> register(

            @RequestParam String nombre,
            @RequestParam String nick,
            @RequestParam String email,
            @RequestParam String contraseña) {


        if (nombre.isEmpty()) {
            return new ResponseEntity<>("Nombre Incompleto", HttpStatus.FORBIDDEN);
        }
        if (nick.isEmpty()) {
            return new ResponseEntity<>("Nick Incompleto", HttpStatus.FORBIDDEN);
        }
        if (email.isEmpty()) {
            return new ResponseEntity<>("Email Incompleto", HttpStatus.FORBIDDEN);
        }
        if (contraseña.isEmpty()) {
            return new ResponseEntity<>("Password Incompleta", HttpStatus.FORBIDDEN);
        }
        if (serviciosUsuario.findByEmail(email) != null) {

            return new ResponseEntity<>("Email existente", HttpStatus.FORBIDDEN);
        }
        if (serviciosUsuario.findByNick(nick) != null) {
            return new ResponseEntity<>("Nick existente", HttpStatus.FORBIDDEN);
        }

        Usuario usuario = new Usuario(email,nombre, nick,  passwordEncoder.encode(contraseña));
        serviciosUsuario.save(usuario);

        return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.CREATED);

    }




}
