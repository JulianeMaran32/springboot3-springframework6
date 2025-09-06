package com.juhmaran.beersystem.controller;

import com.juhmaran.beersystem.dto.CustomerDTO;
import com.juhmaran.beersystem.exceptions.NotFoundException;
import com.juhmaran.beersystem.services.CustomerService;
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
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping("/{customerId}")
  public CustomerDTO getCustomerById(@PathVariable("customerId") UUID id) {
    return customerService.getCustomerById(id).orElseThrow(NotFoundException::new);
  }

  @GetMapping
  public List<CustomerDTO> listAllCustomers() {
    return customerService.getAllCustomers();
  }

  @PostMapping
  public ResponseEntity handlePost(@RequestBody CustomerDTO customer) {
    CustomerDTO savedCustomer = customerService.saveNewCustomer(customer);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", "/api/v1/customer/" + savedCustomer.getId().toString());
    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{customerId}")
  public ResponseEntity updateCustomerByID(@PathVariable("customerId") UUID customerId,
                                           @RequestBody CustomerDTO customer) {
    if (customerService.updateCustomerById(customerId, customer).isEmpty()) {
      throw new NotFoundException();
    }
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{customerId}")
  public ResponseEntity deleteCustomerById(@PathVariable("customerId") UUID customerId) {
    if (!customerService.deleteCustomerById(customerId)) {
      throw new NotFoundException();
    }
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @PatchMapping("{customerId}")
  public ResponseEntity patchCustomerById(@PathVariable("customerId") UUID customerId,
                                          @RequestBody CustomerDTO customer) {
    customerService.patchCustomerById(customerId, customer);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

}
