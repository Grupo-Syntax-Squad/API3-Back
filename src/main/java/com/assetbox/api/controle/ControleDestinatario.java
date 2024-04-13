package com.assetbox.api.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Destinatario;
import com.assetbox.api.repositorio.RepositorioDestinatario;

@RestController
public class ControleDestinatario {
	@Autowired
	private RepositorioDestinatario repositorioDestinatario;
	
	@GetMapping("/destinatarios")
	public List<Destinatario> obterDestinatarios() {
		try {
            List<Destinatario> listaDestinatarios = repositorioDestinatario.findAll();
            return listaDestinatarios.isEmpty() ? null : listaDestinatarios;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	@PostMapping("/cadastrar/destinatario")
	public ResponseEntity<Destinatario> cadastrarDestinatario(@RequestBody Destinatario destinatario) {
		 try {
	            Destinatario novoDestinatario = repositorioDestinatario.save(destinatario);
	            return ResponseEntity.ok(novoDestinatario);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	}
	
	@GetMapping("/destinatario/{id}")
	public ResponseEntity<Optional<Destinatario>> obterAtivo(@PathVariable long id) {
		Optional<Destinatario> ativo = repositorioDestinatario.findById(id);
		if (ativo == null) {
			ResponseEntity<Optional<Destinatario>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		}  else {
			return ResponseEntity.ok(ativo);
		}
	}
	
	@DeleteMapping("deletar/destinatario/{id}")
    public ResponseEntity<String> deletarDestinatario(@PathVariable long id) {
        Optional<Destinatario> ativo = repositorioDestinatario.findById(id);
        if (ativo.isPresent()) {
            repositorioDestinatario.deleteById(id);
            return ResponseEntity.ok("Destinatario deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}