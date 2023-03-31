package com.mindhub.merchshop.dtos;

import com.mindhub.merchshop.models.Producto;

import java.util.List;
import java.util.stream.Collectors;


public class ProductoDTO {
    private Long id;
    private String nombre;
    private Integer stock;
    private String descripcion;
    private Double precio;

    private List<PaqueteDeProductosDTO> paqueteDeProductosDTO;
    public ProductoDTO(){}
    public ProductoDTO(Producto producto){
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.stock = producto.getStock();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecio();
        this.paqueteDeProductosDTO = producto.getPaqueteDeProductos().stream().map(PaqueteDeProductosDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
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

    public List<PaqueteDeProductosDTO> getPaqueteDeProductos() {
        return paqueteDeProductosDTO;
    }
}
