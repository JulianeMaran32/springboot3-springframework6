package com.juhmaran.spring6restmvc.customer.controller;

import com.juhmaran.spring6restmvc.customer.model.Customer;
import com.juhmaran.spring6restmvc.customer.services.CustomerService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class CustomerController {

  public static final String CUSTOMER_PATH_ID = "/{customerId}";

  private final CustomerService customerService;

  @PatchMapping(CUSTOMER_PATH_ID)
  public ResponseEntity<Void> updateCustomerNameById(@PathVariable(name = "customerId") UUID customerId,
                                                     @RequestBody Customer customer) {
    customerService.patchCustomerById(customerId, customer);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping(CUSTOMER_PATH_ID)
  public ResponseEntity<Void> deleteCustomerById(@PathVariable(name = "customerId") UUID customerId) {
    log.debug("Delete Customer by Id - in controller. Id: {}", customerId);
    customerService.deleteCustomerById(customerId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping(CUSTOMER_PATH_ID)
  public ResponseEntity<Void> updateCustomerByID(@PathVariable(name = "customerId") UUID customerId,
                                                 @RequestBody Customer customer) {
    log.debug("Update Customer by Id - in controller.");
    customerService.updateCustomerById(customerId, customer);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping
  public ResponseEntity<Customer> saveNewCustomer(@RequestBody Customer customer) {
    Customer savedCustomer = customerService.saveNewCustomer(customer);
    log.debug("Save new Customer - in controller: {}", savedCustomer.getId());
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.LOCATION, savedCustomer.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @GetMapping(CUSTOMER_PATH_ID)
  public Customer getCustomerById(@PathVariable(name = "customerId") UUID customerId) {
    log.debug("Get Customer by Id - in controller.");
    return customerService.getCustomerById(customerId);
  }

  @GetMapping
  public List<Customer> listCustomers() {
    return customerService.getAllCustomers();
  }

}
