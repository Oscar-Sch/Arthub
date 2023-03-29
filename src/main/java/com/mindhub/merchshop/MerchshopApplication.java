package com.mindhub.merchshop;

import com.mindhub.merchshop.models.*;
import com.mindhub.merchshop.repositories.IlustracionRepository;
import com.mindhub.merchshop.repositories.IlustradorRepository;
import com.mindhub.merchshop.repositories.ProductoIlustracionRepository;
import com.mindhub.merchshop.repositories.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MerchshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchshopApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductoRepository productoRepository, IlustradorRepository ilustradorRepository, IlustracionRepository ilustracionRepository, ProductoIlustracionRepository productoIlustracionRepository) {
		return (args) -> {

			Ilustrador ilustrador1 = new Ilustrador("cameronilustra@gmail.com", "Cameron Lino", "Niett", "http://url.com", "000000", List.of());

			Ilustracion ilustracion1 = new Ilustracion("Bosque", "http://url", ilustrador1, List.of());
			Ilustracion ilustracion2 = new Ilustracion("Playa", "http://url", ilustrador1, List.of());
			Ilustracion ilustracion3 = new Ilustracion("Desierto", "http://url", ilustrador1, List.of());

			ilustradorRepository.save(ilustrador1);

			ilustracionRepository.save(ilustracion1);
			ilustracionRepository.save(ilustracion2);
			ilustracionRepository.save(ilustracion3);



			//Productos equis
			Producto producto1 = new Producto(TipoProducto.RAMERA, List.of("XS", "S", "M", "L"), List.of("BLANCO", "NEGRO"), "poleras manga corta de algodón", List.of());
			Producto producto2 = new Producto(TipoProducto.LIBRETA, List.of("Pequeña", "Mediana", "Grande"), List.of("NORMAL", "GLITTER", "TORNASOL"), "libretas anilladas papel bond", List.of());
			Producto producto3 = new Producto(TipoProducto.LLAVERO, List.of("Unico(cuadrado)"), List.of("NORMAL", "GLITTER", "TORNASOL"), "llavero acrílico", List.of());
			Producto producto4 = new Producto(TipoProducto.PRINT, List.of("A6", "A4", "A3"), List.of("NORMAL", "GLITTER", "TORNASOL"), "prints papel bond gramaje medio", List.of());
			Producto producto5 = new Producto(TipoProducto.TAZA, List.of("Unico(cuadrado)"), List.of("BLANCO", "NEGRO"), "tazas de loza, laminadas", List.of());

			ProductoIlustracion productoIlustracion1 = new ProductoIlustracion("RAMERA, XS, NEGRO", ilustracion1, producto1, 50, "stock de marzo", 500.0);
			ProductoIlustracion productoIlustracion2 = new ProductoIlustracion("RAMERA, M, NEGRO", ilustracion1, producto1, 50, "stock de marzo", 500.0);
			ProductoIlustracion productoIlustracion3 = new ProductoIlustracion("RAMERA, L, NEGRO", ilustracion1, producto1, 50, "stock de marzo", 500.0);


			productoRepository.save(producto1);
			productoRepository.save(producto2);
			productoRepository.save(producto3);
			productoRepository.save(producto4);
			productoRepository.save(producto5);

			productoIlustracionRepository.save(productoIlustracion1);
			productoIlustracionRepository.save(productoIlustracion2);
			productoIlustracionRepository.save(productoIlustracion3);

			List<ProductoIlustracion> productoIlustraciones = productoIlustracionRepository.findAll();
			producto1.setProductoIlustraciones(productoIlustraciones);

		};
	}

}
