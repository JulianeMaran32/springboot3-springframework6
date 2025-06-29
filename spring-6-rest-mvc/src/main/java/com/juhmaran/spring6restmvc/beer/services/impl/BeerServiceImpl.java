package com.juhmaran.spring6restmvc.beer.services.impl;

import com.juhmaran.spring6restmvc.beer.model.Beer;
import com.juhmaran.spring6restmvc.beer.model.BeerStyle;
import com.juhmaran.spring6restmvc.beer.services.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Juliane Maran
 *
 * @since 26/06/2025
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

  private final Map<UUID, Beer> beerMap;

  public BeerServiceImpl() {
    this.beerMap = new HashMap<>();

    Beer beer1 = Beer.builder()
      .id(UUID.randomUUID())
      .version(1)
      .beerName("Mango Bobs")
      .beerStyle(BeerStyle.ALE)
      .upc("0631234200036")
      .price(new BigDecimal("29.16"))
      .quantityOnHand(4525)
      .createdDate(LocalDateTime.now())
      .updateDate(LocalDateTime.now())
      .build();

    Beer beer2 = Beer.builder()
      .id(UUID.randomUUID())
      .version(1)
      .beerName("Galaxy Cat")
      .beerStyle(BeerStyle.PALE_ALE)
      .upc("9122089364369")
      .price(new BigDecimal("6.60"))
      .quantityOnHand(4170)
      .createdDate(LocalDateTime.now())
      .updateDate(LocalDateTime.now())
      .build();

    Beer beer3 = Beer.builder()
      .id(UUID.randomUUID())
      .version(1)
      .beerName("No Hammers On The Bar")
      .beerStyle(BeerStyle.WHEAT)
      .upc("0083783375213")
      .price(new BigDecimal("95.51"))
      .quantityOnHand(522)
      .createdDate(LocalDateTime.now())
      .updateDate(LocalDateTime.now())
      .build();

    beerMap.put(beer1.getId(), beer1);
    beerMap.put(beer2.getId(), beer2);
    beerMap.put(beer3.getId(), beer3);
  }

  @Override
  public Beer getBeerById(UUID id) {
    return beerMap.get(id);
  }

  @Override
  public List<Beer> listBeers() {
    return new ArrayList<>(beerMap.values());
  }

  @Override
  public Beer saveNewBeer(Beer beer) {
    Beer savedBeer = Beer.builder()
      .id(UUID.randomUUID())
      .createdDate(LocalDateTime.now())
      .updateDate(LocalDateTime.now())
      .version(1)
      .beerName(beer.getBeerName())
      .beerStyle(beer.getBeerStyle())
      .upc(beer.getUpc())
      .price(beer.getPrice())
      .quantityOnHand(beer.getQuantityOnHand())
      .build();
    beerMap.put(savedBeer.getId(), savedBeer);
    return savedBeer;
  }

  @Override
  public void updateBeerById(UUID beerId, Beer beer) {
    Beer existing = beerMap.get(beerId);
    existing.setBeerName(beer.getBeerName());
    existing.setPrice(beer.getPrice());
    existing.setUpc(beer.getUpc());
    existing.setQuantityOnHand(beer.getQuantityOnHand());

    beerMap.put(existing.getId(), existing);
  }

  @Override
  public void deleteBeerById(UUID beerId) {
    beerMap.remove(beerId);
  }

}
