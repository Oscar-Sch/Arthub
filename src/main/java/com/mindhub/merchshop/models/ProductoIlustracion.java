package com.mindhub.merchshop.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ProductoIlustracion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private Long id;
    private String nombre;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="illustracion_id")
    private Ilustracion ilustracion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Producto producto;
    private Integer stock;
    private String descripcion;
    private Double precio;

    public ProductoIlustracion(){}
    public ProductoIlustracion(String nombre, Ilustracion illustration, Producto producto, Integer stock, String descripcion, Double precio) {
        this.nombre = nombre;
        this.ilustracion = illustration;
        this.producto = producto;
        this.stock = stock;
        this.descripcion = descripcion;
        this.precio = precio;
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

    public Ilustracion getIllustracion() {
        return ilustracion;
    }

    public void setIllustracion(Ilustracion illustration) {
        this.ilustracion = illustration;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
