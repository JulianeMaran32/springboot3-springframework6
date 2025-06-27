package com.juhmaran.spring6restmvc.services;

import com.juhmaran.spring6restmvc.model.Beer;

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

}
