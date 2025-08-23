package com.juhmaran.springframework.guru.repository;

import com.juhmaran.springframework.guru.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
