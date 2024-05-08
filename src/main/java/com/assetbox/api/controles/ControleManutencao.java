package com.assetbox.api.controles;

import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.enums.ManutencaoStatus;
import com.assetbox.api.modelos.HistoricoManutencao;
import com.assetbox.api.modelos.Manutencao;
import com.assetbox.api.processos.StringVerificadorNulo;
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
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("manutencoes")
public class ControleManutencao {
    @Autowired
    private RepositorioManutencao repositorioManutencao;

    @Autowired
    private RepositorioHistoricoManutencao repositorioHistoricoManutencao;

    private StringVerificadorNulo stringVerificadorNulo = new StringVerificadorNulo();

    @GetMapping("")
    public ResponseEntity<?> getManutencoes() {
        try {
            return new ResponseEntity<List<Manutencao>>(repositorioManutencao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> postManutencao(@RequestBody Manutencao manutencao) {
        try {
            Manutencao manutencaoEntidade = repositorioManutencao.save(manutencao);

            HistoricoManutencao historicoManutencao = new HistoricoManutencao(manutencaoEntidade.getMan_ativo_id(),
                    manutencaoEntidade.getMan_id(), manutencaoEntidade.getMan_atividade(),
                    manutencaoEntidade.getMan_data(), manutencaoEntidade.getMan_horario(),
                    manutencaoEntidade.getMan_status(), manutencaoEntidade.getMan_responsavel());

            repositorioHistoricoManutencao.save(historicoManutencao);

            return new ResponseEntity<Manutencao>(manutencaoEntidade, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getManutencao(@PathVariable Long id) {
        try {
            return new ResponseEntity<Manutencao>(repositorioManutencao.findById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAtivo(@PathVariable Long id) {
        try {
            Manutencao manutencao = repositorioManutencao.findById(id).get();
            manutencao.setMan_status(ManutencaoStatus.CANCELADA);

            HistoricoManutencao historicoManutencao = new HistoricoManutencao(manutencao.getMan_ativo_id(),
                    manutencao.getMan_id(), manutencao.getMan_atividade(), manutencao.getMan_data(),
                    manutencao.getMan_horario(), manutencao.getMan_status(), manutencao.getMan_responsavel());

            repositorioHistoricoManutencao.save(historicoManutencao);
            return new ResponseEntity<Manutencao>(repositorioManutencao.save(manutencao), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putMethodName(@PathVariable Long id, @RequestBody Manutencao atualizacao) {
        try {
            Manutencao manutencao = repositorioManutencao.findById(id).get();

            // Atualizando campos
            if (!stringVerificadorNulo.verificarNulo(atualizacao.getMan_atividade())) manutencao.setMan_atividade(atualizacao.getMan_atividade());
            if (!(atualizacao.getMan_data() == null)) manutencao.setMan_data(atualizacao.getMan_data());
            if (!(atualizacao.getMan_horario() == null)) manutencao.setMan_horario(atualizacao.getMan_horario());
            if (!stringVerificadorNulo.verificarNulo(atualizacao.getMan_responsavel())) manutencao.setMan_responsavel(atualizacao.getMan_responsavel());
            if (!(atualizacao.getMan_status() == null)) manutencao.setMan_status(atualizacao.getMan_status());
            repositorioManutencao.save(manutencao);

            // Colocando atualização no histórico
            HistoricoManutencao historicoManutencao = new HistoricoManutencao(manutencao.getMan_ativo_id(),
                    manutencao.getMan_id(), manutencao.getMan_atividade(), manutencao.getMan_data(),
                    manutencao.getMan_horario(), manutencao.getMan_status(), manutencao.getMan_responsavel());
            repositorioHistoricoManutencao.save(historicoManutencao);
            
            return new ResponseEntity<Manutencao>(manutencao, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
