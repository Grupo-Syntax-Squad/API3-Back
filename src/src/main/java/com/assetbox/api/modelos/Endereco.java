package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long end_id;
	
	@Column
	private String end_numero;
	
	@Column
	private String end_rua;
	
	@Column
	private String end_bairro;
	
	@Column
	private String end_cidade;
	
	@Column
	private String end_uf;
	
	@Column
	private String end_complemento;
}
