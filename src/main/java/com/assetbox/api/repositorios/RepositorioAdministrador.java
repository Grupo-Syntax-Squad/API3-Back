package com.assetbox.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Administrador;

public interface RepositorioAdministrador extends JpaRepository<Administrador, Long> {
    Administrador findByEmail(String adm_email);
}
