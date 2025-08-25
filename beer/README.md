# Beer

- URL: [SFG Beer Works](https://sfg-beer-works.github.io/brewery-api/#tag/Beer-Service/operation/listBeers)

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

### GET /beer

**cURL - Request**

```
curl --location 'http://localhost:8080/api/v1/beer'
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

---

### GET /beer/{beerId}

**cURL - Request**

```
curl --location 'http://localhost:8080/api/v1/beer/f7995058-436c-483e-8e91-61df2515a98f'
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

---

### POST /beer

**cURL - Request**

```
curl --location 'http://localhost:8080/api/v1/beer' \
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
POST /api/v1/beer HTTP/1.1
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
Location: /api/v1/beer/c82acc2b-1d32-4db6-ab13-2e1f62c7f029
Content-Length: 0
Date: Mon, 25 Aug 2025 01:08:05 GMT
Keep-Alive: timeout=60
Connection: keep-alive
```

---

### PUT /beer/{beerId}

**cURL - Request**

```

```

**Response**

```json

```

---

### DELETE /beer/{beerId}

**cURL - Request**

```

```

**Response**

```json

```

## Order Service

### GET /customer

**cURL - Request**

```
curl --location 'http://localhost:8080/api/v1/customer'
```

**Response**

```json

```

---

### GET /customer/{customerId}

**cURL - Request**

```
curl --location --globoff 'http://localhost:8080/api/v1/customer/{customerId}'
```

**Response**

```json

```

---

### POST /customer

**cURL - Request**

```
curl --location 'http://localhost:8080/api/v1/customer' \
--header 'Content-Type: application/json' \
--data '{
    "name": "José da Silva"
}'
```

**Response**

Status HTTP: 201 Created

```bash
POST /api/v1/customer HTTP/1.1
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
Location: /api/v1/customer/a2ebf9f8-4c50-49ff-8071-2c75e28f5023
Content-Length: 0
Date: Mon, 25 Aug 2025 11:02:43 GMT
Keep-Alive: timeout=60
Connection: keep-alive
```

---

### PUT /customer/{customerId}

**cURL - Request**

```

```

**Response**

```json

```

---

### DELETE /customer/{customerId}

**cURL - Request**

```

```

**Response**

```json

```