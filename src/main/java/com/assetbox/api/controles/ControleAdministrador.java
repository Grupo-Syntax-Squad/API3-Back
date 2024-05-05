package com.assetbox.api.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Administrador;
import com.assetbox.api.repositorios.RepositorioAdministrador;

@RestController
public class ControleAdministrador {
	@Autowired
	private RepositorioAdministrador repositorioAdministrador;
	
	@GetMapping("/administradores")
	public ResponseEntity<List<Administrador>> getAdministradores() {
		return ResponseEntity.ok().body(repositorioAdministrador.findAll());
	}
	
	@GetMapping("/administradores/{id}")
	public ResponseEntity<Administrador> getAdministrador(@PathVariable Long id){
		return ResponseEntity.ok().body(repositorioAdministrador.findById(id).get());
	}
	
	@PostMapping("/administradores")
	public ResponseEntity<Administrador> postAdministrador(@RequestBody Administrador administrador){
		return ResponseEntity.ok().body(repositorioAdministrador.save(administrador));
	}
	
	@DeleteMapping("/administradores/{id}")
	public ResponseEntity<?> deleteAdministrador(@PathVariable Long id) {
		repositorioAdministrador.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
