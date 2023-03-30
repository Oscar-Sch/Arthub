package com.mindhub.merchshop.servicios.Impl;

import com.mindhub.merchshop.models.ProductoIlustracion;
import com.mindhub.merchshop.repositories.ProductoIlustracionRepository;
import com.mindhub.merchshop.servicios.ServicioProductoIlustracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioProductoIlustracionImpl implements ServicioProductoIlustracion {
    @Autowired
    ProductoIlustracionRepository productoIlustracionRepository;
    @Override
    public ProductoIlustracion findById(Long id) {
        return productoIlustracionRepository.findById(id).get();
    }
}
