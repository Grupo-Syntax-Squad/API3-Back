package com.assetbox.api.modelos;

import java.sql.Time;
import java.util.Date;

import com.assetbox.api.enums.ManutencaoStatus;

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
public class HistoricoManutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "his_ativo_id")
    private Ativo his_ativo_id;

    @Column
    private Long his_manutencao_id;

    @Column
    private String man_atividade;

    @Column
    private Date man_data;

    @Column
    private Time man_horario;

    @Enumerated(EnumType.STRING)
    private ManutencaoStatus man_status;

    @Column
    private String man_responsavel;

    public HistoricoManutencao() {
    }

    public HistoricoManutencao(Ativo his_ativo_id, Long his_manutencao_id, String man_atividade, Date man_data, Time man_horario, ManutencaoStatus man_status, String man_responsavel) {
        this.his_ativo_id = his_ativo_id;
        this.his_manutencao_id = his_manutencao_id;
        this.man_atividade = man_atividade;
        this.man_data = man_data;
        this.man_horario = man_horario;
        this.man_status = man_status;
        this.man_responsavel = man_responsavel;
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

    public Long getHis_manutencao_id() {
        return his_manutencao_id;
    }

    public void setHis_manutencao_id(Long his_manutencao_id) {
        this.his_manutencao_id = his_manutencao_id;
    }

    public String getMan_atividade() {
        return man_atividade;
    }

    public void setMan_atividade(String man_atividade) {
        this.man_atividade = man_atividade;
    }

    public Date getMan_data() {
        return man_data;
    }

    public void setMan_data(Date man_data) {
        this.man_data = man_data;
    }

    public Time getMan_horario() {
        return man_horario;
    }

    public void setMan_horario(Time man_horario) {
        this.man_horario = man_horario;
    }

    public ManutencaoStatus getMan_status() {
        return man_status;
    }

    public void setMan_status(ManutencaoStatus man_status) {
        this.man_status = man_status;
    }

    public String getMan_responsavel() {
        return man_responsavel;
    }

    public void setMan_responsavel(String man_responsavel) {
        this.man_responsavel = man_responsavel;
    }

    
}