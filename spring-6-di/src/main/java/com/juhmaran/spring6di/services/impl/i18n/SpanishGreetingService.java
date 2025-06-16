package com.juhmaran.spring6di.services.impl.i18n;


import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ES")
@Service("i18nService")
public class SpanishGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hola Mundo - ES";
  }

}
