package com.juhmaran.spring6di.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropertyInjectedControllerTest {

  @Autowired
  PropertyInjectedController propertyInjectedController;

  @Test
  @DisplayName("Test Property Injected Controller")
  void sayHello() {
    System.out.println(propertyInjectedController.sayHello());
  }
}