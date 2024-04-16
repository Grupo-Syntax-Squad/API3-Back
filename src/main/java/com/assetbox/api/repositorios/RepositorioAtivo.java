package com.assetbox.API.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.API.modelos.Ativo;

public interface RepositorioAtivo extends JpaRepository<Ativo, Long>{
    
}
