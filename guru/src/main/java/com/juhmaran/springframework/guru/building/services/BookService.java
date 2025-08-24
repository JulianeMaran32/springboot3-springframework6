package com.juhmaran.springframework.guru.building.services;

import com.juhmaran.springframework.guru.building.domain.Book;

public interface BookService {

  Iterable<Book> findAll();

}
