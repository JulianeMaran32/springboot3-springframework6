package com.juhmaran.springframework.dependencyinjection.controllers;

import com.juhmaran.springframework.dependencyinjection.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

  private final GreetingService greetingService;

  public ConstructorInjectedController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}
