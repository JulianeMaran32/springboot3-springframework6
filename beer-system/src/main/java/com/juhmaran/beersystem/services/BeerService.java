package com.juhmaran.beersystem.services;

import com.juhmaran.beersystem.dto.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Juliane Maran
 */
public interface BeerService {

  List<BeerDTO> listBeers();

  Optional<BeerDTO> getBeerById(UUID id);

  BeerDTO saveNewBeer(BeerDTO beer);

  Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

  Boolean deleteById(UUID beerId);

  Optional<BeerDTO> patchBeerById(UUID beerId, BeerDTO beer);

}