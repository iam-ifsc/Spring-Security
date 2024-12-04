# Demo Spring Security 🌿

Este projeto é uma aplicação Spring Boot que demonstra o uso de autenticação e autorização utilizando Spring Security, OAuth2, OIDC e JWT (JSON Web Token). O projeto possui duas configurações de autenticação:

- **Google User**: Configura o login via OAuth2 com Google e utiliza tokens JWT para autenticação e autorização. Essa configuração permite o acesso aos endpoints `/public`, `/private`, `/cookie` e `/jwt`. Após o login com o Google, o usuário pode acessar as rotas protegidas e visualizar as informações de autenticação.

- **Own Users**: Utiliza o formulário de login padrão do Spring Security para autenticação com usuários locais. Apenas as rotas `/public` e `/private` estão disponveis nessa configuração. Usuários precisam de um nome de usuário e senha definidos no sistema para acessar as rotas protegidas.

## Endpoints 📌

- **/public**: Rota pública acessível por qualquer pessoa, independente de autenticação. Permite que todos acessem o conteúdo sem restrições.
  
- **/private**: Rota privada, acessível apenas para usuários autenticados. Exibe uma mensagem exclusiva para usuários autorizados. Está disponível em ambas as configurações de autenticação (Google User e Own Users).

- **/cookie**: Exclusivo para a configuração **Google User**. Exibe detalhes do usuário autenticado via OAuth2, incluindo atributos como o token JWT, email e permissões (roles).

- **/jwt**: Exclusivo para a configuração **Google User**. Exibe informações contidas no token JWT, como claims e o email do usuário autenticado. Este endpoint requer um token JWT válido para funcionar.

## Notas de Estudo 📚  
Algumas anotações estão na raíz do projeto no arquivo chamado `oauth&oidc.md`

## Dependências 📚   

- [Spring Boot](https://spring.io/projects/spring-boot)  
- [Spring Security](https://spring.io/projects/spring-security)  

## Licença 📜 

Este projeto está licenciado sob a licença MIT.