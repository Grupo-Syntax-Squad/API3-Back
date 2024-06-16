package com.assetbox.api.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.classes.ContagemDTO;
import com.assetbox.api.services.DashboardStatus;
import com.assetbox.api.services.DashboardTipo;
import com.assetbox.api.services.DashboardLocalização;


@RestController
@RequestMapping("dashboard")
public class ControleDashboard {

    @Autowired
    private DashboardLocalização dashboardLocalizacao;

    @Autowired
    private DashboardStatus dashboardStatus;

    @Autowired
    private DashboardTipo dashboardTipo;

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
}
