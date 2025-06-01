package com.juhmaran.spring6di.controllers;

import org.springframework.stereotype.Controller;

/**
 * Created by Juliane Maran
 *
 * @since 01/06/2025
 */
@Controller
public class MyController {

  public String sayHello() {
    System.out.println("I'm in the controller");
    return "Hello Everyone!!!";
  }

}
