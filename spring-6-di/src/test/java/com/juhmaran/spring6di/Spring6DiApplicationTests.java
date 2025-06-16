package com.juhmaran.spring6di;

import com.juhmaran.spring6di.controllers.MyController;
import org.junit.jupiter.api.DisplayName;
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

  @Test
  @DisplayName("Test Autowired of Controller")
  void testAutowireOfController() {
    // Usa o myController que foi injetado diretamente
    System.out.println(myController.sayHello());
  }

  @Test
  @DisplayName("Test Get Controller from Ctx")
  void testGetControllerFromCtx() {
    // Pede o bean MyController ao Contexto da Aplicação que foi injetado
    MyController myController = applicationContext.getBean(MyController.class);
    System.out.println(myController.sayHello());
  }

  @Test
  @DisplayName("Context Loads")
  void contextLoads() {
    // Este teste verifica se o contexto Spring carrega corretamente
  }
}



