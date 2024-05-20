package com.assetbox.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetbox.api.modelos.Destinatario;

public interface RepositorioDestinatario extends JpaRepository<Destinatario, Long> {
    Destinatario findByEmail(String des_email);
    Destinatario findByCpf(String des_cpf);
    Destinatario findByTelefone(String des_telefone);
}
