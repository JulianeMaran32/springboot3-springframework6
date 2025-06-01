package com.juhmaran.spring6webapp.author.repositories;

import com.juhmaran.spring6webapp.author.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Juliane Maran
 *
 * @since 29/05/2025
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
