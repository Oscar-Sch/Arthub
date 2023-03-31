package com.mindhub.merchshop.controllers;

import com.mindhub.merchshop.dtos.DireccionDTO;
import com.mindhub.merchshop.dtos.RegisterDTO;
import com.mindhub.merchshop.dtos.UsuarioDTO;
import com.mindhub.merchshop.models.Direccion;
import com.mindhub.merchshop.models.Usuario;
import com.mindhub.merchshop.servicios.ServicioDireccion;
import com.mindhub.merchshop.servicios.ServicioEmail;
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

    @Autowired
    ServicioDireccion servicioDireccion;


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
                                         @RequestParam String email) {

        Usuario usuarioModificado = serviciosUsuario.findByEmail(authentication.getName());


        if (nombre.isEmpty() && nick.isEmpty() && email.isEmpty()) {
            return new ResponseEntity<>("Los campos no pueden estar vacios", HttpStatus.FORBIDDEN);
        }

        if (nombre.isEmpty()) {
            return new ResponseEntity<>("El nombre no puede estar vacío", HttpStatus.FORBIDDEN);
        }
        usuarioModificado.setNombre(nombre);

        if (nick.isEmpty()) {
            Usuario usuarioExistente = serviciosUsuario.findByNick(nick);
            if (usuarioExistente != null && !usuarioExistente.getNick().equals(usuarioModificado.getNick())) {
                return new ResponseEntity<>("El nick ya está en uso", HttpStatus.FORBIDDEN);
            }
            usuarioModificado.setNick(nick);
        }

        if (email.isEmpty()) {
            Usuario usuarioExistente = serviciosUsuario.findByEmail(email);
            if (usuarioExistente != null && !usuarioExistente.getEmail().equals(usuarioModificado.getEmail())) {
                return new ResponseEntity<>("El correo electrónico ya está en uso", HttpStatus.FORBIDDEN);
            }
            usuarioModificado.setEmail(email);
        }

        serviciosUsuario.save(usuarioModificado);
        return new ResponseEntity<>("Los datos han sido modificados con éxito", HttpStatus.OK);
    }


    @PostMapping("/api/usuario/registro")
    public ResponseEntity<Object> register(
            @RequestBody RegisterDTO registerDTO) {

        String nombre = registerDTO.getNombre();
        String nick = registerDTO.getNick();
        String email = registerDTO.getEmail();
        String contraseña = registerDTO.getContraseña();
        String pais = registerDTO.getPais();
        String ciudad = registerDTO.getCiudad();
        String direccion = registerDTO.getDireccion();
        String zipcode = registerDTO.getZipCode();
        String descripcion = registerDTO.getDescripcion();


        if (nombre.isEmpty()) {
            return new ResponseEntity<>("Nombre Incompleto", HttpStatus.FORBIDDEN);
        }
        if (nick.isEmpty()) {
            return new ResponseEntity<>("Nick Incompleto", HttpStatus.FORBIDDEN);
        }
        if (email.isEmpty()) {
            return new ResponseEntity<>("Email Incompleto", HttpStatus.FORBIDDEN);
        }
        if (pais.isEmpty()) {
            return new ResponseEntity<>("País Incompleto", HttpStatus.FORBIDDEN);
        }
        if (ciudad.isEmpty()) {
            return new ResponseEntity<>("Ciudad Incompleta", HttpStatus.FORBIDDEN);
        }
        if (direccion.isEmpty()) {
            return new ResponseEntity<>("Direccion Incompleta", HttpStatus.FORBIDDEN);
        }
        if (zipcode.isEmpty()) {
            return new ResponseEntity<>("Codigo Postal Incompleto", HttpStatus.FORBIDDEN);
        }
        if (descripcion.isEmpty()) {
            return new ResponseEntity<>("Descripcion Incompleta", HttpStatus.FORBIDDEN);
        }
        if (contraseña.isEmpty()) {
            return new ResponseEntity<>("Contraseña Incompleta", HttpStatus.FORBIDDEN);
        }
        if (serviciosUsuario.findByEmail(email) != null) {
            return new ResponseEntity<>("Email existente", HttpStatus.FORBIDDEN);
        }
        if (serviciosUsuario.findByNick(nick) != null) {
            return new ResponseEntity<>("Nick existente", HttpStatus.FORBIDDEN);
        }

        Direccion nuevaDireccion = new Direccion(pais,ciudad,direccion,descripcion,zipcode);
        Usuario nuevoUsuario = new Usuario(email,nombre,nick, passwordEncoder.encode(contraseña), nuevaDireccion);

        servicioDireccion.save(nuevaDireccion);
        serviciosUsuario.save(nuevoUsuario);

        return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.CREATED);
    }



    }



