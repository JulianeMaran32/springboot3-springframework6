package com.juhmaran.springframework.guru;

import com.juhmaran.springframework.guru.performing.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GuruApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(GuruApplication.class, args);
    MyController controller = ctx.getBean(MyController.class);
    System.out.println("In Main Mehtod");
    System.out.println(controller.sayHello());

  }

}
