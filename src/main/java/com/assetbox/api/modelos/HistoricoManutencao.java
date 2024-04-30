package com.assetbox.api.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HistoricoManutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "his_ativo_id")
    private Ativo his_ativo_id;

    @ManyToOne
    @JoinColumn(name = "his_man_id")
    private Manutencao his_manutencao_id;

    public HistoricoManutencao() {
    }

    public HistoricoManutencao(Ativo his_ativo_id, Manutencao his_manutencao_id) {
        this.his_ativo_id = his_ativo_id;
        this.his_manutencao_id = his_manutencao_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ativo getHis_ativo_id() {
        return his_ativo_id;
    }

    public void setHis_ativo_id(Ativo his_ativo_id) {
        this.his_ativo_id = his_ativo_id;
    }

    public Manutencao getHis_manutencao_id() {
        return his_manutencao_id;
    }

    public void setHis_manutencao_id(Manutencao his_manutencao_id) {
        this.his_manutencao_id = his_manutencao_id;
    }
}