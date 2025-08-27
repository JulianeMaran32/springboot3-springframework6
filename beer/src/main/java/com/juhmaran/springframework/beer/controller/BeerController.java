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

  @PatchMapping("/{beerId}")
  public ResponseEntity<Void> updateBeerPatchById(@PathVariable("beerId") UUID beerId,
                                                  @RequestBody Beer beer) {
    beerService.patchBeerById(beerId, beer);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{beerId}")
  public ResponseEntity<Void> deleteById(@PathVariable("beerId") UUID beerId) {
    beerService.deleteById(beerId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<Void> updateById(@PathVariable("beerId") UUID beerId,
                                         @RequestBody Beer beer) {
    beerService.updateBeerById(beerId, beer);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping
  public ResponseEntity<Void> handlePost(@RequestBody Beer beer) {
    Beer savedBeer = beerService.saveNewBeer(beer);
    var headers = new HttpHeaders();
    headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Beer>> listBeers() {
    return new ResponseEntity<>(beerService.listBeers(), HttpStatus.OK);
  }

  @GetMapping("/{beerId}")
  public ResponseEntity<Beer> getBeerById(@PathVariable("beerId") UUID beerId) {
    log.debug("Get Beer by Id - in controller");
    return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
  }

}
