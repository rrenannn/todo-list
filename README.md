# 📌 API de Gerenciamento de Tarefas

Uma API REST para gerenciar tarefas, permitindo criar, listar, atualizar, excluir e marcar tarefas como concluídas.

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot** (Spring Web, Spring Data JPA)
- **PostgreSQL** (banco de dados relacional)
- **Lombok** (redução de código boilerplate)
- **Swagger (OpenAPI)** (documentação interativa)

## 📦 Instalação e Execução

### 1️⃣ Clonar o repositório
```sh
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```

### 2️⃣ Configurar o Banco de Dados (PostgreSQL)
Edite o `application.properties` para configurar a conexão com o PostgreSQL:
  ```properties
  spring.datasource.url=jdbc:postgresql://localhost:5432/tarefas
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  spring.jpa.hibernate.ddl-auto=update
  ```

### 3️⃣ Executar a aplicação
```sh
mvn spring-boot:run
```

## 📌 Endpoints da API

### 📌 Criar uma nova tarefa
**POST** `/tarefas`
```json
{
  "titulo": "Tomar água",
  "descricao": "Beber 2L pela manhã"
}
```
✅ **Resposta:** `201 Created`
```json
{
  "id": 1,
  "titulo": "Tomar água",
  "descricao": "Beber 2L pela manhã",
  "status": "PENDENTE",
  "dataCriacao": "2025-03-27T10:00:00"
}
```

### 📌 Listar todas as tarefas
**GET** `/tarefas`
✅ **Resposta:** `200 OK`
```json
[
  {
    "id": 1,
    "titulo": "Tomar água",
    "descricao": "Beber 2L pela manhã",
    "status": "PENDENTE"
  }
]
```

### 📌 Concluir uma tarefa
**PATCH** `/tarefas/{id}/concluir`
✅ **Resposta:** `200 OK`
```json
{
  "id": 1,
  "status": "CONCLUIDA",
  "dataConclusao": "2025-03-27T12:00:00"
}
```

### 📌 Reabrir uma tarefa
**PATCH** `/tarefas/{id}/reabrir`
✅ **Resposta:** `200 OK`
```json
{
  "id": 1,
  "status": "PENDENTE",
  "dataConclusao": null
}
```

### 📌 Excluir uma tarefa
**DELETE** `/tarefas/{id}`
✅ **Resposta:** `204 No Content`

## 🛠️ Melhorias Futuras
- [ ] Implementar autenticação JWT
- [ ] Adicionar paginação na listagem de tarefas
- [ ] Criar notificações para tarefas atrasadas

## 📜 Licença
Este projeto é open-source sob a licença MIT. Sinta-se à vontade para contribuir! 😃

---
💡 **Gostou do projeto?** Deixe uma ⭐ no GitHub! 🚀

