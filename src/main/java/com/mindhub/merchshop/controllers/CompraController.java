

package com.mindhub.merchshop.controllers;

import com.mindhub.merchshop.dtos.CompraDataDTO;
import com.mindhub.merchshop.dtos.PaqueteDeProductosDTO;
import com.mindhub.merchshop.dtos.TransaccionDTO;
import com.mindhub.merchshop.models.Compra;
import com.mindhub.merchshop.models.PaqueteDeProductos;
import com.mindhub.merchshop.models.ProductoIlustracion;
import com.mindhub.merchshop.models.Usuario;
import com.mindhub.merchshop.servicios.ServicioCompra;
import com.mindhub.merchshop.servicios.ServicioEmail;
import com.mindhub.merchshop.servicios.ServicioProductoIlustracion;
import com.mindhub.merchshop.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.mindhub.merchshop.Utilidades.Utilidades.generarNumeroCompra;


@RestController
@RequestMapping("/api")
public class CompraController {

    @Autowired
    ServicioUsuario servicioUsuario;
    @Autowired
    ServicioEmail servicioEmail;
    @Autowired
    ServicioCompra servicioCompra;
    @Autowired
    ServicioProductoIlustracion servicioProductoIlustracion;


@PostMapping("/email/pdf")
    public void enviarpdf(Authentication authentication){
    Usuario user = servicioUsuario.findByEmail(authentication.getName());

    Compra nuevaCompra = new Compra(user , LocalDateTime.now(), generarNumeroCompra());
    servicioEmail.EnviarEmail("fxargentinoinvestment@gmail.com", nuevaCompra);
}


//    @Transactional
//    @PostMapping("/comprar")
//    public ResponseEntity<?> realizarCompra(@RequestBody List<PaqueteDeProductosDTO> paquetes, Authentication authentication, HttpServletResponse response) throws IOException {
//
//        // Descontar stock
//        for (PaqueteDeProductosDTO paquete : paquetes) {
//            ProductoIlustracion productoIlustracion = servicioProductoIlustracion.findById(paquete.getProductoIlustracionId());
//            productoIlustracion.setStock(productoIlustracion.getStock() - paquete.getCantidad());
//        }
//
//        // Calcular el monto total de la compra
//        Double montoTotal = 0.0;
//        for (PaqueteDeProductosDTO paquete : paquetes) {
//            montoTotal += paquete.getMontoTotal();
//        }
//
//        // Generar la compra
//        Usuario usuarioAutenticado = servicioUsuario.findByEmail(authentication.getName());
//        Compra nuevaCompra = new Compra(usuarioAutenticado, paquetes, LocalDateTime.now(), generarNumeroCompra());
//        servicioCompra.save(nuevaCompra);
//
//        //Generar PDF
//       generarPDF(authentication, response, nuevaCompra);
//
//        servicioEmail.EnviarEmail(usuarioAutenticado.getEmail(), authentication, nuevaCompra, response);
//
//        return new ResponseEntity<>("Compra efectuada exitosamente" , HttpStatus.CREATED);
//    }
}
