package com.assetbox.api.controles;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Manutencao;
import com.assetbox.api.repositorios.RepositorioManutencao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ControleManutencao {
    @Autowired
    private RepositorioManutencao repositorioManutencao;

    @GetMapping("/manutencoes")
    public ResponseEntity<List<Manutencao>> getManutencoes() {
        try {
            return new ResponseEntity<List<Manutencao>>(repositorioManutencao.findAll(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<List<Manutencao>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/manutencoes")
    public ResponseEntity<Manutencao> postManutencao(@RequestBody Manutencao manutencao) {
        try {
            return new ResponseEntity<>(repositorioManutencao.save(manutencao), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/manutencoes/{id}")
    public ResponseEntity<Manutencao> getManutencao(@PathVariable Long id) {
        try {
            return new ResponseEntity<Manutencao>(repositorioManutencao.findById(id).get(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
