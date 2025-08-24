package com.juhmaran.springframework.dependencyinjection.controllers;

import com.juhmaran.springframework.dependencyinjection.services.greeting.GreetingService;
import com.juhmaran.springframework.dependencyinjection.services.greeting.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

  private final GreetingService greetingService;

  public MyController() {
    this.greetingService = new GreetingServiceImpl();
  }

  public String sayHello(){
    System.out.println("I'm in the controller");

    return greetingService.sayGreeting();
  }

}
