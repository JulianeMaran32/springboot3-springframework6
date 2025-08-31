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
  public void updateBeerById(UUID beerId, BeerDTO beerDTO) {
    beerRepository.findById(beerId).ifPresent(foundBeer -> {
      foundBeer.setBeerName(beerDTO.getBeerName());
      foundBeer.setBeerStyle(beerDTO.getBeerStyle());
      foundBeer.setPrice(beerDTO.getPrice());
      foundBeer.setUpc(beerDTO.getUpc());
      beerRepository.save(foundBeer);
    });
  }

  @Override
  public void deleteById(UUID beerId) {

  }

  @Override
  public void patchBeerById(UUID beerId, BeerDTO beerDTO) {

  }
}
