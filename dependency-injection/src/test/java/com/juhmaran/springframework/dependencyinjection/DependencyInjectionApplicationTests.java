package com.juhmaran.springframework.dependencyinjection;

import com.juhmaran.springframework.dependencyinjection.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DependencyInjectionApplicationTests {

  @Autowired
  ApplicationContext applicationContext;

  @Autowired
  MyController myController;

  @Test
  void testAutowireOfController() {
    System.out.println(myController.sayHello());
  }

  @Test
  void testGetControllerFromCtx() {
    MyController myController1 = applicationContext.getBean(MyController.class);
    System.out.println(myController1.sayHello());
  }

  @Test
  void contextLoads() {
  }

}
