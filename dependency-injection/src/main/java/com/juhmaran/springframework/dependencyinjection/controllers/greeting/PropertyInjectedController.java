package com.juhmaran.springframework.dependencyinjection.controllers.greeting;

import com.juhmaran.springframework.dependencyinjection.services.greeting.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

  @Qualifier("propertyGreetingService")
  @Autowired
  GreetingService greetingService;

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}
