package com.juhmaran.spring6di.services.impl;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello Everyone From Base Service!";
  }

}
