package com.juhmaran.springframework.beer.controller;

import com.juhmaran.springframework.beer.model.Beer;
import com.juhmaran.springframework.beer.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/beer")
public class BeerController {

  private final BeerService beerService;

  @PostMapping
  public ResponseEntity handlePost(@RequestBody Beer beer) {
    Beer savedBeer = beerService.saveNewBeer(beer);
    var headers = new HttpHeaders();
    headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @GetMapping
  public List<Beer> listBeers() {
    return beerService.listBeers();
  }

  @GetMapping(value = "{beerId}")
  public Beer getBeerById(@PathVariable(name = "beerId") UUID id) {
    log.debug("Get Beer by Id - in controller");
    return beerService.getBeerById(id);
  }

}
