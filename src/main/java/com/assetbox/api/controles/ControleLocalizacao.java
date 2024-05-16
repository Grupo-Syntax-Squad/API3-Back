package com.assetbox.api.controles;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Localizacao;
import com.assetbox.api.repositorios.RepositorioLocalizacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("localizacoes")
public class ControleLocalizacao {
    @Autowired
    private RepositorioLocalizacao repositorioLocalizacao;

    @GetMapping
    public ResponseEntity<?> getLocalizacoes() {
        try {
            return new ResponseEntity<>(repositorioLocalizacao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> getLocalizacao(@PathVariable Long id) {
        try {
            if (repositorioLocalizacao.findById(id).isPresent()) return new ResponseEntity<>(repositorioLocalizacao.findById(id), HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> postLocalizacao(@RequestBody Localizacao localizacao) {
        try {
            return new ResponseEntity<>(repositorioLocalizacao.save(localizacao), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteLocalizacao(@PathVariable Long id) {
        try {
            repositorioLocalizacao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
