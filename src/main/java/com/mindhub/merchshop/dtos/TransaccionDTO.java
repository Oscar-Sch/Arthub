package com.mindhub.merchshop.dtos;

public class TransaccionDTO {
    private String numero;
    private String cvv;
    private String descripcion;
    private Double montoAPagar;

    public TransaccionDTO(){}

    public TransaccionDTO(String numero, String cvv, String descripcion, Double montoAPagar) {
        this.numero = numero;
        this.cvv = cvv;
        this.descripcion = descripcion;
        this.montoAPagar = montoAPagar;
    }

    public String getNumero() {
        return numero;
    }

    public String getCvv() {
        return cvv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getMontoAPagar() {
        return montoAPagar;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMontoAPagar(Double montoAPagar) {
        this.montoAPagar = montoAPagar;
    }
}
