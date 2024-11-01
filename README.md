<h1>Sistema CRUD de Clientes</h1>

Este é um projeto de sistema CRUD (Create, Read, Update, Delete) para gerenciamento de clientes, desenvolvido em **Java** e **Spring Boot**. Ele permite realizar operações básicas de cadastro, consulta, atualização e exclusão de dados de clientes, aplicando boas práticas de desenvolvimento e arquitetura.

<h2>🚀 Tecnologias e Ferramentas Utilizadas</h2>

- **Java 21**
- **Spring Boot 3.3.5**
- **Spring Data JPA** com **Hibernate** para manipulação de dados
- **Banco de Dados H2** em memória para armazenamento dos dados
- **Bean Validation** para validação dos dados de entrada

## ⚙️ Funcionalidades

1. **Cadastro de Clientes**: Permite a criação de um novo cliente com dados como nome, e-mail, telefone, etc.
2. **Listagem de Clientes**: Exibe a lista completa dos clientes cadastrados.
3. **Consulta de Cliente**: Permite a busca de um cliente específico pelo seu ID.
4. **Atualização de Dados do Cliente**: Atualiza informações de um cliente existente.
5. **Exclusão de Cliente**: Remove um cliente do sistema pelo ID.

## 🛠️ Configuração e Execução do Projeto

### Pré-requisitos

Para executar este projeto localmente, é necessário ter:
- **Java 21** ou superior
- **Maven** para gerenciar as dependências

### Passos para rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/sistema-crud-clientes.git
   cd sistema-crud-clientes

2. Compile e execute o projeto com o Maven:
   ```bash
   mvn spring-boot:run
   
3. Acesse o sistema em http://localhost:8080.

<h2>🧩 Estrutura do Projeto</h2>
- src/main/java - Contém a estrutura do código-fonte do projeto.
  - controllers - Contém os controladores REST, responsáveis por definir as rotas e endpoints da aplicação.
    
  - services - Contém a lógica de negócios da aplicação.
    
  - repositories - Contém as interfaces de repositório que realizam a comunicação com o banco de dados.
    
  - entities - Contém as classes de modelo que representam as entidades do banco de dados.
    
  - dto - Contém as classes de transferência de dados (Data Transfer Objects) utilizadas nas requisições e respostas.
    
<h2>🚨 Validações</h2>
As validações de dados de entrada foram implementadas usando Bean Validation. Isso garante que as informações dos clientes, como nome, e-mail e telefone, sejam válidas antes de serem salvas no banco de dados.

<h2>📝 Exemplos de Uso</h2>
Abaixo estão alguns exemplos de uso dos endpoints da aplicação:

<h3>1. Cadastro de um novo cliente</h3>

- Endpoint: POST /clients
- Body:

```bash
{
   "nome": "Rafael Costa",
   "cpf": "11111111123",
   "income": 4500.00,
   "birthDate": "1999-02-27",
   "children": 0
}
```
<h3>2. Listagem de todos os clientes</h3>

- Endpoint: GET /clients

<h3>3. Consulta de cliente por ID</h3>

- Endpoint: GET /clients/{id}

<h3>4. Atualização de dados do cliente</h3>

- Endpoint: PUT /clients/{id}
Body:
```bash
{
   "nome": "Joana Gomes",
   "cpf": "33322233305",
   "income": 5500.00,
   "birthDate": "1985-05-15",
   "children": 3
}
```
<h3>5. Exclusão de um cliente</h3>

- Endpoint: DELETE /clients/{id}
