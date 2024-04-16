package com.assetbox.API.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.API.modelos.Endereco;

public interface RepositorioEndereco extends JpaRepository<Endereco, Long>{
    
}
