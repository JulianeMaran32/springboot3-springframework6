package com.juhmaran.spring6di.controllers.i18n;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class Myi18nController {

  private final GreetingService greetingService;

  @Autowired
  public Myi18nController(@Qualifier("i18nService") GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}
