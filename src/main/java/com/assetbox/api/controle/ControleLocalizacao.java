package com.assetbox.api.controle;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Localizacao;
import com.assetbox.api.repositorio.RepositorioLocalizacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<Localizacao> getLocalizacoes() {
    	try {
            List<Localizacao> listaLocalizacoes = repositorioLocalizacao.findAll();
            return listaLocalizacoes.isEmpty() ? null : listaLocalizacoes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/localizacao/{id}")
    public ResponseEntity<Optional<Localizacao>> getLocalizacao(@RequestParam Long id) {
    	Optional<Localizacao> localizacao = repositorioLocalizacao.findById(id);
    	if (localizacao == null) {
    		ResponseEntity<Optional<Localizacao>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		return resposta;
    	} else {
    		return ResponseEntity.ok(localizacao);
    	}
    }
    
    @PostMapping("cadastrar/localizacao")
    public ResponseEntity<Localizacao> postLocalizacao(@RequestBody Localizacao localizacao) {
    	try {
            Localizacao novaLocalizacao = repositorioLocalizacao.save(localizacao);
            return ResponseEntity.ok(novaLocalizacao);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
