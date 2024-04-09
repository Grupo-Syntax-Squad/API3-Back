package com.assetbox.api.modelos;

import com.assetbox.api.enums.ManutencaoStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
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
	
	@Column
	private Integer man_status;
	
	public ManutencaoStatus getMan_status() {
		return ManutencaoStatus.valueOf(man_status);
	}

	public void setMan_status(Integer man_status) {
		this.man_status = man_status;
	}

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Administrador man_administrador_id;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Ativo man_ativo_id;
	
	@Column
	private String man_localizacao;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco man_endereco_id;

	public Long getMan_id() {
		return man_id;
	}

	public void setMan_id(Long man_id) {
		this.man_id = man_id;
	}

	public String getMan_descricao() {
		return man_descricao;
	}

	public void setMan_descricao(String man_descricao) {
		this.man_descricao = man_descricao;
	}

	public String getMan_data() {
		return man_data;
	}

	public void setMan_data(String man_data) {
		this.man_data = man_data;
	}

	public String getMan_hora() {
		return man_hora;
	}

	public void setMan_hora(String man_hora) {
		this.man_hora = man_hora;
	}

	public Administrador getMan_administrador_id() {
		return man_administrador_id;
	}

	public void setMan_administrador_id(Administrador man_administrador_id) {
		this.man_administrador_id = man_administrador_id;
	}

	public Ativo getMan_ativo_id() {
		return man_ativo_id;
	}

	public void setMan_ativo_id(Ativo man_ativo_id) {
		this.man_ativo_id = man_ativo_id;
	}

	public String getMan_localizacao() {
		return man_localizacao;
	}

	public void setMan_localizacao(String man_localizacao) {
		this.man_localizacao = man_localizacao;
	}

	public Endereco getMan_endereco_id() {
		return man_endereco_id;
	}

	public void setMan_endereco_id(Endereco man_endereco_id) {
		this.man_endereco_id = man_endereco_id;
	}
	
	
}
