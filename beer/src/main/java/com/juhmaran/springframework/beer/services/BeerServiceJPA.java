package com.juhmaran.springframework.beer.services;

import com.juhmaran.springframework.beer.dto.BeerDTO;
import com.juhmaran.springframework.beer.mappers.BeerMapper;
import com.juhmaran.springframework.beer.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceJPA implements BeerService {

  private final BeerRepository beerRepository;
  private final BeerMapper beerMapper;

  @Override
  public List<BeerDTO> listBeers() {
    return beerRepository.findAll()
      .stream()
      .map(beerMapper::beerToBeerDto)
      .toList();
  }

  @Override
  public Optional<BeerDTO> getBeerById(UUID id) {
    return Optional.ofNullable(beerMapper.beerToBeerDto(beerRepository.findById(id)
      .orElse(null)));
  }

  @Override
  public BeerDTO saveNewBeer(BeerDTO beer) {
    return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beer)));
  }

  @Override
  public Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer) {
    AtomicReference<Optional<BeerDTO>> atomicReference = new AtomicReference<>();

    beerRepository.findById(beerId).ifPresentOrElse(foundBeer -> {
      foundBeer.setBeerName(beer.getBeerName());
      foundBeer.setBeerStyle(beer.getBeerStyle());
      foundBeer.setUpc(beer.getUpc());
      foundBeer.setPrice(beer.getPrice());
      atomicReference.set(Optional.of(beerMapper
        .beerToBeerDto(beerRepository.save(foundBeer))));
    }, () -> {
      atomicReference.set(Optional.empty());
    });

    return atomicReference.get();
  }

  @Override
  public void deleteById(UUID beerId) {

  }

  @Override
  public void patchBeerById(UUID beerId, BeerDTO beerDTO) {

  }
}
