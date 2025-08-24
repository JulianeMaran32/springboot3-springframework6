package com.juhmaran.springframework.beer.services;

import com.juhmaran.springframework.beer.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

  Customer getCustomerById(UUID uuid);

  List<Customer> getAllCustomers();

}
