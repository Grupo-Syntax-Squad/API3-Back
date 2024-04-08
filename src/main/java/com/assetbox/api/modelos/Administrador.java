package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adm_id;
	
	@Column
	private String adm_nome;
	
	@Column
	private String adm_email;
	
	@Column
	private String adm_senha;
	
	@Column
	private char adm_telefone;

	public Long getAdm_id() {
		return adm_id;
	}

	public void setAdm_id(Long adm_id) {
		this.adm_id = adm_id;
	}

	public String getAdm_nome() {
		return adm_nome;
	}

	public void setAdm_nome(String adm_nome) {
		this.adm_nome = adm_nome;
	}

	public String getAdm_email() {
		return adm_email;
	}

	public void setAdm_email(String adm_email) {
		this.adm_email = adm_email;
	}

	public String getAdm_senha() {
		return adm_senha;
	}

	public void setAdm_senha(String adm_senha) {
		this.adm_senha = adm_senha;
	}

	public char getAdm_telefone() {
		return adm_telefone;
	}

	public void setAdm_telefone(char adm_telefone) {
		this.adm_telefone = adm_telefone;
	}
	
	
}
