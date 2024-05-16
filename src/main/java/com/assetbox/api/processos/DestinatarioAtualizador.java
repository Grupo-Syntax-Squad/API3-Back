package com.assetbox.api.processos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.assetbox.api.controles.ControleEndereco;
import com.assetbox.api.modelos.Destinatario;

public class DestinatarioAtualizador {

    @Autowired
    public StringVerificadorNulo stringVerificadorNulo;

    @Autowired
    public ControleEndereco controleEndereco;

    public Destinatario atualizar(Destinatario destinatarioEntidade, Destinatario atualizacao) {

        ResponseEntity<?> responseEndereco = controleEndereco.getEndereco(atualizacao.getDes_endereco_id().getEnd_id());

        if (!stringVerificadorNulo.verificarNulo(atualizacao.getDes_cpf()))
            destinatarioEntidade.setDes_cpf(atualizacao.getDes_cpf());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getDes_email()))
            destinatarioEntidade.setDes_email(atualizacao.getDes_email());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getDes_nome()))
            destinatarioEntidade.setDes_nome(atualizacao.getDes_nome());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getDes_telefone()))
            destinatarioEntidade.setDes_telefone(atualizacao.getDes_telefone());
        if (responseEndereco.getStatusCode().value() == 200)
            destinatarioEntidade.setDes_endereco_id(atualizacao.getDes_endereco_id());
        return destinatarioEntidade;
    }
}
