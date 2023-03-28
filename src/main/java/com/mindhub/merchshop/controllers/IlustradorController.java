package com.mindhub.merchshop.controllers;

import com.mindhub.merchshop.dtos.IlustradorDTO;
import com.mindhub.merchshop.models.Ilustrador;
import com.mindhub.merchshop.repositories.IlustradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
public class IlustradorController {
    @Autowired
    IlustradorRepository ilustradorRepository;

    @GetMapping("/ilustradores")
    public Set<IlustradorDTO> listaIlustradores(){
        return ilustradorRepository.findAll().stream().map(IlustradorDTO::new).collect(Collectors.toSet());
    }
    @PostMapping("/admin/illustradores")
    public ResponseEntity<Object> crearIlustrador (@RequestBody IlustradorDTO ilustradorDTO){

        Ilustrador ilustradorExistente = ilustradorRepository.findByEmail(ilustradorDTO.getEmail());
        String mail = ilustradorDTO.getEmail();
        String nombre = ilustradorDTO.getNombre();
        String nick = ilustradorDTO.getNick();
        String avatar = ilustradorDTO.getAvatarURL();
        String contrasenia = ilustradorDTO.getContrasenia();


        if(mail.isEmpty()){
            return new ResponseEntity<>("Este campo no puede estar vacío", HttpStatus.BAD_REQUEST);}
        if(ilustradorExistente != null){
            return new ResponseEntity<>("Este correo ya está en uso", HttpStatus.BAD_REQUEST);}
        if(nombre.isEmpty() ){
            return new ResponseEntity<>("Este campo no puede estar vacío", HttpStatus.BAD_REQUEST);}
        if(nick.isEmpty()){
            return new ResponseEntity<>("Este campo no puede estar vacío", HttpStatus.BAD_REQUEST);}
        if(avatar.isEmpty()){
            return new ResponseEntity<>("Este campo no puede estar vacío", HttpStatus.BAD_REQUEST);}
        if(contrasenia.isEmpty() ){
            return new ResponseEntity<>("Este campo no puede estar vacío", HttpStatus.BAD_REQUEST);}

        Ilustrador nuevoIlustrador = new Ilustrador(mail, nombre, nick, avatar, contrasenia, List.of());
        ilustradorRepository.save(nuevoIlustrador);

        return new ResponseEntity<>("Ilustrador creado!", HttpStatus.CREATED);
    }
}
