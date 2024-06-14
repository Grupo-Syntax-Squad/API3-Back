package com.assetbox.api.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetbox.api.classes.ContagemDTO;
import com.assetbox.api.enums.AtiStatus;
import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.modelos.Localizacao;
import com.assetbox.api.repositorios.RepositorioAtivo;

@Service
public class DashboardStatus {

    @Autowired
    private RepositorioAtivo repositorio;

    public List<ContagemDTO> contarAtivosPorLocalizacao() {
        List<Ativo> ativos = repositorio.findAll();
        Map<AtiStatus, Long> contagem = new HashMap<>();
        for (Ativo ativo : ativos) {
            AtiStatus status = ativo.getAti_status();
            if (status != null) {
                Long quantidade = contagem.getOrDefault(status, 0L);
                contagem.put(status, quantidade + 1);
            }
        }
        List<ContagemDTO> resultados = new ArrayList<>();
        for (Map.Entry<AtiStatus, Long> entry : contagem.entrySet()) {
            ContagemDTO dto = new ContagemDTO();
            if (entry.getKey() == AtiStatus.DESATIVADO) dto.setNome("DESATIVADO");
            if (entry.getKey() == AtiStatus.EM_MANUTENCAO) dto.setNome("EM_MANUTENCAO");
            if (entry.getKey() == AtiStatus.EM_OPERACAO) dto.setNome("EM_OPERACAO");
            if (entry.getKey() == AtiStatus.OCIOSO) dto.setNome("OCIOSO");
            dto.setQuantidade(entry.getValue());
            resultados.add(dto);
        }
        return resultados;
    }
}
