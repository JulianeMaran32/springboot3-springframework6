package com.juhmaran.spring6di.services.impl.environment;

import com.juhmaran.spring6di.services.EnvironmentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class EnvironmentServiceProd implements EnvironmentService {

  @Override
  public String getEnv() {
    return "prod";
  }

}


