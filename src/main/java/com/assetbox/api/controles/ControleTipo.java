package com.assetbox.api.controles;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Tipo;
import com.assetbox.api.repositorios.RepositorioTipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class ControleTipo {
    @Autowired
    private RepositorioTipo repositorioTipo;

    @GetMapping("/tipos")
    public ResponseEntity<List<Tipo>> getTipos() {
        return ResponseEntity.ok().body(repositorioTipo.findAll());
    }

    @GetMapping("/tipos/{id}")
    public ResponseEntity<Tipo> getTipo(@PathVariable Long id) {
        return ResponseEntity.ok().body(repositorioTipo.findById(id).get());
    }

    @PostMapping("/tipos")
    public ResponseEntity<Tipo> postTipo(@RequestBody Tipo tipo) {
        return ResponseEntity.ok().body(repositorioTipo.save(tipo));
    }
}
