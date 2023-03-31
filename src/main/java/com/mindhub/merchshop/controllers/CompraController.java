package com.mindhub.merchshop.controllers;


import com.mindhub.merchshop.servicios.ServicioCompra;
//import com.mindhub.merchshop.servicios.ServicioEmail;
import com.mindhub.merchshop.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CompraController {

    @Autowired
    ServicioUsuario servicioUsuario;
//    @Autowired
//    ServicioEmail servicioEmail;
    @Autowired
    ServicioCompra servicioCompra;


    //si se genera se envia el mail

//    @Transactional
//    @PostMapping("/comprar")
//    public ResponseEntity<?> realizarCompra(@RequestBody CompraDataDTO compraDataDTO, Authentication authentication, HttpServletResponse response) throws IOException {
//        //descontar stock
//        List<PaqueteDeProductosDTO> paqueteDeProductosElegidos = compraDataDTO.getPaqueteDeProductosDTOS();
//        for (PaqueteDeProductosDTO paquete : paqueteDeProductosElegidos){
//            ProductoIlustracion productoIlustracion =  servicioProductoIlustracion.findById(paquete.getProductoIlustracionId());
//            productoIlustracion.setStock(productoIlustracion.getStock() - paquete.getCantidad());
//        }
//        //Recibir pago
//        List<PaqueteDeProductosDTO> paqueteDeProductos = compraDataDTO.getPaqueteDeProductosDTOS();
//        Double montoTotal = null;
//        for (PaqueteDeProductosDTO paquete : paqueteDeProductos){
//            montoTotal += paquete.getMontoTotal();
//        }
//        String numero = compraDataDTO.getTransaccionDTO().getNumero();
//        String cvv = compraDataDTO.getTransaccionDTO().getCvv();
//        String descripcion = compraDataDTO.getTransaccionDTO().getDescripcion();
//        Double montoAPagar = compraDataDTO.getTransaccionDTO().getMontoAPagar();
//        TransaccionDTO transaccionDTO = compraDataDTO.getTransaccionDTO();
//
//        final String URL = "https://mindhub-brothers-bank.up.railway.app/api/cards/transaction";
//
//        transaccionDTO.setMontoAPagar(montoTotal);
//        transaccionDTO.setDescripcion("compra en ArtHub");
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
//        HttpEntity<TransaccionDTO> entidad = new HttpEntity<>(transaccionDTO, headers);
//
//        ResponseEntity<?> respuesta = restTemplate.exchange(URL, HttpMethod.POST, entidad, String.class);
//
//        //comprobar transaccion exitosa
//        //sino se genera compra, devolver stock
//
//        //Generar Compra
//        List<PaqueteDeProductos> listaNueva = new ArrayList<>();
//        for(PaqueteDeProductosDTO productos : paqueteDeProductos){
//            PaqueteDeProductos lista = new PaqueteDeProductos();
//            lista.setMontoTotal(lista.getMontoTotal());
//            lista.setCantidad(lista.getCantidad());
//            lista.setCompra(lista.getCompra());
//            lista.setProductoIlustracion(lista.getProductoIlustracion());
//            listaNueva.add(lista);
//        }
//
//        Usuario usuarioAutenticado = servicioUsuario.findByEmail(authentication.getName());
//        Compra nuevaCompra = new Compra(usuarioAutenticado, listaNueva , LocalDateTime.now(),generarNumeroCompra());
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
