package com.juhmaran.springframework.dependencyinjection.services.i18n;

import com.juhmaran.springframework.dependencyinjection.services.greeting.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Primary
@Profile("ES")
@Service("i18nService")
public class SpanishGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hola Mundo - ES";
  }

}
