package com.juhmaran.beersystem.bootstrap;

import com.juhmaran.beersystem.repositories.BeerRepository;
import com.juhmaran.beersystem.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
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
  @DisplayName("Test run method of BootstrapData")
  void testRun() throws Exception {
    bootstrapData.run(null);

    assertThat(beerRepository.count()).isEqualTo(3);
    assertThat(customerRepository.count()).isEqualTo(3);
  }

}