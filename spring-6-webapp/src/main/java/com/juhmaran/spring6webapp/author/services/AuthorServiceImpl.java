package com.juhmaran.spring6webapp.author.services;

import com.juhmaran.spring6webapp.author.domain.Author;
import com.juhmaran.spring6webapp.author.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Juliane Maran
 *
 * @since 01/06/2025
 */
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
