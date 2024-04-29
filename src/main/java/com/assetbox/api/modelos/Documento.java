package com.assetbox.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentoId;

    @Column(nullable = false)
    private String documentoNome;

    @Column(nullable = false)
    private String documentoCaminho;

    public Long getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(Long documentoId) {
        this.documentoId = documentoId;
    }

    public String getDocumentoNome() {
        return documentoNome;
    }

    public void setDocumentoNome(String documentoNome) {
        this.documentoNome = documentoNome;
    }

    public String getDocumentoCaminho() {
        return documentoCaminho;
    }

    public void setDocumentoCaminho(String documentoCaminho) {
        this.documentoCaminho = documentoCaminho;
    }
}
