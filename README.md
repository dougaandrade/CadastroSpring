# 📌 Sistema de Cadastro e Gerenciamento de Pessoas e Setores

Este projeto é um sistema de cadastro e gerenciamento de pessoas e setores, desenvolvido com Spring Boot para o back-end. Ele permite a criação, edição, exclusão e consulta de registros, garantindo um controle eficiente dos dados.

## 🚀 Tecnologias Utilizadas

- ✅ **Spring Boot** – Framework para a construção da API REST.
- ✅ **Spring Data JPA** – Para a integração com o banco de dados.
- ✅ **PostgreSQL** – Banco de dados relacional utilizado na aplicação.
- ✅ **Docker Compose** – Para orquestração do banco de dados.
- ✅ **Lombok** – Para reduzir a verbosidade do código.
- ✅ **Swagger** – Para documentação da API.
- ✅ **Postman** – Para testes e desenvolvimento.
- ✅ **DBeaver** – Cliente SQL para gerenciar o banco de dados.

## 🔥 Funcionalidades

- 🔹 Cadastro, edição e remoção de pessoas e setores.
- 🔹 Associação de pessoas a setores específicos.
- 🔹 Consulta eficiente por meio de endpoints RESTful.
- 🔹 Documentação interativa da API via Swagger.

## 📂 Como Executar o Projeto

### 📌 Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

- ✅ **JDK 17** ou superior
- ✅ **Maven**
- ✅ **Git**
- ✅ **Docker e Docker Compose**
- ✅ **DBeaver** (opcional, para acessar o banco de dados)

### 🚀 Clonando o Repositório

```sh
# Clone este repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Acesse a pasta do projeto
cd seu-repositorio
```

### ⚙️ Configurando e Executando a Aplicação

```sh
# Construir o projeto
mvn clean install

# Subir o banco de dados com Docker Compose
docker-compose up -d

# Executar a aplicação
mvn spring-boot:run
```

### 🛠 Acessando a API

Após iniciar o projeto, você pode acessar:

- 🔹 **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- 🔹 **Banco de dados PostgreSQL:** Conectar-se via um cliente PostgreSQL (ex: DBeaver, pgAdmin) utilizando as credenciais configuradas no `docker-compose.yml`.

## 📜 Licença

Este projeto está licenciado sob a MIT License – veja o arquivo LICENSE para mais detalhes.

🚀 **Este projeto serve como base para aplicações que necessitam de um sistema de gerenciamento de cadastros, podendo ser expandido conforme necessário.**
