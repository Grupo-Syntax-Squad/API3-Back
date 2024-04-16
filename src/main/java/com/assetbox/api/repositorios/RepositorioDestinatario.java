package com.assetbox.API.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.API.modelos.Destinatario;

public interface RepositorioDestinatario extends JpaRepository<Destinatario, Long> {
    
}
