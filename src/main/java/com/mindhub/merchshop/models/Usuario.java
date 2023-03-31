package com.mindhub.merchshop.models;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    private String email;
    private String nombre;
    private String nick;
    private String avatarUrl;
    private String contraseña;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Compra> listaDeCompras = new ArrayList<>();

    public Usuario(){};
    public Usuario(String email, String nombre, String nick, String contraseña, Direccion direccion) {
        this.email = email;
        this.nombre = nombre;
        this.nick = nick;
        this.contraseña = contraseña;
        this.direccion = direccion;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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

    public void addListaDeCompras(Compra compra) {
        compra.setUsuario(this);
        listaDeCompras.add(compra);
    }

}
