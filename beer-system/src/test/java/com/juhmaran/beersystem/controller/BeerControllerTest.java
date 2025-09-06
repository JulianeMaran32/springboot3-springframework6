package com.juhmaran.beersystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juhmaran.beersystem.dto.BeerDTO;
import com.juhmaran.beersystem.services.BeerService;
import com.juhmaran.beersystem.services.impl.BeerServiceImpl;
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
import org.springframework.test.web.servlet.MvcResult;

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

@WebMvcTest(BeerController.class)
class BeerControllerTest {

  private static final String BEER_PATH = "/api/v1/beer";
  private static final String BEER_PATH_ID = "/api/v1/beer/{beerId}";

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Captor
  ArgumentCaptor<UUID> uuidArgumentCaptor;

  @Captor
  ArgumentCaptor<BeerDTO> beerArgumentCaptor;

  @MockitoBean
  BeerService beerService;

  BeerServiceImpl beerServiceImpl;

  @BeforeEach
  void setUp() {
    beerServiceImpl = new BeerServiceImpl();
  }

  @Test
  @DisplayName("GET /api/v1/beer/{beerId} - Found")
  void getBeerById() throws Exception {
    BeerDTO testBeer = beerServiceImpl.listBeers().getFirst();

    given(beerService.getBeerById(testBeer.getId())).willReturn(Optional.of(testBeer));

    mockMvc.perform(get(BEER_PATH_ID, testBeer.getId())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.id", is(testBeer.getId().toString())))
      .andExpect(jsonPath("$.beerName", is(testBeer.getBeerName())));
  }

  @Test
  @DisplayName("GET /api/v1/beer/{beerId} - Not Found")
  void getBeerByIdNotFound() throws Exception {

    given(beerService.getBeerById(any(UUID.class))).willReturn(Optional.empty());

    mockMvc.perform(get(BEER_PATH_ID, UUID.randomUUID()))
      .andExpect(status().isNotFound());
  }

  @Test
  @DisplayName("GET /api/v1/beer - List Beers")
  void testListBeers() throws Exception {
    given(beerService.listBeers()).willReturn(beerServiceImpl.listBeers());

    mockMvc.perform(get(BEER_PATH)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.length()", is(3)));
  }

  @Test
  @DisplayName("POST /api/v1/beer - Bad Request")
  void testCreateBeerNullBeerName() throws Exception {

    BeerDTO beerDTO = BeerDTO.builder().build();

    given(beerService.saveNewBeer(any(BeerDTO.class))).willReturn(beerServiceImpl.listBeers().get(1));

    MvcResult mvcResult = mockMvc.perform(post(BEER_PATH)
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beerDTO)))
      .andExpect(status().isBadRequest())
      .andExpect(jsonPath("$.length()", is(6)))
      .andReturn();

    System.out.println(mvcResult.getResponse().getContentAsString());
  }

  @Test
  @DisplayName("POST /api/v1/beer - Created")
  void testCreateNewBeer() throws Exception {
    BeerDTO beer = beerServiceImpl.listBeers().getFirst();
    beer.setVersion(null);
    beer.setId(null);

    given(beerService.saveNewBeer(any(BeerDTO.class))).willReturn(beerServiceImpl.listBeers().get(1));

    mockMvc.perform(post(BEER_PATH)
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beer)))
      .andExpect(status().isCreated())
      .andExpect(header().exists("Location"));
  }

  @Test
  @DisplayName("PUT /api/v1/beer/{beerId} - Bad Request")
  void testUpdateBeerBlankName() throws Exception {
    BeerDTO beer = beerServiceImpl.listBeers().getFirst();
    beer.setBeerName("");
    given(beerService.updateBeerById(any(), any())).willReturn(Optional.of(beer));

    mockMvc.perform(put(BEER_PATH_ID, beer.getId())
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beer)))
      .andExpect(status().isBadRequest())
      .andExpect(jsonPath("$.length()", is(1)));

  }

  @Test
  @DisplayName("PUT /api/v1/beer/{beerId} - No Content")
  void testUpdateBeer() throws Exception {
    BeerDTO beer = beerServiceImpl.listBeers().getFirst();

    given(beerService.updateBeerById(any(), any())).willReturn(Optional.of(beer));

    mockMvc.perform(put(BEER_PATH_ID, beer.getId())
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beer)))
      .andExpect(status().isNoContent());

    verify(beerService).updateBeerById(any(UUID.class), any(BeerDTO.class));
  }

  @Test
  @DisplayName("DELETE /api/v1/beer/{beerId} - No Content")
  void testDeleteBeer() throws Exception {
    BeerDTO beer = beerServiceImpl.listBeers().getFirst();

    given(beerService.deleteById(any())).willReturn(true);

    mockMvc.perform(delete(BEER_PATH_ID, beer.getId())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isNoContent());

    verify(beerService).deleteById(uuidArgumentCaptor.capture());

    assertThat(beer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
  }

  @Test
  @DisplayName("PATCH /api/v1/beer/{beerId} - No Content")
  void testPatchBeer() throws Exception {
    BeerDTO beer = beerServiceImpl.listBeers().getFirst();

    Map<String, Object> beerMap = new HashMap<>();
    beerMap.put("beerName", "New Name");

    mockMvc.perform(patch(BEER_PATH_ID, beer.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beerMap)))
      .andExpect(status().isNoContent());

    verify(beerService).patchBeerById(uuidArgumentCaptor.capture(), beerArgumentCaptor.capture());

    assertThat(beer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
    // Use assertThat(actual).containsEntry(key, value) instead.
    assertThat(beerMap.get("beerName")).isEqualTo(beerArgumentCaptor.getValue().getBeerName());
  }

}