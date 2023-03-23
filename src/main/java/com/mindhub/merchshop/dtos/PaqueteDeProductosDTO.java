package com.mindhub.merchshop.dtos;


import com.mindhub.merchshop.models.PaqueteDeProductos;


public class PaqueteDeProductosDTO {
    private Long id;
    private Byte cantidad;
    private Double montoTotal;
    private Long compraId; //me traigo la clase Compra? o solo el id ta bn?
    private Long productoIlustracionId; //lo mismo
    public PaqueteDeProductosDTO(){}
    public PaqueteDeProductosDTO(PaqueteDeProductos paqueteDeProductos){
        this.id = paqueteDeProductos.getId();
        this.cantidad = paqueteDeProductos.getCantidad();
        this.montoTotal = paqueteDeProductos.getMontoTotal();
        this.compraId = paqueteDeProductos.getCompra().getId();
        this.productoIlustracionId = paqueteDeProductos.getProductoIlustracion().getId();
    }

    public Long getId() {
        return id;
    }

    public Byte getCantidad() {
        return cantidad;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public Long getCompraId() {
        return compraId;
    }

    public Long getProductoIlustracionId() {
        return productoIlustracionId;
    }
}
