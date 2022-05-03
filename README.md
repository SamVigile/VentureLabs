# Desafio BackEnd - Samara Vigile

### Objetivo

Esse desafio constituir em realizar a construção de um sistema de compra de passagens aéreas. O sistema possui os seguintes requisitos:

- Suportar múltiplos voos
- Suportar múltiplos assentos por voo
- Suportar múltiplas compras de passagem aérea
- Suportar múltiplas aeroportos
- Suportar cadastro de múltiplos cliente
- Cada passagem aérea deve possuir:
  - Voo
  - Assento
  - Cliente
  - Data Compra
  - Localizador/Identificador da passagem
- Cada voo deve possuir:
    - Horário de saída
    - Horário de chegada
    - Aeroporto Origem
    - Aeroporto Destino
    - Quantidade de Assentos
    - Preço da passagem aérea
-Atentar-se para overbooking (venda de assentos iguais)
-API deve utilizar padrão REST
- O banco de dados deve ser MySQL
- A linguagem deve ser Kotlin ou Node.JS

Rotas/Métodos Esperadas
1. Adicionar voo. ( Obs: esse método deve criar os assentos vinculados ao voo)
2. Adicionar cliente
3.  Adicionar compra de passagem aérea
4. Listar voo com assentos disponíveis
5. Listar passagem aéreas por cliente
6. Listar passagens por voo
7. Obter detalhe da passagem aérea contendo os dados do voo também

Criar uma API no padrão REST para suportar um sistema de venda de passagens aéreas.

### Pré Requisitos
Java 11
IntelliJ ou IDE de sua preferência
MySQL Server

### Como Rodar o Projeto
É recomendado que seja realizado o import do projeto em sua IDE mas caso queira, pode empacotar e subir o projeto.
É necessário no MySQL criar um Schema, no meu caso eu chamei del VentureLabs.
O Projeto já está com a geração das tabelas automaticamente com bases nas classes, porém, caso queira alterar isso, só ir no .properties e alterar a propriedade;

    spring.jpa.hibernate.ddl-auto 

para o que lhe melhor atender.
É necessário realizar a configuração da URL do banco, nas propriedades abaixo;

    spring.datasource.url = jdbc:mysql://localhost:3306/venturelabs?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false  
    spring.datasource.username = root  
    spring.datasource.password =

### Notas

O que eu achei do projeto
Antes desse projeto, eu não tinha muito conhecimento em Kotlin, minha expertise era mais em Java, então estudei bastante em como fazer toda a arquitetura e de fato criar o código, estou bem satisfeita com o resultado que cheguei, alguns pontos preciso melhorar mesmo após a entrega do desafio.
Muito obrigada pela oportunidade.

### STACK TECNOLÓGICA
Java 11
Kotlin 1.6.21
MySQL
SpringBoot 2.6.7

Para realizar os testes foi utilizado o Postman e a coleção está na pasta Postman
Foi entregue um banco de dados Limpo para que o usuário consiga cadastrar as informações da forma que melhor atender os requisitos e necessidades.


### Byebye! Obrigada!

![](https://media.giphy.com/media/m9eG1qVjvN56H0MXt8/giphy.gif)