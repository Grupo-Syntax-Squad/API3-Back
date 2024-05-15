package com.assetbox.api.processos;

import com.assetbox.api.modelos.Matriz;

public class MatrizAtualizador {
    private StringVerificadorNulo stringVerificadorNulo = new StringVerificadorNulo();
    private EnderecoAtualizador enderecoAtualizador = new EnderecoAtualizador();

    public Matriz atualizar(Matriz matrizEntidade, Matriz atualizacao) {
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getMat_cnpj())) matrizEntidade.setMat_cnpj(atualizacao.getMat_cnpj());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getMat_email())) matrizEntidade.setMat_email(atualizacao.getMat_email());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getMat_nome_fantasia())) matrizEntidade.setMat_nome_fantasia(atualizacao.getMat_nome_fantasia());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getMat_razao_social())) matrizEntidade.setMat_razao_social(atualizacao.getMat_razao_social());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getMat_telefone())) matrizEntidade.setMat_telefone(atualizacao.getMat_telefone());
        if (!(atualizacao.getMat_endereco() == null)) matrizEntidade.setMat_endereco(enderecoAtualizador.atualizar(matrizEntidade.getMat_endereco(), atualizacao.getMat_endereco()));
        return matrizEntidade;
    }
}
