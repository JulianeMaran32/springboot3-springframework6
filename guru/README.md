# Guru

## Exemplo de Sucesso - Book

**Request**

```
curl --location 'http://localhost:8080/books'
```

**Response**

```json

```

## Exemplos de Erros

### 404 Not Found

**Request**

```
curl --location 'http://localhost:8080'
```

**Response**

```json
{
  "timestamp": "2025-08-24T01:17:32.919+00:00",
  "status": 404,
  "error": "Not Found",
  "path": "/"
}
```

### 500 Internal Server Error

**Request**

```
curl --location 'http://localhost:8080/books'
```

**Response**

```json
{
  "timestamp": "2025-08-24T01:16:11.328+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/books"
}
```

