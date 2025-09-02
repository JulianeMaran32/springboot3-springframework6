package com.juhmaran.springframework.beer.controller;

import com.juhmaran.springframework.beer.dto.BeerDTO;
import com.juhmaran.springframework.beer.exception.NotFoundException;
import com.juhmaran.springframework.beer.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
  public ResponseEntity updateBeerPatchById(@PathVariable("beerId") UUID beerId,
                                            @RequestBody BeerDTO beer) {
    beerService.patchBeerById(beerId, beer);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{beerId}")
  public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId) {
    if (!beerService.deleteById(beerId)) {
      throw new NotFoundException();
    }
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity updateById(@PathVariable("beerId") UUID beerId,
                                   @Validated @RequestBody BeerDTO beer) {
    if (beerService.updateBeerById(beerId, beer).isEmpty()) {
      throw new NotFoundException();
    }
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @PostMapping
  public ResponseEntity handlePost(@Validated @RequestBody BeerDTO beer) {
    BeerDTO savedBeer = beerService.saveNewBeer(beer);
    var headers = new HttpHeaders();
    headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @GetMapping
  public List<BeerDTO> listBeers() {
    return beerService.listBeers();
  }

  @GetMapping("/{beerId}")
  public BeerDTO getBeerById(@PathVariable("beerId") UUID beerId) {
    log.debug("Get Beer by Id - in controller");
    return beerService.getBeerById(beerId).orElseThrow(NotFoundException::new);
  }

}
