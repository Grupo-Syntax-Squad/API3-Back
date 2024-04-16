package com.assetbox.API.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.API.modelos.Imagem;

public interface RepositorioImagem extends JpaRepository<Imagem, Long>{
    
}
