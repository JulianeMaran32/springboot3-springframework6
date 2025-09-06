package com.juhmaran.beersystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juhmaran.beersystem.dto.BeerDTO;
import com.juhmaran.beersystem.entities.Beer;
import com.juhmaran.beersystem.exceptions.NotFoundException;
import com.juhmaran.beersystem.mappers.BeerMapper;
import com.juhmaran.beersystem.repositories.BeerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BeerControllerIT {

  private static final String BEER_PATH_ID = "/api/v1/beer/{beerId}";

  @Autowired
  BeerController beerController;

  @Autowired
  BeerRepository beerRepository;

  @Autowired
  BeerMapper beerMapper;

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  WebApplicationContext wac;

  MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  @DisplayName("Test list beers")
  void testListBeers() {
    List<BeerDTO> dtos = beerController.listBeers();

    assertThat(dtos.size()).isEqualTo(3);
  }

  @Test
  @DisplayName("Test get beer by id")
  void testGetById() {
    Beer beer = beerRepository.findAll().getFirst();

    BeerDTO dto = beerController.getBeerById(beer.getId());

    assertThat(dto).isNotNull();
  }

  @Test
  @DisplayName("Test get beer by id not found")
  void testBeerIdNotFound() {
    assertThrows(NotFoundException.class, () -> beerController.getBeerById(UUID.randomUUID()));
  }

  @Rollback
  @Transactional
  @Test
  @DisplayName("Test save new beer")
  void saveNewBeerTest() {
    BeerDTO beerDTO = BeerDTO.builder()
      .beerName("New Beer")
      .build();

    ResponseEntity responseEntity = beerController.handlePost(beerDTO);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
    assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

    String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
    UUID savedUUID = UUID.fromString(locationUUID[ 4 ]);

    // 'Optional.get()' without 'isPresent()' check
    Beer beer = beerRepository.findById(savedUUID).get();
    assertThat(beer).isNotNull();
  }

  @Rollback
  @Transactional
  @Test
  @DisplayName("Test update existing beer")
  void updateExistingBeer() {
    Beer beer = beerRepository.findAll().getFirst();
    BeerDTO beerDTO = beerMapper.beerToBeerDto(beer);
    beerDTO.setId(null);
    beerDTO.setVersion(null);
    final String beerName = "UPDATED";
    beerDTO.setBeerName(beerName);

    ResponseEntity responseEntity = beerController.updateById(beer.getId(), beerDTO);
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

    // 'Optional.get()' without 'isPresent()' check
    Beer updatedBeer = beerRepository.findById(beer.getId()).get();
    assertThat(updatedBeer.getBeerName()).isEqualTo(beerName);
  }

  @Test
  @DisplayName("Test update not found")
  void testUpdateNotFound() {
    assertThrows(NotFoundException.class, () -> beerController.updateById(UUID.randomUUID(), BeerDTO.builder().build()));
  }

  @Rollback
  @Transactional
  @Test
  @DisplayName("Test delete by id found")
  void deleteByIdFound() {
    Beer beer = beerRepository.findAll().getFirst();

    ResponseEntity responseEntity = beerController.deleteById(beer.getId());
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

    assertThat(beerRepository.findById(beer.getId()).isEmpty());
  }

  @Test
  @DisplayName("Test delete by id not found")
  void testDeleteByIDNotFound() {
    assertThrows(NotFoundException.class, () -> beerController.deleteById(UUID.randomUUID()));
  }

  @Test
  @DisplayName("Test patch beer")
  void testPatchBeerBadName() throws Exception {
    Beer beer = beerRepository.findAll().getFirst();

    Map<String, Object> beerMap = new HashMap<>();
    beerMap.put("beerName", "New Name 12345678901234567890123456789012345678901234567890123456789012345678901234567890" +
      "12345678901234567890123456789012345678901234567890");

    mockMvc.perform(patch(BEER_PATH_ID, beer.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(beerMap)))
      .andExpect(status().isBadRequest());

  }

  @Rollback
  @Transactional
  @Test
  @DisplayName("Test empty list")
  void testEmptyList() {
    beerRepository.deleteAll();
    List<BeerDTO> dtos = beerController.listBeers();

    assertThat(dtos.size()).isEqualTo(0);
  }

}