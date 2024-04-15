package com.assetbox.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Tipo;

public interface RepositorioTipo extends JpaRepository<Tipo, Long> {
    
}
