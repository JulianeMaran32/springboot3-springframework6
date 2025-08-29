package com.juhmaran.springframework.beer.repositories;

import com.juhmaran.springframework.beer.dto.BeerStyle;
import com.juhmaran.springframework.beer.entities.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BeerRepositoryTest {

  @Autowired
  BeerRepository beerRepository;

  @Test
  void testSaveBeer() {
    Beer savedBeer = beerRepository.save(Beer.builder()
      .beerName("My Beer")
      .beerStyle(BeerStyle.LAGER)
      .upc("123456789012")
      .price(BigDecimal.valueOf(9.99))
      .build());
    assertThat(savedBeer).isNotNull();
    assertThat(savedBeer.getId()).isNotNull();
  }

}