package com.juhmaran.spring6di.controllers;

import com.juhmaran.spring6di.services.GreetingService;

/**
 * Created by Juliane Maran
 *
 * @since 02/06/2025
 */
public class SetterInjectedController {

  private GreetingService greetingService;

  public void setGreetingService(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}
