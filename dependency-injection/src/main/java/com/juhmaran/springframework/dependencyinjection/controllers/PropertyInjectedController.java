package com.juhmaran.springframework.dependencyinjection.controllers;

import com.juhmaran.springframework.dependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

  @Autowired
  GreetingService greetingService;

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}
