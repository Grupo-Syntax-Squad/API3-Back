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
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long man_id;

    @Column(nullable = false)
    private String man_atividade;

    @Column(nullable = false)
    private Date man_data;

    @Column(nullable = false)
    private Time man_horario;

    // @ManyToOne
    // @JoinColumn(name = "ma_administrador_id")
    // private Administrador man_administrador_id;

    @ManyToOne
    @JoinColumn(name = "man_ativo_id")
    private Ativo man_ativo_id;

    @ManyToOne
    @JoinColumn(name = "man_endereco_id")
    private Endereco man_endereco_id;

    @Enumerated(EnumType.STRING)
    private ManutencaoStatus man_status;

    @Column(nullable = false)
    private String man_responsavel;

    public Long getMan_id() {
        return man_id;
    }

    public void setMan_id(Long man_id) {
        this.man_id = man_id;
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

    public Ativo getMan_ativo_id() {
        return man_ativo_id;
    }

    public void setMan_ativo_id(Ativo man_ativo_id) {
        this.man_ativo_id = man_ativo_id;
    }

    public Endereco getMan_endereco_id() {
        return man_endereco_id;
    }

    public void setMan_endereco_id(Endereco man_endereco_id) {
        this.man_endereco_id = man_endereco_id;
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
