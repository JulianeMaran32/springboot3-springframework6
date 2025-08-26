package com.juhmaran.springframework.beer.controller;

import com.juhmaran.springframework.beer.model.Customer;
import com.juhmaran.springframework.beer.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

  private final CustomerService customerService;

  @PatchMapping("{customerId}")
  public ResponseEntity patchCustomerById(@PathVariable("customerId") UUID customerId,
                                          @RequestBody Customer customer) {
    customerService.patchCustomerById(customerId, customer);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("{customerId}")
  public ResponseEntity deleteCustomerById(@PathVariable("customerId") UUID customerId) {
    customerService.deleteCustomerById(customerId);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @PutMapping("{customerId}")
  public ResponseEntity updateCustomerByID(@PathVariable("customerId") UUID customerId,
                                           @RequestBody Customer customer) {
    customerService.updateCustomerById(customerId, customer);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @PostMapping
  public ResponseEntity handlePost(@RequestBody Customer customer) {
    Customer savedCustomer = customerService.saveNewCustomer(customer);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/customer/" + savedCustomer.getId().toString());
    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @GetMapping
  public List<Customer> listAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("{customerId}")
  public Customer getCustomerById(@PathVariable("customerId") UUID id) {
    return customerService.getCustomerById(id);
  }

}
