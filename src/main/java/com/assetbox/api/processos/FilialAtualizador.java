package com.assetbox.api.processos;

import com.assetbox.api.modelos.Filial;

public class FilialAtualizador {
    private StringVerificadorNulo stringVerificadorNulo = new StringVerificadorNulo();

    public Filial atualizar(Filial filialEntidade, Filial atualizacao) {
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getFil_nome())) filialEntidade.setFil_nome(atualizacao.getFil_nome());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getFil_email())) filialEntidade.setFil_email(atualizacao.getFil_email());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getFil_telefone())) filialEntidade.setFil_telefone(atualizacao.getFil_telefone());
        // Atualizar o endereço!!!
        return filialEntidade;
    }
}
