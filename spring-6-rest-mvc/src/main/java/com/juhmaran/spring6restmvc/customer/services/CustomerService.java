package com.juhmaran.spring6restmvc.customer.services;

import com.juhmaran.spring6restmvc.customer.model.Customer;

import java.util.List;
import java.util.UUID;

/**
 * Created by Juliane Maran
 *
 * @since 28/06/2025
 */
public interface CustomerService {

  Customer getCustomerById(UUID uuid);

  List<Customer> getAllCustomers();

}
