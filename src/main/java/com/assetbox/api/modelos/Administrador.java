package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;

@Entity
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adm_id;
	
	@Column
	private String adm_nome;
	
	@Column
	private String email;
	
	@Column
	private String adm_senha;

	@Column
	private String adm_telefone;
	
	@Column(nullable = false, unique = true)
	private String adm_cpf;

//	@ManyToOne
//	@JoinColumn(name = "adm_empresa_id")
//	private Empresa adm_empresa_id;

	public Administrador() {
	}

	public Administrador(String adm_nome, String email, String adm_senha, String adm_telefone, String adm_cpf) {
		this.adm_nome = adm_nome;
		this.email = email;
		this.adm_senha = adm_senha;
		this.adm_telefone = adm_telefone;
		this.adm_cpf = adm_cpf;
	}

	public Long getAdm_id() {
		return adm_id;
	}

	public void setAdm_id(Long id) {
		this.adm_id = id;
	}

	public String getAdm_nome() {
		return adm_nome;
	}

	public void setAdm_nome(String adm_nome) {
		this.adm_nome = adm_nome;
	}

	public String getAdm_email() {
		return email;
	}

	public void setAdm_email(String email) {
		this.email = email;
	}

	public String getAdm_senha() {
		return adm_senha;
	}

	public void setAdm_senha(String adm_senha) {
		this.adm_senha = adm_senha;
	}

	public String getAdm_telefone() {
		return adm_telefone;
	}

	public void setAdm_telefone(String adm_telefone) {
		this.adm_telefone = adm_telefone;
	}

	public String getAdm_cpf() {
		return adm_cpf;
	}

	public void setAdm_cpf(String adm_cpf) {
		this.adm_cpf = adm_cpf;
	}
	
}
