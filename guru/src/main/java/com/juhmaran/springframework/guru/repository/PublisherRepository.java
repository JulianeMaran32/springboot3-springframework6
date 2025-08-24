package com.juhmaran.springframework.guru.repository;

import com.juhmaran.springframework.guru.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Juliane Maran
 *
 * @since 23/08/2025
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
