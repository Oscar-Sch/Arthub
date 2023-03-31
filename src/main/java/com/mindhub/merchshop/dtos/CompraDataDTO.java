package com.mindhub.merchshop.dtos;

import java.util.List;

public class CompraDataDTO {

    private List<PaqueteDeProductosDTO> paqueteDeProductosDTOS;

    public CompraDataDTO( List<PaqueteDeProductosDTO> paqueteDeProductosDTOS) {

        this.paqueteDeProductosDTOS = paqueteDeProductosDTOS;
    }


    public List<PaqueteDeProductosDTO> getPaqueteDeProductosDTOS() {
        return paqueteDeProductosDTOS;
    }
}
