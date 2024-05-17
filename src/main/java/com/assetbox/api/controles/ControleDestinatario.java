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
    public ResponseEntity<List<Destinatario>> getDestinatarios() {
        return ResponseEntity.ok().body(repositorioDestinatario.findAll());
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
    public ResponseEntity<Destinatario> postDestinatario(@RequestBody Destinatario destinatario) {
        return ResponseEntity.ok().body(repositorioDestinatario.save(destinatario));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putDestinatario(@PathVariable Long id, @RequestBody Destinatario destinatario) {
        try {
            if (repositorioDestinatario.findById(id).isPresent()) {
                Destinatario destinatarioEntidade = repositorioDestinatario.findById(id).get();

                destinatarioEntidade = destinatarioAtualizador.atualizar(destinatarioEntidade, destinatario);
                repositorioDestinatario.save(destinatarioEntidade);

                return new ResponseEntity<Destinatario>(repositorioDestinatario.findById(id).get(), HttpStatus.OK);
            } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteDestinatario(@PathVariable Long id) {
        repositorioDestinatario.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
