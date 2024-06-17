package com.assetbox.api.classes;

import org.springframework.stereotype.Service;

import com.assetbox.api.enums.AtiStatus;
import com.assetbox.api.modelos.Ativo;

@Service
public class ContagemAtivoStatus {
    @SuppressWarnings("unused")
    private int manutencao;
    @SuppressWarnings("unused")
    private int ocioso;
    @SuppressWarnings("unused")
    private int operacao;
    @SuppressWarnings("unused")
    private int desativado;

    public ContagemAtivoStatus() {
        this.manutencao = 0;
        this.ocioso = 0;
        this.desativado = 0;
    }

    public void ContarStatus(Ativo ativo) {
        AtiStatus status = ativo.getAti_status();
        switch (status) {
            case EM_MANUTENCAO:
                this.manutencao++;
                break;
            case OCIOSO:
                this.ocioso++;
                break;
            case EM_OPERACAO:
                this.operacao++;
                break;
            case DESATIVADO:
                this.desativado++;
                break;
            default:
                break;
        }
    }

}
