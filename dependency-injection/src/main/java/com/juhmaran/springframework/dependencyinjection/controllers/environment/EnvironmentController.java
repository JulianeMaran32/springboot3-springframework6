package com.juhmaran.springframework.dependencyinjection.controllers.environment;

import com.juhmaran.springframework.dependencyinjection.services.environment.EnvironmentService;
import org.springframework.stereotype.Controller;

@Controller
public class EnvironmentController {

  private final EnvironmentService environmentService;

  public EnvironmentController(EnvironmentService environmentService) {
    this.environmentService = environmentService;
  }

  public String getEnvironment() {
    return "You are in " + environmentService.getEnv() + " Environment";
  }

}
