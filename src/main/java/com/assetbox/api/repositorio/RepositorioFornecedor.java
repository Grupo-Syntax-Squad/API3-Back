package com.assetbox.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Fornecedor;

public interface RepositorioFornecedor extends JpaRepository<Fornecedor, Long>{

}
