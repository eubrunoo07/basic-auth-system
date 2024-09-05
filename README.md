
# Basic Auth System

Este é um sistema básico de autenticação construído com **Spring Boot**, projetado para demonstrar funcionalidades de registro, login e controle de acesso usando autenticação básica.

## Funcionalidades

- Registro de novos usuários
- Login de usuários existentes
- Autenticação básica para proteger endpoints
- Manipulação de erros de autenticação e autorização

## Tecnologias Utilizadas

- **Spring Boot** - Framework para criar aplicações Java
- **Spring Security** - Para lidar com autenticação e autorização
- **JPA (Java Persistence API)** - Para interagir com o banco de dados
- **H2 Database** - Banco de dados em memória para ambiente de desenvolvimento
- **Maven** - Gerenciador de dependências

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter as seguintes ferramentas instaladas:

- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)

## Configuração do Banco de Dados

Por padrão, o projeto usa o banco de dados H2 em memória para desenvolvimento. As configurações podem ser encontradas no arquivo `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password: password
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
```

### Alterando o Banco de Dados

Para usar outro banco de dados, como PostgreSQL ou MySQL, altere as propriedades correspondentes no arquivo `application.yml`.

## Executando o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/eubrunoo07/basic-auth-system.git
   ```
   
2. Navegue até o diretório do projeto:
   ```bash
   cd basic-auth-system
   ```

3. Execute o Maven para compilar e iniciar o projeto:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse o sistema em `http://localhost:8080`.

## Endpoints

Os principais endpoints disponíveis são:

- `POST /create` - Registro de novos usuários
- `POST /login` - Login de usuários
- `GET /` - Endpoint da classe User para testes de autenticação e permissão

## Estrutura do Projeto

O projeto segue a estrutura padrão do Spring Boot:

```
src/
└── main/
    ├── java/
    │   └── com/
    │       └── eubrunoo07/
    │           └── basicauthsystem/
    ├── resources/
    │   └── application.yml
```

## Testes

Para executar os testes automatizados, use o comando:

```bash
mvn test
```

## Contribuição

Se você deseja contribuir com este projeto, siga as etapas abaixo:

1. Faça um fork do repositório.
2. Crie uma nova branch para suas alterações:
   ```bash
   git checkout -b minha-nova-funcionalidade
   ```
3. Faça commit das suas alterações:
   ```bash
   git commit -m 'Adicionei nova funcionalidade'
   ```
4. Envie para o repositório remoto:
   ```bash
   git push origin minha-nova-funcionalidade
   ```
5. Abra um pull request no GitHub.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
