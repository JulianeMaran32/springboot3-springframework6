package com.juhmaran.spring6restmvc.customer.controller;

import com.juhmaran.spring6restmvc.customer.model.Customer;
import com.juhmaran.spring6restmvc.customer.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by Juliane Maran
 *
 * @since 28/06/2025
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping("/{customerId}")
  public Customer getCustomerById(@PathVariable(name = "customerId") UUID customerId) {
    log.debug("Get Customer by Id - in controller.");
    return customerService.getCustomerById(customerId);
  }

  @GetMapping
  public List<Customer> listCustomers() {
    return customerService.getAllCustomers();
  }

}
