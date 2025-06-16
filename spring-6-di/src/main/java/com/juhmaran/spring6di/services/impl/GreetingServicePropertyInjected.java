package com.juhmaran.spring6di.services.impl;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.stereotype.Service;

@Service(value = "propertyGreetingService") // Demos um nome customizado para o bean
public class GreetingServicePropertyInjected implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Friends don't let friends to property injection!";
  }

}