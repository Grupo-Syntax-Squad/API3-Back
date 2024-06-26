package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Localizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loc_id;

    @Column(nullable = false)
    private String loc_titulo;

    @Column()
    private Long loc_filial_id;

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

    public Long getLoc_filial_id() {
        return loc_filial_id;
    }

    public void setLoc_filial_id(Long loc_filial_id) {
        this.loc_filial_id = loc_filial_id;
    }
}
