package com.juhmaran.springframework.guru.services;

import com.juhmaran.springframework.guru.domain.Author;

public interface AuthorService {

  Iterable<Author> findAll();

}
