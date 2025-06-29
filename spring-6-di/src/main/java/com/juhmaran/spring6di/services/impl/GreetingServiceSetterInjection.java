package com.juhmaran.spring6di.services.impl;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.stereotype.Service;

@Service("setterGreetingBean")
public class GreetingServiceSetterInjection implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hey I'm Setting a Greeting!!";
  }
  
}