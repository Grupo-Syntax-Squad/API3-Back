package com.assetbox.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.modelos.Filial;

public interface RepositorioAtivo extends JpaRepository<Ativo, Long>{
    List<Ativo> findByFilial(Filial filial);
}
