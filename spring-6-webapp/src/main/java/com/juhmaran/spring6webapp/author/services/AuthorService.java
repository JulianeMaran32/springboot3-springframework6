package com.juhmaran.spring6webapp.author.services;

import com.juhmaran.spring6webapp.author.domain.Author;

/**
 * Created by Juliane Maran
 *
 * @since 01/06/2025
 */
public interface AuthorService {

  Iterable<Author> findAll();

}
