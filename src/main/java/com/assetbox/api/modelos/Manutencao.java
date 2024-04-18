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

    @ManyToOne
    @JoinColumn(name = "man_ativo_id")
    private Ativo man_ativo_id;

    // @ManyToOne
    // @JoinColumn(name = "ma_administrador_id")
    // private Administrador man_administrador_id;

    @ManyToOne
    @JoinColumn(name = "man_endereco_id")
    private Endereco man_endereco_id;

    @Column(nullable = false)
    private String man_desc;
    
    @Column(nullable = false)
    private Date man_data;

    @Column(nullable = false)
    private Time man_hora;

    @Column(nullable = false)
    private String man_localizacao;

    @Enumerated(EnumType.STRING)
    private ManutencaoStatus man_status;

    public Long getMan_id() {
        return man_id;
    }

    public void setMan_id(Long man_id) {
        this.man_id = man_id;
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

    public String getMan_desc() {
        return man_desc;
    }

    public void setMan_desc(String man_desc) {
        this.man_desc = man_desc;
    }

    public Date getMan_data() {
        return man_data;
    }

    public void setMan_data(Date man_data) {
        this.man_data = man_data;
    }

    public Time getMan_hora() {
        return man_hora;
    }

    public void setMan_hora(Time man_hora) {
        this.man_hora = man_hora;
    }

    public String getMan_localizacao() {
        return man_localizacao;
    }

    public void setMan_localizacao(String man_localizacao) {
        this.man_localizacao = man_localizacao;
    }

    public ManutencaoStatus getMan_status() {
        return man_status;
    }

    public void setMan_status(ManutencaoStatus man_status) {
        this.man_status = man_status;
    }
}
