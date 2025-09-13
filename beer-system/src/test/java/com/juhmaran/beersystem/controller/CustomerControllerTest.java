package com.juhmaran.beersystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juhmaran.beersystem.dto.CustomerDTO;
import com.juhmaran.beersystem.services.CustomerService;
import com.juhmaran.beersystem.services.impl.CustomerServiceImpl;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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

  public static final String CUSTOMER_PATH = "/api/v1/customer";
  public static final String CUSTOMER_PATH_ID = "/api/v1/customer/{customerId}";

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Captor
  ArgumentCaptor<UUID> uuidArgumentCaptor;

  @Captor
  ArgumentCaptor<CustomerDTO> customerArgumentCaptor;

  @MockitoBean
  CustomerService customerService;

  CustomerServiceImpl customerServiceImpl;

  @BeforeEach
  void setUp() {
    customerServiceImpl = new CustomerServiceImpl();
  }

  @Test
  @DisplayName("GET /api/v1/customer/{customerId} - Found")
  void getCustomerById() throws Exception {
    CustomerDTO customer = customerServiceImpl.getAllCustomers().getFirst();

    given(customerService.getCustomerById(customer.getId())).willReturn(Optional.of(customer));

    mockMvc.perform(get(CUSTOMER_PATH_ID, customer.getId())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.name", is(customer.getName())))
      .andExpect(jsonPath("$.email", is(customer.getEmail())));
  }

  @Test
  @DisplayName("GET /api/v1/customer/{customerId} - Not Found")
  void getCustomerByIdNotFound() throws Exception {

    given(customerService.getCustomerById(any(UUID.class))).willReturn(Optional.empty());

    mockMvc.perform(get(CUSTOMER_PATH_ID, UUID.randomUUID()))
      .andExpect(status().isNotFound());
  }

  @Test
  @DisplayName("GET /api/v1/customer - List All Customers")
  void listAllCustomers() throws Exception {
    given(customerService.getAllCustomers()).willReturn(customerServiceImpl.getAllCustomers());

    mockMvc.perform(get(CUSTOMER_PATH)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.length()", is(3)));
  }

  @Test
  @DisplayName("POST /api/v1/customer - Create New Customer")
  void testCreateCustomer() throws Exception {
    CustomerDTO customer = customerServiceImpl.getAllCustomers().getFirst();
    customer.setId(null);
    customer.setVersion(null);

    given(customerService.saveNewCustomer(any(CustomerDTO.class)))
      .willReturn(customerServiceImpl.getAllCustomers().get(1));

    mockMvc.perform(post(CUSTOMER_PATH).contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(customer)))
      .andExpect(status().isCreated())
      .andExpect(header().exists("Location"));
  }

  @Test
  @DisplayName("PUT /api/v1/customer/{customerId} - Update Customer")
  void testUpdateCustomer() throws Exception {
    CustomerDTO customer = customerServiceImpl.getAllCustomers().getFirst();

    given(customerService.updateCustomerById(any(), any())).willReturn(Optional.of(CustomerDTO.builder()
      .build()));

    mockMvc.perform(put(CUSTOMER_PATH_ID, customer.getId())
        .content(objectMapper.writeValueAsString(customer))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isNoContent());

    verify(customerService).updateCustomerById(uuidArgumentCaptor.capture(), any(CustomerDTO.class));

    assertThat(customer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
  }

  @Test
  @DisplayName("DELETE /api/v1/customer/{customerId} - Delete Customer")
  void testDeleteCustomer() throws Exception {
    CustomerDTO customer = customerServiceImpl.getAllCustomers().getFirst();

    given(customerService.deleteCustomerById(any())).willReturn(true);

    mockMvc.perform(delete(CUSTOMER_PATH_ID, customer.getId())
        .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isNoContent());

    verify(customerService).deleteCustomerById(uuidArgumentCaptor.capture());

    assertThat(customer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
  }

  @Test
  @DisplayName("PATCH /api/v1/customer/{customerId} - Patch Customer")
  void testPatchCustomer() throws Exception {
    CustomerDTO customer = customerServiceImpl.getAllCustomers().getFirst();

    Map<String, Object> customerMap = new HashMap<>();
    customerMap.put("name", "New Name");
    customerMap.put("email", "New Email");

    mockMvc.perform(patch(CUSTOMER_PATH_ID, customer.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(customerMap)))
      .andExpect(status().isNoContent());

    verify(customerService).patchCustomerById(uuidArgumentCaptor.capture(),
      customerArgumentCaptor.capture());

    assertThat(uuidArgumentCaptor.getValue()).isEqualTo(customer.getId());
    assertThat(customerArgumentCaptor.getValue().getName())
      .isEqualTo(customerMap.get("name"));
    assertThat(customerArgumentCaptor.getValue().getEmail())
      .isEqualTo(customerMap.get("email"));
  }


}