package com.juhmaran.springframework.dependencyinjection.i18n.controller;

import com.juhmaran.springframework.dependencyinjection.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class Myi18NController {

  private final GreetingService greetingService;

  public Myi18NController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}
