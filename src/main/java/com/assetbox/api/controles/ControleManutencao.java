package com.assetbox.api.controles;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.enums.ManutencaoStatus;
import com.assetbox.api.modelos.HistoricoManutencao;
import com.assetbox.api.modelos.Manutencao;
import com.assetbox.api.repositorios.RepositorioHistoricoManutencao;
import com.assetbox.api.repositorios.RepositorioManutencao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("manutencoes")
public class ControleManutencao {
    @Autowired
    private RepositorioManutencao repositorioManutencao;

    @Autowired
    private RepositorioHistoricoManutencao repositorioHistoricoManutencao;

    @GetMapping("")
    public ResponseEntity<List<Manutencao>> getManutencoes() {
        try {
            return new ResponseEntity<List<Manutencao>>(repositorioManutencao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Manutencao>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Manutencao> postManutencao(@RequestBody Manutencao manutencao) {
        try {
            Manutencao manutencaoEntidade = repositorioManutencao.save(manutencao);

            HistoricoManutencao historicoManutencao = new HistoricoManutencao(manutencaoEntidade.getMan_ativo_id(),
                    manutencaoEntidade.getMan_id(), manutencaoEntidade.getMan_atividade(),
                    manutencaoEntidade.getMan_data(), manutencaoEntidade.getMan_horario(),
                    manutencaoEntidade.getMan_status(), manutencaoEntidade.getMan_responsavel());

            repositorioHistoricoManutencao.save(historicoManutencao);

            return new ResponseEntity<Manutencao>(manutencaoEntidade, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Manutencao> getManutencao(@PathVariable Long id) {
        try {
            return new ResponseEntity<Manutencao>(repositorioManutencao.findById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Manutencao> deleteAtivo(@PathVariable Long id) {
        try {
            Manutencao manutencao = repositorioManutencao.findById(id).get();
            manutencao.setMan_status(ManutencaoStatus.CANCELADA);

            HistoricoManutencao historicoManutencao = new HistoricoManutencao(manutencao.getMan_ativo_id(),
                    manutencao.getMan_id(), manutencao.getMan_atividade(), manutencao.getMan_data(),
                    manutencao.getMan_horario(), manutencao.getMan_status(), manutencao.getMan_responsavel());

            repositorioHistoricoManutencao.save(historicoManutencao);
            return new ResponseEntity<Manutencao>(repositorioManutencao.save(manutencao), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
