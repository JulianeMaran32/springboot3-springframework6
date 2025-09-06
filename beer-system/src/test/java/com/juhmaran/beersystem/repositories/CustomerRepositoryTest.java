package com.juhmaran.beersystem.repositories;

import com.juhmaran.beersystem.entities.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

  @Autowired
  CustomerRepository customerRepository;

  @Test
  @DisplayName("Test saving a customer")
  void testSaveCustomer() {
    Customer savedCustomer = customerRepository.save(Customer.builder()
      .name("John Doe")
      .build());
    assertThat(savedCustomer).isNotNull();
    assertThat(savedCustomer.getId()).isNotNull();
  }

}