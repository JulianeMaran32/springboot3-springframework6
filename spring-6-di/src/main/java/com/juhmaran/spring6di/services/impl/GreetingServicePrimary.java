package com.juhmaran.spring6di.services.impl;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class GreetingServicePrimary implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello From the Primary Bean!!";
  }

}
