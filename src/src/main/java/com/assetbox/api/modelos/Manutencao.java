package com.assetbox.api.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Manutencao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long man_id;
	
	@Column
	private String man_descricao;
	
	@Column
	private String man_data;
	
	@Column
	private String man_hora;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Long man_administrador_id;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Long man_ativo_id;
	
	@Column
	private String man_localizacao;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Long man_endereco_id;
}
