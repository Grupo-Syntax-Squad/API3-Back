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
	
	@Column(nullable = false)
	private String end_numero;
	
	@Column(nullable = false)
	private String end_rua;
	
	@Column
	private String end_bairro;
	
	@Column
	private String end_cidade;
	
	@Column(nullable = false)
	private String end_uf;
	
	@Column
	private String end_complemento;
	
	@Column(nullable = false)
	private String end_cep;

	public Long getEnd_id() {
		return end_id;
	}

	public void setEnd_id(Long end_id) {
		this.end_id = end_id;
	}

	public String getEnd_numero() {
		return end_numero;
	}

	public void setEnd_numero(String end_numero) {
		this.end_numero = end_numero;
	}

	public String getEnd_rua() {
		return end_rua;
	}

	public void setEnd_rua(String end_rua) {
		this.end_rua = end_rua;
	}

	public String getEnd_bairro() {
		return end_bairro;
	}

	public void setEnd_bairro(String end_bairro) {
		this.end_bairro = end_bairro;
	}

	public String getEnd_cidade() {
		return end_cidade;
	}

	public void setEnd_cidade(String end_cidade) {
		this.end_cidade = end_cidade;
	}

	public String getEnd_uf() {
		return end_uf;
	}

	public void setEnd_uf(String end_uf) {
		this.end_uf = end_uf;
	}

	public String getEnd_complemento() {
		return end_complemento;
	}

	public void setEnd_complemento(String end_complemento) {
		this.end_complemento = end_complemento;
	}

	public String getEnd_cep() {
		return end_cep;
	}

	public void setEnd_cep(String end_cep) {
		this.end_cep = end_cep;
	}
	
}
