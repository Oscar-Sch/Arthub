package com.mindhub.merchshop.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ilustracion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private Long id;
    private String nombre;
    private String imgURL;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ilustrador_id")
    private Ilustrador ilustrador;
    @OneToMany(mappedBy = "ilustracion", fetch = FetchType.EAGER)
    private List<ProductoIlustracion> productoIlustraciones = new ArrayList<>();

    public Ilustracion(){}
    public Ilustracion(String nombre, String imgURL, Ilustrador ilustrador, List<ProductoIlustracion> productoIlustraciones) {
        this.nombre = nombre;
        this.imgURL = imgURL;
        this.ilustrador = ilustrador;
        this.productoIlustraciones = productoIlustraciones;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Ilustrador getIllustrator() {
        return ilustrador;
    }

    public void setIllustrator(Ilustrador ilustrador) {
        this.ilustrador = ilustrador;
    }

    public List<ProductoIlustracion> getProductoIlustraciones() {
        return productoIlustraciones;
    }

    public void setProductoIlustraciones(List<ProductoIlustracion> productoIlustraciones) {
        this.productoIlustraciones = productoIlustraciones;
    }
    public void addProductoIlustraciones(ProductoIlustracion productoIlustracion) {
        productoIlustracion.setIllustracion(this);
        productoIlustraciones.add(productoIlustracion);
    }
}
