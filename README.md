"" Este repositório foi criado para acompanhar a aula de Java completo do professor Nelio ""
"" Os comentários dentro do código, caso exista, estão todos em inglês ""

Aplicação: Embora este webservice tenha entidades fortes como Payment, Product, Order e User.. a intenção da applicação web nesta forma é:
	1- Testar/aprender/implantar Endpoints;
	2- Aprender API;
	3- Testar o HTML: Get, Post, Update e Delete;
	4- Aprender e testar JPA / Hibernate;
	5- Aprender a usar springBoot;


O que usamos:
- Java Orientado a Objetos;
- SpringBoot;
- Maven;
- H2 database (Banco de dados H2 para o desenvolvimento);
- Postgres - Para produção;
- Heroku - Heroku CLI;

Softwares:
- IDE Spring Tool Suite;
- Postman;
- PostgresSQL (pgAdmin 4);


Demais skills reforçados nesse projeto:
- Git hub;
- Coleções (collections);
- Exceções - Tratamento;
- Interfaces;
- UML;


URL publicada no heroku: https://fsantosbr-course-springboot.herokuapp.com/
OBS: Caso não esteja acessível, me avisa, pois é uma ferramenta free.

Esta URL deve trazer a mensagem de erro padrão do Spring Boot.

Testando - GET:
 1- Para testar, podemos abrir o navegador do seu dispositivo e adicionar '/users' no final da URL:
	https://fsantosbr-course-springboot.herokuapp.com/users
 2- Isso deve trazer dois usuários já cadastrados no nosso banco de dados.
 3- Um dos usuários são meus dados para contato. Não vale usar para golpes.
 4- Adicionando '/users/2' na URL, teremos um filtro do usuário em questão pelo Id cadastrado no banco de dados.

Testando - POST:
1- Usando o Postman, mude a requisição para POST.
2- URL: https://fsantosbr-course-springboot.herokuapp.com/users
3- Headers: A chave 'Content-Type' precisar ter o valor 'application/json'
4- Body precisa ser em 'Raw'. Formato do body precisa ser 'Json' ou 'Json Application'
5- Body:
{
    "name": "Fabio Alves dos Santos",
    "email": "fsantosinfo@gmail.com",
    "phone": "11965398826",
    "password": "Me contrata"
}

OBS: Dando tudo certo, deve retornar o código '201 created'.


Referência ao professor: educandoweb.com
Autor dos comentários no código: Fabio Alves
Criação do readme: Fabio Alves
Linkedin: https://www.linkedin.com/in/fabioalsantos/
