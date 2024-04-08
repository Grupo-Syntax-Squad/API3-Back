package com.assetbox.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.repositorio.RepositorioAtivo;
import com.assetbox.api.repositorio.RepositorioDeletados;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ControleDeletados {
    
    private RepositorioDeletados deletados;

    @GetMapping("/ativos/deletados")
    public List<Ativo> obterAtivosDeletados(){
        return (List<Ativo>) deletados;
    }
}