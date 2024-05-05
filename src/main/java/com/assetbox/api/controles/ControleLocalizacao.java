package com.assetbox.api.controles;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Localizacao;
import com.assetbox.api.repositorios.RepositorioLocalizacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ControleLocalizacao {
    @Autowired
    private RepositorioLocalizacao repositorioLocalizacao;

    @GetMapping("/localizacoes")
    public ResponseEntity<List<Localizacao>> getLocalizacoes() {
        return ResponseEntity.ok().body(repositorioLocalizacao.findAll());
    }
    
    @GetMapping("/localizacoes/{id}")
    public ResponseEntity<Localizacao> getLocalizacao(@PathVariable Long id) {
        return ResponseEntity.ok().body(repositorioLocalizacao.findById(id).get());
    }

    @PostMapping("/localizacoes")
    public ResponseEntity<Localizacao> postLocalizacao(@RequestBody Localizacao localizacao) {
        return ResponseEntity.ok().body(repositorioLocalizacao.save(localizacao));
    }
}
