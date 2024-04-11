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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
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
    public ResponseEntity<InputStreamResource> getImagem(@PathVariable Long id) {
        Imagem imagem = repositorioImagem.findById(id).orElse(null);
    
        if (imagem == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        String caminhoImagem = imagem.getIma_caminho();
        Path caminhoAbsoluto = Paths.get(caminhoImagem);

        if (!Files.exists(caminhoAbsoluto)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        try (InputStream inputStream = Files.newInputStream(caminhoAbsoluto)) {
            // Obter o tipo de mídia apropriado com base no tipo de imagem
            String contentType = Files.probeContentType(caminhoAbsoluto);
            if (contentType == null) {
                contentType = "application/octet-stream"; // Tipo de mídia genérico se não puder ser detectado
            }

            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(new InputStreamResource(inputStream));
        } catch (IOException e) {
            // Lidar com a exceção de IO (por exemplo, registrar, lançar uma exceção personalizada, etc.)
            e.printStackTrace(); // Aqui estamos apenas imprimindo a pilha de exceção, você pode personalizar isso conforme necessário
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
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