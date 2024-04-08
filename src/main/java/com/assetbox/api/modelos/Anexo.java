package com.assetbox.api.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Anexo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ane_id;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Ativo ane_ativo_id;

	@Column
	private String ane_nome;

	@Column
	private String ane_caminho;

	public Long getAne_id() {
		return ane_id;
	}

	public void setAne_id(Long ane_id) {
		this.ane_id = ane_id;
	}

	public Ativo getAne_ativo_id() {
		return ane_ativo_id;
	}

	public void setAne_ativo_id(Ativo ane_ativo_id) {
		this.ane_ativo_id = ane_ativo_id;
	}

	public String getAne_nome() {
		return ane_nome;
	}

	public void setAne_nome(String ane_nome) {
		this.ane_nome = ane_nome;
	}

	public String getAne_caminho() {
		return ane_caminho;
	}

	public void setAne_caminho(String ane_caminho) {
		this.ane_caminho = ane_caminho;
	}
}
