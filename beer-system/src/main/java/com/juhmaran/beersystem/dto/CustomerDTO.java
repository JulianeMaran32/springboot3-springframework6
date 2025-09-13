package com.juhmaran.beersystem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Juliane Maran
 */
@Builder
@Data
public class CustomerDTO {

  private UUID id;
  private Integer version;
  private String name;
  private String email;
  private LocalDateTime createdDate;
  private LocalDateTime updateDate;

}
