package com.juhmaran.springframework.beer.controller;

import com.juhmaran.springframework.beer.exception.NotFoundException;
import com.juhmaran.springframework.beer.dto.BeerDTO;
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
                                                  @RequestBody BeerDTO beerDTO) {
    beerService.patchBeerById(beerId, beerDTO);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{beerId}")
  public ResponseEntity<Void> deleteById(@PathVariable("beerId") UUID beerId) {
    beerService.deleteById(beerId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<Void> updateById(@PathVariable("beerId") UUID beerId,
                                         @RequestBody BeerDTO beerDTO) {
    beerService.updateBeerById(beerId, beerDTO);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping
  public ResponseEntity<Void> handlePost(@RequestBody BeerDTO beerDTO) {
    BeerDTO savedBeerDTO = beerService.saveNewBeer(beerDTO);
    var headers = new HttpHeaders();
    headers.add("Location", "/api/v1/beer/" + savedBeerDTO.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<BeerDTO>> listBeers() {
    return new ResponseEntity<>(beerService.listBeers(), HttpStatus.OK);
  }

  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId) {
    log.debug("Get Beer by Id - in controller");
    return new ResponseEntity<>(beerService.getBeerById(beerId)
      .orElseThrow(NotFoundException::new), HttpStatus.OK);
  }

}
