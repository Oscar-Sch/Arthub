package com.mindhub.merchshop.dtos;


import com.mindhub.merchshop.models.Ilustracion;
import com.mindhub.merchshop.models.ProductoIlustracion;


import java.util.List;
import java.util.stream.Collectors;

public class IlustracionDTO {
    private Long id;
    private String nombre;
    private String imgURL;
    private List<ProductoIlustracionDTO> productoIlustraciones ;
    public IlustracionDTO(){}
    public IlustracionDTO(Ilustracion ilustracion){
        this.id = ilustracion.getId();
        this.nombre = ilustracion.getNombre();
        this.imgURL = ilustracion.getImgURL();
        this.productoIlustraciones = ilustracion.getProductoIlustraciones().stream().map(ProductoIlustracionDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImgURL() {
        return imgURL;
    }

    public List<ProductoIlustracionDTO> getProductoIlustraciones() {
        return productoIlustraciones;
    }
}
