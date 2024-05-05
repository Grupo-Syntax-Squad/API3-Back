package com.assetbox.api.controles;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assetbox.api.modelos.Imagem;
import com.assetbox.api.repositorios.RepositorioImagem;

@RestController
public class ControleImagem {
    @Autowired
    private RepositorioImagem repositorioImagem;

    @GetMapping("/imagens/{id}")
    public ResponseEntity<Resource> getImagem(@PathVariable Long id) {
        try {
            Imagem imagem = repositorioImagem.findById(id).get();

            Path path = Paths.get("src/main/resources/static/" + imagem.getImg_nome());
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok(resource);
            } else {
                throw new RuntimeException("Não foi possível ler o arquivo!");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/imagens")
    public ResponseEntity<?> uploadImagem(@RequestParam("file") MultipartFile file) {
        Path path = Paths.get("src/main/resources/static/" + file.getOriginalFilename());
        
        Imagem imagem = new Imagem();
        imagem.setImg_nome(file.getOriginalFilename());
        imagem.setImg_caminho(path.toString());
        System.out.println(imagem.getImg_caminho());

        try {
            // Caminho para a pasta onde as imagens serão salvas
            Files.write(path, file.getBytes());

            System.out.println(imagem.getImg_caminho());
            repositorioImagem.save(imagem);
            
            return ResponseEntity.ok().body(imagem);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
