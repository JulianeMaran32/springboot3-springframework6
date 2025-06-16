package com.juhmaran.spring6di.controllers;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {

  private GreetingService greetingService; // O campo

  @Autowired // @Autowired no metodo setter
  public void setGreetingService(@Qualifier("setterGreetingBean")
                                 GreetingService greetingService) { // @Qualifier no parâmetro
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}