package com.juhmaran.spring6di.services;

import org.springframework.stereotype.Service;

/**
 * Created by Juliane Maran
 *
 * @since 01/06/2025
 */
@Service
public class GreetingServiceImpl implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello Everyone From Base Service!";
  }

}
