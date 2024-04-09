package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Imagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ima_id;
	
	@Column
	private String ima_nome;
	
	@Column
	private String ima_caminho;

	public Long getIma_id() {
		return ima_id;
	}

	public void setIma_id(Long ima_id) {
		this.ima_id = ima_id;
	}

	public String getIma_nome() {
		return ima_nome;
	}

	public void setIma_nome(String ima_nome) {
		this.ima_nome = ima_nome;
	}

	public String getIma_caminho() {
		return ima_caminho;
	}

	public void setIma_caminho(String ima_caminho) {
		this.ima_caminho = ima_caminho;
	}
}
