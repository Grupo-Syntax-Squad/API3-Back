package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Destinatario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long des_id;

    @Column(nullable = false)
    private String des_nome;

    @Column(nullable = false)
    private String des_email;

    @Column(nullable = false)
    private String des_telefone;

    @Column
    private String des_senha;

    @ManyToOne
    @JoinColumn(name = "des_endereco_id")
    private Endereco des_endereco_id;

    public Long getDes_id() {
        return des_id;
    }

    public void setDes_id(Long des_id) {
        this.des_id = des_id;
    }

    public String getDes_nome() {
        return des_nome;
    }

    public void setDes_nome(String des_nome) {
        this.des_nome = des_nome;
    }

    public String getDes_email() {
        return des_email;
    }

    public void setDes_email(String des_email) {
        this.des_email = des_email;
    }

    public String getDes_telefone() {
        return des_telefone;
    }

    public void setDes_telefone(String des_telefone) {
        this.des_telefone = des_telefone;
    }

    public String getDes_senha() {
        return des_senha;
    }

    public void setDes_senha(String des_senha) {
        this.des_senha = des_senha;
    }

    public Endereco getDes_endereco_id() {
        return des_endereco_id;
    }

    public void setDes_endereco_id(Endereco des_endereco_id) {
        this.des_endereco_id = des_endereco_id;
    }

    
}
