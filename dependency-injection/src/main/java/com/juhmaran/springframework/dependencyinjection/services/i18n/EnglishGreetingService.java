package com.juhmaran.springframework.dependencyinjection.services.i18n;

import com.juhmaran.springframework.dependencyinjection.services.greeting.GreetingService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Primary
@Profile("EN")
@Service("i18nService")
public class EnglishGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello World - EN";
  }

}
