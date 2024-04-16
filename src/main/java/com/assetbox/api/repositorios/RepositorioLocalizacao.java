package com.assetbox.API.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.API.modelos.Localizacao;

public interface RepositorioLocalizacao extends JpaRepository<Localizacao, Long>{
    
}
