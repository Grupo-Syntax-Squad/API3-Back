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
}
