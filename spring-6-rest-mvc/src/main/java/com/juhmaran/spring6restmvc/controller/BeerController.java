package com.juhmaran.spring6restmvc.controller;

import com.juhmaran.spring6restmvc.model.Beer;
import com.juhmaran.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by Juliane Maran
 *
 * @since 26/06/2025
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/beer")
@AllArgsConstructor
public class BeerController {

  private final BeerService beerService;

  public Beer getBeerById(UUID id) {
    log.debug("Get Beer by Id - in controller.");
    return beerService.getBeerById(id);
  }

  @GetMapping
  public List<Beer> listBeer() {
    return beerService.listBeers();
  }

}
