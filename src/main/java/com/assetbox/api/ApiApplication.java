package com.assetbox.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assetbox.api.modelos.Administrador;
import com.assetbox.api.repositorios.RepositorioAdministrador;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
	@Autowired
	RepositorioAdministrador repositorioAdministrador;
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (repositorioAdministrador.count() == 0) {
			Administrador administrador = new Administrador("admin", "admin@gmail.com", "123", "(12) 99999-9999");
			repositorioAdministrador.save(administrador);
			System.out.println("Administrador cadastrado com sucesso!");
		}
	}
}
