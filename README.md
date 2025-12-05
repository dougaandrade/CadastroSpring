# 📌 Sistema de Cadastro e Gerenciamento de Pessoas e Setores

Este projeto é um sistema de cadastro e gerenciamento de pessoas e setores, desenvolvido com Spring Boot para o back-end. Ele permite a criação, edição, exclusão e consulta de registros, garantindo um controle eficiente dos dados.

## 🚀 Tecnologias Utilizadas

- ✅ **Spring Boot** – Framework para a construção da API REST.
- ✅ **Spring Data JPA** – Para a integração com o banco de dados.
- ✅ **PostgreSQL** – Banco de dados relacional utilizado na aplicação.
- ✅ **Docker Compose** – Para orquestração do banco de dados.
- ✅ **Lombok** – Para reduzir a verbosidade do código.
- ✅ **Postman** – Para testes e desenvolvimento.
- ✅ **DBeaver** – Cliente SQL para gerenciar o banco de dados.
- ✅ **Scalar** - Para testes da API e documentação.
- ✅ **Spring Test** - Para testes unitários.

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
- ✅ **Postman**
- ✅ **DBeaver** (opcional, para acessar o banco de dados)
- ✅ **Scalar**

### 🚀 Clonando o Repositório

```sh
# Clone este repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Acesse a pasta do projeto
cd seu-repositorio
```

### ⚙️ Configurando e Executando a Aplicação

#### 1️⃣ Primeiro, inicie o banco de dados PostgreSQL:

```sh
# Subir o banco de dados PostgreSQL em background
docker-compose up -d postgres

# Verificar se o container está rodando
docker ps
```

#### 2️⃣ Compile o projeto:

```sh
# Limpar e compilar o projeto
./mvnw clean compile

# Ou fazer build completo com testes
./mvnw clean install
```

#### 3️⃣ Execute a aplicação:

```sh
# Executar a aplicação Spring Boot
./mvnw spring-boot:run
```

#### 4️⃣ Para parar os serviços:

```sh
# Parar a aplicação Spring Boot (Ctrl+C no terminal onde está rodando)

# Parar e remover os containers Docker
docker-compose down
```

### 🛠 Acessando a API

Após iniciar o projeto, você pode acessar:

- 🔹 **API REST:** [http://localhost:8080](http://localhost:8080)
- 🔹 **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- 🔹 **Actuator Health:** [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)
- 🔹 **Banco de dados PostgreSQL:**
  - **Host:** localhost
  - **Porta:** 5401
  - **Database:** postgres
  - **Username:** postgres
  - **Password:** postgres

## ⚙️ Configurações Importantes

### 📌 Configuração do Banco de Dados

O projeto está configurado para conectar no PostgreSQL via Docker na porta `5401`. As configurações estão em:

- `application.properties`: URL de conexão e credenciais
- `docker-compose.yaml`: Configuração do container PostgreSQL

### 📌 Recursos Disponíveis

- **JPA/Hibernate**: Criação automática das tabelas (`spring.jpa.hibernate.ddl-auto=update`)
- **Flyway**: Configurado mas desabilitado por padrão
- **Lombok**: Para reduzir código boilerplate
- **OpenAPI/Swagger**: Documentação automática da API

## 📜 Licença

Este projeto está licenciado sob a MIT License – veja o arquivo LICENSE para mais detalhes.

🚀 **Este projeto serve como base para aplicações que necessitam de um sistema de gerenciamento de cadastros, podendo ser expandido conforme necessário.**
