package com.juhmaran.springframework.beer.controller;

import com.juhmaran.springframework.beer.dto.BeerDTO;
import com.juhmaran.springframework.beer.entities.Beer;
import com.juhmaran.springframework.beer.exception.NotFoundException;
import com.juhmaran.springframework.beer.mappers.BeerMapper;
import com.juhmaran.springframework.beer.repositories.BeerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BeerControllerIT {

  @Autowired
  BeerController beerController;

  @Autowired
  BeerRepository beerRepository;

  @Autowired
  BeerMapper beerMapper;

  @Test
  void updateExistingBeer() {
    Beer beer = beerRepository.findAll().get(0);
    BeerDTO beerDTO = beerMapper.beerToBeerDto(beer);
    beerDTO.setId(null);
    beerDTO.setVersion(null);

    final String beerName = "Updated Name";
    beerDTO.setBeerName(beerName);

    ResponseEntity responseEntity = beerController.updateById(beer.getId(), beerDTO);
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

    Beer updateBeer = beerRepository.findById(beer.getId()).get();
    assertThat(updateBeer.getBeerName()).isEqualTo(beerName);

  }

  @Rollback
  @Transactional
  @Test
  @DisplayName("Test for saving a new beer")
  void saveNewBeerTest() {
    var beerDTO = BeerDTO.builder()
      .beerName("New Beer")
      .build();

    ResponseEntity responseEntity = beerController.handlePost(beerDTO);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
    assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

    String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
    UUID savedUUID = UUID.fromString(locationUUID[ 4 ]);

    Beer beer = beerRepository.findById(savedUUID).get();
    assertThat(beer).isNotNull();
  }

  @Test
  @DisplayName("Test for beer not found exception")
  void testBeerIdNotFound() {
    assertThrows(NotFoundException.class, () -> {
      beerController.getBeerById(UUID.randomUUID());
    });
  }

  @Test
  @DisplayName("Test for getting a beer by ID")
  void testGetById() {
    Beer beer = beerRepository.findAll().get(0);
    BeerDTO dto = beerController.getBeerById(beer.getId());
    assertThat(dto).isNotNull();
  }

  @Test
  @DisplayName("Test for listing all beers")
  void testListBeers() {
    List<BeerDTO> dtos = beerController.listBeers();
    assertThat(dtos.size()).isEqualTo(3);
  }

  @Rollback
  @Transactional
  @Test
  @DisplayName("Test for empty beer list")
  void testEmptyList() {
    beerRepository.deleteAll();
    List<BeerDTO> dtos = beerController.listBeers();
    assertThat(dtos.size()).isEqualTo(0);
  }

}