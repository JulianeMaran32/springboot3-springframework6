package com.juhmaran.springframework.beer.controller;

import com.juhmaran.springframework.beer.model.Beer;
import com.juhmaran.springframework.beer.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@Controller
@AllArgsConstructor
public class BeerController {

  private final BeerService beerService;

  public Beer getBeerById(UUID id) {
    log.debug("Get Beer by Id - in controller");
    return beerService.getBeerById(id);
  }

}
