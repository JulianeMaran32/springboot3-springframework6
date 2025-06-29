package com.juhmaran.spring6restmvc.beer.controller;

import com.juhmaran.spring6restmvc.beer.model.Beer;
import com.juhmaran.spring6restmvc.beer.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @DeleteMapping("/{beerId}")
  public ResponseEntity<Void> deleteById(@PathVariable(name = "beerId") UUID beerId) {
    log.debug("Delete Beer by Id - in controller. Id: {}", beerId);
    beerService.deleteBeerById(beerId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<Beer> updateById(@PathVariable(name = "beerId") UUID beerId,
                                         @RequestBody Beer beer) {
    beerService.updateBeerById(beerId, beer);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping
  public ResponseEntity<Beer> saveNewBeer(@RequestBody Beer beer) {
    Beer savedBeer = beerService.saveNewBeer(beer);
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.LOCATION, "/api/v1/beer/" + savedBeer.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @GetMapping("/{beerId}")
  public Beer getBeerById(@PathVariable(name = "beerId") UUID beerId) {
    log.debug("Get Beer by Id - in controller. Id: {}", beerId);
    return beerService.getBeerById(beerId);
  }

  @GetMapping
  public List<Beer> listBeer() {
    log.debug("List Beer - in controller");
    return beerService.listBeers();
  }

}