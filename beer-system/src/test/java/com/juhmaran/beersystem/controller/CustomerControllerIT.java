package com.juhmaran.beersystem.controller;

import com.juhmaran.beersystem.dto.CustomerDTO;
import com.juhmaran.beersystem.entities.Customer;
import com.juhmaran.beersystem.exceptions.NotFoundException;
import com.juhmaran.beersystem.mappers.CustomerMapper;
import com.juhmaran.beersystem.repositories.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

  @Autowired
  CustomerMapper customerMapper;

  @Test
  @DisplayName("Test Get By Id")
  void testGetById() {
    Customer customer = customerRepository.findAll().get(0);
    CustomerDTO customerDTO = customerController.getCustomerById(customer.getId());
    assertThat(customerDTO).isNotNull();
  }

  @Test
  @DisplayName("Test Get By Id Not Found")
  void testGetByIdNotFound() {
    assertThrows(NotFoundException.class, () -> customerController.getCustomerById(UUID.randomUUID()));
  }

  @Test
  @DisplayName("Test List All Customers")
  void testListAll() {
    List<CustomerDTO> dtos = customerController.listAllCustomers();

    assertThat(dtos.size()).isEqualTo(3);
  }

  @Rollback
  @Transactional
  @Test
  @DisplayName("Test List All Customers Empty List")
  void testListAllEmptyList() {
    customerRepository.deleteAll();
    List<CustomerDTO> dtos = customerController.listAllCustomers();

    assertThat(dtos.size()).isEqualTo(0);
  }

  @Rollback
  @Transactional
  @Test
  @DisplayName("Test Save New Beer")
  void saveNewBeerTest() {
    CustomerDTO customerDTO = CustomerDTO.builder()
      .name("TEST")
      .build();

    ResponseEntity responseEntity = customerController.handlePost(customerDTO);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
    assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

    String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
    UUID savedUUID = UUID.fromString(locationUUID[ 4 ]);

    Customer customer = customerRepository.findById(savedUUID).get();
    assertThat(customer).isNotNull();
  }

  @Rollback
  @Transactional
  @Test
  @DisplayName("Test Update Existing Beer")
  void updateExistingBeer() {
    Customer customer = customerRepository.findAll().getFirst();
    CustomerDTO customerDTO = customerMapper.customerToCustomerDto(customer);
    customerDTO.setId(null);
    customerDTO.setVersion(null);
    final String customerName = "UPDATED";
    customerDTO.setName(customerName);

    ResponseEntity responseEntity = customerController.updateCustomerByID(customer.getId(), customerDTO);
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

    Customer updatedCustomer = customerRepository.findById(customer.getId()).get();
    assertThat(updatedCustomer.getName()).isEqualTo(customerName);
  }

  @Test
  @DisplayName("Test Update Not Found")
  void testUpdateNotFound() {
    assertThrows(NotFoundException.class,
      () -> customerController.updateCustomerByID(UUID.randomUUID(), CustomerDTO.builder().build()));
  }

  @Test
  @DisplayName("Test Delete Not Found")
  void testDeleteNotFound() {
    assertThrows(NotFoundException.class, () -> customerController.deleteCustomerById(UUID.randomUUID()));
  }

  @Rollback
  @Transactional
  @Test
  @DisplayName("Test Delete By Id Found")
  void deleteByIdFound() {
    Customer customer = customerRepository.findAll().get(0);

    ResponseEntity responseEntity = customerController.deleteCustomerById(customer.getId());
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

    assertThat(customerRepository.findById(customer.getId()).isEmpty());
  }

}