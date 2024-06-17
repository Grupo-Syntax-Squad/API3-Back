package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tip_id;
    
    @Column(nullable = false)
    private String tip_titulo;

    public Long getTip_id() {
        return tip_id;
    }

    public void setTip_id(Long tip_id) {
        this.tip_id = tip_id;
    }

    public String getTip_titulo() {
        return tip_titulo;
    }

    public void setTip_titulo(String tip_titulo) {
        this.tip_titulo = tip_titulo;
    }
}