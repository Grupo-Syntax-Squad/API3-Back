package com.assetbox.api.modelos;


import java.util.Date;

import com.assetbox.api.enums.AtiStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Ativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ati_id;
    
    @ManyToOne
    @JoinColumn(name = "ati_localizacao_id")
    private Localizacao ati_localizacao_id;

    @ManyToOne
    @JoinColumn(name = "ati_tipo_id")
    private Tipo ati_tipo_id;
    
    @Enumerated(EnumType.STRING)
    private AtiStatus ati_status;

    @Column
    private String ati_complemento;

    @ManyToOne
    @JoinColumn(name = "ati_destinatario_id")
    private Destinatario ati_destinatario_id;

    @Column
    private String ati_marca;

    @Column
    private String ati_modelo;

    @Column(nullable = false, unique = true)
    private String ati_numero_serie;

    @Column
    private int ati_quantidade;

    @Column
    private Date ati_data_expiracao;

    @Column
    private Date ati_previsao_manutencao;

    @Column(nullable = false)
    private double ati_preco_aquisicao;

    @Column(nullable = false, unique = true)
    private String ati_chave_nf_e;

    @Column
    private String ati_observacao;

    @Column(unique = true)
    private String ati_url;

    @Column(nullable = false, unique = true)
    private String ati_numero;

    @Column
    private int ati_manutencoes_feitas;

    @Column
    private Date ati_ultima_manutencao;

    @Column
    private String ati_ano_fabricacao;

    @Column
    private String ati_titulo;

    @Column
    private String ati_capacidade;

    @Column
    private String ati_tamanho;

    @Column(nullable = false)
    private Date ati_data_cadastro;

    @OneToOne
    @JoinColumn(name = "ati_imagem_id")
    private Imagem ati_imagem_id;

    @Column
    private String ati_condicoes_uso;

    public Long getAti_id() {
        return ati_id;
    }

    public void setAti_id(Long ati_id) {
        this.ati_id = ati_id;
    }

    public Localizacao getAti_localizacao_id() {
        return ati_localizacao_id;
    }

    public void setAti_localizacao_id(Localizacao ati_localizacao_id) {
        this.ati_localizacao_id = ati_localizacao_id;
    }

    public Tipo getAti_tipo_id() {
        return ati_tipo_id;
    }

    public void setAti_tipo_id(Tipo ati_tipo_id) {
        this.ati_tipo_id = ati_tipo_id;
    }

    public AtiStatus getAti_status() {
        return ati_status;
    }

    public void setAti_status(AtiStatus ati_status) {
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

    public Date getAti_data_expiracao() {
        return ati_data_expiracao;
    }

    public void setAti_data_expiracao(Date ati_data_expiracao) {
        this.ati_data_expiracao = ati_data_expiracao;
    }

    public Date getAti_previsao_manutencao() {
        return ati_previsao_manutencao;
    }

    public void setAti_previsao_manutencao(Date ati_previsao_manutencao) {
        this.ati_previsao_manutencao = ati_previsao_manutencao;
    }

    public double getAti_preco_aquisicao() {
        return ati_preco_aquisicao;
    }

    public void setAti_preco_aquisicao(double ati_preco_aquisicao) {
        this.ati_preco_aquisicao = ati_preco_aquisicao;
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

    public int getAti_manutencoes_feitas() {
        return ati_manutencoes_feitas;
    }

    public void setAti_manutencoes_feitas(int ati_manutencoes_feitas) {
        this.ati_manutencoes_feitas = ati_manutencoes_feitas;
    }

    public Date getAti_ultima_manutencao() {
        return ati_ultima_manutencao;
    }

    public void setAti_ultima_manutencao(Date ati_ultima_manutencao) {
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

    public Date getAti_data_cadastro() {
        return ati_data_cadastro;
    }

    public void setAti_data_cadastro(Date ati_data_cadastro) {
        this.ati_data_cadastro = ati_data_cadastro;
    }

    public Imagem getAti_imagem_id() {
        return ati_imagem_id;
    }

    public void setAti_imagem_id(Imagem ati_imagem_id) {
        this.ati_imagem_id = ati_imagem_id;
    }

    public String getAti_condicoes_uso() {
        return ati_condicoes_uso;
    }

    public void setAti_condicoes_uso(String ati_condicoes_uso) {
        this.ati_condicoes_uso = ati_condicoes_uso;
    }

    
}
