package com.juhmaran.spring6di.controllers;

import com.juhmaran.spring6di.services.environment.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EnvironmentController {

  private final EnvironmentService environmentService;

  @Autowired
  public EnvironmentController(EnvironmentService environmentService) {
    this.environmentService = environmentService;
  }

  public String getEnvironment() {
    return "You are in " + environmentService.getEnv() + " Environment.";
  }

}
