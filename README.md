# Project-Dao-Streaming-System

# 📺 Projeto Sistema de Streaming — Java JDBC + DAO

Olá! 👋 Este é o meu primeiro projeto seguindo um **padrão de projeto oficial** e também a minha primeira aplicação que integra **Java** com um banco de dados usando **JDBC**.  
Até aqui, eu vinha trabalhando apenas com Java puro na IDE, então esse projeto marca uma fase importante da minha jornada de estudos.

Aqui, estou reunindo tudo que venho aprendendo: desde boas práticas de programação até o uso de **DAO (Data Access Object)** e **JDBC** para persistência de dados. O projeto é inspirado no conteúdo do Nelio Alves, mas adaptado para a minha proposta.

---

## 📖 Sobre o Projeto

A ideia desse projeto é simular um **sistema de streaming**, onde posso gerenciar:

- **Plataformas de streaming**
- **Assinantes**
- O relacionamento entre eles

Com isso, estou praticando operações **CRUD (Create, Read, Update e Delete)** diretamente no banco de dados e trabalhando com um projeto mais próximo da realidade de sistemas profissionais.

---

## Tecnologias Utilizadas

- **JDBC API**
- **PostgreSQL Database**
- **PostgreSQL Connector/J**

---

## Padrões e Boas Práticas que estou aplicando

- 📁 **DAO Pattern** → separação da lógica de acesso a dados.
- 🏭 **Factory Pattern** → para criação das instâncias DAO de forma centralizada.
- 🔒 **PreparedStatement** → segurança contra SQL Injection e melhor performance.
- ⚠️ **Tratamento customizado de exceções** → com classes específicas.
- 📦 Organização de pacotes de forma modular.
- 🔌 Encapsulamento das conexões com o banco de dados.
- 📈 Projeto preparado para uma futura migração para frameworks ORM, como **JPA** ou **Hibernate**.

---

## 🗂️ Estrutura do Projeto
```
src/
├── application/ → programa principal
├── db/ → manipulação de conexões e exceções
├── model/
│   ├── dao/ → interfaces e fábrica de DAOs
│   ├── dao/impl/ → implementações concretas dos DAOs
│   └── entities/ → classes que representam as entidades do projeto
```

## Por que estou fazendo esse projeto?
Porque quero consolidar o que venho estudando sobre **Java e Banco de Dados**, colocar boas práticas em ação e deixar pronto um projeto que posso apresentar como parte do meu portfólio. Além disso, trabalhar com padrões de projeto como DAO e Factory Pattern me ajuda a entender melhor como sistemas reais são organizados.

---
Se quiser acompanhar a evolução, fica à vontade para dar uma olhada no código, sugerir melhorias ou trocar conhecimento.
