package com.juhmaran.springframework.beer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juhmaran.springframework.beer.dto.BeerDTO;
import com.juhmaran.springframework.beer.exception.NotFoundException;
import com.juhmaran.springframework.beer.services.BeerService;
import com.juhmaran.springframework.beer.services.BeerServiceImpl;
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

@WebMvcTest(BeerController.class)
class BeerDTOControllerTest {

  public static final String BEER_PATH = "/api/v1/beer";

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
  ArgumentCaptor<BeerDTO> beerArgumentCaptor;

  @BeforeEach
  void setUp() {
    beerServiceImpl = new BeerServiceImpl();
  }

  @Test
  @DisplayName("Test patch beer")
  void testPatchBeer() throws Exception {
    BeerDTO beerDTO = beerServiceImpl.listBeers().getFirst();

    Map<String, Object> beerMap = new HashMap<>();
    beerMap.put("beerName", "New Name");

    mockMvc.perform(patch(BEER_PATH + "/" + beerDTO.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beerMap)))
      .andExpect(status().isNoContent());

    verify(beerService).patchBeerById(uuidArgumentCaptor.capture(), beerArgumentCaptor.capture());

    assertThat(beerDTO.getId()).isEqualTo(uuidArgumentCaptor.getValue());

    assertThat(beerMap).containsEntry("beerName", beerArgumentCaptor.getValue().getBeerName());
  }

  @Test
  @DisplayName("Test delete beer")
  void testDeleteBeer() throws Exception {
    BeerDTO beerDTO = beerServiceImpl.listBeers().getFirst();

    mockMvc.perform(delete(BEER_PATH + "/" + beerDTO.getId())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isNoContent());

    verify(beerService).deleteById(uuidArgumentCaptor.capture());

    assertThat(beerDTO.getId()).isEqualTo(uuidArgumentCaptor.getValue());
  }

  @Test
  @DisplayName("Test update beer")
  void testUpdateBeer() throws Exception {
    BeerDTO beer = beerServiceImpl.listBeers().get(0);

    given(beerService.updateBeerById(any(), any())).willReturn(Optional.of(beer));

    mockMvc.perform(put("/api/v1/beer/{beerId}", beer.getId())
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beer)))
      .andExpect(status().isNoContent());

    verify(beerService).updateBeerById(any(UUID.class), any(BeerDTO.class));
  }

  @Test
  @DisplayName("Test create new beer")
  void testCreateNewBeer() throws Exception {
    BeerDTO beerDTO = beerServiceImpl.listBeers().getFirst();
    beerDTO.setVersion(null);
    beerDTO.setId(null);

    given(beerService.saveNewBeer(any(BeerDTO.class))).willReturn(beerServiceImpl.listBeers().get(1));

    mockMvc.perform(post(BEER_PATH)
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beerDTO)))
      .andExpect(status().isCreated())
      .andExpect(header().exists("Location"));
  }

  @Test
  @DisplayName("Test list beers")
  void testListBeers() throws Exception {
    given(beerService.listBeers()).willReturn(beerServiceImpl.listBeers());

    mockMvc.perform(get(BEER_PATH)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.length()", is(3)));
  }

  @Test
  @DisplayName("Test get beer by id")
  void getBeerById() throws Exception {
    BeerDTO testBeerDTO = beerServiceImpl.listBeers().getFirst();

    given(beerService.getBeerById(testBeerDTO.getId())).willReturn(Optional.of(testBeerDTO));

    mockMvc.perform(get(BEER_PATH + "/" + testBeerDTO.getId())
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.id", is(testBeerDTO.getId().toString())))
      .andExpect(jsonPath("$.beerName", is(testBeerDTO.getBeerName())));
  }

  @Test
  @DisplayName("Test get beer by id not found")
  void getBeerByIdNotFound() throws Exception {

    given(beerService.getBeerById(any(UUID.class))).willThrow(NotFoundException.class);

    mockMvc.perform(get("/api/v1/beer/{beerId}", UUID.randomUUID()))
      .andExpect(status().isNotFound());
  }

}