package com.luizakuze.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Classe de configuração de segurança para o serviço web.
 * <p>
 * Configura a segurança usando OAuth2, permitindo acesso público a determinadas
 * rotas e exigindo autenticação para outras rotas.
 * </p>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configura o filtro de segurança para definir permissões de acesso às rotas.
     *
     * @param http O objeto HttpSecurity usado para configurar a segurança.
     * @return A cadeia de filtros de segurança configurada.
     * @throws Exception Em caso de erro na configuração.
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(
                authorizeConfig -> {
                    authorizeConfig.requestMatchers("/public").permitAll();
                    authorizeConfig.requestMatchers("/logout").permitAll();
                    authorizeConfig.anyRequest().authenticated();
                })
            .oauth2Login(Customizer.withDefaults()) // Integração com OAuth2.0 e cookies de sessão
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())) // Configuração para JWT no Resource Server
            .build();
    }
}
