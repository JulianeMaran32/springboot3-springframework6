package com.juhmaran.spring6restmvc.controller;

import com.juhmaran.spring6restmvc.model.Beer;
import com.juhmaran.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by Juliane Maran
 *
 * @since 26/06/2025
 */
@Slf4j
@RestController
@AllArgsConstructor
public class BeerController {

  private final BeerService beerService;

  public Beer getBeerById(UUID id) {
    log.debug("Get Beer by Id - in controller.");
    return beerService.getBeerById(id);
  }

}
