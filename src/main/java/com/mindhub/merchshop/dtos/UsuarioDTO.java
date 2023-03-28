package com.mindhub.merchshop.dtos;

import com.mindhub.merchshop.models.Compra;
import com.mindhub.merchshop.models.Direccion;
import com.mindhub.merchshop.models.Usuario;


import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDTO {
    private String email;
    private String nombre;
    private String nick;
    private String avatarUrl;
    private List<CompraDTO> listaDeCompras;
    private List<DireccionDTO> direcciones;
    public UsuarioDTO(){}
    public UsuarioDTO(Usuario usuario){
        this.email = usuario.getEmail();
        this.nombre = usuario.getNombre();
        this.nick = usuario.getNick();
        this.avatarUrl = usuario.getAvatarUrl();
        this.listaDeCompras = usuario.getListaDeCompras().stream().map(CompraDTO::new).collect(Collectors.toList());
//        this.direcciones = usuario.getDirecciones().stream().map(DireccionDTO::new).collect(Collectors.toList());
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNick() {
        return nick;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public List<CompraDTO> getListaDeCompras() {
        return listaDeCompras;
    }

    public List<DireccionDTO> getDirecciones() {
        return direcciones;
    }
}
