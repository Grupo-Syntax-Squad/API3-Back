package com.assetbox.api.processos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.assetbox.api.controles.ControleLocalizacao;
import com.assetbox.api.controles.ControleTipo;
import com.assetbox.api.controles.ControleDestinatario;
import com.assetbox.api.controles.ControleDocumento;
import com.assetbox.api.controles.ControleImagem;
import com.assetbox.api.modelos.Ativo;

public class AtivoAtualizador {
    @Autowired
    private StringVerificadorNulo stringVerificadorNulo;

    @Autowired
    private ControleLocalizacao controleLocalizacao;

    @Autowired
    private ControleDestinatario controleDestinatario;

    @Autowired
    private ControleTipo controleTipo;

    @Autowired
    private ControleImagem controleImagem;

    @Autowired
    private ControleDocumento controleDocumento;

    public Ativo atualizar(Ativo ativoEntidade, Ativo atualizacao) {

        ResponseEntity<?> responseLocalizacao = controleLocalizacao.getLocalizacao(atualizacao.getAti_localizacao_id().getLoc_id());
        ResponseEntity<?> responseDestinatario = controleDestinatario.getDestinatario(atualizacao.getAti_destinatario_id().getDes_id());
        ResponseEntity<?> responseTipo = controleTipo.getTipo(atualizacao.getAti_tipo_id().getTip_id());
        ResponseEntity<?> responseImagem = controleImagem.getImagem(atualizacao.getAti_imagem_id().getImg_id());
        ResponseEntity<?> responseDocumento = controleDocumento.getDocumento(atualizacao.getAti_documento_id().getDocumentoId());

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
        if (responseLocalizacao.getStatusCode().value() == 200)
            ativoEntidade.setAti_localizacao_id(atualizacao.getAti_localizacao_id());
        if (responseDestinatario.getStatusCode().value() == 200)
            ativoEntidade.setAti_destinatario_id(atualizacao.getAti_destinatario_id());
        if (responseTipo.getStatusCode().value() == 200)
            ativoEntidade.setAti_tipo_id(atualizacao.getAti_tipo_id());
        if (responseImagem.getStatusCode().value() == 200)
            ativoEntidade.setAti_imagem_id(atualizacao.getAti_imagem_id());
        if (responseDocumento.getStatusCode().value() == 200)
            ativoEntidade.setAti_documento_id(atualizacao.getAti_documento_id());
        return ativoEntidade;
    }
}
