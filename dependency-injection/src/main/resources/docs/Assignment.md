# Assignment

## 1. Create Spring DI Example Project

### Instruções

_Create New Spring Project_

* Use Spring Initializr to Create New Spring Boot Project
* Use Java 17, Spring Boot 3.x, Maven
* Simple Project, No Dependencies Required
* Download Project to Your Working Directory

### Pergunta

* **Can you use Java 11 with Spring Framework 6?**
    * **Minha Resposta:** No, you can't use Java 11 with Spring Framework 6. Spring Framework 6.0 and newer versions
      require a minimum of Java 17.
    * **Resposta do Instrutor:** No, Java 17 or higher is required for Spring Framework 6.

---

## 2. Dependency Injection

_Purpose to simulate using profiles in multiple operating environments -dev, qa, uat, prod_

### Instruções

* Purpose to simulate using profiles in multiple operating environments -dev, qa, uat, prod
    * Development, Quality Assurance, User Acceptance Testing, Production
* Create faux Controller to return a string of datasource
* Create Service to get datasource string
* Create implementations to return dev, qa, uat, or prod
* Setup profiles for each
* Configure so dev environment is the default

### Pergunta

* **If you do not specify a profile to be active, is there a profile active?**
    * **Minha Resposta:** Yes, if no profile is specified, Spring Boot automatically activates the "default" profile.
    * **Resposta do Instrutor:** If there is no other profiles active, the profile 'default' will be treated as active.