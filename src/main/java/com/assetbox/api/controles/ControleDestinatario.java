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

import com.assetbox.api.modelos.Destinatario;
import com.assetbox.api.processos.DestinatarioAtualizador;
import com.assetbox.api.repositorios.RepositorioDestinatario;

@RestController
@RequestMapping("destinatarios")
public class ControleDestinatario {
    @Autowired
    private RepositorioDestinatario repositorioDestinatario;

    @Autowired
    private DestinatarioAtualizador destinatarioAtualizador;

    @GetMapping
    public ResponseEntity<?> getDestinatarios() {
        try {
            if (repositorioDestinatario.findAll().isEmpty()) return new ResponseEntity<>("Nenhum destinatário cadastrado", HttpStatus.BAD_REQUEST);
            else return new ResponseEntity<List<Destinatario>>(repositorioDestinatario.findAll(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getDestinatario(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(repositorioDestinatario.findById(id).get());
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PostMapping
    public ResponseEntity<?> postDestinatario(@RequestBody Destinatario destinatario) {
        try {
            return new ResponseEntity<Destinatario>(repositorioDestinatario.save(destinatario), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putDestinatario(@PathVariable Long id, @RequestBody Destinatario destinatario) {
		try {
			if (repositorioDestinatario.findById(id).isPresent()) {
				Destinatario destinatarioEntidade = repositorioDestinatario.findById(id).get();

				if (repositorioDestinatario.findByCpf(destinatario.getCpf()) != null && repositorioDestinatario.findByCpf(destinatario.getCpf()).getDes_id() != destinatarioEntidade.getDes_id()) return new ResponseEntity<>("CPF já registrado no sistema!", HttpStatus.BAD_REQUEST);

				if (repositorioDestinatario.findByEmail(destinatario.getEmail()) != null && repositorioDestinatario.findByEmail(destinatario.getEmail()).getDes_id() != destinatarioEntidade.getDes_id()) return new ResponseEntity<>("Email já registrado no sistema!", HttpStatus.BAD_REQUEST);

				if (repositorioDestinatario.findByTelefone(destinatario.getTelefone()) != null && repositorioDestinatario.findByTelefone(destinatario.getTelefone()).getDes_id() != destinatarioEntidade.getDes_id()) return new ResponseEntity<>("Telefone já registrado no sistema!", HttpStatus.BAD_REQUEST);

				destinatarioEntidade = destinatarioAtualizador.atualizar(destinatarioEntidade, destinatario);
				repositorioDestinatario.save(destinatarioEntidade);

				return new ResponseEntity<Destinatario>(repositorioDestinatario.findById(id).get(), HttpStatus.OK);
			} else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteDestinatario(@PathVariable Long id) {
        try {
            repositorioDestinatario.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
