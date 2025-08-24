package com.juhmaran.springframework.guru.building.services.impl;

import com.juhmaran.springframework.guru.building.domain.Author;
import com.juhmaran.springframework.guru.building.repositories.AuthorRepository;
import com.juhmaran.springframework.guru.building.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository authorRepository;

  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public Iterable<Author> findAll() {
    return authorRepository.findAll();
  }
}
