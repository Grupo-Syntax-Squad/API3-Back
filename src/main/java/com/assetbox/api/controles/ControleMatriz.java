package com.assetbox.api.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Matriz;
import com.assetbox.api.processos.MatrizAtualizador;
import com.assetbox.api.repositorios.RepositorioMatriz;

@RestController
@RequestMapping("matriz")
public class ControleMatriz {
    @Autowired
    private RepositorioMatriz repositorioMatriz;

    private MatrizAtualizador matrizAtualizador = new MatrizAtualizador();
    
    @GetMapping
    public ResponseEntity<?> getMatriz() {
        try {
            if (repositorioMatriz.findById(1L).isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<Matriz>(repositorioMatriz.findById(1L).get(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> postMatriz(@RequestBody Matriz matriz) {
        try {
            repositorioMatriz.save(matriz);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 

    @PutMapping
    public ResponseEntity<?> putMatriz(@RequestBody Matriz matriz) {
        try {
            Matriz matrizEntidade = repositorioMatriz.findById(1L).get();
            matrizEntidade = matrizAtualizador.atualizar(matrizEntidade, matriz);
            matrizEntidade = repositorioMatriz.save(matrizEntidade);
            return new ResponseEntity<Matriz>(matrizEntidade, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
