package com.assetbox.api.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.classes.ContagemDTO;
import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.repositorios.RepositorioAtivo;
import com.assetbox.api.services.DashboardStatus;
import com.assetbox.api.services.DashboardTipo;
import com.assetbox.api.services.DashboardLocalização;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("dashboard")
public class ControleDashboard {

    @Autowired
    private DashboardLocalização dashboardLocalizacao;

    @Autowired
    private DashboardStatus dashboardStatus;

    @Autowired
    private DashboardTipo dashboardTipo;

    @Autowired
    private RepositorioAtivo repositorioAtivo;

    @GetMapping("localizacao")
    public ResponseEntity<?> contarAtivosPorLocalizacao() {
        try {
            List<ContagemDTO> contagem = dashboardLocalizacao.contarAtivosPorLocalizacao();
            return ResponseEntity.ok(contagem);
        } catch (Exception e) {
            return ResponseEntity.ofNullable(e);
        } 
    }

    @GetMapping("status")
    public ResponseEntity<?> contarAtivosPorStatus() {
        try {
            List<ContagemDTO> contagem = dashboardStatus.contarAtivosPorStatus();
            return ResponseEntity.ok(contagem);
        } catch (Exception e) {
            return ResponseEntity.ofNullable(e);
        }
    }

    @GetMapping("tipo")
    public ResponseEntity<?> contarAtivosPorTipo() {
        try {
            List<ContagemDTO> contagem = dashboardTipo.contarAtivosPorTipo();
            return ResponseEntity.ok(contagem);
        } catch (Exception e) {
            return ResponseEntity.ofNullable(e);
        }   
    }

    @GetMapping("valorTotal")
    public ResponseEntity<?> contarValorTotal() {
        try {
            double total = 0;
            List<Ativo> ativos = repositorioAtivo.findAll();
            for (Ativo ativo: ativos) {
                total += ativo.getAti_preco_aquisicao();
            }
            return ResponseEntity.ok(total);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
    @GetMapping("quantidadeTotal")
    public ResponseEntity<?> contarQuantidadeTotal() {
        try {
            List<Ativo> ativos = repositorioAtivo.findAll();
            return new ResponseEntity<>(ativos.size(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
