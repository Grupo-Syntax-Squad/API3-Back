package com.assetbox.api.processos;

import com.assetbox.api.modelos.Endereco;

public class EnderecoAtualizador {
    private StringVerificadorNulo stringVerificadorNulo = new StringVerificadorNulo();
    
    public Endereco atualizar(Endereco enderecoEntidade, Endereco atualizacao) {
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_bairro())) enderecoEntidade.setEnd_bairro(atualizacao.getEnd_bairro());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_cep())) enderecoEntidade.setEnd_cep(atualizacao.getEnd_cep());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_cidade())) enderecoEntidade.setEnd_cidade(atualizacao.getEnd_cidade());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_complemento())) enderecoEntidade.setEnd_complemento(atualizacao.getEnd_complemento());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_numero())) enderecoEntidade.setEnd_numero(atualizacao.getEnd_numero());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_rua())) enderecoEntidade.setEnd_rua(atualizacao.getEnd_rua());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_uf())) enderecoEntidade.setEnd_uf(atualizacao.getEnd_uf());
        return enderecoEntidade;
    }
}
