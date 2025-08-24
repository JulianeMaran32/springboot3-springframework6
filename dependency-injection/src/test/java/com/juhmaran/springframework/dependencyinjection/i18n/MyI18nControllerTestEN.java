package com.juhmaran.springframework.dependencyinjection.i18n;

import com.juhmaran.springframework.dependencyinjection.controllers.i18n.Myi18NController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// Comment ou active profile to test use of default profile
// @ActiveProfiles("EN")
@SpringBootTest
class MyI18nControllerTestEN {

  @Autowired
  Myi18NController myi18NController;

  @Test
  void sayHello() {
    System.out.println(myi18NController.sayHello());
  }

}