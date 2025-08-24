package com.juhmaran.springframework.dependencyinjection;

import com.juhmaran.springframework.dependencyinjection.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);
    MyController controller = ctx.getBean(MyController.class);
    System.out.println("In Main Method");
    System.out.println(controller.sayHello());
  }

}
