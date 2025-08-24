package com.juhmaran.springframework.dependencyinjection.controllers.environment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"uat", "EN"})
@SpringBootTest
class EnvironmentControllerTest {

  @Autowired
  EnvironmentController controller;

  @Test
  void getEnvironment() {
    System.out.println(controller.getEnvironment());

  }

}