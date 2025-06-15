package com.juhmaran.spring6di.controllers.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("EN")
@SpringBootTest
class Myi18nControllerTestEN {

  @Autowired
  Myi18nController myi18nController;

  @Test
  void sayHello() {
    System.out.println(myi18nController.sayHello());
  }

}