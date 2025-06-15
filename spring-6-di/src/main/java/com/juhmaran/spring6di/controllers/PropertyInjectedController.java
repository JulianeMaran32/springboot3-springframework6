package com.juhmaran.spring6di.controllers;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

  // Injeção por Propriedade - Menos recomendado
  @Qualifier("propertyGreetingService")
  @Autowired
  GreetingService greetingService;

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}

