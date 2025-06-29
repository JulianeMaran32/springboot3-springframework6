package com.juhmaran.spring6restmvc.beer.services;

import com.juhmaran.spring6restmvc.beer.model.Beer;

import java.util.List;
import java.util.UUID;

/**
 * Created by Juliane Maran
 *
 * @since 26/06/2025
 */
public interface BeerService {

  Beer getBeerById(UUID id);

  List<Beer> listBeers();

  Beer saveNewBeer(Beer beer);

  void updateBeerById(UUID beerId, Beer beer);

}
