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

import com.assetbox.api.modelos.Destinatario;
import com.assetbox.api.repositorios.RepositorioDestinatario;

@RestController
public class ControleDestinatario {
    @Autowired
    private RepositorioDestinatario repositorioDestinatario;

    @GetMapping("/destinatarios")
    public ResponseEntity<List<Destinatario>> getDestinatarios() {
        return ResponseEntity.ok().body(repositorioDestinatario.findAll());
    }

    @GetMapping("/destinatarios/{id}")
    public ResponseEntity<Destinatario> getDestinatario(@PathVariable Long id) {
        return ResponseEntity.ok().body(repositorioDestinatario.findById(id).get());
    }

    @PostMapping("/destinatarios")
    public ResponseEntity<Destinatario> postDestinatario(@RequestBody Destinatario destinatario) {
        return ResponseEntity.ok().body(repositorioDestinatario.save(destinatario));
    }

    @DeleteMapping("/destinatarios/{id}")
    public ResponseEntity<?> deleteDestinatario(@PathVariable Long id) {
        repositorioDestinatario.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
