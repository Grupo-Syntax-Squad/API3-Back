package com.assetbox.API.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.API.modelos.Ativo;
import com.assetbox.API.repositorios.RepositorioAtivo;

@RestController
public class ControleAtivo {
    @Autowired
    private RepositorioAtivo repositorioAtivo;

    @GetMapping("/ativos")
    public ResponseEntity<List<Ativo>> getAtivos() {
        return ResponseEntity.ok().body(repositorioAtivo.findAll());
    }

    @GetMapping("/ativos/{id}")
    public ResponseEntity<Ativo> getAtivo(@PathVariable Long id) {
        return ResponseEntity.ok().body(repositorioAtivo.findById(id).get());
    }

    @PostMapping("/ativos")
    public ResponseEntity<Ativo> postAtivo(@RequestBody Ativo ativo) {
        return ResponseEntity.ok().body(repositorioAtivo.save(ativo));
    }
}
