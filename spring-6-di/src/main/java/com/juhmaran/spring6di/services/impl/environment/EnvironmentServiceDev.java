package com.juhmaran.spring6di.services.impl.environment;

import com.juhmaran.spring6di.services.EnvironmentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Serviço para ambiente dev, marcado com perfil "dev" E "default"
@Profile({"dev", "default"})
@Service
public class EnvironmentServiceDev implements EnvironmentService {

  @Override
  public String getEnv() {
    return "dev";
  }

}