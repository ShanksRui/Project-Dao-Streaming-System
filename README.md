# Project-Dao-Streaming-System

## 📺 Projeto Sistema de Streaming — Java JDBC + DAO

Olá! Este é o meu primeiro projeto seguindo um **padrão de projeto oficial** e também a minha primeira aplicação que integra **Java** com banco de dados usando **JDBC**.

Até aqui, vinha trabalhando apenas com Java puro na IDE, então esse projeto marca uma fase importante na minha jornada de estudos.

Aqui estou reunindo tudo o que venho aprendendo: desde boas práticas de programação até o uso de **DAO (Data Access Object)** e **JDBC** para persistência de dados. O projeto é inspirado no conteúdo do *Nelio Alves*, mas adaptado para a minha proposta.

---

## 📖 Sobre o Projeto

A ideia desse projeto é simular um **sistema de streaming**, onde posso gerenciar:

- **Plataformas de streaming**
- **Assinantes**
- O relacionamento entre eles

Com isso, estou praticando operações **CRUD (Create, Read, Update e Delete)** diretamente no banco de dados, trabalhando com um projeto mais próximo da realidade de sistemas profissionais.

---

## 🚀 Tecnologias Utilizadas

- **JDBC API**
- **PostgreSQL Database**
- **PostgreSQL Connector/J**
- **Apache Maven**

---

## 📌 Padrões e Boas Práticas Aplicadas

- 📁 **DAO Pattern** → separação da lógica de acesso a dados.
- 🏭 **Factory Pattern** → criação centralizada das instâncias DAO.
- 🔒 **PreparedStatement** → segurança contra SQL Injection e melhor performance.
- ⚠️ **Tratamento customizado de exceções** → classes específicas.
- 📦 Organização modular dos pacotes.
- 🔌 Encapsulamento das conexões com o banco de dados.
- 📈 Projeto preparado para migração futura para frameworks ORM como **JPA** ou **Hibernate**.
- 💉 Injeção de conexão via construtor pelo Factory.
- 📁 Uso do **Maven** para gerenciamento de dependências.

---

## 🗂️ Estrutura do Projeto
```
├── application/ → programa principal
├── db/ → manipulação de conexões e exceções
├── model/
│ ├── dao/ → interfaces e fábrica de DAOs
│ ├── dao/impl/ → implementações concretas dos DAOs
│ └── entities/ → classes que representam as entidades
├── config.properties
├── pom.xml
```

---

##  Por que estou fazendo esse projeto?

Porque quero consolidar o que venho estudando sobre **Java e Banco de Dados**, colocar boas práticas em ação e deixar pronto um projeto que possa apresentar como parte do meu portfólio. 
Além disso, trabalhar com padrões de projeto como **DAO** e **Factory Pattern** me ajuda a entender melhor como sistemas reais são organizados.

---
Se quiser acompanhar a evolução, fica à vontade para explorar o código, sugerir melhorias ou trocar ideias.



