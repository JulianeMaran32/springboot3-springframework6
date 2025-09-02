# Assignment

## Spring MVC REST Services

### HTTP GET with Spring MVC

_Implement `GET` customerDTO operations_

#### Instruções

* Assignment is to implement `GET` customerDTO operations.
* Customer simple POJO of `customerName`, `id`, `version`, `createdDate`, `lastModifiedDate`.
* Use Project Lombok.
* Create Service, use Map to store 2-3 customers.
* Create Controller Endpoint to **list all customers**.
* Create Controller Endpoint to **get customerDTO by id**.

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
* Return 201 status with location of created customerDTO object

#### Pergunta

* What does the HTTP status 201 mean?
    * **Minha Resposta:** `HTTP Status 201` means creating a resource.
    * **Resposta do Instrutor:** `HTTP 201` means `created`. The server response to indicate the resource was created
      successfully.

### HTTP `PUT` with Spring MVC

_Implement HTTP `PUT` endpoint to update existing customer_

#### Instruções

* Implement HTTP `PUT` endpoint to update existing customerDTO

#### Pergunta

* What is special about the `@PutMapping` annotation?
    * **Minha Resposta:** The `@PutMapping` annotation in Spring is used to map `HTTP PUT` requests to specific methods
      in a controller, indicating that this action should be used to update an existing resource.
    * **Resposta do Instrutor:** The `@PutMapping` annotation will limit the method to responding to `HTTP PUT` requests
      only.

### HTTP `DELETE` with Spring MVC

#### Instruções

* Implement HTTP `DELETE` endpoint to delete existing customerDTO

#### Pergunta

* Should you return a content body in a delete operation?
    * **Minha Resposta:** In a `DELETE` operation, it is best not to return a content body, especially if the delete was
      successful. The HTTP status code `204 No Content` is the safest way to indicate that the request was successful
      and that there is no content to return in the response.
    * **Resposta do Instrutor:** No, delete operations should just return a HTTP `204 No Content` status.

### HTTP `PATCH` with Spring MVC

_Implement `PATCH` endpoint for customerDTO._

#### Instruções

* Implement `PATCH` endpoint for customerDTO.
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

* Use Spring MockMVC and Mockito to test GET operations for customerDTO
* Write test to test get customerDTO list
    * verify number of elements in list
* Write test to get customerDTO by id
    * Verify properties in JSON response from Spring Mock MVC

#### Pergunta

* Why use Spring MockMVC?
    * **Minha Resposta:** MockMvc, part of the Spring MVC testing framework, is used to test the web layer of a Spring
      application in isolation, without the need for a running server. This allows for faster and more efficient
      testing, focusing on controller logic and interaction with the web layer, such as JSON serialization and
      validation.
    * **Resposta do Instrutor:** Spring MockMVC allows you to test the controller interactions in a servlet context
      without the application running in a application server.

### Test Create Customer

_Use Spring MockMVC and Mockito to test Create endpoint for Customer_

#### Instruções

* Use Spring MockMVC and Mockito to test Create endpoint for Customer
* Write test to test creation of customerDTO
* Update Test to re-create CustomerServiceImpl before each test
* Verify HTTP 201 is returned
* Verify Location Header is returned

#### Pergunta

* What HTTP method is used to create a new resource?
    * **Minha Resposta:** The HTTP method used to create a new resource is `POST`.
    * **Resposta do Instrutor:** HTTP `POST` is used to create a new resource.

### Test Update Customer

_Use Spring MockMVC and Mockito to test Update endpoint for Customer_

#### Instruções

* Use Spring MockMVC and Mockito to test Update endpoint for Customer
* Write test to test Update of customerDTO
* Verify HTTP 204 is returned
* Verify Mockito Mock is called

#### Pergunta

* What HTTP Method is used to update an existing resource?
    * **Minha Resposta:** The HTTP PUT method is used to update an existing resource.
    * **Resposta do Instrutor:** HTTP PUT is used to update existing resources.

### Test Delete Customer

_Use Spring MockMVC and Mockito to test Delete endpoint for Customer_

#### Instruções

* Use Spring MockMVC and Mockito to test Delete endpoint for Customer
* Write test for Delete of Customer
* Verify HTTP 204 is returned
* Verify Mockito Mock delete method is called
* Verify the proper UUID is sent to the delete method using an Argument Captor

#### Pergunta

* Could you implement a delete operation by passing the Id to delete in the request body?
    * **Minha Resposta:** **No, it's not recommended**. The `DELETE` method should typically include the ID in the URL
      path (e.g., `/api/items/{id}`). While technically possible to send an ID in the request body, it violates RESTful
      principles, can cause compatibility issues, and is generally considered bad practice for `DELETE` operations.
    * **Resposta do Instrutor:** In theory you could do this, BUT this is not considered a best practice. Each resource
      should have a unique URL. The unique URL should be used with the HTTP `DELETE` method to delete a resource.

### Test patch Customer

_Use Spring MockMVC and Mockito to test Patch endpoint for Customer_

#### Instruções

* Use Spring MockMVC and Mockito to test Patch endpoint for Customer
* Write test for Patch of Customer
* Verify HTTP 204 is returned
* Verify Mockito Mock patch method is called
* Verify the proper UUID is sent to the patch method using an Argument Captor
* Verify the proper value is sent for the Customer property update

#### Pergunta

* How do you verify the proper value is sent to the service method?
    * **Minha Resposta:** I use Mockito's `ArgumentCaptor`. It captures the actual argument passed to a mock, so I can
      then run assertions on it to verify its value.
    * **Resposta do Instrutor:** You can verify this by using a Mockito Mock with an argument captor.

---

### Tarefa 15: Atribuição - Popular Dados de Teste

#### Instruções

* Popule o banco de dados com dados de teste.
* Desafio: Use o mesmo método mostrado anteriormente no curso.
* É aceitável emular a inicialização do mapa – NÃO DEFINA ID e Versão.
* Inicialize dados para as entidades Beer e Customer.
* Altere os testes de repositório para verificar a inicialização dos dados.

#### Pergunta

* Why should not NOT set the Id and version properties? (Por que não se deve definir as propriedades de ID e versão?)
    * **Minha Resposta (EN):** You should not set the ID and version properties directly because they are automatically
      managed by the persistence provider (like Hibernate with Spring Data JPA). The ID is often generated by the
      database or a specific strategy (like UUIDs), and the version is used for optimistic concurrency control.
    * **Minha Resposta (PT):** Não se deve definir as propriedades de ID e versão diretamente porque elas são
      gerenciadas automaticamente pelo provedor de persistência (como o Hibernate com Spring Data JPA). O ID é
      frequentemente gerado pelo banco de dados ou por uma estratégia específica (como UUIDs), e a versão é usada para
      controle de concorrência otimista.
        * **Resposta do Instrutor:** These properties are managed by Hibernate and should not be set externally. (Essas
          propriedades são gerenciadas pelo Hibernate e não devem ser definidas externamente.)

### Tarefa 16: Atribuição - Implementar Operações GET de Cliente

_Implement operações GET no Serviço JPA de Cliente._

#### Instruções

* Desenvolvimento Orientado a Testes (TDD - Test Driven Development): Escreva testes falhos primeiro, depois implemente
  a funcionalidade.
* Crie um Teste de Integração para o Controlador de Cliente.
* Escreva Testes para Listar e Obter por ID.
    * Teste para lista vazia e ID não encontrado.
* Espere que os testes falhem, pois os métodos JPA não estão implementados.
* Implemente operações GET no Serviço JPA de Cliente.
    * Verifique os testes aprovados.

#### Pergunta

* Why use Java optional? (Por que usar o `Optional` do Java?)
    * **Minha Resposta (EN):** Java's `Optional` is used to **prevent `NullPointerExceptions`** and to make code more
      **readable and robust** by explicitly indicating that a value might be absent. It forces the developer to actively
      handle the possibility of a missing value, rather than relying on implicit null checks.
    * **Minha Resposta (PT):** O `Optional` em Java é usado para **evitar `NullPointerExceptions`** e para tornar o
      código mais **legível e robusto** ao indicar explicitamente que um valor pode estar ausente. Ele força o
      desenvolvedor a lidar com a possibilidade de ausência de um valor, em vez de depender de verificações de nulo
      implícitas.
    * **Resposta do Instrutor:** Using Java `Optional` is generally considered a best practice since it indicates the
      return value may be null and reduces null type checking. Using `Optional` also helps reduce unintentional Null
      pointer errors at runtime. (Usar `Optional` do Java é geralmente considerado uma boa prática, pois indica que o
      valor de retorno pode ser nulo e reduz a verificação de tipo nulo. Usar `Optional` também ajuda a reduzir
      erros de ponteiro nulo não intencionais em tempo de execução.)

### Tarefa 17: Atribuição - Implementar Operações JPA de Cliente (POST, PUT, DELETE, PATCH)

_CComplete os Testes de Integração e Implementações para Salvar Novo, Atualizar por ID, Excluir por ID e Patch de
Cliente._

#### Instruções

* Complete os Testes de Integração e Implementações para Salvar Novo, Atualizar por ID, Excluir por ID e Patch de
  Cliente.
* Use **TDD**
* Além disso, implemente a operação JPA **Patch** para a entidade Beer – **Muito Semelhante** a Atualizar por ID.
* Inclua lógica de "não encontrado" para fornecer HTTP 404 quando não encontrado.
    * Refatore os métodos conforme necessário.
* A revisão da atribuição será em formato de revisão de código, não código ao vivo.

#### Pergunta

* If the requested resource of a delete operation is not found, what HTTP status should be returned? (Se o recurso
  solicitado de uma operação de exclusão não for encontrado, qual status HTTP deve ser retornado?)
    * **Minha Resposta (EN):** A 404 Not Found HTTP status should be returned.
    * **Minha Resposta (PT):** Um status HTTP 404 Not Found deve ser retornado.
    * **Resposta do Instrutor:** A HTTP Status of 404 should be returned to indicate the requested resource was not
      found. (Um Status HTTP 404 deve ser retornado para indicar que o recurso solicitado não foi encontrado.)

---

## Data Validation with Spring