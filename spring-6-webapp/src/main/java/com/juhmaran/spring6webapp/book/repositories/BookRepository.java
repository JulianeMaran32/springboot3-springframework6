package com.juhmaran.spring6webapp.book.repositories;

import com.juhmaran.spring6webapp.book.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Juliane Maran
 *
 * @since 29/05/2025
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
