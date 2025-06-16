package com.juhmaran.spring6di.controllers;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

  private final GreetingService greetingService;

  // Usamos @Qualifier para dizer ao Spring qual bean queremos EXATAMENTE
  public ConstructorInjectedController(@Qualifier("greetingServiceImpl") GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}