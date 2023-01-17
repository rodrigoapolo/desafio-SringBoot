# Desafio Sring Boot

### Avaliação Desenvolvedor Back-end Attornatus

O objetivo deste documento é identificar seus conhecimentos quanto às tecnologias utilizadas no cotidiano de desenvolvimento da equipe de Back-end na Attornatus Procuradoria Digital.

Esta análise propõe avaliar os seguintes temas:
* Qualidade de código
* Java, Spring boot
* API REST
* Testes

A entrega deverá ser feita da seguinte forma:
* O prazo para entrega da avaliação será de até 7 dias após envio da mesma
* Encaminhar este documento com as perguntas respondidas e com o link do código público em sua conta do GitHub
* Opcionalmente, caso você consiga fazer o build da aplicação, poderá também informar o link de acesso


### Qualidade de código

1. Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

Durante a implementação de uma nova funcionalidade de software solicitada, eu avalio se as características de qualidade estão sendo atendidas, são elas:
funcionalidade, confiabilidade, Usabilidade, Eficiência, manutenibilidade, portabilidade.

2. Em qual etapa da implementação você considera a qualidade de software?

As etapas de implementação que eu considero qualidade de software são, o recursos de código,  fácil encontrar uma falha quando ocorre,  fácil modificar ou remover defeitos e atualização em um software.

### Desafio Java

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:

* Criar uma pessoa

requisição: POST

http://localhost:8080/pessoas
```
{
    "name": "Maria Brown",
    "dataNascimento": "2005-06-20T19:53:07Z"
}
```

* Editar uma pessoa

requisição: PUT

http://localhost:8080/pessoas/1
```
{
    "name": "Rodrigo",
    "dataNascimento": "1990-06-20T19:53:07Z"
}
```


* Consultar uma pessoa

requisição: GET

http://localhost:8080/pessoas/1

* Listar pessoas

requisição: GET

http://localhost:8080/pessoas

* Criar endereço para pessoa

requisição: POST

http://localhost:8080/enderecos

```
{
    "logradouro": "Rua Oscar Freire",
    "cep": "5409-010",
    "numero": "6546",
    "cidade": "São Paulo",
    "pessoa": {
    "id": 1,
    "name": "Maria Brown",
    "dataNascimento": "2000-06-20T19:53:07Z"
    }
}
```


* Listar endereços da pessoa

requisição: GET

http://localhost:8080/enderecos/pessoa/1


* Poder informar qual endereço é o principal da pessoa  

requisição: GET

http://localhost:8080/enderecos/pessoaMain/1

### Uma Pessoa deve ter os seguintes campos:  
* Nome
* Data de nascimento
* Endereço:

  * Logradouro
  * CEP
  * Número
  * Cidade

### Requisitos  
* Todas as respostas da API devem ser JSON  
* Banco de dados H2

### Diferencial
* Testes
* Clean Code

### Será levado em avaliação
* Estrutura, arquitetura e organização do projeto  
* Boas práticas de programação  
* Alcance dos objetivos propostos.


## Funcionamento do projeto Main
As instruções abaixo ir ajudar a roda o main do projeto. Para isso, siga o passo-a-passo abaixo:

1. Baixe o projeto.

2. Execute o arquivo 'DesafioSringBootApplication.java', como main na sua IDE no package com.rodrigoapolo.desafioSringBoot.

## Tecnologia usada
* Java 17
* API Collection
* Lambda
* Programação Orientada a Objetos (POO)
* Banco de dados H2
* JSON  
* Spring boot (3.0.1)

