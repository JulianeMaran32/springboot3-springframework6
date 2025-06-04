package com.juhmaran.spring6di.controllers;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Juliane Maran
 *
 * @since 02/06/2025
 */
@Controller
public class PropertyInjectedController {

  @Autowired
  GreetingService greetingService;

  public String sayHello() {
    return greetingService.sayGreeting();
  }

}

