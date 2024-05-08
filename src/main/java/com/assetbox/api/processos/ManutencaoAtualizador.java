package com.assetbox.api.processos;

import com.assetbox.api.modelos.Manutencao;

public class ManutencaoAtualizador {
    private StringVerificadorNulo stringVerificadorNulo = new StringVerificadorNulo();

    public Manutencao atualizar(Manutencao manutencaoEntidade, Manutencao atualizacao) {
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getMan_atividade()))
            manutencaoEntidade.setMan_atividade(atualizacao.getMan_atividade());
        if (!(atualizacao.getMan_data() == null))
            manutencaoEntidade.setMan_data(atualizacao.getMan_data());
        if (!(atualizacao.getMan_horario() == null))
            manutencaoEntidade.setMan_horario(atualizacao.getMan_horario());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getMan_responsavel()))
            manutencaoEntidade.setMan_responsavel(atualizacao.getMan_responsavel());
        if (!(atualizacao.getMan_status() == null))
            manutencaoEntidade.setMan_status(atualizacao.getMan_status());
        return manutencaoEntidade;
    }
}
