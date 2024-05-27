package com.assetbox.api.controles;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assetbox.api.modelos.Documento;
import com.assetbox.api.repositorios.RepositorioDocumento;




@RestController
@RequestMapping("documentos")
public class ControleDocumento {

    @Autowired
    private RepositorioDocumento repositorioDocumento;

    @GetMapping("{id}")
    public ResponseEntity<?> getDocumento(@PathVariable Long id) {
        try {
            Documento documento = repositorioDocumento.findById(id).orElseThrow(() -> new RuntimeException("Documento não encontrado"));

            Path path = Paths.get(documento.getDocumentoCaminho());
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok(resource);
            } else {
                throw new RuntimeException("Não foi possível ler o arquivo!");
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> uploadDocumento(@RequestParam("file") MultipartFile file) {
        Path path = Paths.get("src/main/resources/static/" + file.getOriginalFilename());

        Documento documento = new Documento();
        documento.setDocumentoNome(file.getOriginalFilename());
        documento.setDocumentoCaminho(path.toString());

        try {
            Files.write(path, file.getBytes());

            repositorioDocumento.save(documento);

            return ResponseEntity.ok().body(documento);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
