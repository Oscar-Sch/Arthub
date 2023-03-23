package com.mindhub.merchshop.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private Long id;
    private TipoProducto tipoProducto;
    @ElementCollection
    @Column(name = "tamaños")
    private List<String> tamaños;
    @ElementCollection
    @Column(name = "colores")
    private List<String> colores;
    private String descripcion;
    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private List<ProductoIlustracion> productoIlustraciones = new ArrayList<>();

    public  Producto (){};

    public Producto(TipoProducto tipoProducto, List<String> tamaños, List<String> colores, String descripcion, List<ProductoIlustracion> productoIlustraciones) {
        this.tipoProducto = tipoProducto;
        this.tamaños = tamaños;
        this.colores = colores;
        this.descripcion = descripcion;
        this.productoIlustraciones = productoIlustraciones;
    }

    public Long getId() {
        return id;
    }
    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public List<String> getTamaños() {
        return tamaños;
    }

    public void setTamaños(List<String> tamaños) {
        this.tamaños = tamaños;
    }

    public List<String> getColores() {
        return colores;
    }

    public void setColores(List<String> colores) {
        this.colores = colores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ProductoIlustracion> getProductoIlustraciones() {
        return productoIlustraciones;
    }

    public void setProductoIlustraciones(List<ProductoIlustracion> productoIlustraciones) {
        this.productoIlustraciones = productoIlustraciones;
    }
    public void addProductoIlustraciones(ProductoIlustracion productoIlustracion) {
        productoIlustracion.setProducto(this);
        productoIlustraciones.add(productoIlustracion);
    }
}
