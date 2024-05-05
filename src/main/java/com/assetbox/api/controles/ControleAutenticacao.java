package com.assetbox.api.controles;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetbox.api.dtos.LoginDTO;
import com.assetbox.api.dtos.RegistrarDTO;
import com.assetbox.api.modelos.Administrador;
import com.assetbox.api.processos.JwtUtil;
import com.assetbox.api.repositorios.RepositorioAdministrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("autenticacao")
public class ControleAutenticacao {
    @Autowired
    private RepositorioAdministrador repositorioAdministrador;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("login")
    public ResponseEntity postLogin(@RequestBody LoginDTO data) {
        Administrador administrador = repositorioAdministrador.findByEmail(data.email());

        if (administrador == null || !administrador.getAdm_senha().equals(data.senha())) {
            return ResponseEntity.badRequest().build();
        }

        String jwt = jwtUtil.generateToken(data.email());

        return ResponseEntity.ok(jwt);
    }

    @PostMapping("registrar")
    public ResponseEntity postRegistrar(@RequestBody RegistrarDTO data) {
        if (repositorioAdministrador.findByEmail(data.adm_email()) != null) {
            return ResponseEntity.badRequest().build();
        }

        Administrador administrador = new Administrador(data.adm_nome(), data.adm_email(), data.adm_senha(), data.adm_telefone(), data.adm_cpf());

        repositorioAdministrador.save(administrador);

        return ResponseEntity.ok().build();
    }

    @PostMapping("verificarToken")
    public ResponseEntity postVerificarToken(@RequestBody String token) {
        try {
            boolean verificacao = jwtUtil.validateToken(token);
            return ResponseEntity.ok(verificacao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token inválido");
        }
    }
}
