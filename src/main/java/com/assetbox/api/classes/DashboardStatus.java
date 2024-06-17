package com.assetbox.api.classes;

public class DashboardStatus {
    private int manutencao;
    private int ocioso;
    private int operacao;

    public DashboardStatus(int manutencao, int ocioso, int operacao) {
        this.manutencao = manutencao;
        this.ocioso = ocioso;
        this.operacao = operacao;
    }

    public int getManutencao() {
        return manutencao;
    }

    public void setManutencao(int manutencao) {
        this.manutencao = manutencao;
    }

    public int getOcioso() {
        return ocioso;
    }

    public void setOcioso(int ocioso) {
        this.ocioso = ocioso;
    }

    public int getOperacao() {
        return operacao;
    }

    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    
}
