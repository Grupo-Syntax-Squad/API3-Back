package com.assetbox.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		Map<String, Object> configuracao = new HashMap<>();

		configuracao.put("server.port", "8000"); // seleção da porta

		configuracao.put("spring.datasource.url", "jdbc:mysql://localhost:3306/assetbox");
		
		configuracao.put("spring.datasource.username", "root"); // usuario
		configuracao.put("spring.datasource.password", "fatec"); // senha
		
		configuracao.put("spring.jpa.show-sql", "true"); // mostrar comandos
		configuracao.put("spring.jpa.hibernate.ddl-auto", "update"); // criar editar
		
		SpringApplication app = new SpringApplication(ApiApplication.class);
		app.setDefaultProperties(configuracao);
		app.run(args);
	}
}
