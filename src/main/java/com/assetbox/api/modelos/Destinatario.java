package com.assetbox.api.modelos;

import com.assetbox.api.enums.DestinatarioStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String des_nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "des_endereco_id")
    private Endereco des_endereco_id;

    @Enumerated(EnumType.STRING)
    private DestinatarioStatus des_status;

    public DestinatarioStatus getDes_status() {
        return des_status;
    }

    public void setDes_status(DestinatarioStatus des_status) {
        this.des_status = des_status;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public Endereco getDes_endereco_id() {
        return des_endereco_id;
    }

    public void setDes_endereco_id(Endereco des_endereco_id) {
        this.des_endereco_id = des_endereco_id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
