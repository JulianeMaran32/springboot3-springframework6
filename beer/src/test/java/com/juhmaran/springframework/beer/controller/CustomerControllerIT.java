package com.juhmaran.springframework.beer.controller;

import com.juhmaran.springframework.beer.dto.CustomerDTO;
import com.juhmaran.springframework.beer.entities.Customer;
import com.juhmaran.springframework.beer.exception.NotFoundException;
import com.juhmaran.springframework.beer.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CustomerControllerIT {

  @Autowired
  CustomerController customerController;

  @Autowired
  CustomerRepository customerRepository;

  @Rollback
  @Transactional
  @Test
  void testListAllEmptyList() {
    customerRepository.deleteAll();
    List<CustomerDTO> dtos = customerController.listAllCustomers();

    assertThat(dtos.size()).isEqualTo(0);
  }

  @Test
  void testListAll() {
    List<CustomerDTO> dtos = customerController.listAllCustomers();

    assertThat(dtos.size()).isEqualTo(3);
  }

  @Test
  void testGetByIdNotFound() {
    assertThrows(NotFoundException.class, () -> {
      customerController.getCustomerById(UUID.randomUUID());
    });
  }

  @Test
  void testGetById() {
    Customer customer = customerRepository.findAll().get(0);
    CustomerDTO customerDTO = customerController.getCustomerById(customer.getId());
    assertThat(customerDTO).isNotNull();
  }

}