package com.assetbox.api.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetbox.api.classes.ContagemDTO;
import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.modelos.Localizacao;
import com.assetbox.api.repositorios.RepositorioAtivo;

@Service
public class DashboardLocalização {

    @Autowired
    private RepositorioAtivo repositorio;

    public List<ContagemDTO> contarAtivosPorLocalizacao() {
        List<Ativo> ativos = repositorio.findAll();
        Map<Localizacao, Long> contagem = new HashMap<>();
        for (Ativo ativo : ativos) {
            Localizacao localizacao = ativo.getAti_localizacao_id();
            if (localizacao != null) {
                Long quantidade = contagem.getOrDefault(localizacao, 0L);
                contagem.put(localizacao, quantidade + 1);
            }
        }
        List<ContagemDTO> resultados = new ArrayList<>();
        for (Map.Entry<Localizacao, Long> entry : contagem.entrySet()) {
            ContagemDTO dto = new ContagemDTO();
            dto.setNome(entry.getKey().getLoc_titulo());
            dto.setQuantidade(entry.getValue());
            resultados.add(dto);
        }
        return resultados;
    }
}
