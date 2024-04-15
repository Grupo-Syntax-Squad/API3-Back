package com.assetbox.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Manutencao;

public interface RepositorioManutencao extends JpaRepository<Manutencao, Long>{

}
