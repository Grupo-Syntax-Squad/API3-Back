package com.assetbox.api.modelos;

import java.sql.Date;
import java.sql.Time;

import org.hibernate.annotations.Collate;

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
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "man_ativo_id")
    // private Ativo man_ativo_id;

    // @ManyToOne
    // @JoinColumn(name = "ma_administrador_id")
    // private Administrador man_administrador_id;

    // @ManyToOne
    // @JoinColumn(name = "man_endereco_id")
    // private Endereco man_endereco_id;

    @Column(nullable = false)
    private String man_desc;
    
    @Column(nullable = false)
    private Date man_data;

    // @Column(nullable = false)
    // private Time man_hora;

    @Column(nullable = false)
    private String man_localizacao;

    @Enumerated(EnumType.STRING)
    private ManutencaoStatus man_status;
}
