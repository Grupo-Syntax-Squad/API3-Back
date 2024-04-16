package com.assetbox.API.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.API.modelos.Tipo;

public interface RepositorioTipo extends JpaRepository<Tipo, Long>{
    
}
