package com.juhmaran.spring6webapp.book.controllers;

import com.juhmaran.spring6webapp.book.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Juliane Maran
 *
 * @since 29/05/2025
 */
@Controller
public class BookController {


  private final BookService bookService;

  /**
   * Constructor for BookController that initializes the bookService.
   *
   * @param bookService the service used to manage books
   */
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * Handles requests to the "/books" endpoint and returns a view with a list of books.
   *
   * @param model the model to which the list of books will be added
   * @return the name of the view to be rendered
   */
  @RequestMapping("/books")
  public String getBooks(Model model) {
    model.addAttribute("books", bookService.findAll());
    return "books";
  }

}

