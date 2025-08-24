# Add Publisher Entity

## Instruções

* Create new Entity called Publisher
    * POJO with properties for `id`, and `publisherName`, `address`, `city`, `state`, `zip`.
    * Annotate with necessary JPA annotations.
    * Add `toString`, `equals`, and `hashCode`.
* Create Spring Data JPA repository
* Add to Bootstrap class and create new publisher
    * Verify database count using `System.out.println`

## Pergunta

* **Is the `@Entity` annotation required?**
    * **Minha resposta:** **Yes, the `@Entity` annotation is required** for a class if you want the JPA provider (like
      Hibernate) to treat instances of that class as persistent entities mapped to a database table.
    * **Resposta do Instrutor:** Yes, the `@Entity` annotation is required for JPA to detect the class as an entity.



