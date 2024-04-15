package com.assetbox.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Administrador;
 

public interface RepositorioAdministrador extends JpaRepository<Administrador, Long>{

}
