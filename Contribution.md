#Contribuindo com [LibraryApi]

 ## :gear: Como contribuir?

1. Faça o **fork** do repositório.
2. Crie uma **branch** para a sua feature (ex: `git checkout -b minha-feature`).
3. Faça suas alterações e commit as mudanças (ex: `git commit -m 'Adiciona nova funcionalidade'`).
4. Envie a **branch** para o seu repositório (ex: `git push origin minha-feature`).
5. Crie um **pull request** para o repositório original.

Algumas dependências são necessárias para rodar o projeto localmente:

- **JDK 17 ou superior**
  
  Se necessário, adicionar ao PATH.
  para verificar a versão do java, voce pode escrever "java -version" no cmd ou bash.
- **Apache Maven**
  
  Você instala o maven e coloca o diretório do bin no PATH do sistema.
  escreva mvn -v para verificar a versão do maven e confirmar se ele está instalado no sistema.
- **Docker**
  
  No docker, é necessário o docker desktop para o windows.


## Front-End/Back-end
Por ser utilizado o Thymeleaf para elaboração do projeto, é necessário somente as seguintes configurações
va na pasta \BibliotecaAPI\Back-End\src\main\resources\application.properties

e edite o arquivo de configuração para o seu banco de dados
- spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_bd (utilizo o localhost:3306 para o banco)
- atribuir o login e senha para o banco em
- spring.datasource.username=(usuário do banco)
- spring.datasource.password=(senha do banco)
e, caso queira, atribua um valor para o server port
- server.port=9000 (por exemplo)
Depois, utiize os comandos para rodar o docker
- docker compose build —no-cache
e
- docker compose build —no-cache
então, abra o localhost com a porta escolhida no server.port e

Pronto, o projeto está pronto para ser rodado localmente :).


## ⚠️ Reportando Problemas
Se encontrar algum problema, abra uma Issue no nosso repositorio, utilizando o padrão 'issue nome-issue' e inclua o máximo de detalhes possível, como:

-Passos para reproduzir o problema

-Comportamento esperado

-Comportamento real

-Captura de tela ou log
e crie um pull request querendo saber mais sobre

Criando um fork do repositório,
Envie seus commits em português ou inglês.

Insira um pequeno resumo sobre o que foi adicionado.

Solicite um pull request.
