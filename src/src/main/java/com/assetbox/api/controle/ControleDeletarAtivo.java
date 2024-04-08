package com.assetbox.api.controle;

import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.modelos.DeletarAtivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deletarAtivo")
public class ControleDeletarAtivo {

    private DeletarAtivo deletarAtivo;

    @Autowired
    public void AtivoController(DeletarAtivo deletarAtivo) {
        this.deletarAtivo = deletarAtivo;
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<?> atualizarStatus(@PathVariable Long id, @RequestBody String novoStatus) {
        Ativo ativo = deletarAtivo.buscarPorId(id);
        if (ativo == null) {
            return ResponseEntity.notFound().build();
        }

        ativo.setAti_status(novoStatus);

        return ResponseEntity.ok().build();
    }


}