package com.assetbox.api.controle;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Endereco;
import com.assetbox.api.repositorio.RepositorioEndereco;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ControleEndereco {
    @Autowired
    private RepositorioEndereco repositorioEndereco;

    @GetMapping("/endereco/{id}")
    public ResponseEntity<Optional<Endereco>> getEnderecoById(@PathVariable Long id) {
        return ResponseEntity.ok(repositorioEndereco.findById(id));
    }
    
    @PostMapping("/endereco")
    public ResponseEntity<Endereco> postEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(repositorioEndereco.save(endereco));
    }
}
