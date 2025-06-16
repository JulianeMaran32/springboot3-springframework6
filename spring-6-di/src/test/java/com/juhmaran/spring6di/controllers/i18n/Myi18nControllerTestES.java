package com.juhmaran.spring6di.controllers.i18n;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// @ActiveProfiles("ES")
@SpringBootTest
class Myi18nControllerTestES {

  @Autowired
  Myi18nController myi18nController;

  @Test
  @DisplayName("Test My i18n ES Controller")
  void sayHello() {
    System.out.println(myi18nController.sayHello());
  }

}