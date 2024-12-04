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
 * Configura a autorização para rotas públicas e privadas, utilizando a autenticação OIDC.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configura a cadeia de filtros de segurança do Spring Security.
     * <p>
     * Define as permissões para endpoints específicos e exige autenticação
     * para qualquer requisição que não seja explicitamente permitida.
     *
     * @param http instância de HttpSecurity usada para configurar as regras de segurança
     * @return a cadeia de filtros de segurança configurada
     * @throws Exception se ocorrer um erro durante a configuração de segurança
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(
                authorizeConfig -> {
                    authorizeConfig.requestMatchers("/public").permitAll(); // permite qualquer usuário
                    authorizeConfig.requestMatchers("/logout").permitAll(); // permite qualquer usuário
                    authorizeConfig.anyRequest().authenticated(); // Todos devem estar autenticados até que se diga o contrário
                })
            .formLogin(Customizer.withDefaults()) // Evita sobrescrever o formulário padrão do Spring Security
            .build();
    }
}
