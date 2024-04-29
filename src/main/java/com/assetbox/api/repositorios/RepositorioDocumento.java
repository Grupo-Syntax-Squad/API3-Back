package com.assetbox.api.repositorios;

import javax.swing.text.Document;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Documento;

public interface RepositorioDocumento extends JpaRepository<Documento, Long> {
    
}
