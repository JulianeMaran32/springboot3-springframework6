# Assignment

## GET Customer

_Implement GET customer operations_

### Instruções

* Assignment is to implement GET customer operations
* Customer simple POJO of `customerName`, `id`, `version`, `createdDate`, `lastModifiedDate`
* Use Project Lombok
* Create Service, use Map to store 2-3 customers
* Create Controller Endpoint to list all customers
* Create Controller Endpoint to get customer by id

### Pergunta

* **If you're using Project Lombok, how do you override a getter implementation?**
    * **Minha Resposta:** If you create a getter method without using Lombok, when running the application the method
      will not be generated again by Lombok.
    * **Resposta do Instrutor:** Simply implement the desired getter method. Lombok will not generate the method if one
      is provided.

## HTTP POST with Spring MVC

_Handle HTTP Post for Create new Customer_

### Instruções

* Assignment - Handle HTTP Post for Create new Customer
* Create Controller method to handle post
* Update Request Mapping
* Save to in-memory hash map
* Return 201 status with location of created customer object

### Pergunta

* **What does the HTTP status 201 mean?**
    * **Minha Resposta:** HTTP Status 201 means creating a resource.
    * **Resposta do Instrutor:** HTTP 201 means created. The server response to indicate the resource was created
      successfully.

## HTTP PUT with Spring MVC

### Instruções

### Pergunta

* **Xxxxxxxxxxxxxxxxxx**
    * **Minha Resposta:**
    * **Resposta do Instrutor:**

## HTTP DELETE with Spring MVC

### Instruções

### Pergunta

* **Xxxxxxxxxxxxxxxxxx**
    * **Minha Resposta:**
    * **Resposta do Instrutor:**

## HTTP PATCH with Spring MVC

### Instruções

### Pergunta

* **Xxxxxxxxxxxxxxxxxx**
    * **Minha Resposta:**
    * **Resposta do Instrutor:**