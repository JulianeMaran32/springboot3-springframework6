package com.juhmaran.springframework.guru.services.impl;

import com.juhmaran.springframework.guru.domain.Book;
import com.juhmaran.springframework.guru.repositories.BookRepository;
import com.juhmaran.springframework.guru.services.BookService;
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
