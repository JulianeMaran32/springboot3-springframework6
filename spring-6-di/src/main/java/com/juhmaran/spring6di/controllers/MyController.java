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

  public void beforeInit() {
    System.out.println("## - Before Init - Called by Bean Post Processor");
  }

  public void afterInit() {
    System.out.println("## - After init called by Bean Post Processor");
  }

}