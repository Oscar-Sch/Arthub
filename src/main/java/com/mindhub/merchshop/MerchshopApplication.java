package com.mindhub.merchshop;


import com.mindhub.merchshop.repositories.*;
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
	public CommandLineRunner initData(UsuarioRepository usuarioRepository, CompraRepository compraRepository, PaqueteDeProductosRepository paqueteDeProductosRepository, ProductoRepository productoRepository, IlustradorRepository ilustradorRepository, IlustracionRepository ilustracionRepository, ProductoRepository productoIlustracionRepository) {
		return (args) -> {


		};
	}

}
