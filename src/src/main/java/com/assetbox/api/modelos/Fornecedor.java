package com.assetbox.api.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long for_id;
	
	@Column
	private String for_nome;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Long for_endereco_id;
}
