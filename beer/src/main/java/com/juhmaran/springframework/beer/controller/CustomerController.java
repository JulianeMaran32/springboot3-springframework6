package com.juhmaran.springframework.beer.controller;

import com.juhmaran.springframework.beer.exception.NotFoundException;
import com.juhmaran.springframework.beer.model.CustomerDTO;
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
  public ResponseEntity<Void> patchCustomerById(@PathVariable("customerId") UUID customerId,
                                                @RequestBody CustomerDTO customerDTO) {
    customerService.patchCustomerById(customerId, customerDTO);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{customerId}")
  public ResponseEntity<Void> deleteCustomerById(@PathVariable("customerId") UUID customerId) {
    customerService.deleteCustomerById(customerId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{customerId}")
  public ResponseEntity<Void> updateCustomerByID(@PathVariable("customerId") UUID customerId,
                                                 @RequestBody CustomerDTO customerDTO) {
    customerService.updateCustomerById(customerId, customerDTO);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping
  public ResponseEntity<Void> handlePost(@RequestBody CustomerDTO customerDTO) {
    CustomerDTO savedCustomerDTO = customerService.saveNewCustomer(customerDTO);
    var headers = new HttpHeaders();
    headers.add("Location", "/api/v1/customer/" + savedCustomerDTO.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<CustomerDTO>> listAllCustomers() {
    return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("customerId") UUID id) {
    return new ResponseEntity<>(customerService.getCustomerById(id)
      .orElseThrow(NotFoundException::new), HttpStatus.OK);
  }

}
