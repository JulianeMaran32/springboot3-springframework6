package com.juhmaran.beersystem.repositories;

import com.juhmaran.beersystem.dto.BeerStyle;
import com.juhmaran.beersystem.entities.Beer;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class BeerRepositoryTest {

  @Autowired
  BeerRepository beerRepository;

  @Test
  @DisplayName("Test saving a beer with a name that is too long")
  void testSaveBeerNameTooLong() {
    assertThrows(ConstraintViolationException.class, () -> {
      Beer savedBeer = beerRepository.save(Beer.builder()
        .beerName("My Beer 0123345678901233456789012334567890123345678901233456789012334567890123345678901233456789")
        .beerStyle(BeerStyle.PALE_ALE)
        .upc("234234234234")
        .price(new BigDecimal("11.99"))
        .build());
      beerRepository.flush();
    });
  }

  @Test
  @DisplayName("Test saving a valid beer")
  void testSaveBeer() {
    Beer savedBeer = beerRepository.save(Beer.builder()
      .beerName("My Beer")
      .beerStyle(BeerStyle.PALE_ALE)
      .upc("234234234234")
      .price(new BigDecimal("11.99"))
      .build());

    // beerRepository.flush();

    assertThat(savedBeer).isNotNull();
    assertThat(savedBeer.getId()).isNotNull();
  }

}