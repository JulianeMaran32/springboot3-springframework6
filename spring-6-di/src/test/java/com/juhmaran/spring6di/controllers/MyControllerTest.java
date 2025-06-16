package com.juhmaran.spring6di.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyControllerTest {

  @Test
  @DisplayName("Test My Controller")
  void sayHello() {
    MyController myController = new MyController();
    System.out.println(myController.sayHello());
  }

}