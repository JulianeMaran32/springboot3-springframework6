package com.juhmaran.springframework.guru.repository;

import com.juhmaran.springframework.guru.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
