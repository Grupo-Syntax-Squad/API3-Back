package com.assetbox.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Endereco;

public interface RepositorioEndereco extends JpaRepository<Endereco, Long>{

}
