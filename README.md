<h1 align="center"> LibraryApi</h1>

<h1>Introdução</h1>

O projeto LibraryApi é uma aplicação de API desenvolvida para simular a gestão de uma bilbioteca,.
O sistema permite o gerenciamento de livros, empréstimo, endereço e usuário. Através dessa API, é possível realizar operações como o cadastro de livros, a criação e edição de usuários, registro de empréstimos de livros e cadastro de endereços.


<h1>Funcionalidades</h1>

A API implementa as seguintes funcionalidades:
  <ul>
    Gerenciamento de livros
    <ul>- Cadastro, edição, remoção e consulta do livro.</ul>
    <ul>- Cada livro possui poucas informações como o nome dele somente.</ul>
    Gerenciamento de usuários
    <ul>- Cadastro de usuários</ul>
    <ul>- Edição e remoção de usuários</ul>
    Gerenciamento de empréstimos
    <ul>- Registro de empréstimos de livro para usuários</ul>
    <ul>- Verificação de livros emprestados e devolução dos mesmos</ul>
    Gerenciamento de endereços
    <ul>- Cadastro de endereços</ul>
    <ul>- Busca dos dados de endereço</ul>
  </ul>


  ## :rocket: Tecnologias Utilizadas


- **MySQL/PostgreSQL** - Banco de dados relacional
- **JWT (JSON Web Tokens)** - Para autenticação de usuários
- **Jest** - Framework de testes para garantir a qualidade do código
- **Maeven** - Para Depêndecias e organização do projeto
- **Thymeleaf** - Framework para front end utilizando java



# LibraryApi 📚

## :bookmark_tabs: Descrição

---

## :gear: Como Rodar o Projeto

### 1. Clone o repositório

no bash

- git clone https://github.com/mauroinojosa/LibraryApi.git

cd LibraryApi


## Front-End
va na pasta \BibliotecaAPI\Back-End\src\main\resources\application.properties

e edite o arquivo de configuração para o seu banco de dados
- spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_bd (utilizo o localhost:3306 para o banco)
e, caso queira, atribua um valor para o server port
- server.port=9000 (por exemplo)

## Back-End
Va para a pasta \BibliotecaAPI-Back-End\BibliotecaAPI-Back-End\Back-End\src\main\resources\application.properties
e edite o arquivo de configuração do banco de dados
- spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_bd (utilizo o localhost:3306 para o banco)

apos isso, realize um Clean Install no maeven  e execute o back-end, e depois o front.

Pronto, o projeto está pronto para ser rodado localmente :).




