package com.assetbox.api.controle;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assetbox.api.modelos.Ativo;
import com.assetbox.api.modelos.Imagem;
import com.assetbox.api.repositorio.RepositorioImagem;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class ControleImagem {
    @Autowired
    private RepositorioImagem repositorioImagem;

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

    @PostMapping("/imagem")
    public ResponseEntity<String> postImagem(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String pathString = "./" + file.getOriginalFilename();
                Path path = Paths.get("./" + file.getOriginalFilename());
                Files.write(path, bytes);
                
                Imagem imagem = new Imagem();
                imagem.setIma_caminho("./" + file.getOriginalFilename());
                imagem.setIma_nome(file.getOriginalFilename());
                repositorioImagem.save(imagem);

                return ResponseEntity.ok().body("Imagem enviada com sucesso!");
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a imagem.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Selecione uma imagem para fazer o upload.");
        }
    }
}