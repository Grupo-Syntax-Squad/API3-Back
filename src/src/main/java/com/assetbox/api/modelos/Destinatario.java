package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Destinatario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long des_id;
	
	@Column
	private String des_nome;
	
	@Column
	private String des_email;
	
	@Column
	private String des_senha;
	
	@Column
	private String des_telefone;
	
	@Column
	private Long des_empresa;
	
	@OneToOne()
	@Column
	private Long des_endereco_id;
}
