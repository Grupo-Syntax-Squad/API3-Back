package com.assetbox.api.controle;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assetbox.api.modelos.Imagem;
import com.assetbox.api.repositorio.RepositorioImagem;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class ControleImagem {

    private class Getimg {
        private String caminho;

        public String getCaminho() {
            return caminho;
        }

        public void setCaminho(String caminho) {
            this.caminho = caminho;
        }

    }

    @Autowired
    private RepositorioImagem repositorioImagem;

    @GetMapping("/imagem/{id}")
    public ResponseEntity<ByteArrayResource> getImageById(@PathVariable Long id) {
        Optional<Imagem> optionalImage = repositorioImagem.findById(id);
        if (optionalImage.isPresent()) {
            Imagem imagem = optionalImage.get();
            Path path = Path.of(imagem.getIma_caminho()); // Supondo que getCaminho() retorna o caminho da imagem
            byte[] imageBytes;
            try {
                imageBytes = Files.readAllBytes(path);
            } catch (IOException e) {
                // Lidar com exceções de leitura de arquivo
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            
            // Inicialize o ByteArrayResource com os bytes da imagem
            ByteArrayResource resource = new ByteArrayResource(imageBytes);
            
            return ResponseEntity.ok()
                    .contentLength(imageBytes.length)
                    .body(resource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/imagem")
    public ResponseEntity<Imagem> postImagem(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get("./src/main/resources/imgs/" + file.getOriginalFilename());
                Files.write(path, bytes);

                Imagem imagem = new Imagem();
                imagem.setIma_caminho("./src/main/resources/imgs/" + file.getOriginalFilename());
                imagem.setIma_nome(file.getOriginalFilename());
                repositorioImagem.save(imagem);

                return ResponseEntity.ok().body(imagem);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}