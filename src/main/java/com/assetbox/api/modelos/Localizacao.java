package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Localizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loc_id;

    @Column(nullable = false)
    private String loc_titulo;

    @ManyToOne
    @JoinColumn(name = "loc_filial_id", nullable = false)
    private Filial loc_filial;

    public Long getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(Long loc_id) {
        this.loc_id = loc_id;
    }

    public String getLoc_titulo() {
        return loc_titulo;
    }

    public void setLoc_titulo(String loc_titulo) {
        this.loc_titulo = loc_titulo;
    }

    public Filial getLoc_filial() {
        return loc_filial;
    }

    public void setLoc_filial(Filial loc_filial) {
        this.loc_filial = loc_filial;
    }

    
}
