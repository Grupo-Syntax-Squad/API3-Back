package com.assetbox.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Imagem;

public interface RepositorioImagem extends JpaRepository<Imagem, Long>{
    
}
