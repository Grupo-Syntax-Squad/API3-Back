package com.assetbox.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Destinatario;

public interface RepositorioDestinatario extends JpaRepository<Destinatario, Long>{

}