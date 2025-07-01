# MockBean vs MockitoBean no Spring Boot

Vamos esclarecer a questão sobre o uso de `@MockBean` e `@MockitoBean` no contexto do Spring Boot, especialmente em
relação ao seu teste de unidade para o `BeerController`.

## Contexto

Você mencionou que estava usando `@MockitoBean` em seu teste, e que havia lido que `@MockBean` estava obsoleto (
deprecated) e que deveria ser substituído por `@MockitoBean`. Isso é uma confusão comum, especialmente com as mudanças
recentes no Spring Framework e Spring Boot.

## Esclarecimento

### `@MockBean` vs. `@MockitoBean`

Primeiro, é importante esclarecer que **`@MockBean` não está obsoleto**. A confusão pode surgir porque o Spring
Framework introduziu uma nova anotação chamada `@MockitoBean` no Spring Framework 6.1, que é usado pelo Spring Boot 3.2
e superiores. No entanto, **`@MockBean` continua sendo a anotação padrão e mais comum** para criar mocks no Spring Boot.

### O que são `@MockBean` e `@MockitoBean`?

`@MockBean` e `@MockitoBean` são ambos usados para criar mocks de beans no contexto do Spring, mas eles têm diferenças 

Vamos entender a diferença, pois é muito importante.

---

### A Diferença: `@MockBean` vs. `@MockitoBean`

#### 1. `@MockBean`

* **Pacote:** `org.springframework.boot.test.mock.mockito.MockBean`
* **Origem:** Spring Boot
* **Como funciona:** É a forma tradicional e mais conhecida. Ele procura no `ApplicationContext` por um bean do tipo
  especificado (ex: `BeerService.class`) e o **substitui** por um mock do Mockito. Se não encontrar nenhum, ele adiciona
  o mock ao contexto.
* **Uso:** É a ferramenta "padrão" para a maioria dos casos de teste com `@SpringBootTest` e `@WebMvcTest`. É simples e
  direto.

```java
// Exemplo com @MockBean
@WebMvcTest(BeerController.class)
class BeerControllerTest {
  @MockBean // Do Spring Boot
  private BeerService beerService;
  // ...
}
```

#### 2. `@MockitoBean`

* **Pacote:** `org.springframework.test.context.bean.override.mockito.MockitoBean`
* **Origem:** Spring Framework (introduzido no 6.1)
* **Como funciona:** Faz parte de um novo e mais poderoso mecanismo chamado **Bean Overriding**. Ele permite substituir
  a definição de um bean específico pelo nome, em vez de apenas pelo tipo. Isso oferece um controle muito mais granular.
* **Uso:** É ideal para cenários mais complexos. Por exemplo, se você tivesse duas implementações de `BeerService` com
  qualificadores (`@Qualifier`), com `@MockitoBean` você poderia escolher exatamente qual delas mockar pelo nome do
  bean.

```java
// Exemplo com @MockitoBean
@WebMvcTest(BeerController.class)
class BeerControllerTest {
  // A anotação @MockitoBean por padrão procura um bean com o mesmo nome do campo
  // (neste caso, "beerService") para substituir.
  @MockitoBean
  private BeerService beerService;
  // ...
}
```

### Qual usar e por quê?

* **Para o seu caso de uso, ambos funcionam perfeitamente.** No contexto do seu `BeerControllerTest`, há apenas uma
  implementação de `BeerService`, então tanto `@MockBean` quanto `@MockitoBean` atingirão o mesmo resultado final:
  substituir o bean `BeerService` por um mock.

* **`@MockBean` é mais idiomático e comum.** A maioria dos desenvolvedores Spring e tutoriais usam `@MockBean`. Se você
  não precisa do controle granular extra, usá-lo mantém seu código mais alinhado com as convenções existentes.

* **`@MockitoBean` é a abordagem mais moderna e flexível.** Se você já está usando Spring Boot 3.2+ e prefere usar as
  APIs mais recentes do Spring Framework, ou se prevê que seus testes podem se tornar mais complexos no futuro, usar
  `@MockitoBean` é uma excelente escolha.

### Conclusão e Código Corrigido

Você estava correto ao usar `@MockitoBean` em seu código original. Minha sugestão de refatoração para `@MockBean` foi
baseada no que é mais comum e amplamente conhecido, mas sua abordagem é igualmente válida e, em certo sentido, mais "
moderna".

A principal correção é: **`@MockBean` não está obsoleto**. Ambas as anotações coexistem e servem a propósitos
ligeiramente diferentes, sendo `@MockitoBean` a opção mais granular e nova.

Portanto, a versão refatorada do seu teste é perfeitamente válida com qualquer uma das duas anotações. Vou manter a
versão com `@MockitoBean` para respeitar a sua escolha original e a modernidade da abordagem.

```java
// O código refatorado que forneci anteriormente funciona perfeitamente
// apenas trocando @MockBean por @MockitoBean, como você já tinha.

// ... importações

@WebMvcTest(BeerController.class)
class BeerControllerTest {

  // ... constantes e outros campos

  // Usando a anotação que você mencionou. Perfeitamente correto!
  @MockitoBean
  BeerService beerService;

  // ... resto do código refatorado ...
}
```

Resumindo: **Ótima observação!** Você está usando a API de teste mais recente do Spring. Apenas tenha em mente que a API
antiga (`@MockBean`) ainda é totalmente suportada e não foi preterida. A escolha entre elas é uma questão de preferência
e da complexidade do cenário de teste.