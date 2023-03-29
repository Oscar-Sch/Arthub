package com.mindhub.merchshop;

import com.mindhub.merchshop.models.*;
import com.mindhub.merchshop.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

//import static com.mindhub.merchshop.Utilidades.Utilidades.generarNumeroCompra;

@SpringBootApplication
public class MerchshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchshopApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UsuarioRepository usuarioRepository, CompraRepository compraRepository, PaqueteDeProductosRepository paqueteDeProductosRepository, ProductoRepository productoRepository, IlustradorRepository ilustradorRepository, IlustracionRepository ilustracionRepository, ProductoIlustracionRepository productoIlustracionRepository) {
		return (args) -> {

			//Ilustrador1 y sus ilustraciones
			Ilustrador ilustrador1 = new Ilustrador("izuu@gmail.com", "Joel Trinidad", "Izuu", "https://firebasestorage.googleapis.com/v0/b/arthub-102d1.appspot.com/o/305033956_1263199574444982_6802776079643692029_n_494110.png?alt=media&token=70a0f9bf-ae73-488f-a9eb-d092b65b9baf", "000000", List.of());

			Ilustracion ilustracion1 = new Ilustracion("A", "https://firebasestorage.googleapis.com/v0/b/arthub-102d1.appspot.com/o/109086572_165094608472609_1619852278073271916_n_493205.png?alt=media&token=b48e8969-6b2d-427c-95e8-ae474b390948", ilustrador1, List.of());
			Ilustracion ilustracion2 = new Ilustracion("B", "https://firebasestorage.googleapis.com/v0/b/arthub-102d1.appspot.com/o/117811586_171719334476803_1337973533433460834_n_493253.png?alt=media&token=a3e0a217-12dc-4c59-8d6d-9a8ea24f7678", ilustrador1, List.of());
			Ilustracion ilustracion3 = new Ilustracion("C", "https://firebasestorage.googleapis.com/v0/b/arthub-102d1.appspot.com/o/119031130_180659546916115_5991594656918939829_n_493257.png?alt=media&token=a9f7881e-be79-447d-9c8a-7ce191a4c64d", ilustrador1, List.of());
			Ilustracion ilustracion4 = new Ilustracion("D", "https://firebasestorage.googleapis.com/v0/b/arthub-102d1.appspot.com/o/hero-color-sketch.png?alt=media&token=da1ce51e-71f4-4c69-9574-0dbd4371371a", ilustrador1, List.of());

			//Ilustrador2 y sus ilustraciones
			Ilustrador ilustrador2 = new Ilustrador("niett@gmail.com", "Cameron Velasquez", "Niett", "", "000000", List.of());

			Ilustracion ilustracion5 = new Ilustracion("A2", "https://firebasestorage.googleapis.com/v0/b/arthub-102d1.appspot.com/o/CameronG.png?alt=media&token=7eab0746-09dc-4382-bceb-89cc2366db45", ilustrador2, List.of());
			Ilustracion ilustracion6 = new Ilustracion("B2", "https://firebasestorage.googleapis.com/v0/b/arthub-102d1.appspot.com/o/CameronF.PNG?alt=media&token=47749f76-8ffb-4a82-bd44-c677fcd9ca5b", ilustrador2, List.of());
			Ilustracion ilustracion7 = new Ilustracion("C2", "https://firebasestorage.googleapis.com/v0/b/arthub-102d1.appspot.com/o/CameronD.PNG?alt=media&token=857bc98f-7784-46d2-b8fd-e822c24b659a", ilustrador2, List.of());
			Ilustracion ilustracion8 = new Ilustracion("D2", "https://firebasestorage.googleapis.com/v0/b/arthub-102d1.appspot.com/o/CameronA.JPG?alt=media&token=e2fed519-dbae-4c2e-bba0-43a7bdd8e392", ilustrador2, List.of());


			ilustradorRepository.save(ilustrador1);
			ilustradorRepository.save(ilustrador2);

			ilustracionRepository.save(ilustracion1);
			ilustracionRepository.save(ilustracion2);
			ilustracionRepository.save(ilustracion3);
			ilustracionRepository.save(ilustracion4);
			ilustracionRepository.save(ilustracion5);
			ilustracionRepository.save(ilustracion6);
			ilustracionRepository.save(ilustracion7);
			ilustracionRepository.save(ilustracion8);


			//Productos equis(stock del ilustrador1)

			ProductoIlustracion productoIlustracion1 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XS, ColorProducto.NEGRO);
			ProductoIlustracion productoIlustracion2 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.S, ColorProducto.NEGRO);
			ProductoIlustracion productoIlustracion3 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.M ,ColorProducto.NEGRO);
			ProductoIlustracion productoIlustracion4 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.L,  ColorProducto.NEGRO);
			ProductoIlustracion productoIlustracion5 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.NEGRO);
			ProductoIlustracion productoIlustracion6 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XS,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion7 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.S,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion8 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.M,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion9 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.L,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion10 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion11 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.AZUL);
			ProductoIlustracion productoIlustracion12 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.LILA);
			ProductoIlustracion productoIlustracion13 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.AMARILLO);
			ProductoIlustracion productoIlustracion14 = new ProductoIlustracion( ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.VERDE);
			ProductoIlustracion productoIlustracion15 = new ProductoIlustracion( ilustracion2, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.AZUL);
			ProductoIlustracion productoIlustracion16 = new ProductoIlustracion( ilustracion2, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.LILA);
			ProductoIlustracion productoIlustracion17 = new ProductoIlustracion( ilustracion2, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.AMARILLO);
			ProductoIlustracion productoIlustracion18 = new ProductoIlustracion( ilustracion2, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.VERDE);
			ProductoIlustracion productoIlustracion19 = new ProductoIlustracion( ilustracion2, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion20 = new ProductoIlustracion( ilustracion2, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.NEGRO);

			ProductoIlustracion productoIlustracion21 = new ProductoIlustracion(ilustracion3, 50, "stock de marzo", 500.0, TipoProducto.TAZA, ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion22 = new ProductoIlustracion(ilustracion4, 50, "stock de marzo", 500.0, TipoProducto.TAZA, ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion23 = new ProductoIlustracion(ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.TAZA, ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion24 = new ProductoIlustracion(ilustracion2, 50, "stock de marzo", 500.0, TipoProducto.TAZA, ColorProducto.BLANCO);

			ProductoIlustracion productoIlustracion25 = new ProductoIlustracion(ilustracion1, 50, "stock de marzo", 500.0, TipoProducto.LLAVERO);
			ProductoIlustracion productoIlustracion26 = new ProductoIlustracion(ilustracion2, 50, "stock de marzo", 500.0, TipoProducto.LLAVERO);
			ProductoIlustracion productoIlustracion27 = new ProductoIlustracion(ilustracion3, 50, "stock de marzo", 500.0, TipoProducto.LLAVERO);
			ProductoIlustracion productoIlustracion28 = new ProductoIlustracion(ilustracion4, 50, "stock de marzo", 500.0, TipoProducto.LLAVERO);

			ProductoIlustracion productoIlustracion29 = new ProductoIlustracion(ilustracion1, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.PEQUEÑO);
			ProductoIlustracion productoIlustracion30 = new ProductoIlustracion(ilustracion1, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.MEDIANO);
			ProductoIlustracion productoIlustracion31 = new ProductoIlustracion(ilustracion1, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.GRANDE);
			ProductoIlustracion productoIlustracion32 = new ProductoIlustracion(ilustracion2, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.PEQUEÑO);
			ProductoIlustracion productoIlustracion33 = new ProductoIlustracion(ilustracion2, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.MEDIANO);
			ProductoIlustracion productoIlustracion34 = new ProductoIlustracion(ilustracion2, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.GRANDE);

			ProductoIlustracion productoIlustracion35 = new ProductoIlustracion(ilustracion2, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.PEQUEÑO);
			ProductoIlustracion productoIlustracion36 = new ProductoIlustracion(ilustracion2, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.MEDIANO);
			ProductoIlustracion productoIlustracion37 = new ProductoIlustracion(ilustracion2, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.GRANDE);
			ProductoIlustracion productoIlustracion38 = new ProductoIlustracion(ilustracion1, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.PEQUEÑO);
			ProductoIlustracion productoIlustracion39 = new ProductoIlustracion(ilustracion1, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.MEDIANO);
			ProductoIlustracion productoIlustracion40 = new ProductoIlustracion(ilustracion1, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.GRANDE);


			productoIlustracionRepository.save(productoIlustracion1);
			productoIlustracionRepository.save(productoIlustracion2);
			productoIlustracionRepository.save(productoIlustracion3);
			productoIlustracionRepository.save(productoIlustracion4);
			productoIlustracionRepository.save(productoIlustracion5);
			productoIlustracionRepository.save(productoIlustracion6);
			productoIlustracionRepository.save(productoIlustracion7);
			productoIlustracionRepository.save(productoIlustracion8);
			productoIlustracionRepository.save(productoIlustracion9);
			productoIlustracionRepository.save(productoIlustracion10);
			productoIlustracionRepository.save(productoIlustracion11);
			productoIlustracionRepository.save(productoIlustracion12);
			productoIlustracionRepository.save(productoIlustracion13);
			productoIlustracionRepository.save(productoIlustracion14);
			productoIlustracionRepository.save(productoIlustracion15);
			productoIlustracionRepository.save(productoIlustracion16);
			productoIlustracionRepository.save(productoIlustracion17);
			productoIlustracionRepository.save(productoIlustracion18);
			productoIlustracionRepository.save(productoIlustracion19);
			productoIlustracionRepository.save(productoIlustracion20);
			productoIlustracionRepository.save(productoIlustracion21);
			productoIlustracionRepository.save(productoIlustracion22);
			productoIlustracionRepository.save(productoIlustracion23);
			productoIlustracionRepository.save(productoIlustracion24);
			productoIlustracionRepository.save(productoIlustracion25);
			productoIlustracionRepository.save(productoIlustracion26);
			productoIlustracionRepository.save(productoIlustracion27);
			productoIlustracionRepository.save(productoIlustracion28);
			productoIlustracionRepository.save(productoIlustracion29);
			productoIlustracionRepository.save(productoIlustracion30);
			productoIlustracionRepository.save(productoIlustracion31);
			productoIlustracionRepository.save(productoIlustracion32);
			productoIlustracionRepository.save(productoIlustracion33);
			productoIlustracionRepository.save(productoIlustracion34);
			productoIlustracionRepository.save(productoIlustracion35);
			productoIlustracionRepository.save(productoIlustracion36);
			productoIlustracionRepository.save(productoIlustracion37);
			productoIlustracionRepository.save(productoIlustracion38);
			productoIlustracionRepository.save(productoIlustracion39);
			productoIlustracionRepository.save(productoIlustracion40);


			//stock ilustrador 2
			ProductoIlustracion productoIlustracion41 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XS, ColorProducto.NEGRO);
			ProductoIlustracion productoIlustracion42 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.S, ColorProducto.NEGRO);
			ProductoIlustracion productoIlustracion43 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.M ,ColorProducto.NEGRO);
			ProductoIlustracion productoIlustracion44 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.L,  ColorProducto.NEGRO);
			ProductoIlustracion productoIlustracion45 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.NEGRO);
			ProductoIlustracion productoIlustracion46 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XS,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion47 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.S,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion48 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.M,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion49 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.L,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion50 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion51 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.AZUL);
			ProductoIlustracion productoIlustracion52 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.LILA);
			ProductoIlustracion productoIlustracion53 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.AMARILLO);
			ProductoIlustracion productoIlustracion54 = new ProductoIlustracion( ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.VERDE);
			ProductoIlustracion productoIlustracion55 = new ProductoIlustracion( ilustracion6, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.AZUL);
			ProductoIlustracion productoIlustracion56 = new ProductoIlustracion( ilustracion6, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.LILA);
			ProductoIlustracion productoIlustracion57 = new ProductoIlustracion( ilustracion6, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.AMARILLO);
			ProductoIlustracion productoIlustracion58 = new ProductoIlustracion( ilustracion6, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.VERDE);
			ProductoIlustracion productoIlustracion59 = new ProductoIlustracion( ilustracion6, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion60 = new ProductoIlustracion( ilustracion6, 50, "stock de marzo", 500.0, TipoProducto.RAMERA, TallaProducto.XL,  ColorProducto.NEGRO);

			ProductoIlustracion productoIlustracion61 = new ProductoIlustracion(ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.TAZA, ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion62 = new ProductoIlustracion(ilustracion6, 50, "stock de marzo", 500.0, TipoProducto.TAZA, ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion63 = new ProductoIlustracion(ilustracion7, 50, "stock de marzo", 500.0, TipoProducto.TAZA, ColorProducto.BLANCO);
			ProductoIlustracion productoIlustracion64 = new ProductoIlustracion(ilustracion8, 50, "stock de marzo", 500.0, TipoProducto.TAZA, ColorProducto.BLANCO);

			ProductoIlustracion productoIlustracion65 = new ProductoIlustracion(ilustracion5, 50, "stock de marzo", 500.0, TipoProducto.LLAVERO);
			ProductoIlustracion productoIlustracion66 = new ProductoIlustracion(ilustracion6, 50, "stock de marzo", 500.0, TipoProducto.LLAVERO);
			ProductoIlustracion productoIlustracion67 = new ProductoIlustracion(ilustracion7, 50, "stock de marzo", 500.0, TipoProducto.LLAVERO);
			ProductoIlustracion productoIlustracion68 = new ProductoIlustracion(ilustracion8, 50, "stock de marzo", 500.0, TipoProducto.LLAVERO);

			ProductoIlustracion productoIlustracion69 = new ProductoIlustracion(ilustracion5, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.PEQUEÑO);
			ProductoIlustracion productoIlustracion70 = new ProductoIlustracion(ilustracion5, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.MEDIANO);
			ProductoIlustracion productoIlustracion71 = new ProductoIlustracion(ilustracion5, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.GRANDE);
			ProductoIlustracion productoIlustracion72 = new ProductoIlustracion(ilustracion6, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.PEQUEÑO);
			ProductoIlustracion productoIlustracion73 = new ProductoIlustracion(ilustracion6, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.MEDIANO);
			ProductoIlustracion productoIlustracion74 = new ProductoIlustracion(ilustracion6, 50, "stock de marzo", 5000.0, TipoProducto.LIBRETA, TamañoProducto.GRANDE);

			ProductoIlustracion productoIlustracion75 = new ProductoIlustracion(ilustracion5, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.PEQUEÑO);
			ProductoIlustracion productoIlustracion76 = new ProductoIlustracion(ilustracion5, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.MEDIANO);
			ProductoIlustracion productoIlustracion77 = new ProductoIlustracion(ilustracion5, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.GRANDE);
			ProductoIlustracion productoIlustracion78 = new ProductoIlustracion(ilustracion6, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.PEQUEÑO);
			ProductoIlustracion productoIlustracion79 = new ProductoIlustracion(ilustracion6, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.MEDIANO);
			ProductoIlustracion productoIlustracion80 = new ProductoIlustracion(ilustracion6, 50, "stock de marzo", 5000.0, TipoProducto.PRINT, TamañoProducto.GRANDE);

			productoIlustracionRepository.save(productoIlustracion41);
			productoIlustracionRepository.save(productoIlustracion42);
			productoIlustracionRepository.save(productoIlustracion43);
			productoIlustracionRepository.save(productoIlustracion44);
			productoIlustracionRepository.save(productoIlustracion45);
			productoIlustracionRepository.save(productoIlustracion46);
			productoIlustracionRepository.save(productoIlustracion47);
			productoIlustracionRepository.save(productoIlustracion48);
			productoIlustracionRepository.save(productoIlustracion49);
			productoIlustracionRepository.save(productoIlustracion50);
			productoIlustracionRepository.save(productoIlustracion51);
			productoIlustracionRepository.save(productoIlustracion52);
			productoIlustracionRepository.save(productoIlustracion53);
			productoIlustracionRepository.save(productoIlustracion54);
			productoIlustracionRepository.save(productoIlustracion55);
			productoIlustracionRepository.save(productoIlustracion56);
			productoIlustracionRepository.save(productoIlustracion57);
			productoIlustracionRepository.save(productoIlustracion58);
			productoIlustracionRepository.save(productoIlustracion59);
			productoIlustracionRepository.save(productoIlustracion60);
			productoIlustracionRepository.save(productoIlustracion61);
			productoIlustracionRepository.save(productoIlustracion62);
			productoIlustracionRepository.save(productoIlustracion63);
			productoIlustracionRepository.save(productoIlustracion64);
			productoIlustracionRepository.save(productoIlustracion65);
			productoIlustracionRepository.save(productoIlustracion66);
			productoIlustracionRepository.save(productoIlustracion67);
			productoIlustracionRepository.save(productoIlustracion68);
			productoIlustracionRepository.save(productoIlustracion69);
			productoIlustracionRepository.save(productoIlustracion70);
			productoIlustracionRepository.save(productoIlustracion71);
			productoIlustracionRepository.save(productoIlustracion72);
			productoIlustracionRepository.save(productoIlustracion73);
			productoIlustracionRepository.save(productoIlustracion74);
			productoIlustracionRepository.save(productoIlustracion75);
			productoIlustracionRepository.save(productoIlustracion76);
			productoIlustracionRepository.save(productoIlustracion77);
			productoIlustracionRepository.save(productoIlustracion78);
			productoIlustracionRepository.save(productoIlustracion79);
			productoIlustracionRepository.save(productoIlustracion80);


			Usuario usuario1 = new Usuario("asd@gmail.com", "Julio Perez", "Nick", "123");

//			Compra compra1 = new Compra(usuario1, List.of(), LocalDateTime.now(), generarNumeroCompra());
//
//			PaqueteDeProductos paqueteDeProductos1 = new PaqueteDeProductos(compra1, productoIlustracion1, (byte) 2);
//			PaqueteDeProductos paqueteDeProductos2 = new PaqueteDeProductos(compra1, productoIlustracion2, (byte) 2);
//			PaqueteDeProductos paqueteDeProductos3 = new PaqueteDeProductos(compra1, productoIlustracion3, (byte) 2);





			usuarioRepository.save(usuario1);
//			compraRepository.save(compra1);
//			paqueteDeProductosRepository.save(paqueteDeProductos1);
//			paqueteDeProductosRepository.save(paqueteDeProductos2);
//			paqueteDeProductosRepository.save(paqueteDeProductos3);

			List<ProductoIlustracion> productoIlustraciones = productoIlustracionRepository.findAll();

		};
	}

}
