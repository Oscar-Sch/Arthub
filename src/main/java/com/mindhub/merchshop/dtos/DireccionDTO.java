package com.mindhub.merchshop.dtos;

import com.mindhub.merchshop.models.Direccion;

public class DireccionDTO {
    private Long id;
    private String pais;
    private String ciudad;
    private String calle;
    private Integer numero;
    private String zipCode;
    private String descripcion;

    public DireccionDTO(){}
    public DireccionDTO(Direccion direccion){
        this.id = direccion.getId();
        this.pais = direccion.getPais();
        this.ciudad = direccion.getCiudad();
        this.calle = direccion.getCalle();
        this.numero = direccion.getNumero();
        this.zipCode = direccion.getZipCode();
        this.descripcion = direccion.getDescripcion();
    }

    public Long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
