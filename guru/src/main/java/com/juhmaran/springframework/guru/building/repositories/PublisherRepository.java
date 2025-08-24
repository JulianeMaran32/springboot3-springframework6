package com.juhmaran.springframework.guru.building.repositories;

import com.juhmaran.springframework.guru.building.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Juliane Maran
 *
 * @since 23/08/2025
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
