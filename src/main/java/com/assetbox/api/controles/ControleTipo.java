package com.assetbox.api.controles;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Tipo;
import com.assetbox.api.repositorios.RepositorioTipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("tipos")
public class ControleTipo {
    @Autowired
    private RepositorioTipo repositorioTipo;

    @GetMapping
    public ResponseEntity<?> getTipos() {
        try{
            return ResponseEntity.ok().body(repositorioTipo.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTipo(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(repositorioTipo.findById(id).get());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PostMapping
    public ResponseEntity<?> postTipo(@RequestBody Tipo tipo) {
        try {
            return ResponseEntity.ok().body(repositorioTipo.save(tipo));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
