package com.juhmaran.spring6restmvc.customer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juhmaran.spring6restmvc.customer.model.Customer;
import com.juhmaran.spring6restmvc.customer.services.CustomerService;
import com.juhmaran.spring6restmvc.customer.services.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

  @MockitoBean
  CustomerService customerService;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  CustomerServiceImpl customerServiceImpl;

  @Captor
  ArgumentCaptor<UUID> uuidArgumentCaptor;

  @BeforeEach
  void setUp() {
    customerServiceImpl = new CustomerServiceImpl();
  }

  @Test
  @DisplayName("Delete Customer")
  void testDeleteCustomer() throws Exception {
    Customer customer = customerServiceImpl.getAllCustomers().getFirst();
    mockMvc.perform(delete("/api/v1/customer/" + customer.getId())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isNoContent());
    verify(customerService).deleteCustomerById(uuidArgumentCaptor.capture());
    assertThat(customer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
  }

  @Test
  @DisplayName("Update Customer")
  void testUpdateCustomer() throws Exception {
    Customer customer = customerServiceImpl.getAllCustomers().getFirst();
    mockMvc.perform(put("/api/v1/customer/" + customer.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(customer)))
      .andExpect(status().isNoContent());
    verify(customerService).updateCustomerById(uuidArgumentCaptor.capture(), any(Customer.class));
    assertThat(customer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
  }

  @Test
  @DisplayName("Create New Customer")
  void testCreateNewCustomer() throws Exception {
    Customer customer = customerServiceImpl.getAllCustomers().getFirst();
    customer.setId(null);
    customer.setVersion(null);

    given(customerService.saveNewCustomer(any(Customer.class)))
      .willReturn(customerServiceImpl.getAllCustomers().get(1));

    mockMvc.perform(post("/api/v1/customer").contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(customer)))
      .andExpect(status().isCreated())
      .andExpect(header().exists("Location"));
  }

  @Test
  @DisplayName("Get Customer by ID")
  void getCustomerById() throws Exception {
    Customer testCustomer = customerServiceImpl.getAllCustomers().getFirst();
    given(customerService.getCustomerById(testCustomer.getId())).willReturn(testCustomer);

    mockMvc.perform(get("/api/v1/customer/" + testCustomer.getId())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.id", is(testCustomer.getId().toString())))
      .andExpect(jsonPath("$.name", is(testCustomer.getName())));
  }

  @Test
  @DisplayName("Get All Customers")
  void listCustomers() throws Exception {
    given(customerService.getAllCustomers()).willReturn(customerServiceImpl.getAllCustomers());
    mockMvc.perform(get("/api/v1/customer")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.length()", is(3)));
  }

}