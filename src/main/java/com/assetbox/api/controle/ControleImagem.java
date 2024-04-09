package com.assetbox.api.controle;

import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ControleImagem {
    @GetMapping("/imagem")
    public ResponseEntity<InputStreamResource> getImagem(@RequestBody String caminhoImagem) {
        Path caminhoAbsoluto = Paths.get(caminhoImagem);

        if (!Files.exists(caminhoAbsoluto)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        InputStream inputStream = getClass().getResourceAsStream(caminhoImagem);

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType("image/*"))
            .body(new InputStreamResource(inputStream));
    }
    
}
