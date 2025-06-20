package com.juhmaran.spring6di.services.impl.i18n;

import com.juhmaran.spring6di.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"EN", "default"})
@Service("i18NService")
public class EnglishGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello World - EN";
  }

}
