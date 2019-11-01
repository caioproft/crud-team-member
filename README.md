# CRUD de times e membros

## Motivação

Este projeto tem como intuito fornecer um CRUD para times e integrantes desses times, de modo que um integrante sempre precisa estar cadastrado em um time.

## Guia básico

Acessando a pasta src -> main -> java é possível ter acesso a todos os pacotes que envolvem o backend deste projeto.
Acessando a pasta src -> main -> resources -> templates é possvel ter acesso às telas HTML do projeto;
Acessando a pasta src -> main -> resources -> static é possvel ter acesso aos arquivos CSS que estilizam as páginas HTML

### Conectando o POSTGRES ao seu projeto

Para que sua aplicaço funcione corretamene com o POSGRES é preciso acessar o arquivo application.properties a partir do caminho src -> main -> resources.
- Na linha 1 "spring.datasource.url=jdbc:postgresql://localhost:5432/NOME_DO_SEU_BANCO" alterar o campo NOME_DO_SEU_BANCO pelo nome dado ao seu banco de dados criado a partir do POSTGRES
- Na linha 2 "spring.datasource.username=SEU_USER_NAME" alter o campo SEU_USER_NAME para seu user name utilizado no POSTGRES.
- Na linha 3 "spring.datasource.password=SUA_SENHA" alterar o campo SUA_SENHA para a senha utilizada no POSTGRES.


## Tecnologias utilizadas

- Java
- Framework Spring (Spring Data, Spring MVC, Spring WEB e Spring Boot)
- Postgres
- Gradle
- HTML
- CSS
- Bootstrap


