package com.assetbox.api.processos;

import com.assetbox.api.modelos.Filial;

public class FilialAtualizador {
    private StringVerificadorNulo stringVerificadorNulo = new StringVerificadorNulo();
    private EnderecoAtualizador enderecoAtualizador = new EnderecoAtualizador();

    public Filial atualizar(Filial filialEntidade, Filial atualizacao) {
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getFil_nome())) filialEntidade.setFil_nome(atualizacao.getFil_nome());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getFil_email())) filialEntidade.setFil_email(atualizacao.getFil_email());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getFil_telefone())) filialEntidade.setFil_telefone(atualizacao.getFil_telefone());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getFil_cnpj())) filialEntidade.setFil_cnpj(atualizacao.getFil_cnpj());
        if (!(atualizacao.getFil_endereco() == null)) filialEntidade.setFil_endereco(enderecoAtualizador.atualizar(filialEntidade.getFil_endereco(), atualizacao.getFil_endereco()));
        return filialEntidade;
    }
}
