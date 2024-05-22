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

        if (atualizacao.getDes_endereco_id().getEnd_id() != null) {
            ResponseEntity<?> responseEndereco = controleEndereco.getEndereco(
                atualizacao.getDes_endereco_id().getEnd_id()
                );
            if (responseEndereco.getStatusCode().value() == 200) {
                destinatarioEntidade.setDes_endereco_id(atualizacao.getDes_endereco_id());
            }
        }
        

        if (!stringVerificadorNulo.verificarNulo(atualizacao.getCpf()))
            destinatarioEntidade.setCpf(atualizacao.getCpf());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getEmail()))
            destinatarioEntidade.setEmail(atualizacao.getEmail());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getDes_nome()))
            destinatarioEntidade.setDes_nome(atualizacao.getDes_nome());
        if (!stringVerificadorNulo.verificarNulo(atualizacao.getTelefone()))
            destinatarioEntidade.setTelefone(atualizacao.getTelefone());
        return destinatarioEntidade;
    }
}
