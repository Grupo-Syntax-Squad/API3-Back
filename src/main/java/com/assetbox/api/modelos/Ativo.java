package com.assetbox.api.modelos;

import com.assetbox.api.enums.AtivoStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Ativo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ati_id;
	
	@Column
	private String ati_nome;
	
	@Column
	private String ati_localizacao;
	
	@Column
	private String ati_tipo;
	
	@Column
	private Integer ati_status;
	
	@Column
	private String ati_complemento;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Destinatario ati_destinatario_id;
	
	@Column
	private String ati_marca;

	@Column
	private String ati_modelo;

	@Column
	private String ati_numero_serie;
	
	@Column
	private int ati_quantidade;
	
	@Column
	private String ati_condicoes_uso;
	
	@Column
	private String ati_data_expiracao;
	
	@Column
	private String ati_previsao_manutencao;
	
	@Column
	private double ati_preco_aquisicao;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Administrador ati_administrador_id;
	
	@Column 
	private String ati_chave_nf_e;
	
	@Column
	private String ati_observacao;
	
	@Column
	private String ati_url;
	
	@Column
	private String ati_numero;
	
	@Column
	private double ati_manutencoes_feitas;
	
	@Column
	private String ati_ultima_manutencao;
	
	@Column
	private String ati_ano_fabricacao;
	
	@Column
	private String ati_titulo;
	
	@Column
	private String ati_capacidade;
	
	@Column
	private String ati_tamanho;

	public Long getAti_id() {
		return ati_id;
	}

	public void setAti_id(Long ati_id) {
		this.ati_id = ati_id;
	}

	public String getAti_nome() {
		return ati_nome;
	}

	public void setAti_nome(String ati_nome) {
		this.ati_nome = ati_nome;
	}

	public String getAti_localizacao() {
		return ati_localizacao;
	}

	public void setAti_localizacao(String ati_localizacao) {
		this.ati_localizacao = ati_localizacao;
	}

	public String getAti_tipo() {
		return ati_tipo;
	}

	public void setAti_tipo(String ati_tipo) {
		this.ati_tipo = ati_tipo;
	}

	public AtivoStatus getAti_status() {
		return AtivoStatus.valueOf(ati_ano_fabricacao);
	}

	public void setAti_status(Integer ati_status) {
		this.ati_status = ati_status;
	}

	public String getAti_complemento() {
		return ati_complemento;
	}

	public void setAti_complemento(String ati_complemento) {
		this.ati_complemento = ati_complemento;
	}

	public Destinatario getAti_destinatario_id() {
		return ati_destinatario_id;
	}

	public void setAti_destinatario_id(Destinatario ati_destinatario_id) {
		this.ati_destinatario_id = ati_destinatario_id;
	}

	public String getAti_marca() {
		return ati_marca;
	}

	public void setAti_marca(String ati_marca) {
		this.ati_marca = ati_marca;
	}

	public String getAti_modelo() {
		return ati_modelo;
	}

	public void setAti_modelo(String ati_modelo) {
		this.ati_modelo = ati_modelo;
	}

	public String getAti_numero_serie() {
		return ati_numero_serie;
	}

	public void setAti_numero_serie(String ati_numero_serie) {
		this.ati_numero_serie = ati_numero_serie;
	}

	public int getAti_quantidade() {
		return ati_quantidade;
	}

	public void setAti_quantidade(int ati_quantidade) {
		this.ati_quantidade = ati_quantidade;
	}

	public String getAti_condicoes_uso() {
		return ati_condicoes_uso;
	}

	public void setAti_condicoes_uso(String ati_condicoes_uso) {
		this.ati_condicoes_uso = ati_condicoes_uso;
	}

	public String getAti_data_expiracao() {
		return ati_data_expiracao;
	}

	public void setAti_data_expiracao(String ati_data_expiracao) {
		this.ati_data_expiracao = ati_data_expiracao;
	}

	public String getAti_previsao_manutencao() {
		return ati_previsao_manutencao;
	}

	public void setAti_previsao_manutencao(String ati_previsao_manutencao) {
		this.ati_previsao_manutencao = ati_previsao_manutencao;
	}

	public double getAti_preco_aquisicao() {
		return ati_preco_aquisicao;
	}

	public void setAti_preco_aquisicao(double ati_preco_aquisicao) {
		this.ati_preco_aquisicao = ati_preco_aquisicao;
	}

	public Administrador getAti_administrador_id() {
		return ati_administrador_id;
	}

	public void setAti_administrador_id(Administrador ati_administrador_id) {
		this.ati_administrador_id = ati_administrador_id;
	}

	public String getAti_chave_nf_e() {
		return ati_chave_nf_e;
	}

	public void setAti_chave_nf_e(String ati_chave_nf_e) {
		this.ati_chave_nf_e = ati_chave_nf_e;
	}

	public String getAti_observacao() {
		return ati_observacao;
	}

	public void setAti_observacao(String ati_observacao) {
		this.ati_observacao = ati_observacao;
	}

	public String getAti_url() {
		return ati_url;
	}

	public void setAti_url(String ati_url) {
		this.ati_url = ati_url;
	}

	public String getAti_numero() {
		return ati_numero;
	}

	public void setAti_numero(String ati_numero) {
		this.ati_numero = ati_numero;
	}

	public double getAti_manutencoes_feitas() {
		return ati_manutencoes_feitas;
	}

	public void setAti_manutencoes_feitas(double ati_manutencoes_feitas) {
		this.ati_manutencoes_feitas = ati_manutencoes_feitas;
	}

	public String getAti_ultima_manutencao() {
		return ati_ultima_manutencao;
	}

	public void setAti_ultima_manutencao(String ati_ultima_manutencao) {
		this.ati_ultima_manutencao = ati_ultima_manutencao;
	}

	public String getAti_ano_fabricacao() {
		return ati_ano_fabricacao;
	}

	public void setAti_ano_fabricacao(String ati_ano_fabricacao) {
		this.ati_ano_fabricacao = ati_ano_fabricacao;
	}

	public String getAti_titulo() {
		return ati_titulo;
	}

	public void setAti_titulo(String ati_titulo) {
		this.ati_titulo = ati_titulo;
	}

	public String getAti_capacidade() {
		return ati_capacidade;
	}

	public void setAti_capacidade(String ati_capacidade) {
		this.ati_capacidade = ati_capacidade;
	}

	public String getAti_tamanho() {
		return ati_tamanho;
	}

	public void setAti_tamanho(String ati_tamanho) {
		this.ati_tamanho = ati_tamanho;
	}
	
}
