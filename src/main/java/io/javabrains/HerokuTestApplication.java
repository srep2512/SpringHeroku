package io.javabrains;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.javabrains.init.Initializer;

@SpringBootApplication
public class HerokuTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerokuTestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(Initializer init) {
		return (args) -> {
			//Initialisiere h2 Datenbank 
			init.initialize();			
			
		};
	}
}
