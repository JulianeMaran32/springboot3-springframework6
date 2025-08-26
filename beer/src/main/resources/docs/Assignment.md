# Assignment

## Spring MVC REST Services

### HTTP GET with Spring MVC

_Implement `GET` customer operations_

#### Instruções

* Assignment is to implement `GET` customer operations.
* Customer simple POJO of `customerName`, `id`, `version`, `createdDate`, `lastModifiedDate`.
* Use Project Lombok.
* Create Service, use Map to store 2-3 customers.
* Create Controller Endpoint to **list all customers**.
* Create Controller Endpoint to **get customer by id**.

#### Pergunta

* If you're using Project Lombok, how do you override a getter implementation?
    * **Minha Resposta:** If you create a getter method without using Lombok, when running the application the method
      will not be generated again by Lombok.
    * **Resposta do Instrutor:** Simply implement the desired getter method. Lombok will not generate the method if one
      is provided.

### HTTP `POST` with Spring MVC

_Handle HTTP POST` for Create new Customer_

#### Instruções

* Assignment - Handle HTTP POST` for Create new Customer
* Create Controller method to handle post
* Update Request Mapping
* Save to in-memory hash map
* Return 201 status with location of created customer object

#### Pergunta

* What does the HTTP status 201 mean?
    * **Minha Resposta:** `HTTP Status 201` means creating a resource.
    * **Resposta do Instrutor:** `HTTP 201` means `created`. The server response to indicate the resource was created
      successfully.

### HTTP `PUT` with Spring MVC

_Implement HTTP `PUT` endpoint to update existing customer_

#### Instruções

* Implement HTTP `PUT` endpoint to update existing customer

#### Pergunta

* What is special about the `@PutMapping` annotation?
    * **Minha Resposta:** The `@PutMapping` annotation in Spring is used to map `HTTP PUT` requests to specific methods
      in a controller, indicating that this action should be used to update an existing resource.
    * **Resposta do Instrutor:** The `@PutMapping` annotation will limit the method to responding to `HTTP PUT` requests
      only.

### HTTP `DELETE` with Spring MVC

#### Instruções

* Implement HTTP `DELETE` endpoint to delete existing customer

#### Pergunta

* Should you return a content body in a delete operation?
    * **Minha Resposta:** In a `DELETE` operation, it is best not to return a content body, especially if the delete was
      successful. The HTTP status code `204 No Content` is the safest way to indicate that the request was successful
      and that there is no content to return in the response.
    * **Resposta do Instrutor:** No, delete operations should just return a HTTP `204 No Content` status.

### HTTP `PATCH` with Spring MVC

_Implement `PATCH` endpoint for customer._

#### Instruções

* Implement `PATCH` endpoint for customer.
* Create Service method for patch operation

#### Pergunta

* How is a HTTP Patch operation different from an update operation?
    * **Minha Resposta:** An `HTTP PATCH` operation is for making partial updates to a resource, while `PUT` is for
      replacing the entire resource. In essence, `PATCH` allows you to send only the changes you want to apply, whereas
      `PUT` requires you to send the complete representation of the updated resource.
    * **Resposta do Instrutor:** A `PATCH` operation allows you to update specific properties, while an update operation
      will update all properties.

---

## Spring MockMVC Test with Mockito and JUnit

### Test GET Customer

#### Instruções

* Use Spring MockMVC and Mockito to test GET operations for customer
* Write test to test get customer list
    * verify number of elements in list
* Write test to get customer by id
    * Verify properties in JSON response from Spring Mock MVC

#### Pergunta

* Why use Spring MockMVC?
    * **Minha Resposta:** MockMvc, part of the Spring MVC testing framework, is used to test the web layer of a Spring
      application in isolation, without the need for a running server. This allows for faster and more efficient
      testing, focusing on controller logic and interaction with the web layer, such as JSON serialization and
      validation.
    * **Resposta do Instrutor:** Spring MockMVC allows you to test the controller interactions in a servlet context
      without the application running in a application server.

### Test Xxxxxx

#### Instruções

#### Pergunta

* Why use Spring MockMVC?
    * **Minha Resposta:**
    * **Resposta do Instrutor:**

---

## Exception Handling with Spring MVC

---

## Spring Data JPA with Spring MVC

---

## Data Validation with Spring