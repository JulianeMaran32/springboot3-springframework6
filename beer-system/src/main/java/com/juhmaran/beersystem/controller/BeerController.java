package com.juhmaran.beersystem.controller;

import com.juhmaran.beersystem.dto.BeerDTO;
import com.juhmaran.beersystem.exceptions.NotFoundException;
import com.juhmaran.beersystem.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by Juliane Maran
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

  private final BeerService beerService;

  @GetMapping("/{beerId}")
  public BeerDTO getBeerById(@PathVariable("beerId") UUID beerId) {
    log.debug("Get Beer by Id - in controller");
    return beerService.getBeerById(beerId).orElseThrow(NotFoundException::new);
  }

  @GetMapping
  public List<BeerDTO> listBeers() {
    return beerService.listBeers();
  }

  @PostMapping
  public ResponseEntity handlePost(@Validated @RequestBody BeerDTO beer) {
    BeerDTO savedBeer = beerService.saveNewBeer(beer);
    var headers = new HttpHeaders();
    headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity updateById(@PathVariable("beerId") UUID beerId,
                                   @Validated @RequestBody BeerDTO beer) {
    if (beerService.updateBeerById(beerId, beer).isEmpty()) {
      throw new NotFoundException();
    }
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{beerId}")
  public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId) {
    if (!beerService.deleteById(beerId)) {
      throw new NotFoundException();
    }
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @PatchMapping("/{beerId}")
  public ResponseEntity updateBeerPatchById(@PathVariable("beerId") UUID beerId,
                                            @RequestBody BeerDTO beer) {
    beerService.patchBeerById(beerId, beer);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

}
