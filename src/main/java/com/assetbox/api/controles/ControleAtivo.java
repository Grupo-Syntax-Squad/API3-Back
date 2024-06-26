package com.assetbox.api.controles;

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

import com.assetbox.api.processos.AtivoAtualizador;
import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.repositorios.RepositorioAtivo;

@RestController
@RequestMapping("ativos")
public class ControleAtivo {
    @Autowired
    private RepositorioAtivo repositorioAtivo;

    @Autowired
    private AtivoAtualizador ativoAtualizador;

    @GetMapping
    public ResponseEntity<?> getAtivos() {
        try {
            return ResponseEntity.ok().body(repositorioAtivo.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAtivo(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(repositorioAtivo.findById(id).get());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> postAtivo(@RequestBody Ativo ativo) {
        try {
            return ResponseEntity.ok().body(repositorioAtivo.save(ativo));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putAtivo(@PathVariable Long id, @RequestBody Ativo ativo) {
        try {
			if (repositorioAtivo.findById(id).isPresent()) {
				Ativo ativoEntidade = repositorioAtivo.findById(id).get();
				
				ativoEntidade = ativoAtualizador.atualizar(ativoEntidade, ativo);
				repositorioAtivo.save(ativoEntidade);

				return new ResponseEntity<Ativo>(repositorioAtivo.findById(id).get(), HttpStatus.OK);
			} else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAtivo(@PathVariable Long id) {
        try {
            repositorioAtivo.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
