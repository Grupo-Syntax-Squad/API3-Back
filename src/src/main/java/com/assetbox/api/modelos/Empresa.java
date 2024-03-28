package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emp_id;
	
	@Column
	private String emp_nome;
	
	@Column
	private Long emp_endereco_id;
}
