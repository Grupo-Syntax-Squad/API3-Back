package com.assetbox.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Administrador;


public interface RepositorioAdministrador extends JpaRepository<Administrador, Long> {
    Administrador findByEmail(String adm_email);
    Administrador findByCpf(String adm_cpf);
    Administrador findByTelefone(String adm_telefone);
}
