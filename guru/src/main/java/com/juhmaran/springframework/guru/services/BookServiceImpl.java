package com.juhmaran.springframework.guru.services;

import com.juhmaran.springframework.guru.domain.Book;
import com.juhmaran.springframework.guru.repository.BookRepository;
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
