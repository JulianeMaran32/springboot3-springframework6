package com.juhmaran.springframework.guru.building.controllers;

import com.juhmaran.springframework.guru.building.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @RequestMapping("/books")
  public String getBooks(Model model) {
    model.addAttribute("authors", authorService.findAll());
    return "authors";
  }

}
