package com.assetbox.api.processos;

import com.assetbox.api.modelos.Endereco;

public class EnderecoAtualizador {
    private StringVerificadorNulo stringVerificadorNulo = new StringVerificadorNulo();
    
    public Endereco atualizar(Endereco enderecoEntidade, Endereco atualizacao) {
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_bairro()))
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_cep()))
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_cidade()))
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_complemento()))
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_numero()))
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_rua()))
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEnd_uf()))
        // Terminar a atualização
        return enderecoEntidade;
    }
}
