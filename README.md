# 📚 Biblioteca Pessoal

Um sistema de gerenciamento de livros desenvolvido em Java, criado para praticar conceitos de Programação Orientada a Objetos (POO), estruturas de dados, lógica de programação e, posteriormente, integração com banco de dados.

O projeto permite que usuários criem uma conta, façam login e gerenciem sua própria biblioteca pessoal, com os dados armazenados de forma persistente em um banco de dados MySQL.

## ✨ Funcionalidades

* 👤 Cadastro de usuário
* 🔐 Login de usuário
* 🔒 Validação de nome de usuário e senha
* 📖 Cadastro de livros
* 👨‍💼 Cadastro e associação de autores
* 🏢 Cadastro e associação de editoras
* 👤 Associação dos livros ao usuário logado
* 📋 Listagem de livros
* 🗑️ Remoção de livros
* ✅ Marcar livro como lido
* 📊 Estatísticas de leitura
* 💾 Persistência dos dados em banco de dados MySQL
* ⚠️ Tratamento de entradas inválidas e exceções

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia    | Utilização                                        |
| ------------- | ------------------------------------------------- |
| Java          | Desenvolvimento da aplicação e lógica do sistema  |
| MySQL         | Armazenamento e gerenciamento dos dados           |
| JDBC          | Conexão entre a aplicação Java e o banco de dados |
| IntelliJ IDEA | Ambiente de desenvolvimento                       |
| Git           | Controle de versão                                |
| GitHub        | Hospedagem do projeto                             |

---

## 🗄️ Banco de Dados

O projeto utiliza um banco de dados **MySQL** para armazenar as informações da aplicação.

A integração entre Java e MySQL é realizada utilizando **JDBC**, permitindo que os dados sejam persistidos e recuperados durante a execução do sistema.

O banco de dados possui informações relacionadas a:

* 👤 Usuários
* 📚 Livros
* ✍️ Autores
* 🏢 Editoras

Os livros são associados ao usuário que está utilizando o sistema, permitindo que cada usuário tenha sua própria biblioteca.

Também são utilizados relacionamentos entre as tabelas para conectar livros, autores, editoras e usuários.

---

## 🔌 Integração com JDBC

A aplicação utiliza JDBC para realizar a comunicação com o banco de dados.

Durante o desenvolvimento foram utilizadas operações como:

* Conexão com o banco de dados;
* Inserção de informações;
* Consulta de dados;
* Atualização de informações;
* Exclusão de registros;
* Utilização de `PreparedStatement` para execução de comandos SQL;
* Tratamento de exceções relacionadas ao banco de dados.

Dessa forma, as operações realizadas pelo usuário na aplicação são refletidas diretamente no banco de dados.

---

## 📚 Conceitos Aplicados

* Programação Orientada a Objetos (POO)
* Classes e Objetos
* Encapsulamento
* Construtores
* Métodos
* Retorno de Objetos
* Getters
* Organização em Packages
* CRUD (Create, Read, Update e Delete)
* Estruturas Condicionais
* Estruturas de Repetição
* Tratamento de Exceções
* Manipulação de Strings
* Classe Character
* Controle de Fluxo
* Scanner para entrada de dados
* Banco de Dados Relacional
* MySQL
* SQL
* JDBC
* Relacionamentos entre tabelas
* Chaves Primárias e Estrangeiras
* Persistência de dados
* PreparedStatement

---

---

## 🚀 Exemplo de Execução

```text
--------CADASTRO DA BIBLIOTECA--------

Digite o nome de usuário que deseja criar:
Hellen

Digite a senha do seu usuário:
Java123

Carregando....

--------CADASTRO REALIZADO--------

Sua conta foi criada com sucesso.

--------------------------------------

Bem-vindo(a), Hellen, à sua biblioteca pessoal!

[1] - Adicionar livro
[2] - Listar livros
[3] - Remover livro
[4] - Marcar como lido
[5] - Mostrar estatísticas
[0] - Sair

Escolha uma opção: 1

Digite o nome do livro que deseja adicionar:
Dom Casmurro

Digite o nome do autor:
Machado de Assis

Digite o nome da editora:
Editora X

Livro adicionado com sucesso!

_________________________________

Escolha uma opção: 2

LISTA DE LIVROS

0 - Livro: Dom Casmurro
Autor: Machado de Assis
Status: Não lido

_________________________________

Escolha uma opção: 4

Escolha o número do livro que você leu:
0

Livro marcado como lido com sucesso!

_________________________________

Escolha uma opção: 5

------ ESTATÍSTICAS ------

Total de livros: 1
Livros lidos: 1
Livros não lidos: 0
```

---

## 📁 Estrutura do Projeto

```text
src
├── application
│   └── Main.java
│
├── account
│   ├── User.java
│   ├── UserService.java
│   └── Login.java
│
├── database
│   └── DatabaseService.java
│
└── library
    ├── Book.java
    ├── Author.java
    ├── Publisher.java
    └── LibraryService.java
```

> A estrutura pode sofrer alterações conforme novas funcionalidades e melhorias forem adicionadas ao projeto.

---

## 🎯 O que aprendi com este projeto

* Criar e organizar um projeto Java em múltiplos pacotes.
* Separar responsabilidades entre diferentes classes.
* Criar e utilizar objetos retornados por métodos.
* Aplicar conceitos fundamentais de POO.
* Implementar operações CRUD.
* Validar dados fornecidos pelo usuário.
* Utilizar tratamento de exceções com `try/catch`.
* Manipular Strings e caracteres.
* Desenvolver menus interativos utilizando `switch`.
* Estruturar melhor a lógica de um sistema orientado a objetos.
* Criar e trabalhar com um banco de dados relacional.
* Integrar uma aplicação Java ao MySQL utilizando JDBC.
* Utilizar SQL para inserir, consultar, atualizar e remover dados.
* Trabalhar com relacionamentos entre tabelas.
* Utilizar chaves primárias e estrangeiras.
* Associar os dados da biblioteca ao usuário logado.
* Utilizar `PreparedStatement` para executar comandos SQL.
* Compreender melhor o fluxo de uma informação entre a aplicação e o banco de dados.

---

## 🚧 Próximos Passos

Este projeto continua em desenvolvimento e novas funcionalidades poderão ser adicionadas futuramente.

A ideia é continuar evoluindo tanto a aplicação quanto os conhecimentos utilizados em sua construção, explorando novas tecnologias, melhorias na estrutura do código e funcionalidades mais completas.

---

<div align="center">

## 👩‍💻 Autora: Hellen Maltas

</div>





