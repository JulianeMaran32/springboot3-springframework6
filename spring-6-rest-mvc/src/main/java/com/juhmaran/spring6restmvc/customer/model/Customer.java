package com.juhmaran.spring6restmvc.customer.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Juliane Maran
 *
 * @since 28/06/2025
 */
@Data
@Builder
public class Customer {

  private String name;
  private UUID id;
  private Integer version;
  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
