package com.assetbox.api.modelos;


import com.assetbox.api.enums.AdminStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	@Column(nullable = false)
	private String adm_nome;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String adm_senha;

	@Column(nullable = false, unique = true)
	private String telefone;
	
	@Column(nullable = false, unique = true)
	private String cpf;

	@Enumerated(EnumType.STRING)
	private AdminStatus status;

//	@ManyToOne
//	@JoinColumn(name = "adm_empresa_id")
//	private Empresa adm_empresa_id;

	public Administrador() {
	}

	public Administrador(String adm_nome, String email, String adm_senha, String adm_telefone, String adm_cpf, AdminStatus status) {
		this.adm_nome = adm_nome;
		this.email = email;
		this.adm_senha = adm_senha;
		this.telefone = adm_telefone;
		this.cpf = adm_cpf;
		this.status = status;
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
		return telefone;
	}

	public void setAdm_telefone(String adm_telefone) {
		this.telefone = adm_telefone;
	}

	public String getAdm_cpf() {
		return cpf;
	}

	public void setAdm_cpf(String adm_cpf) {
		this.cpf = adm_cpf;
	}

	public AdminStatus getStatus() {
		return status;
	}

	public void setStatus(AdminStatus status) {
		this.status = status;
	}
}
