package com.assetbox.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Ativo;

public interface RepositorioAtivo extends JpaRepository<Ativo, Long>{

}
