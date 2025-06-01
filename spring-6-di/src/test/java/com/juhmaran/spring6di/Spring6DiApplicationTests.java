package com.juhmaran.spring6di;

import com.juhmaran.spring6di.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest // Diz ao JUnit para rodar este teste com o Spring Boot, criando um Contexto Spring
class Spring6DiApplicationTests {

  @Autowired // Pede ao Spring para injetar o Contexto da Aplicação
  ApplicationContext applicationContext;

  @Autowired // Pede ao Spring para injetar diretamente o objeto MyController
  MyController myController;

  @Test // Marca um metodo como um teste
  void testAutowireOfController() {
    // Usa o myController que foi injetado diretamente
    System.out.println(myController.sayHello());
  }

  @Test // Marca outro metodo como um teste
  void testGetControllerFromCtx() {
    // Pede o bean MyController ao Contexto da Aplicação que foi injetado
    MyController myController = applicationContext.getBean(MyController.class);
    System.out.println(myController.sayHello());
  }

  @Test // Mais um metodo de teste (este não faz nada específico)
  void contextLoads() {
    // Este teste verifica se o contexto Spring carrega corretamente
  }
}



