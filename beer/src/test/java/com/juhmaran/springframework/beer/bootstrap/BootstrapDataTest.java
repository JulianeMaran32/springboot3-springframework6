package com.juhmaran.springframework.beer.bootstrap;

import com.juhmaran.springframework.beer.repositories.BeerRepository;
import com.juhmaran.springframework.beer.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BootstrapDataTest {

  @Autowired
  BeerRepository beerRepository;

  @Autowired
  CustomerRepository customerRepository;

  BootstrapData bootstrapData;

  @BeforeEach
  void setUp() {
    bootstrapData = new BootstrapData(beerRepository, customerRepository);
  }

  @Test
  void run() throws Exception {
    bootstrapData.run();
    bootstrapData.run();

    assertThat(beerRepository.count()).isEqualTo(3);
    assertThat(customerRepository.count()).isEqualTo(3);

    assertEquals(3, beerRepository.count());
    assertEquals(3, customerRepository.count());

  }
}