package com.assetbox.api.controles;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.HistoricoManutencao;
import com.assetbox.api.modelos.Manutencao;
import com.assetbox.api.repositorios.RepositorioHistoricoManutencao;
import com.assetbox.api.repositorios.RepositorioManutencao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ControleManutencao {
    @Autowired
    private RepositorioManutencao repositorioManutencao;

    @Autowired
    private RepositorioHistoricoManutencao repositorioHistoricoManutencao;

    @GetMapping("/manutencoes")
    public ResponseEntity<List<Manutencao>> getManutencoes() {
        try {
            return new ResponseEntity<List<Manutencao>>(repositorioManutencao.findAll(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<List<Manutencao>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/manutencoes")
    public ResponseEntity<?> postManutencao(@RequestBody Manutencao manutencao) {
        try {
            Manutencao manutencaoEntidade = repositorioManutencao.save(manutencao);
            HistoricoManutencao historicoManutencao = new HistoricoManutencao(manutencao.getMan_ativo_id(), manutencaoEntidade);
            repositorioHistoricoManutencao.save(historicoManutencao);
            return new ResponseEntity<Manutencao>(manutencaoEntidade, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
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

        @DeleteMapping("/manutencoes/{id}")
    public ResponseEntity<?> deleteAtivo(@PathVariable Long id) {
        repositorioManutencao.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
