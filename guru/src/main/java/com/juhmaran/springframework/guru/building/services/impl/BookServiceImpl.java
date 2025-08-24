package com.juhmaran.springframework.guru.building.services.impl;

import com.juhmaran.springframework.guru.building.domain.Book;
import com.juhmaran.springframework.guru.building.repositories.BookRepository;
import com.juhmaran.springframework.guru.building.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Iterable<Book> findAll() {
    return bookRepository.findAll();
  }

}
