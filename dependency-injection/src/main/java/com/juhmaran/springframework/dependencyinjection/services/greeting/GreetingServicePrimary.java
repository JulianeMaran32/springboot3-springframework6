package com.juhmaran.springframework.dependencyinjection.services.greeting;

import org.springframework.stereotype.Service;

// @Primary
@Service
public class GreetingServicePrimary implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello From the Primary Bean!";
  }

}
