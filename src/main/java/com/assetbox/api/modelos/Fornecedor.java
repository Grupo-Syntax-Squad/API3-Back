package com.assetbox.api.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long for_id;
	
	@Column
	private String for_nome;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco for_endereco_id;
	
	@Column(nullable = false)
	private String for_telefone;

	public String getFor_telefone() {
		return for_telefone;
	}

	public void setFor_telefone(String for_telefone) {
		this.for_telefone = for_telefone;
	}

	public Long getFor_id() {
		return for_id;
	}

	public void setFor_id(Long for_id) {
		this.for_id = for_id;
	}

	public String getFor_nome() {
		return for_nome;
	}

	public void setFor_nome(String for_nome) {
		this.for_nome = for_nome;
	}

	public Endereco getFor_endereco_id() {
		return for_endereco_id;
	}

	public void setFor_endereco_id(Endereco for_endereco_id) {
		this.for_endereco_id = for_endereco_id;
	}
	
}
