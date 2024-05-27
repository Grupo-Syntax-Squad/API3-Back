package com.assetbox.api.classes;

public class RelatorioContagem {
    public int quantidadeOperacao;
    public int quantidadeManutencao;
    public int quantidadeOcioso;
    public int quantidadeInativado;
    public int quantidadeComFuncionario;
    public int quantidadeProximosManutencao;
    public int quantidadeTotal;
    public double valorOperacao;
    public double valorManutencao;
    public double valorOcioso;
    public double valorInativado;
    public double valorComFuncionario;
    public double valorProximosManutencao;
    public double valorTotal;

    public RelatorioContagem (int quantidadeOperacao, int quantidadeManutencao, int quantidadeOcioso, 
    int quantidadeInativado, int quantidadeComFuncionario, int quantidadeProximosManutencao,
    double valorOperacao, double valorManutencao, double valorOcioso, double valorInativado,
    double valorComFuncionario, double valorProximosManutencao) {

        this.quantidadeOperacao = quantidadeOperacao;
        this.quantidadeManutencao = quantidadeManutencao;
        this.quantidadeOcioso = quantidadeOcioso;
        this.quantidadeInativado = quantidadeInativado;
        this.quantidadeComFuncionario = quantidadeComFuncionario;
        this.quantidadeProximosManutencao = quantidadeProximosManutencao;
        this.quantidadeTotal = quantidadeOperacao + quantidadeManutencao + quantidadeOcioso + 
        quantidadeInativado + quantidadeComFuncionario + quantidadeProximosManutencao;
        this.valorOperacao = valorOperacao;
        this.valorManutencao = valorManutencao;
        this.valorOcioso = valorOcioso;
        this.valorInativado = valorInativado;
        this.valorComFuncionario = valorComFuncionario;
        this.valorProximosManutencao = valorProximosManutencao;
        this.valorTotal = valorOperacao + valorManutencao + valorOcioso + valorInativado + 
        valorComFuncionario + valorProximosManutencao;
    }

    public int getQuantidadeOperacao() {
        return quantidadeOperacao;
    }

    public void setQuantidadeOperacao(int quantidadeOperacao) {
        this.quantidadeOperacao = quantidadeOperacao;
    }

    public int getQuantidadeManutencao() {
        return quantidadeManutencao;
    }

    public void setQuantidadeManutencao(int quantidadeManutencao) {
        this.quantidadeManutencao = quantidadeManutencao;
    }

    public int getQuantidadeOcioso() {
        return quantidadeOcioso;
    }

    public void setQuantidadeOcioso(int quantidadeOcioso) {
        this.quantidadeOcioso = quantidadeOcioso;
    }

    public int getQuantidadeInativado() {
        return quantidadeInativado;
    }

    public void setQuantidadeInativado(int quantidadeInativado) {
        this.quantidadeInativado = quantidadeInativado;
    }

    public int getQuantidadeComFuncionario() {
        return quantidadeComFuncionario;
    }

    public void setQuantidadeComFuncionario(int quantidadeComFuncionario) {
        this.quantidadeComFuncionario = quantidadeComFuncionario;
    }

    public int getQuantidadeProximosManutencao() {
        return quantidadeProximosManutencao;
    }

    public void setQuantidadeProximosManutencao(int quantidadeProximosManutencao) {
        this.quantidadeProximosManutencao = quantidadeProximosManutencao;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public double getValorManutencao() {
        return valorManutencao;
    }

    public void setValorManutencao(double valorManutencao) {
        this.valorManutencao = valorManutencao;
    }

    public double getValorOcioso() {
        return valorOcioso;
    }

    public void setValorOcioso(double valorOcioso) {
        this.valorOcioso = valorOcioso;
    }

    public double getValorInativado() {
        return valorInativado;
    }

    public void setValorInativado(double valorInativado) {
        this.valorInativado = valorInativado;
    }

    public double getValorComFuncionario() {
        return valorComFuncionario;
    }

    public void setValorComFuncionario(double valorComFuncionario) {
        this.valorComFuncionario = valorComFuncionario;
    }

    public double getValorProximosManutencao() {
        return valorProximosManutencao;
    }

    public void setValorProximosManutencao(double valorProximosManutencao) {
        this.valorProximosManutencao = valorProximosManutencao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
