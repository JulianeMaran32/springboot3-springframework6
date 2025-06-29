package com.juhmaran.spring6restmvc.customer.controller;

import com.juhmaran.spring6restmvc.customer.model.Customer;
import com.juhmaran.spring6restmvc.customer.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping
  public ResponseEntity<Customer> saveNewCustomer(@RequestBody Customer customer) {
    Customer savedCustomer = customerService.saveNewCustomer(customer);
    log.debug("Save new Customer - in controller: {}", savedCustomer.getId());
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.LOCATION, "/api/v1/customer/" + savedCustomer.getId().toString());
    return new ResponseEntity<>(savedCustomer, headers, HttpStatus.CREATED);
  }

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
