package com.example.bookRestApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(BookRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Book("A123456789", "El conde de Montecristo", 357, "Alejandro Dumas", "https://www.normaeditorial.com/upload/media/albumes/0001/06/b966a1dcaac3d6282436d07c71fe0c75504bce4a.jpeg", false)));
			log.info("Preloading " + repository.save(new Book("ES0096583923", "Juego de tronos", 217, "George R. Martin", "https://images.cdn1.buscalibre.com/fit-in/360x360/5e/db/5edbc9fa0fdc1b73defbdbc84b331890.jpg", false)));
			log.info("Preloading " + repository.save(new Book("UK724638941238", "Los pilares de la tierra", 425, "Ken Follet", "https://m.media-amazon.com/images/I/912cN-bjuiL._AC_UF894,1000_QL80_.jpg", false)));
		};
	};
}
