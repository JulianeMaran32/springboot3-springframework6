# Beer

- URL: [SFG Beer Works](https://sfg-beerDTO-works.github.io/brewery-api/#tag/Beer-Service/operation/listBeers)

---

## Tópicos

### Spring Boot e Spring MVC

- Usando o Projeto Lombok
- Serviços REST
- Teste do Spring MockMVC com Mockito e JUnit
- Tratamento de Exceções
- Spring Data JPA
- Validação de Dados

---

- MySQL with Spring Boot
- Flyway Migrations with Spring Boot
- Using Test Containers with Spring Boot
- CSV File Uploads
- Query Parameters with Spring MVC
- JPA Database Relationship Mappings
- Database Transactions & Locking and Spring
- Introduction to Spring Data REST

---

## Beer Service

### GET /beerDTO

**cURL - Request**

```
curl --location 'http://localhost:8080/api/v1/beerDTO'
```

**Response**

```json
[
  {
    "id": "32aa45e0-6155-4c05-9923-f8ae38f90109",
    "version": 1,
    "beerName": "Crank",
    "beerStyle": "PALE_ALE",
    "upc": "12356222",
    "quantityOnHand": 392,
    "price": 11.99,
    "createdDate": "2025-08-24T20:40:05.9140668",
    "updateDate": "2025-08-24T20:40:05.9140668"
  },
  {
    "id": "048fb4c8-b412-4e53-b98f-67084d2d3f43",
    "version": 1,
    "beerName": "Galaxy Cat",
    "beerStyle": "PALE_ALE",
    "upc": "12356",
    "quantityOnHand": 122,
    "price": 12.99,
    "createdDate": "2025-08-24T20:40:05.9130553",
    "updateDate": "2025-08-24T20:40:05.9130553"
  },
  {
    "id": "53310740-c4bc-4802-af3f-ecd63e17c6ce",
    "version": 1,
    "beerName": "Sunshine City",
    "beerStyle": "IPA",
    "upc": "12356",
    "quantityOnHand": 144,
    "price": 13.99,
    "createdDate": "2025-08-24T20:40:05.9140668",
    "updateDate": "2025-08-24T20:40:05.9140668"
  }
]
```

### GET /beerDTO/{beerId}

**cURL - Request**

```
curl --location 'http://localhost:8080/api/v1/beerDTO/f7995058-436c-483e-8e91-61df2515a98f'
```

**Response**

```json
{
  "id": "f7995058-436c-483e-8e91-61df2515a98f",
  "version": null,
  "beerName": "Crank",
  "beerStyle": "PALE_ALE",
  "upc": "12356222",
  "quantityOnHand": 392,
  "price": 11.99,
  "createdDate": "2025-08-24T22:01:10.2563538",
  "updateDate": "2025-08-24T22:01:10.2563538"
}
```

### POST /beerDTO

**cURL - Request**

```
curl --location 'http://localhost:8080/api/v1/beerDTO' \
--header 'Content-Type: application/json' \
--data '{
    "beerName": "Crank",
    "beerStyle": "PALE_ALE",
    "upc": "12356222",
    "quantityOnHand": 392,
    "price": 11.99
}'
```

**Response**

Status HTTP: 201 Created

```bash
POST /api/v1/beerDTO HTTP/1.1
Content-Type: application/json
User-Agent: PostmanRuntime/7.45.0
Accept: */*
Cache-Control: no-cache
Postman-Token: b26032b7-538d-4e5a-9ae6-b7a91ac6300b
Host: localhost:8080
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
Content-Length: 132
 
{
"beerName": "Crank",
"beerStyle": "PALE_ALE",
"upc": "12356222",
"quantityOnHand": 392,
"price": 11.99
}
 
HTTP/1.1 201 Created
Location: /api/v1/beerDTO/c82acc2b-1d32-4db6-ab13-2e1f62c7f029
Content-Length: 0
Date: Mon, 25 Aug 2025 01:08:05 GMT
Keep-Alive: timeout=60
Connection: keep-alive
```

### PUT /beerDTO/{beerId}

**cURL - Request**

```
curl --location --request PUT 'http://localhost:8080/api/v1/beerDTO/dcbf93f1-90a6-448a-bd81-005cce0e1705' \
--header 'Content-Type: application/json' \
--data '{
    "beerName": "Crank",
    "beerStyle": "PALE_ALE",
    "upc": "12356222",
    "quantityOnHand": 390,
    "price": 11.99
}'
```

**Response**

- Status HTTP: 204 No Content

### DELETE /beerDTO/{beerId}

**cURL - Request**

```
curl --location --request DELETE 'http://localhost:8080/api/v1/beerDTO/08a5e479-5ee5-476c-8c38-44dea65b710a'
```

**Response**

- Status HTTP: 204 No Content

### PATCH /beerDTO/{beerId}

Atualiza apenas um campo da entidade Beer.

**cURL - Request**

```
curl --location --request PATCH 'http://localhost:8080/api/v1/beerDTO/7bf0d4a7-323f-4bd8-aa8e-7f8ac9926782' \
--header 'Content-Type: application/json' \
--data '{
    "quantityOnHand": 105
}'
```

**Response**

- Status HTTP: 204 No Content

---

## Order Service

### GET /customerDTO

**cURL - Request**

```
curl --location 'http://localhost:8080/api/v1/customerDTO'
```

**Response**

```json
[
  {
    "id": "dd49fd83-f2cc-448c-9d3a-3f621eb5c354",
    "version": 1,
    "name": "Customer 3",
    "createdDate": "2025-08-25T21:23:32.017548",
    "updateDate": "2025-08-25T21:23:32.017548"
  },
  {
    "id": "f54d9ee9-70e6-4629-a394-6712f51ceb99",
    "version": 1,
    "name": "Customer 1",
    "createdDate": "2025-08-25T21:23:32.017548",
    "updateDate": "2025-08-25T21:23:32.017548"
  },
  {
    "id": "6052e994-efeb-4858-ba39-8b11e15a1daf",
    "version": 1,
    "name": "Customer 2",
    "createdDate": "2025-08-25T21:23:32.017548",
    "updateDate": "2025-08-25T21:23:32.017548"
  }
]
```

---

### GET /customerDTO/{customerId}

**cURL - Request**

```
curl --location 'http://localhost:8080/api/v1/customerDTO/f54d9ee9-70e6-4629-a394-6712f51ceb99'
```

**Response**

```json
{
  "id": "f54d9ee9-70e6-4629-a394-6712f51ceb99",
  "version": 1,
  "name": "Customer 1",
  "createdDate": "2025-08-25T21:23:32.017548",
  "updateDate": "2025-08-25T21:23:32.017548"
}
```

---

### POST /customerDTO

**cURL - Request**

```
curl --location 'http://localhost:8080/api/v1/customerDTO' \
--header 'Content-Type: application/json' \
--data '{
    "name": "José da Silva"
}'
```

**Response**

- Status HTTP: 201 Created

```bash
POST /api/v1/customerDTO HTTP/1.1
Content-Type: application/json
User-Agent: PostmanRuntime/7.45.0
Accept: */*
Cache-Control: no-cache
Postman-Token: 07f1c871-876d-4b25-becc-a7f415ac0a66
Host: localhost:8080
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
Content-Length: 34
 
{
"name": "José da Silva"
}
 
HTTP/1.1 201 Created
Location: /api/v1/customerDTO/a2ebf9f8-4c50-49ff-8071-2c75e28f5023
Content-Length: 0
Date: Mon, 25 Aug 2025 11:02:43 GMT
Keep-Alive: timeout=60
Connection: keep-alive
```

---

### PUT /customerDTO/{customerId}

**cURL - Request**

```
curl --location --request PUT 'http://localhost:8080/api/v1/customerDTO/f54d9ee9-70e6-4629-a394-6712f51ceb99' \
--header 'Content-Type: application/json' \
--data '{
    "name": "José da Silva"
}'
```

**Response**

- Status HTTP: 204 No Content

---

### DELETE /customerDTO/{customerId}

**cURL - Request**

```
curl --location --request DELETE 'http://localhost:8080/api/v1/customerDTO/2fc46a08-a6b2-404b-a3fe-b4d4e3289015'
```

**Response**

- Status HTTP: 204 No Content

### PATCH /customerDTO

**cURL - Request**

```
curl --location --request PATCH 'http://localhost:8080/api/v1/customerDTO/6baa2b63-6ec4-4833-b261-09b105de3c53' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Maria do Carmo"
}'
```

**Response**

- Status HTTP: 204 No Content