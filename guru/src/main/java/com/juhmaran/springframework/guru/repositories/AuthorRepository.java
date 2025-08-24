package com.juhmaran.springframework.guru.repositories;

import com.juhmaran.springframework.guru.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
