package com.juhmaran.springframework.dependencyinjection.controllers.i18n;

import com.juhmaran.springframework.dependencyinjection.services.greeting.GreetingService;
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
