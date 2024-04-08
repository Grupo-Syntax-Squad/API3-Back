package com.assetbox.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Imagem;

public interface RepositorioImagem extends JpaRepository<Imagem, Long>{

}
