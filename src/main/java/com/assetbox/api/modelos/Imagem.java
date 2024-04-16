package com.assetbox.API.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Imagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long img_id;

    @Column(nullable = false)
    private String img_nome;

    @Column(nullable = false)
    private String img_caminho;

    public Long getImg_id() {
        return img_id;
    }

    public void setImg_id(Long img_id) {
        this.img_id = img_id;
    }

    public String getImg_nome() {
        return img_nome;
    }

    public void setImg_nome(String img_nome) {
        this.img_nome = img_nome;
    }

    public String getImg_caminho() {
        return img_caminho;
    }

    public void setImg_caminho(String img_caminho) {
        this.img_caminho = img_caminho;
    }

    
}
