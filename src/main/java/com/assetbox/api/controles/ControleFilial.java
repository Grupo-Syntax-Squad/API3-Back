package com.assetbox.api.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Filial;
import com.assetbox.api.processos.FilialAtualizador;
import com.assetbox.api.repositorios.RepositorioFilial;

@RestController
@RequestMapping("filiais")
public class ControleFilial {
    @Autowired
    private RepositorioFilial repositorioFilial;

    private FilialAtualizador filialAtualizador = new FilialAtualizador();

    @GetMapping
    public ResponseEntity<?> getFiliais() {
        try {
            if (repositorioFilial.findAll().isEmpty()) return new ResponseEntity<String>("Não há nenhuma filial cadastrada no sistema!", HttpStatus.NOT_FOUND);
            else return new ResponseEntity<List<Filial>>(repositorioFilial.findAll(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getFilial(@PathVariable Long id) {
        try {
            if (repositorioFilial.findById(id).isEmpty()) return new ResponseEntity<String>("Não há nenhuma filial com o ID " + id.toString() + " cadastrada no sistema!", HttpStatus.NOT_FOUND);
            else return new ResponseEntity<Filial>(repositorioFilial.findById(id).get(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> postFilial(@RequestBody Filial filial) {
        try {
            return new ResponseEntity<Filial>(repositorioFilial.save(filial), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putFilial(@PathVariable Long id, @RequestBody Filial filial) {
        try {
            if (repositorioFilial.findById(id).isPresent()) {
                Filial filialEntidade = repositorioFilial.findById(id).get();

                filialEntidade = filialAtualizador.atualizar(filialEntidade, filial);
                
                filialEntidade = repositorioFilial.save(filialEntidade);
                return new ResponseEntity<>(filialEntidade, HttpStatus.OK);
            } else return new ResponseEntity<String>("Não há nenhuma filial com o ID " + id.toString() + " cadastrada no sistema!", HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFilial(@PathVariable Long id) {
        try {
            if (repositorioFilial.findById(id).isPresent()) {
                repositorioFilial.deleteById(id);
                return new ResponseEntity<String>("Filial deletada com sucesso!", HttpStatus.OK);
            } else return new ResponseEntity<String>("Não há nenhuma filial com o ID " + id.toString() + " cadastrada no sistema!", HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
