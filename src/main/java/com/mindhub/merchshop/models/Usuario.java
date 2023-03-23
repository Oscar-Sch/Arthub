package com.mindhub.merchshop.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private String email;
    private String nombre;
    private String nick;
    private String avatarUrl;
    private String contraseña;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Compra> listaDeCompras = new ArrayList<>();
    @OneToMany(mappedBy = "usuario" , fetch = FetchType.EAGER)
    private List<Direccion> direcciones = new ArrayList<>();

    public Usuario(){};
    public Usuario(String email, String nombre, String nick, String avatarUrl, String contraseña, List<Compra> listaDeCompras, List<Direccion> direcciones) {
        this.email = email;
        this.nombre = nombre;
        this.nick = nick;
        this.avatarUrl = avatarUrl;
        this.contraseña = contraseña;
        this.listaDeCompras = listaDeCompras;
        this.direcciones = direcciones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }

    public void setListaDeCompras(List<Compra> listaDeCompras) {
        this.listaDeCompras = listaDeCompras;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }
    public void addListaDeCompras(Compra compra) {
        compra.setUsuario(this);
        listaDeCompras.add(compra);
    }
    public void addDirecciones(Direccion direccion) {
        direccion.setUsuario(this);
        direcciones.add(direccion);
    }
}
