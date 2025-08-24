package com.juhmaran.springframework.dependencyinjection.controllers;

import com.juhmaran.springframework.dependencyinjection.services.GreetingService;
import com.juhmaran.springframework.dependencyinjection.services.GreetingServiceImpl;
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
