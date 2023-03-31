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
    private String nombre;
    private Integer stock;
    private String descripcion;
    private Double precio;
    private TipoProducto tipoProducto;
    private TallaProducto talla;
    private TamañoProducto tamaño;
    private ColorProducto color;
    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    List<PaqueteDeProductos> paqueteDeProductos = new ArrayList<>();

    public Producto(){}

    public Producto( Integer stock, String descripcion, Double precio, TipoProducto tipoProducto, TallaProducto talla, ColorProducto color) {
        this.nombre = this.tipoProducto + ", "+ this.talla+", "+this.color;
        this.stock = stock;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.talla = talla;
        this.color = color;
    }
    public Producto(Integer stock, String descripcion, Double precio, TipoProducto tipoProducto, ColorProducto color){
        this.nombre = this.tipoProducto + ", "+ this.color;
        this.stock = stock;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.color = color;
    }
    public Producto(Integer stock, String descripcion, Double precio, TipoProducto tipoProducto){
        this.nombre = this.tipoProducto +", cuadrado.";
        this.stock = stock;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    public Producto(Integer stock, String descripcion, Double precio, TipoProducto tipoProducto, TamañoProducto tamaño){
        this.nombre = this.tipoProducto +", "+this.tamaño;
        this.stock = stock;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.tamaño = tamaño;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public TallaProducto getTalla() {
        return talla;
    }

    public void setTalla(TallaProducto talla) {
        this.talla = talla;
    }

    public TamañoProducto getTamaño() {
        return tamaño;
    }

    public void setTamaño(TamañoProducto tamaño) {
        this.tamaño = tamaño;
    }

    public ColorProducto getColor() {
        return color;
    }

    public void setColor(ColorProducto color) {
        this.color = color;
    }

    public List<PaqueteDeProductos> getPaqueteDeProductos() {
        return paqueteDeProductos;
    }

    public void setPaqueteDeProductos(List<PaqueteDeProductos> paqueteDeProductos) {
        this.paqueteDeProductos = paqueteDeProductos;
    }

    public void addListaDePaqueteDeProductos(PaqueteDeProductos paqueteDeProductoss) {
        paqueteDeProductoss.setProducto(this);
        paqueteDeProductos.add(paqueteDeProductoss);
    }
}
