package com.assetbox.api.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetbox.api.classes.ContagemDTO;
import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.modelos.Tipo;
import com.assetbox.api.repositorios.RepositorioAtivo;

@Service
public class DashboardTipo {

    @Autowired
    private RepositorioAtivo repositorioAtivo;

    public List<ContagemDTO> contarAtivosPorTipo() {
        List<Ativo> ativos = repositorioAtivo.findAll();

        Map<Tipo, Long> contagem = new HashMap<>();
        for (Ativo ativo : ativos) {
            Tipo tipo = ativo.getAti_tipo_id();
            if (tipo != null) {
                Long quantidade = contagem.getOrDefault(tipo, 0L);
                contagem.put(tipo, quantidade + 1);
            }
        }

        List<ContagemDTO> resultados = new ArrayList<>();
        for (Map.Entry<Tipo, Long> entry : contagem.entrySet()) {
            ContagemDTO dto = new ContagemDTO();
            dto.setNome(entry.getKey().getTip_titulo());
            dto.setQuantidade(entry.getValue());
            resultados.add(dto);
        }
        return resultados;
    }
}
