package com.juhmaran.spring6di.services.environment;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("uat")
@Service
public class EnvironmentServiceUat implements EnvironmentService {

  @Override
  public String getEnv() {
    return "uat";
  }
}
