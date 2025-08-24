package com.juhmaran.springframework.guru.building.repositories;

import com.juhmaran.springframework.guru.building.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
