package com.assetbox.api.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import com.assetbox.api.modelos.Endereco;
import com.assetbox.api.repositorios.RepositorioEndereco;

@RestController
@RequestMapping("enderecos")
public class ControleEndereco {
    @Autowired
    private RepositorioEndereco repositorioEndereco;

    @GetMapping
    public ResponseEntity<?> getEnderecos() {
        try {
            return new ResponseEntity<>(repositorioEndereco.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEndereco(@PathVariable Long id) {
        try {
            if (repositorioEndereco.findById(id).isPresent()) return new ResponseEntity<>(repositorioEndereco.findById(id).get(), HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> postEndereco(@RequestBody Endereco endereco) {
        try {
            return new ResponseEntity<>(repositorioEndereco.save(endereco), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        try {
            if (repositorioEndereco.findById(id).isPresent()) {
                Endereco enderecoExistente = repositorioEndereco.findById(id).get();

                enderecoExistente.setEnd_rua(endereco.getEnd_rua());
                enderecoExistente.setEnd_numero(endereco.getEnd_numero());
                enderecoExistente.setEnd_bairro(endereco.getEnd_bairro());
                enderecoExistente.setEnd_cidade(endereco.getEnd_cidade());
                enderecoExistente.setEnd_uf(endereco.getEnd_uf());
                enderecoExistente.setEnd_complemento(endereco.getEnd_complemento());
                enderecoExistente.setEnd_cep(endereco.getEnd_cep());

                repositorioEndereco.save(enderecoExistente);

                return new ResponseEntity<>(enderecoExistente, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
