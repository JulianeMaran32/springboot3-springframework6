package com.juhmaran.springframework.guru.building.services;

import com.juhmaran.springframework.guru.building.domain.Author;

public interface AuthorService {

  Iterable<Author> findAll();

}
