package com.assetbox.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.assetbox.api.processos.AtivoAtualizador;
import com.assetbox.api.processos.StringVerificadorNulo;

@Configuration
public class AppConfig {

    @Bean
    public AtivoAtualizador ativoatualizador() {
        return new AtivoAtualizador();
    }

    @Bean
    public StringVerificadorNulo stringVerificadorNulo() {
        return new StringVerificadorNulo();
    }
}
