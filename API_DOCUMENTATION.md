# Documentação da API - Sistema de Gerenciamento de Projetos

Esta documentação detalha as rotas disponíveis na API, com exemplos de requisições e respostas.

---

## **Autenticação**

### **POST /authenticate**
Autentica um usuário e retorna um token JWT.

#### Exemplo de Requisição:
```http
POST /authenticate
Content-Type: application/json

{
    "email": "admin@example.com",
    "password": "12345678"
}
```

#### Exemplo de Resposta:
```http
200 OK
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

## **Usuários**

### **GET /users/**
Lista todos os usuários (somente administradores).

#### Exemplo de Requisição:
```http
GET /users/
Authorization: Bearer <token_jwt>
```

#### Exemplo de Resposta:
```http
200 OK
[
    {
        "id": 1,
        "name": "Admin User",
        "email": "admin@example.com",
        "role": "ADMIN",
        "creationDate": "2025-03-10T09:00:00"
    },
    {
        "id": 2,
        "name": "Regular User",
        "email": "user@example.com",
        "role": "USER",
        "creationDate": "2025-03-10T09:00:00"
    }
]
```

## **Projetos**

### **GET /projects/**
Lista todos os projetos (acessível a usuários autenticados).

#### Exemplo de Requisição:
```http
GET /projects/
Authorization: Bearer <token_jwt>
```

#### Exemplo de Resposta:
```http
200 OK
[
    {
        "id": 1,
        "name": "Sistema de Gerenciamento de Projetos",
        "description": "Plataforma para organizar projetos de TI"
    },
    {
        "id": 2,
        "name": "E-commerce Avançado",
        "description": "Plataforma online para vendas de produtos"
    }
]
```

### **POST /projects/**
Cria um novo projeto (somente usuários autenticados).

#### Exemplo de Requisição:
```http
POST /projects/
Authorization: Bearer <token_jwt>
Content-Type: application/json

{
    "name": "Novo Projeto",
    "description": "Descrição do Novo Projeto"
}
```

#### Exemplo de Resposta:
```http
201 Created
{
    "id": 3,
    "name": "Novo Projeto",
    "description": "Descrição do Novo Projeto"
}
```

## **Atividades**

### **GET /activities/**
Lista todas as atividades de um projeto.

#### Exemplo de Requisição:
```http
GET /activities/
Authorization: Bearer <token_jwt>
```

#### Exemplo de Resposta:
```http
200 OK
[
    {
        "id": 1,
        "name": "Planejamento Inicial",
        "description": "Criação do escopo do projeto"
    },
    {
        "id": 2,
        "name": "Desenvolvimento do Backend",
        "description": "Codificação da API em Java"
    }
]
```

### **POST /activities/**
Adiciona uma nova atividade a um projeto (somente autenticados).

#### Exemplo de Requisição:
```http
POST /activities/
Authorization: Bearer <token_jwt>
Content-Type: application/json

{
    "name": "Nova Atividade",
    "description": "Descrição da Nova Atividade",
    "projectId": 1
}
```

#### Exemplo de Resposta:
```http
201 Created
{
    "id": 3,
    "name": "Nova Atividade",
    "description": "Descrição da Nova Atividade"
}
```

## **Lançamentos de Horas**

### **GET /time-entries/**
Lista os lançamentos de horas de atividades.

#### Exemplo de Requisição:
```http
GET /time-entries/
Authorization: Bearer <token_jwt>
```

#### Exemplo de Resposta:
```http
200 OK
[
    {
        "id": 1,
        "description": "Trabalho em Task 1",
        "startTime": "2025-03-10T09:00:00",
        "endTime": "2025-03-10T12:00:00"
    },
    {
        "id": 2,
        "description": "Trabalho em Task 2",
        "startTime": "2025-03-10T13:00:00",
        "endTime": "2025-03-10T17:00:00"
    }
]
```

## **Notas**

Authorization: O cabeçalho Authorization com o token JWT é obrigatório para todas as rotas protegidas.

Status Codes:

- 200 OK: Requisição bem-sucedida.
- 201 Created: Recurso criado.
- 403 Forbidden: Acesso negado.
- 400 Bad Request: Dados inválidos.
