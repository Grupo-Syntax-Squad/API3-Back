package com.assetbox.api.controle;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Tipo;
import com.assetbox.api.repositorio.RepositorioTipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ControleTipo {
    @Autowired
    private RepositorioTipo repositorioTipo;
    
    @GetMapping("/tipos")
    public ResponseEntity<List<Tipo>> getTipos() {
        return ResponseEntity.ok().body(repositorioTipo.findAll());
    }

    @PostMapping("/tipos")
    public ResponseEntity<Tipo> postTipo(@RequestBody Tipo tipo) {
        return ResponseEntity.ok().body(repositorioTipo.save(tipo));
    }
    
}
