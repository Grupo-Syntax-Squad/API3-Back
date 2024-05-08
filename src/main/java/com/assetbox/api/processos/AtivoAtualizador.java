package com.assetbox.api.processos;

import com.assetbox.api.modelos.Ativo;

public class AtivoAtualizador {
    private StringVerificadorNulo stringVerificadorNulo = new StringVerificadorNulo();
    public Ativo atualizar(Ativo ativoEntidade, Ativo atualizacao) {
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_ano_fabricacao()))
            ativoEntidade.setAti_ano_fabricacao(atualizacao.getAti_ano_fabricacao());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_capacidade()))
            ativoEntidade.setAti_capacidade(atualizacao.getAti_capacidade());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_chave_nf_e()))
            ativoEntidade.setAti_chave_nf_e(atualizacao.getAti_chave_nf_e());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_complemento()))
            ativoEntidade.setAti_complemento(atualizacao.getAti_complemento());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_condicoes_uso()))
            ativoEntidade.setAti_condicoes_uso(atualizacao.getAti_condicoes_uso());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_marca()))
            ativoEntidade.setAti_marca(atualizacao.getAti_marca());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_modelo()))
            ativoEntidade.setAti_modelo(atualizacao.getAti_modelo());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_numero()))
            ativoEntidade.setAti_numero(atualizacao.getAti_numero());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_numero_serie()))
            ativoEntidade.setAti_numero_serie(atualizacao.getAti_numero_serie());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_observacao()))
            ativoEntidade.setAti_observacao(atualizacao.getAti_observacao());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_tamanho()))
            ativoEntidade.setAti_tamanho(atualizacao.getAti_tamanho());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_titulo()))
            ativoEntidade.setAti_titulo(atualizacao.getAti_titulo());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getAti_url()))
            ativoEntidade.setAti_url(atualizacao.getAti_url());
        if (atualizacao.getAti_data_expiracao() != null)
            ativoEntidade.setAti_data_expiracao(atualizacao.getAti_data_expiracao());
        if (atualizacao.getAti_preco_aquisicao() != ativoEntidade.getAti_preco_aquisicao())
            ativoEntidade.setAti_preco_aquisicao(atualizacao.getAti_preco_aquisicao());
        return ativoEntidade;
    }
}
