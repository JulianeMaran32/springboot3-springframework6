package com.juhmaran.springframework.beer.services;

import com.juhmaran.springframework.beer.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

  Optional<CustomerDTO> getCustomerById(UUID uuid);

  List<CustomerDTO> getAllCustomers();

  CustomerDTO saveNewCustomer(CustomerDTO customerDTO);

  void updateCustomerById(UUID customerId, CustomerDTO customerDTO);

  void deleteCustomerById(UUID customerId);

  void patchCustomerById(UUID customerId, CustomerDTO customerDTO);

}
