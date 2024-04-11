
package com.assetbox.api.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.repositorio.RepositorioAtivo;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class ControleAtivo {
	@Autowired
	private RepositorioAtivo repositorioAtivo;

	@GetMapping("/ativos")
	public List<Ativo> obterAtivos() {
		return repositorioAtivo.findAll();
	}

	@PostMapping("/cadastrar/ativo")
	public ResponseEntity<Ativo> cadastrarAtivo(@RequestBody Ativo ativo) {
		return ResponseEntity.ok(repositorioAtivo.save(ativo));
	}

	@GetMapping("/ativo/{id}")
	public ResponseEntity<Optional<Ativo>> obterAtivo(@PathVariable long id) {
		Optional<Ativo> ativo = repositorioAtivo.findById(id);
		if (ativo == null) {
			ResponseEntity<Optional<Ativo>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		}  else {
			return ResponseEntity.ok(ativo);
		}
	}
}
