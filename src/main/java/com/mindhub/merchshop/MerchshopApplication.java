package com.mindhub.merchshop;


import com.mindhub.merchshop.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
public class MerchshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchshopApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UsuarioRepository usuarioRepository, CompraRepository compraRepository, PaqueteDeProductosRepository paqueteDeProductosRepository, ProductoRepository productoRepository, IlustradorRepository ilustradorRepository, IlustracionRepository ilustracionRepository, ProductoRepository productoIlustracionRepository) {
		return (args) -> {




			// GENERAR STOCK


			Producto[] productos = new Producto[30 * ColorProducto.values().length * TamañoProducto.values().length];

			int contador = 0;

			List<String> colores = Arrays.stream(ColorProducto.values())
					.map(Enum::toString)
					.collect(Collectors.toList());
			List<String> tamaños = Arrays.stream(TamañoProducto.values())
					.map(Enum::toString)
					.collect(Collectors.toList());

			int cantidadPorCombinacion = 30 / (colores.size() * tamaños.size());

			for (String color : colores) {
				for (String tamaño : tamaños) {
					for (int i = 0; i < cantidadPorCombinacion; i++) {
					//	productos[contador] = new Producto(TipoProducto.PRINT, tamaño, color, "s");
						contador++;
					}
				}
			}
			for (Producto producto : productos) {
				if (producto != null) {
					productoRepository.save(producto);
				}
			}


		};
	}

}
