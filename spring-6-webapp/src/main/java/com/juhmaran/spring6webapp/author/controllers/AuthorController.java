package com.juhmaran.spring6webapp.author.controllers;

import com.juhmaran.spring6webapp.author.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Juliane Maran
 *
 * @since 31/05/2025
 */
@Controller
public class AuthorController {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @RequestMapping("/authors")
  public String getAuthors(Model model) {
    model.addAttribute("authors", authorService.findAll());
    return "authors";
  }

}
