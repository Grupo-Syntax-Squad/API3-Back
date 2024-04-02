package com.assetbox.api.controller; 

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.assetbox.api.modelos.Anexo;

@Controller
public class AnexoController {

    @PostMapping("/anexo/upload") 
    public void upload(@RequestParam("file") MultipartFile upload) {
        Arquivo arquivo = new Arquivo();
        arquivo.upload("/anexo", upload.getOriginalFilename(), upload.getInputStream());
    }
}
