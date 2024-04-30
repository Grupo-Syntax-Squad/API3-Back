package com.assetbox.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.HistoricoManutencao;

public interface RepositorioHistoricoManutencao extends JpaRepository<HistoricoManutencao, Long> {
    
}