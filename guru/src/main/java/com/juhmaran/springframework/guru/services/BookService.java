package com.juhmaran.springframework.guru.services;

import com.juhmaran.springframework.guru.domain.Book;

public interface BookService {

  Iterable<Book> findAll();

}
