package com.assetbox.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Empresa;

public interface RepositorioEmpresa extends JpaRepository<Empresa, Long>{

}
