package com.juhmaran.springframework.beer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juhmaran.springframework.beer.exception.NotFoundException;
import com.juhmaran.springframework.beer.model.CustomerDTO;
import com.juhmaran.springframework.beer.services.CustomerService;
import com.juhmaran.springframework.beer.services.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
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
class CustomerDTOControllerTest {

  public static final String CUSTOMER_PATH = "/api/v1/customer";

  @MockitoBean
  CustomerService customerService;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  CustomerServiceImpl customerServiceImpl;

  @Captor
  ArgumentCaptor<UUID> uuidArgumentCaptor;

  @Captor
  ArgumentCaptor<CustomerDTO> customerArgumentCaptor;

  @BeforeEach
  void setUp() {
    customerServiceImpl = new CustomerServiceImpl();
  }

  @Test
  void testPatchCustomer() throws Exception {
    CustomerDTO customerDTO = customerServiceImpl.getAllCustomers().getFirst();

    Map<String, Object> customerMap = new HashMap<>();
    customerMap.put("name", "New Name");

    mockMvc.perform(patch(CUSTOMER_PATH + "/" + customerDTO.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(customerMap)))
      .andExpect(status().isNoContent());

    verify(customerService).patchCustomerById(uuidArgumentCaptor.capture(),
      customerArgumentCaptor.capture());

    assertThat(uuidArgumentCaptor.getValue()).isEqualTo(customerDTO.getId());
    assertThat(customerArgumentCaptor.getValue().getName())
      .isEqualTo(customerMap.get("name"));
  }

  @Test
  void testDeleteBeer() throws Exception {
    CustomerDTO customerDTO = customerServiceImpl.getAllCustomers().getFirst();

    mockMvc.perform(delete(CUSTOMER_PATH + "/" + customerDTO.getId())
        .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isNoContent());

    verify(customerService).deleteCustomerById(uuidArgumentCaptor.capture());

    assertThat(customerDTO.getId()).isEqualTo(uuidArgumentCaptor.getValue());
  }

  @Test
  void testUpdateCustomer() throws Exception {
    CustomerDTO customerDTO = customerServiceImpl.getAllCustomers().getFirst();

    mockMvc.perform(put(CUSTOMER_PATH + "/" + customerDTO.getId())
        .content(objectMapper.writeValueAsString(customerDTO))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isNoContent());

    verify(customerService).updateCustomerById(any(UUID.class), any(CustomerDTO.class));
  }

  @Test
  void testCreatCustomer() throws Exception {
    CustomerDTO customerDTO = customerServiceImpl.getAllCustomers().getFirst();
    customerDTO.setId(null);
    customerDTO.setVersion(null);

    given(customerService.saveNewCustomer(any(CustomerDTO.class)))
      .willReturn(customerServiceImpl.getAllCustomers().get(1));

    mockMvc.perform(post(CUSTOMER_PATH).contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(customerDTO)))
      .andExpect(status().isCreated())
      .andExpect(header().exists("Location"));
  }

  @Test
  void listAllCustomers() throws Exception {
    given(customerService.getAllCustomers()).willReturn(customerServiceImpl.getAllCustomers());

    mockMvc.perform(get(CUSTOMER_PATH)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.length()", is(3)));
  }

  @Test
  void getCustomerByIdNotFound() throws Exception {

    given(customerService.getCustomerById(any(UUID.class))).willThrow(NotFoundException.class);

    mockMvc.perform(get("/api/v1/customer/{customerId}", UUID.randomUUID()))
      .andExpect(status().isNotFound());
  }

  @Test
  void getCustomerById() throws Exception {
    CustomerDTO customerDTO = customerServiceImpl.getAllCustomers().getFirst();

    given(customerService.getCustomerById(customerDTO.getId())).willReturn(Optional.of(customerDTO));

    mockMvc.perform(get(CUSTOMER_PATH + "/" + customerDTO.getId())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.name", is(customerDTO.getName())));
  }

}