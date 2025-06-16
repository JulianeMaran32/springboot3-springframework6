package com.juhmaran.spring6di.controllers;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {

  private GreetingService greetingService; // O campo

  // @Qualifier("setterGreetingBean") // <-- Não aqui!
  // @Autowired // <-- Não aqui se for usar no setter!
  // private GreetingService greetingService; // Campo anotado NÃO FUNCIONA BEM com setter

  @Qualifier("setterGreetingBean") // <--- Melhor lugar para @Qualifier e @Autowired no SETTER
  @Autowired // <--- Pedimos para o Spring usar este SETTER para injetar
  public void setGreetingService(GreetingService greetingService) {
    this.greetingService = greetingService; // O Spring chamará este metodo
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}




