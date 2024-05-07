package com.assetbox.api.processos;

import com.assetbox.api.modelos.Administrador;

public class AdministradorAtualizador {
    private StringVerificadorNulo stringVerificadorNulo = new StringVerificadorNulo();
    public Administrador atualizar(Administrador administradorEntidade, Administrador atualizacao) {
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAdm_cpf()))
            administradorEntidade.setAdm_cpf(atualizacao.getAdm_cpf());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAdm_email()))
            administradorEntidade.setAdm_email(atualizacao.getAdm_email());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAdm_nome()))
            administradorEntidade.setAdm_nome(atualizacao.getAdm_nome());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAdm_senha()))
            administradorEntidade.setAdm_senha(atualizacao.getAdm_senha());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAdm_telefone()))
            administradorEntidade.setAdm_telefone(atualizacao.getAdm_telefone());
        return administradorEntidade;
    }
}
