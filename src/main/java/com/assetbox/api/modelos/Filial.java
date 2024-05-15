package com.assetbox.api.modelos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fil_id;

    @Column(nullable = false, unique = true)
    private String fil_nome;

    @Column(nullable = false, unique = true)
    private String fil_telefone;
    
    @Column(nullable = false, unique = true)
    private String fil_email;

    @OneToOne
    @JoinColumn(name = "fil_endereco", nullable = false)
    private Endereco fil_endereco;

    @OneToMany(mappedBy = "filial")
    private List<Localizacao> localizacoes = new ArrayList<>();

    public Long getFil_id() {
        return fil_id;
    }

    public void setFil_id(Long fil_id) {
        this.fil_id = fil_id;
    }

    public String getFil_nome() {
        return fil_nome;
    }

    public void setFil_nome(String fil_nome) {
        this.fil_nome = fil_nome;
    }

    public String getFil_telefone() {
        return fil_telefone;
    }

    public void setFil_telefone(String fil_telefone) {
        this.fil_telefone = fil_telefone;
    }

    public String getFil_email() {
        return fil_email;
    }

    public void setFil_email(String fil_email) {
        this.fil_email = fil_email;
    }

    public Endereco getFil_endereco() {
        return fil_endereco;
    }

    public void setFil_endereco(Endereco fil_endereco) {
        this.fil_endereco = fil_endereco;
    }

    public List<Localizacao> getLocalizacoes() {
        return localizacoes;
    }

    public void setLocalizacoes(List<Localizacao> localizacoes) {
        this.localizacoes = localizacoes;
    }
}
