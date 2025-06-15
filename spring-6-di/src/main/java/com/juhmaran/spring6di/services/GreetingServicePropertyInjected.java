package com.juhmaran.spring6di.services;

import org.springframework.stereotype.Service;

@Service(value = "propertyGreetingService")
public class GreetingServicePropertyInjected implements GreetingService {

  @Override
  public String sayGreeting() {
    // Amigos não deixam amigos fazerem injeção de propriedade!
    return "Friends don't let friends to property injection!";
  }

}
