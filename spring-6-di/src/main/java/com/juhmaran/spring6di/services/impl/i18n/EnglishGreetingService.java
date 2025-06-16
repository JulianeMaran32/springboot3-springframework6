package com.juhmaran.spring6di.services.impl.i18n;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"EN", "default"}) // Adicionamos "default" aqui
@Service("i18nService")
public class EnglishGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello World - EN";
  }

}
