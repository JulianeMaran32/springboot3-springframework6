# Spring 6 - Web App

---

## Configuração do Banco de Dados H2 em Memória

### Explicação das Principais Propriedades

* `spring.datasource.url=jdbc:h2:mem:testdb`: cria um banco de dados **em memória** com o nome `testdb`.
* `DB_CLOSE_DELAY=-1`: mantém o banco ativo mesmo após todas as conexões serem fechadas.
* `DB_CLOSE_ON_EXIT=FALSE`: impede que o banco seja fechado ao encerrar a JVM.
* `spring.datasource.driver-class-name=org.h2.Driver`: define explicitamente o driver H2.
* `spring.h2.console.enabled=true`: habilita o console web do H2 para visualização em navegador.
* `spring.jpa.hibernate.ddl-auto=update`: faz com que o Hibernate atualize o schema automaticamente (útil em
  desenvolvimento).

### Acesso ao Console H2

Com essas configurações, você poderá acessar o H2 Console em: http://localhost:8080/h2-console  
Use o mesmo JDBC URL: `jdbc:h2:mem:testdb`  
`username`: `sa`  
`password`: (deixe em branco)

Se ainda aparecer `Database driver: undefined/unknown`, verifique se a dependência do H2 está incluída no seu
`pom.xml` (para projetos Maven):

```xml

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

---




