package com.juhmaran.spring6restmvc.controller;

import com.juhmaran.spring6restmvc.beer.controller.BeerController;
import com.juhmaran.spring6restmvc.beer.model.Beer;
import com.juhmaran.spring6restmvc.beer.services.BeerService;
import com.juhmaran.spring6restmvc.beer.services.impl.BeerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockitoBean
  BeerService beerService;

  BeerServiceImpl beerServiceImpl = new BeerServiceImpl();

  @Test
  @DisplayName("Get Beer by ID")
  void getBeerById() throws Exception {

    Beer testBeer = beerServiceImpl.listBeers().getFirst();
    given(beerService.getBeerById(any(UUID.class))).willReturn(testBeer);

    mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

}