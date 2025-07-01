package com.juhmaran.spring6restmvc.beer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juhmaran.spring6restmvc.beer.model.Beer;
import com.juhmaran.spring6restmvc.beer.services.BeerService;
import com.juhmaran.spring6restmvc.beer.services.impl.BeerServiceImpl;
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
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockitoBean
  BeerService beerService;

  BeerServiceImpl beerServiceImpl;

  @Captor
  ArgumentCaptor<UUID> uuidArgumentCaptor;

  @Captor
  ArgumentCaptor<Beer> beerArgumentCaptor;

  @BeforeEach
  void setUp() {
    beerServiceImpl = new BeerServiceImpl();
  }

  @Test
  @DisplayName("Patch Beer")
  void testPatchBeer() throws Exception {
    Beer beer = beerServiceImpl.listBeers().getFirst();

    Map<String, Object> beerMap = new HashMap<>();
    beerMap.put("beerName", "New Name");

    mockMvc.perform(patch("/api/v1/beer/" + beer.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beerMap)))
      .andExpect(status().isNoContent());

    verify(beerService).patchBeerById(uuidArgumentCaptor.capture(), beerArgumentCaptor.capture());

    assertThat(beer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
    assertThat(beerMap.get("beerName")).isEqualTo(beerArgumentCaptor.getValue().getBeerName());
  }

  @Test
  @DisplayName("Delete Beer")
  void testDeleteBeer() throws Exception {
    Beer beer = beerServiceImpl.listBeers().getFirst();
    mockMvc.perform(delete("/api/v1/beer/" + beer.getId())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isNoContent());
    verify(beerService).deleteBeerById(uuidArgumentCaptor.capture());
    assertThat(beer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
  }

  @Test
  @DisplayName("Update Beer")
  void testUpdateBeer() throws Exception {
    Beer beer = beerServiceImpl.listBeers().getFirst();
    mockMvc.perform(put("/api/v1/beer/" + beer.getId())
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beer)))
      .andExpect(status().isNoContent());
    verify(beerService).updateBeerById(uuidArgumentCaptor.capture(), any(Beer.class));
    assertThat(beer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
  }

  @Test
  @DisplayName("Create New Beer")
  void testCreateNewBeer() throws Exception {
    Beer beer = beerServiceImpl.listBeers().getFirst();
    beer.setVersion(null);
    beer.setId(null);

    given(beerService.saveNewBeer(any(Beer.class))).willReturn(beerServiceImpl.listBeers().get(1));

    mockMvc.perform(post("/api/v1/beer")
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beer)))
      .andExpect(status().isCreated())
      .andExpect(header().exists("Location"));
  }

  @Test
  @DisplayName("List Beers")
  void testListBeers() throws Exception {
    given(beerService.listBeers()).willReturn(beerServiceImpl.listBeers());
    mockMvc.perform(get("/api/v1/beer")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.length()", is(3)));
  }

  @Test
  @DisplayName("Get Beer by ID")
  void getBeerById() throws Exception {
    Beer testBeer = beerServiceImpl.listBeers().getFirst();
    given(beerService.getBeerById(testBeer.getId())).willReturn(testBeer);
    mockMvc.perform(get("/api/v1/beer/" + testBeer.getId())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.id", is(testBeer.getId().toString())))
      .andExpect(jsonPath("$.beerName", is(testBeer.getBeerName())));
  }

}