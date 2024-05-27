package com.assetbox.api.controles;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.classes.RelatorioContagem;
import com.assetbox.api.enums.AtiStatus;
import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.modelos.Filial;
import com.assetbox.api.repositorios.RepositorioAtivo;
import com.assetbox.api.repositorios.RepositorioFilial;

@RestController
@RequestMapping("relatorios")
public class ControleRelatorio {

    @Autowired
    private RepositorioFilial repositorioFilial;

    @Autowired
    private RepositorioAtivo repositorioAtivo;

    @GetMapping("filial/{id}")
    public ResponseEntity<?> getRelatorio (@PathVariable Long id){
        try {
            Optional<Filial> opicionalFilial = repositorioFilial.findById(id);
            if (opicionalFilial.isPresent()) {
                Filial filialEntidade = opicionalFilial.get();
                List<Ativo> ativosDaFilial = repositorioAtivo.findByFilial(filialEntidade);
                RelatorioContagem newRelatorio = new RelatorioContagem(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                for (Ativo ativo: ativosDaFilial){
                    if (ativo.getAti_status() == AtiStatus.EM_OPERACAO){
                        int quantidadeAtual = newRelatorio.getQuantidadeOperacao();
                        quantidadeAtual = quantidadeAtual + 1;
                        newRelatorio.setQuantidadeOperacao(quantidadeAtual);

                        double valorAtual = newRelatorio.getValorOperacao();
                        valorAtual = ativo.getAti_preco_aquisicao() + valorAtual;
                        newRelatorio.setValorOperacao(valorAtual);
                    }

                    if (ativo.getAti_status() == AtiStatus.EM_MANUTENCAO){
                        int quantidadeAtual = newRelatorio.getQuantidadeManutencao();
                        quantidadeAtual = quantidadeAtual + 1;
                        newRelatorio.setQuantidadeManutencao(quantidadeAtual);

                        double valorAtual = newRelatorio.getValorManutencao();
                        valorAtual = ativo.getAti_preco_aquisicao() + valorAtual;
                        newRelatorio.setValorManutencao(valorAtual);
                    }

                    if (ativo.getAti_status() == AtiStatus.OCIOSO){
                        int quantidadeAtual = newRelatorio.getQuantidadeOcioso();
                        quantidadeAtual = quantidadeAtual + 1;
                        newRelatorio.setQuantidadeOcioso(quantidadeAtual);

                        double valorAtual = newRelatorio.getValorOcioso();
                        valorAtual = ativo.getAti_preco_aquisicao() + valorAtual;
                        newRelatorio.setValorOcioso(valorAtual);
                    }

                    if (ativo.getAti_status() == AtiStatus.DESATIVADO){
                        int quantidadeAtual = newRelatorio.getQuantidadeInativado();
                        quantidadeAtual = quantidadeAtual + 1;
                        newRelatorio.setQuantidadeInativado(quantidadeAtual);

                        double valorAtual = newRelatorio.getValorInativado();
                        valorAtual = ativo.getAti_preco_aquisicao() + valorAtual;
                        newRelatorio.setValorInativado(valorAtual);
                    }

                    if (ativo.getAti_destinatario_id() != null){
                        int quantidadeAtual = newRelatorio.getQuantidadeComFuncionario();
                        quantidadeAtual = quantidadeAtual + 1;
                        newRelatorio.setQuantidadeComFuncionario(quantidadeAtual);

                        double valorAtual = newRelatorio.getValorComFuncionario();
                        valorAtual = ativo.getAti_preco_aquisicao() + valorAtual;
                        newRelatorio.setValorComFuncionario(valorAtual);
                    }

                    LocalDate dataExpiracaoAtivo = ativo.getAti_data_expiracao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate dataAtual = LocalDate.now();
                    long daysBetween = ChronoUnit.DAYS.between(dataExpiracaoAtivo, dataAtual);

                    if (Math.abs(daysBetween) <= 15) {
                        int quantidadeAtual = newRelatorio.getQuantidadeProximosManutencao();
                        quantidadeAtual = quantidadeAtual + 1;
                        newRelatorio.setQuantidadeProximosManutencao(quantidadeAtual);

                        double valorAtual = newRelatorio.getValorProximosManutencao();
                        valorAtual = valorAtual + ativo.getAti_preco_aquisicao();
                        newRelatorio.setValorProximosManutencao(valorAtual);
                    }
                }
                return new ResponseEntity<>(newRelatorio, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Filial não encontrada!", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
