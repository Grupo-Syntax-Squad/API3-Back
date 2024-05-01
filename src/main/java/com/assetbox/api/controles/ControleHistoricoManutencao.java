package com.assetbox.api.controles;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.HistoricoManutencao;
import com.assetbox.api.repositorios.RepositorioHistoricoManutencao;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("historicosManutencao")
public class ControleHistoricoManutencao {
    @Autowired
    private RepositorioHistoricoManutencao repositorioHistoricoManutencao;

    @GetMapping("")
    public ResponseEntity<List<HistoricoManutencao>> getHistoricoManutencoes() {
        try {
            return ResponseEntity.ok(repositorioHistoricoManutencao.findAll());
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
