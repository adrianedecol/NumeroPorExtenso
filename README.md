# NumeroPorExtenso

Projeto que recebe um número no path "/api/", sendo no intervalo de -99999 até 99999 e retorna a versão por extenso do mesmo.

## Tecnologias Utilizadas

| # | Para que |
|:-:|:-|
| [Java 8](https://java.com/en/download/help/linux_x64_install.xml) | Linguagem de programação qual a aplicação foi construída |
| [Spring Boot](https://spring.io/projects/spring-boot) | Framework base em qual a aplicação foi construída e projetada |
| [Spring Fox](http://springfox.github.io/springfox/) | Ferramenta para geração da documentação da api Rest com Swagger, que funciona integrada com Spring Boot |
| [Swagger](https://swagger.io) | Tecnologia utilizada para documentação das api’s Rest  |
| [Maven](https://maven.apache.org/) | Ferramenta de gestão de dependências e build  |
| [JUnit 5](https://junit.org/junit5/) | Utilizado para execução dos testes da app |

## Execução

### Execução local IDE 
A aplicação pode ser executada e alterada por uma IDE Java (Eclipse, IntelliJ IDEA, etc). O formato da abertura/importação do processo vai depender da IDE adotada.

#### Pré requisitos
- [Java 8](https://java.com/en/download/help/linux_x64_install.xml) 
- [Maven](https://maven.apache.org/)

### Execução local manual
A aplicação pode ser executada manualmente atráves de linha de comando

#### Pré requisitos
- [Java 8](https://java.com/en/download/help/linux_x64_install.xml) 
- [Maven](https://maven.apache.org/)

#### Comandos
```shell
# Na raiz do projeto, executar os seguintes comandos

# Build Maven (executa os testes automatizados)
mvn clean install

# Execução
java -jar target\numeroporextenso-0.0.1-SNAPSHOT.jar

```

## Links importantes

### Swagger

A documentação da API pode ser acessada pela própria aplicação, via Swagger, disponível atráves do link `http://localhost:8080/swagger-ui.html`.