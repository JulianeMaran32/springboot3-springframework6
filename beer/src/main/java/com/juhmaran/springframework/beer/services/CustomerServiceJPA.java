package com.juhmaran.springframework.beer.services;

import com.juhmaran.springframework.beer.dto.CustomerDTO;
import com.juhmaran.springframework.beer.mappers.CustomerMapper;
import com.juhmaran.springframework.beer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  @Override
  public Optional<CustomerDTO> getCustomerById(UUID uuid) {
    return Optional.empty();
  }

  @Override
  public List<CustomerDTO> getAllCustomers() {
    return List.of();
  }

  @Override
  public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
    return null;
  }

  @Override
  public void updateCustomerById(UUID customerId, CustomerDTO customerDTO) {

  }

  @Override
  public void deleteCustomerById(UUID customerId) {

  }

  @Override
  public void patchCustomerById(UUID customerId, CustomerDTO customerDTO) {

  }
}