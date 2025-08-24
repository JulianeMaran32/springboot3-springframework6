package com.juhmaran.springframework.beer.services;

import com.juhmaran.springframework.beer.model.Beer;

import java.util.UUID;

public interface BeerService {

  Beer getBeerById(UUID id);

}
