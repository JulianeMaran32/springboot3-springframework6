package com.juhmaran.spring6restmvc.customer.services.impl;

import com.juhmaran.spring6restmvc.customer.model.Customer;
import com.juhmaran.spring6restmvc.customer.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Juliane Maran
 *
 * @since 28/06/2025
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  private final Map<UUID, Customer> customerMap;

  public CustomerServiceImpl() {
    Customer customer1 = Customer.builder()
      .id(UUID.randomUUID())
      .name("Customer 1")
      .version(1)
      .createdDate(LocalDateTime.now())
      .updateDate(LocalDateTime.now())
      .build();
    Customer customer2 = Customer.builder()
      .id(UUID.randomUUID())
      .name("Customer 2")
      .version(1)
      .createdDate(LocalDateTime.now())
      .updateDate(LocalDateTime.now())
      .build();
    Customer customer3 = Customer.builder()
      .id(UUID.randomUUID())
      .name("Customer 3")
      .version(1)
      .createdDate(LocalDateTime.now())
      .updateDate(LocalDateTime.now())
      .build();

    customerMap = new HashMap<>();
    customerMap.put(customer1.getId(), customer1);
    customerMap.put(customer2.getId(), customer2);
    customerMap.put(customer3.getId(), customer3);

  }

  @Override
  public Customer getCustomerById(UUID uuid) {
    return customerMap.get(uuid);
  }

  @Override
  public List<Customer> getAllCustomers() {
    return new ArrayList<>(customerMap.values());
  }

  @Override
  public Customer saveNewCustomer(Customer customer) {
    log.debug("Save new Customer - in controller: {}", customer.getId());
    Customer savedCustomer = Customer.builder()
      .id(UUID.randomUUID())
      .name(customer.getName())
      .version(1)
      .createdDate(LocalDateTime.now())
      .updateDate(LocalDateTime.now())
      .build();
    customerMap.put(savedCustomer.getId(), savedCustomer);
    return savedCustomer;
  }

  @Override
  public void updateCustomerById(UUID customerId, Customer customer) {
    Customer existingCustomer = customerMap.get(customerId);
    existingCustomer.setName(customer.getName());
  }

  @Override
  public void deleteCustomerById(UUID customerId) {
    customerMap.remove(customerId);
    log.debug("Customer with id {} deleted", customerId);
  }

}
