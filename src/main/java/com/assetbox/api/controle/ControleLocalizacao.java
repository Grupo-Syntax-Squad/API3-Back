package com.assetbox.api.controle;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Localizacao;
import com.assetbox.api.repositorio.RepositorioLocalizacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class ControleLocalizacao {
    @Autowired
    private RepositorioLocalizacao repositorioLocalizacao;

    @GetMapping("/localizacoes")
    public ResponseEntity<List<Localizacao>> getLocalizacoes() {
        return ResponseEntity.ok().body(repositorioLocalizacao.findAll());
    }

    @GetMapping("/localizacao/{id}")
    public ResponseEntity<Optional<Localizacao>> getLocalizacao(@RequestParam Long id) {
        return ResponseEntity.ok().body(repositorioLocalizacao.findById(id));
    }
    
    @PostMapping("/localizacao")
    public ResponseEntity<Localizacao> postLocalizacao(@RequestBody Localizacao localizacao) {
        return ResponseEntity.ok().body(repositorioLocalizacao.save(localizacao));
    }
}
