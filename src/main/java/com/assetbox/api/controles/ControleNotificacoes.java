package com.assetbox.api.controles;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.repositorios.RepositorioAtivo;

@RestController
@RequestMapping("notificacoes")
public class ControleNotificacoes {
    @Autowired
    RepositorioAtivo repositorioAtivo;

    @GetMapping("expiracao/ativos")
    public ResponseEntity<?> getExpiracaoAtivos() {
        try {
            List<Ativo> ativos = repositorioAtivo.findAll();
            List<Ativo> ativosProximoExpiracao = new ArrayList<>();
            for (Ativo ativo : ativos) {
                LocalDate dataExpiracaoAtivo = LocalDate.of(ativo.getAti_data_expiracao().getYear(),
                        ativo.getAti_data_expiracao().getMonth(), ativo.getAti_data_expiracao().getDay());

                LocalDate dataAtual = LocalDate.now();

                long daysBetween = ChronoUnit.DAYS.between(dataExpiracaoAtivo, dataAtual);

                if (Math.abs(daysBetween) <= 15) {
                    ativosProximoExpiracao.add(ativo);
                } else {
                    System.out.println("A data atual NÃO está a 15 dias da data específica.");
                }
            }
            return new ResponseEntity<>(ativosProximoExpiracao, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
