package com.assetbox.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Anexo;
import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.repositorio.RepositorioAnexo;
import com.assetbox.api.repositorio.RepositorioAtivo;
import com.assetbox.api.repositorio.RepositorioDestinatario;
import com.assetbox.api.repositorio.RepositorioImagem;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class ControleAtivo {
	@Autowired
	private RepositorioAnexo anexoRepositorio;

	@Autowired
	private RepositorioAtivo ativoRepositorio;

	@Autowired
	private RepositorioDestinatario destinatarioRepositorio;

	@Autowired
	private RepositorioImagem imagemRepositorio;

	@GetMapping("/ativos")
	public List<Ativo> obterAtivo() {
		return ativoRepositorio.findAll();
	}

	@PostMapping("/cadastrar/ativo")
	public void cadastrarAtivo(@RequestBody Ativo ativo) {
	}
}
