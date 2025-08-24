# Hands On Assignment

## 1. Add Publisher Entity

### Instruções

* Create new Entity called Publisher
    * POJO with properties for `id`, and `publisherName`, `address`, `city`, `state`, `zip`.
    * Annotate with necessary JPA annotations.
    * Add `toString`, `equals`, and `hashCode`.
* Create Spring Data JPA repository
* Add to Bootstrap class and create new publisher
    * Verify database count using `System.out.println`

### Pergunta

* **Is the `@Entity` annotation required?**
    * **Minha resposta:** **Yes, the `@Entity` annotation is required** for a class if you want the JPA provider (like
      Hibernate) to treat instances of that class as persistent entities mapped to a database table.
    * **Resposta do Instrutor:** Yes, the `@Entity` annotation is required for JPA to detect the class as an entity.

---

## 2. Display List of Authors

### Instruções

* Use same methods used to display a list of books to display a list of Authors.
* Create Author Service and Implementation for "findAll"
* Create Author Controller for path "/authors"
* Add to model response list of authors
* Create Thymeleaf template to display list of Authors
* Test is browser

### Pergunta

* **On the service implementation, why use the `@Override` annotation?
    * **Minha Resposta:** The `@Override` annotation is used to ensure, at compile time, that a method truly overrides a
      superclass method or implements an interface method. This prevents subtle errors (like misspellings in method
      name/signature) that would lead to creating a new method instead of overriding the intended one, and also improves
      code readability. It's crucial when implementing interfaces in services to guarantee adherence to the contract.
    * **Resposta do Instrutor:** `@Override` is considered a best practice to help prevent you from accidentally
      implementing a method not defined by the interface.
