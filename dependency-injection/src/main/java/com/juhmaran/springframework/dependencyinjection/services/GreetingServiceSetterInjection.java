package com.juhmaran.springframework.dependencyinjection.services;

import org.springframework.stereotype.Service;

@Service("setterGreetingBean")
public class GreetingServiceSetterInjection implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hey I'm Setting a Greeting!";
  }

}
