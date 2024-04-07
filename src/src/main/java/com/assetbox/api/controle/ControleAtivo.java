package com.assetbox.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.repositorio.RepositorioAtivo;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class ControleAtivo {
	
	@Autowired
	private RepositorioAtivo ativo;
	
	@GetMapping("/ativo")
	public List<Ativo> obterAtivo(){
		return ativo.findAll();
	}

	@PostMapping("/cadastrar/ativo")
	public Ativo cadastrarAtivo(@RequestBody Ativo ativo) {
		return this.ativo.save(ativo);
	}
}