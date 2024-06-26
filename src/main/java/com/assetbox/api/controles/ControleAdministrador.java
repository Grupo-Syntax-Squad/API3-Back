package com.assetbox.api.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.enums.AdminStatus;
import com.assetbox.api.modelos.Administrador;
import com.assetbox.api.processos.AdministradorAtualizador;
import com.assetbox.api.repositorios.RepositorioAdministrador;

@RestController
@RequestMapping("administradores")
public class ControleAdministrador {
	@Autowired
	private RepositorioAdministrador repositorioAdministrador;

	private AdministradorAtualizador administradorAtualizador = new AdministradorAtualizador();


	@GetMapping
	public ResponseEntity<?> getAdministradores() {
		try {
			return new ResponseEntity<List<Administrador>>(repositorioAdministrador.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getAdministrador(@PathVariable Long id) {
		try {
			if (repositorioAdministrador.findById(id).isPresent()) return new ResponseEntity<Administrador>(repositorioAdministrador.findById(id).get(), HttpStatus.OK);
			else return new ResponseEntity<Administrador>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<?> putAdministrador(@PathVariable Long id, @RequestBody Administrador administrador) {
		try {
			if (repositorioAdministrador.findById(id).isPresent()) {
				Administrador administradorEntidade = repositorioAdministrador.findById(id).get();

				if (repositorioAdministrador.findByCpf(administrador.getAdm_cpf()) != null && repositorioAdministrador.findByCpf(administrador.getAdm_cpf()).getAdm_id() != administradorEntidade.getAdm_id()) return new ResponseEntity<>("CPF já registrado no sistema!", HttpStatus.BAD_REQUEST);

				if (repositorioAdministrador.findByEmail(administrador.getAdm_email()) != null && repositorioAdministrador.findByEmail(administrador.getAdm_email()).getAdm_id() != administradorEntidade.getAdm_id()) return new ResponseEntity<>("Email já registrado no sistema!", HttpStatus.BAD_REQUEST);

				if (repositorioAdministrador.findByTelefone(administrador.getAdm_telefone()) != null && repositorioAdministrador.findByTelefone(administrador.getAdm_telefone()).getAdm_id() != administradorEntidade.getAdm_id()) return new ResponseEntity<>("Telefone já registrado no sistema!", HttpStatus.BAD_REQUEST);

				administradorEntidade = administradorAtualizador.atualizar(administradorEntidade, administrador);
				repositorioAdministrador.save(administradorEntidade);

				return new ResponseEntity<Administrador>(repositorioAdministrador.findById(id).get(), HttpStatus.OK);
			} else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteAdministrador(@PathVariable Long id) {
		try {
			if (repositorioAdministrador.findById(id).isPresent()) {
				Administrador administrador = repositorioAdministrador.findById(id).get();
				administrador.setStatus(AdminStatus.INATIVO);
				repositorioAdministrador.save(administrador);
				return new ResponseEntity<>(HttpStatus.OK);
			} else return new ResponseEntity<>("Administrador não encontrado!", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
