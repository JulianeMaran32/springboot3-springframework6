package com.juhmaran.spring6restmvc.beer.controller;

import com.juhmaran.spring6restmvc.beer.services.BeerService;
import com.juhmaran.spring6restmvc.beer.model.Beer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/{beerId}")
  public Beer getBeerById(@PathVariable(name = "beerId") UUID beerId) {
    log.debug("Get Beer by Id - in controller.");
    return beerService.getBeerById(beerId);
  }

  @GetMapping
  public List<Beer> listBeer() {
    return beerService.listBeers();
  }

}