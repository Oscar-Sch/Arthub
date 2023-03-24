package com.mindhub.merchshop.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ilustrador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private String email;
    private String nombre;
    private String nick;
    private String avatarURL;
    private String contraseña;
    private Direccion direccion;
    @OneToMany(mappedBy = "illustrator", fetch = FetchType.EAGER)
    private List<Ilustracion> ilustraciones = new ArrayList<>();

    public Ilustrador(){};
    public Ilustrador(String email, String nombre, String nick, String avatarURL, String contraseña, Direccion direccion, List<Ilustracion> ilustraciones) {
        this.email = email;
        this.nombre = nombre;
        this.nick = nick;
        this.avatarURL = avatarURL;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.ilustraciones = ilustraciones;
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

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Ilustracion> getIlustraciones() {
        return ilustraciones;
    }

    public void setIlustraciones(List<Ilustracion> ilustraciones) {
        this.ilustraciones = ilustraciones;
    }
    public void addIlustraciones(Ilustracion ilustracion) {
        ilustracion.setIllustrator(this);
        ilustraciones.add(ilustracion);
    }
}
