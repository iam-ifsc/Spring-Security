package com.luizakuze.demo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador HTTP que define várias rotas com diferentes níveis de acesso,
 * usando segurança baseada em OAuth2 e JWT.
 * <p>
 * Este controlador inclui rotas públicas, privadas, uma rota para exibir informações do
 * cookie de sessão OAuth2 e uma rota para acessar informações de JWT.
 * </p>
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
    public String privateRoute(@AuthenticationPrincipal OidcUser principal) { // oidcUser contém atributos do usuário, id token e roles
        return "<h1>Private route! 🔐🐱🕶️🛡️  </h1>";
    }


    /**
     * Endpoint para acessar informações do usuário autenticado, incluindo atributos e o JWT. 
     * Forma de controlar se o usuário está autenticado ou não com a presença de cookie
     *
     * @param principal O objeto principal do usuário autenticado via OAuth2.
     * @return Informações sobre o usuário autenticado.
     */
    @GetMapping("/cookie")
    public String cookie(@AuthenticationPrincipal OidcUser principal) {
        return String.format("""
                    <h1>Oauth2 🔐  </h1>
                <h3>Principal: %s</h3>
                <h3>Email attribute: %s</h3>
                <h3>Authorities: %s</h3>
                <h3>JWT: %s</h3>
                """, principal, principal.getAttribute("email"), principal.getAuthorities(),
                principal.getIdToken().getTokenValue());
    }

    /**
     * Endpoint para acessar informações JWT diretamente.
     * Forma de controlar se o usuário está autenticado ou não com jwt
     *
     * @param jwt O objeto JWT do usuário autenticado.
     * @return Informações do JWT, incluindo atributos e o token.
     */
    @GetMapping("/jwt")
    
    public String jwt(@AuthenticationPrincipal Jwt jwt) { 
        return String.format("""
                Principal: %s\n
                Email attribute: %s\n
                JWT: %s\n
                """, jwt.getClaims(), jwt.getClaim("email"), jwt.getTokenValue());
    }
}
