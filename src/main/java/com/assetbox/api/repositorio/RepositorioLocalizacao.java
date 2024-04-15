package com.assetbox.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Localizacao;

public interface RepositorioLocalizacao extends JpaRepository<Localizacao, Long> {
    
}
