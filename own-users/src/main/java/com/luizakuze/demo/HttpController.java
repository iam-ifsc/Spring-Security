package com.luizakuze.demo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para gerenciar endpoints HTTP.
 * <p>
 * Possui rotas públicas e privadas para demonstrar o uso de autorização.
 */
@RestController
public class HttpController {

    /**
     * Endpoint público acessível a todos.
     *
     * @return Mensagem para rota pública.
     */
    @GetMapping("/public")
    public String publicRoute() {
        return "<h1>Public route! 🔓🐸🌐✨ </h1>";
    }

    /**
     * Endpoint privado acessível apenas para usuários autenticados via OAuth2.
     *
     * @param principal O objeto principal do usuário autenticado.
     * @return Mensagem para rota privada.
     */
    @GetMapping("/private")
    public String privateRoute(@AuthenticationPrincipal OidcUser principal) {
        return "<h1>Private route! 🔐🐱🕶️🛡️  </h1>";

        // Lembrando que a senha foi definida no application.properties!
    }
}
