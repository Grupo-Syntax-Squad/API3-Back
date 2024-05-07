package com.assetbox.api.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Administrador;
import com.assetbox.api.repositorios.RepositorioAdministrador;

@RestController
@RequestMapping("administradores")
public class ControleAdministrador {
	@Autowired
	private RepositorioAdministrador repositorioAdministrador;

	@GetMapping("")
	public ResponseEntity<List<Administrador>> getAdministradores() {
		return ResponseEntity.ok().body(repositorioAdministrador.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Administrador> getAdministrador(@PathVariable Long id) {
		return ResponseEntity.ok().body(repositorioAdministrador.findById(id).get());
	}

	@PutMapping("{id}")
	public ResponseEntity<?> putAdministrador(@PathVariable Long id, @RequestBody Administrador administrador) {
		try {
			if (repositorioAdministrador.findById(id).isPresent()) {
				Administrador administradorEntidade = repositorioAdministrador.findById(id).get();
				administradorEntidade.setAdm_cpf(administrador.getAdm_cpf());
				administradorEntidade.setAdm_email(administrador.getAdm_email());
				administradorEntidade.setAdm_nome(administrador.getAdm_nome());
				administradorEntidade.setAdm_senha(administrador.getAdm_senha());
				administradorEntidade.setAdm_telefone(administrador.getAdm_telefone());
				repositorioAdministrador.save(administradorEntidade);
				return new ResponseEntity<Administrador>(repositorioAdministrador.findById(id).get(), HttpStatus.OK);
			} else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteAdministrador(@PathVariable Long id) {
		repositorioAdministrador.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
