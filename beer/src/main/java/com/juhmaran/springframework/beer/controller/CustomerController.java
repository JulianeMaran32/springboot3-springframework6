package com.juhmaran.springframework.beer.controller;

import com.juhmaran.springframework.beer.model.Customer;
import com.juhmaran.springframework.beer.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping
  public List<Customer> listAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping(value = "{customerId}")
  public Customer getCustomerById(@PathVariable(name = "customerId") UUID id) {
    log.debug("Get Beer by Id - in controller");
    return customerService.getCustomerById(id);
  }

}
