package com.juhmaran.spring6di.controllers;

import com.juhmaran.spring6di.services.GreetingService;

/**
 * Created by Juliane Maran
 *
 * @since 02/06/2025
 */
public class ConstructorInjectedController {

  private final GreetingService greetingService;

  public ConstructorInjectedController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}
