package com.juhmaran.spring6restmvc.beer.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Juliane Maran
 *
 * @since 26/06/2025
 */
@Data
@Builder // add Builder
public class Beer {

  private UUID id;
  private Integer version;
  private String beerName;
  private BeerStyle beerStyle;
  private String upc;
  private Integer quantityOnHand;
  private BigDecimal price;
  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
