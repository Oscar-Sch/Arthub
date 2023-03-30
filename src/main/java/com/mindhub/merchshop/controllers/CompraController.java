//package com.mindhub.merchshop.controllers;
//
//import com.mindhub.merchshop.models.Usuario;
//import com.mindhub.merchshop.servicios.ServicioEmail;
//import com.mindhub.merchshop.servicios.ServicioUsuario;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.transaction.Transactional;
//
//@RestController
//public class CompraController {
//
//    @Autowired
//    ServicioUsuario servicioUsuario;
//
//    @Autowired
//    ServicioEmail servicioEmail;
//
//    @PostMapping("/api/email/pdf")
//    public void enviarEmailPdf(Authentication authentication){
//        Usuario usuario = servicioUsuario.findByEmail(authentication.getName());
//        servicioEmail.EnviarEmail(usuario.getEmail());
//    }
//
//
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
//        String numero = compraDataDTO.getTransaccionDTO().getNumero();
//        String cvv = compraDataDTO.getTransaccionDTO().getCvv();
//        String descripcion = compraDataDTO.getTransaccionDTO().getDescripcion();
//        Double montoAPagar = compraDataDTO.getTransaccionDTO().getMontoAPagar();
//
//
//        final String URL = "https://mindhub-brothers-bank.up.railway.app/web/index.html";
//
//        TransaccionDTO.setMontoAPagar(compraDataDTO.get);
//        TransaccionDTO.setDescripcion("compra en ArtHub");
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
//        HttpEntity<TransaccionDTO> entidad = new HttpEntity<>(TransaccionDTO, headers);
//
//        ResponseEntity<?> respuesta = restTemplate.exchange(URL, HttpMethod.POST, entidad, String.class);
//
//        //comprobar transaccion exitosa
//        //sino se genera compra, devolver stock
//
//        //Generar Compra
//        List<PaqueteDeProductos> paqueteDeProductos = compraDataDTO.getPaqueteDeProductosDTOS().stream().map(PaqueteDeProductos::new).collect(Collectors.toList());
//        Double montoTotal = null;
//        for (PaqueteDeProductos paquete : paqueteDeProductos){
//            montoTotal += paquete.getMontoTotal();
//        }
//        Usuario usuarioAutenticado = servicioUsuario.findByEmail(authentication.getName());
//        Compra nuevaCompra = new Compra(usuarioAutenticado, paqueteDeProductos , LocalDateTime.now(),generarNumeroCompra());
//        servicioCompra.save(nuevaCompra);
//
//        //Generar PDF
////        generarPDF(authentication, response, nuevaCompra);
//
//        servicioEmail.EnviarEmail(usuarioAutenticado.getEmail());
//
//        return new ResponseEntity<>("Compra efectuada exitosamente" , HttpStatus.CREATED);
//    }
//
//
//}
