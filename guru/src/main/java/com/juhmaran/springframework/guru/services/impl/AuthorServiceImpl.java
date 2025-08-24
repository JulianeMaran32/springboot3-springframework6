package com.juhmaran.springframework.guru.services.impl;

import com.juhmaran.springframework.guru.domain.Author;
import com.juhmaran.springframework.guru.repositories.AuthorRepository;
import com.juhmaran.springframework.guru.services.AuthorService;
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
