package com.juhmaran.spring6di.controllers;

import com.juhmaran.spring6di.services.GreetingService;
import com.juhmaran.spring6di.services.impl.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

  private final GreetingService greetingService;

  public MyController() {
    this.greetingService = new GreetingServiceImpl();
  }

  public String sayHello() {
    System.out.println("I'm in the controller");
    return greetingService.sayGreeting();
  }

}