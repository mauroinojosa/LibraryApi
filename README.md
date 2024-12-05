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


## Front-End/Back-end
Por ser utilizado o Thymesia para elaboração do projeto, é necessário somente:
va na pasta \BibliotecaAPI\Back-End\src\main\resources\application.properties

e edite o arquivo de configuração para o seu banco de dados
- spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_bd (utilizo o localhost:3306 para o banco)
e, caso queira, atribua um valor para o server port
- server.port=9000 (por exemplo)

Pronto, o projeto está pronto para ser rodado localmente :).

#Endpoints do projeto

![image](https://github.com/user-attachments/assets/5e2b3f87-a7ee-4833-9b94-f8819bf6adc7)

![image](https://github.com/user-attachments/assets/e62104b7-2aba-4ba2-8ed1-d1443087779e)

![image](https://github.com/user-attachments/assets/2b43ddc5-b8eb-4654-b154-4294b3dd16f8)

![image](https://github.com/user-attachments/assets/0d1bae6c-9aab-43ec-b1e8-097f13163ef5)




