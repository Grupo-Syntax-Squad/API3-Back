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
	private String ima_ativo_id;
	
	@Column
	private String ima_nome;
	
	@Column
	private String ima_caminho;
	
}
