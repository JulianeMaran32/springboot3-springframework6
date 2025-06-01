package com.juhmaran.spring6di.controllers;

import org.springframework.stereotype.Controller;

@Controller // Diz ao Spring que esta classe é um componente (um "bean")
public class MyController {

  public String sayHello() { // Um metodo que retorna um texto
    System.out.println("I'm in the controller"); // Mostra no console quando o metodo é chamado
    return "Hello Everyone!!!"; // Devolve este texto
  }

}



