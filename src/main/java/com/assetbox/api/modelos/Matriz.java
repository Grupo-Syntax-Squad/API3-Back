package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Matriz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mat_id;

    @OneToOne
    @JoinColumn(name = "mat_endereco", nullable = false)
    private Endereco mat_endereco;

    @Column(nullable = false, unique = true)
    private String mat_cnpj;

    @Column(nullable = false)
    private String mat_razao_social;

    @Column(nullable = false)
    private String mat_nome_fantasia;

    @Column(nullable = false)
    private String mat_telefone;

    @Column(nullable = false)
    private String mat_email;

    public Long getMat_id() {
        return mat_id;
    }

    public void setMat_id(Long mat_id) {
        this.mat_id = mat_id;
    }

    public Endereco getMat_endereco() {
        return mat_endereco;
    }

    public void setMat_endereco(Endereco mat_endereco) {
        this.mat_endereco = mat_endereco;
    }

    public String getMat_cnpj() {
        return mat_cnpj;
    }

    public void setMat_cnpj(String mat_cnpj) {
        this.mat_cnpj = mat_cnpj;
    }

    public String getMat_razao_social() {
        return mat_razao_social;
    }

    public void setMat_razao_social(String mat_razao_social) {
        this.mat_razao_social = mat_razao_social;
    }

    public String getMat_nome_fantasia() {
        return mat_nome_fantasia;
    }

    public void setMat_nome_fantasia(String mat_nome_fantasia) {
        this.mat_nome_fantasia = mat_nome_fantasia;
    }

    public String getMat_telefone() {
        return mat_telefone;
    }

    public void setMat_telefone(String mat_telefone) {
        this.mat_telefone = mat_telefone;
    }

    public String getMat_email() {
        return mat_email;
    }

    public void setMat_email(String mat_email) {
        this.mat_email = mat_email;
    }
}
