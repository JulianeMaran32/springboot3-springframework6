# Spring MVC REST - Quiz

1. What is the difference between @Controller and @RestController
    - A) There is no difference.
    - B) The `@RestController` is a helper annotation which applies the `@ResponseBody` annotation. The `@ResponseBody`
      annotation instructs Spring to serialize the body into JSON. (correta)
    - C) The `@RestController` annotation is used to reflect the intent of the contoller.

2. What is the default library used by Spring to convert Java objects into JSON?
    - A) Jackson (correta)
    - B) GSON
    - C) json-simple
    - D) Flexjosn
    - E) Spring does not use a library

3. How do you extract a URL Path Parameter from a request?
    - A) Just add the variable to the method. (incorreto)
        - Like: `public String myGetMethod(String pathParam)`.
    - B) Use the annotation `@PathVariable`. (incorreto)
        - Like: `public String myGetMethod(@PathVariable String pathParam)`.
    - C) Map the parameter in the `RequestMapping`. (incorreto)
        - Like: `@RequestMapping(value = "/api/pathParam")`.
        - Like: `public String myGetMethod(String pathParam)`.
    - D) Map the parameter in the `RequestMapping`, and use the `@PathVariable` annotation. (correto)
        - Like: `@RequestMapping(value = "/api/{pathParam}")`.
        - Like: `public String myGetMethod(@PathVariable String pathParam)`.
        - OR
        - Like: `@RequestMapping(value = "/api/{pathParam}")`.
        - Like: `public String myGetMethod(@PathVariable("pathParam") String pathParam)`.

4. Given the url path of `/api/customerDTO` how to you map a `DELETE` request to a specific controller method?
    - A) Use `@RequestMapping(value = "/api/customerDTO", method = RequestMethod.DELETE)` on the desired method. (
      incorreto).
    - B) Can be done by convention, by starting the method name with 'delete'. Spring will use reflection to determine
      the proper method to use. (incorreto)
    - C) Use `@RequestMapping(value = "/api/customerDTO", method = RequestMethod.DELETE)` on the desired method. OR Use
      `@DeleteMapping("/api/customerDTO")`. (correto)

5. What does the `@Slf4j` annotation do?
    - A) Makes the class serializable. (incorreto)
    - B) Creates default constructors for the class. (incorreto)
    - C) Uses Project Lombok to inject a SLF4J logger into the class. (correto)
