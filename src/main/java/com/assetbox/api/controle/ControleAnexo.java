package com.assetbox.api.controle; 

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ControleAnexo {

    @PostMapping("/anexo/upload") 
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile upload) {
        String caminho = "../../Pictures/AssetBox/" + UUID.randomUUID() + "." + extrairExtensao(upload.getOriginalFilename());
        try {
            Files.copy(upload.getInputStream(), Path.of(caminho), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(Path.of(caminho));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            String mensagemErro = e.getMessage();
            System.out.println(mensagemErro);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String extrairExtensao(String nomeArquivo) {
        int i = nomeArquivo.lastIndexOf(".");
        return nomeArquivo.substring(i + 1);
    }
}