package com.juhmaran.beersystem.repositories;

import com.juhmaran.beersystem.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Juliane Maran
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
