package com.assetbox.api.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emp_id;
	
	@Column
	private String emp_nome;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Long emp_endereco_id;
}
