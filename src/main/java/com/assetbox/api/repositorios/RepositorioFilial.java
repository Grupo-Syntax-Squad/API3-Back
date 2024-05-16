package com.assetbox.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Filial;

public interface RepositorioFilial extends JpaRepository<Filial, Long>{
    
}
