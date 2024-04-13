package com.assetbox.api.controle;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Tipo;
import com.assetbox.api.repositorio.RepositorioTipo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class ControleTipo {
    @Autowired
    private RepositorioTipo repositorioTipo;
    
    @GetMapping("/tipos")
    public ResponseEntity<List<Tipo>> getTipos() {
        return ResponseEntity.ok().body(repositorioTipo.findAll());
    }

    @GetMapping("/tipo/{id}")
    public ResponseEntity<Optional<Tipo>> getMethodName(@RequestParam Long id) {
        return ResponseEntity.ok().body(repositorioTipo.findById(id));
    }
    
    @PostMapping("/cadastrar/tipo")
    public ResponseEntity<Tipo> postTipo(@RequestBody Tipo tipo) {
        return ResponseEntity.ok().body(repositorioTipo.save(tipo));
    }
    
}
