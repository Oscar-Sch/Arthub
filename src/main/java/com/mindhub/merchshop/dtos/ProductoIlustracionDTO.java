package com.mindhub.merchshop.dtos;

import com.mindhub.merchshop.models.Ilustracion;
import com.mindhub.merchshop.models.Producto;
import com.mindhub.merchshop.models.ProductoIlustracion;



public class ProductoIlustracionDTO {
    private Long id;
    private String nombre;
    private Long ilustracionId; //traer la clase Ilustrador o solo el id ta bn?
    private Long productoId; // lo mismo
    private Integer stock;
    private String descripcion;
    private Double precio;

    public ProductoIlustracionDTO(){}
    public ProductoIlustracionDTO(ProductoIlustracion productoIlustracion){
        this.id = productoIlustracion.getId();
        this.nombre = productoIlustracion.getNombre();
        this.ilustracionId = productoIlustracion.getIlustracion().getId();
        this.productoId = productoIlustracion.getProducto().getId();
        this.stock = productoIlustracion.getStock();
        this.descripcion = productoIlustracion.getDescripcion();
        this.precio = productoIlustracion.getPrecio();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getIlustracionId() {
        return ilustracionId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public Integer getStock() {
        return stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }
}
