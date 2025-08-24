package com.juhmaran.springframework.dependencyinjection.i18n.service;

import com.juhmaran.springframework.dependencyinjection.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// @Primary
@Profile("EN")
@Service("i18nService")
public class EnglishGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello World - EN";
  }

}
