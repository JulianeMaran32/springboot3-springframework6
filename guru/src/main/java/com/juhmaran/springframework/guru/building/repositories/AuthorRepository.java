package com.juhmaran.springframework.guru.building.repositories;

import com.juhmaran.springframework.guru.building.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
