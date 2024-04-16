package com.assetbox.api.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Endereco;
import com.assetbox.api.repositorios.RepositorioEndereco;

@RestController
public class ControleEndereco {
    @Autowired
    private RepositorioEndereco repositorioEndereco;

    @GetMapping("/enderecos")
    public ResponseEntity<List<Endereco>> getEnderecos() {
        return ResponseEntity.ok().body(repositorioEndereco.findAll());
    }

    @GetMapping("/enderecos/{id}")
    public ResponseEntity<Endereco> getEndereco(@PathVariable Long id) {
        return ResponseEntity.ok().body(repositorioEndereco.findById(id).get());
    }

    @PostMapping("/enderecos")
    public ResponseEntity<Endereco> postEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.ok().body(repositorioEndereco.save(endereco));
    }
}
