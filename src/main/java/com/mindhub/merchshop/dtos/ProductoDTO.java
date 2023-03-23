package com.mindhub.merchshop.dtos;

import com.mindhub.merchshop.models.Producto;
import com.mindhub.merchshop.models.ProductoIlustracion;
import com.mindhub.merchshop.models.TipoProducto;


import java.util.List;
import java.util.stream.Collectors;

public class ProductoDTO {
    private Long id;
    private TipoProducto tipoProducto;
    private List<String> tamaños;
    private List<String> colores;
    private String descripcion;
    private List<ProductoIlustracionDTO> productoIlustraciones;
    public ProductoDTO(){}
    public ProductoDTO(Producto producto){
        this.id = producto.getId();
        this.tipoProducto = producto.getTipoProducto();
        this.tamaños = producto.getTamaños();
        this.colores = producto.getColores();
        this.descripcion = producto.getDescripcion();
        this.productoIlustraciones = producto.getProductoIlustraciones().stream().map(ProductoIlustracionDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public List<String> getTamaños() {
        return tamaños;
    }

    public List<String> getColores() {
        return colores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<ProductoIlustracionDTO> getProductoIlustraciones() {
        return productoIlustraciones;
    }
}
