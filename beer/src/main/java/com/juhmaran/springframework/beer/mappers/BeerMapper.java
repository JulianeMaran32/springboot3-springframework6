package com.juhmaran.springframework.beer.mappers;

import com.juhmaran.springframework.beer.dto.BeerDTO;
import com.juhmaran.springframework.beer.entities.Beer;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

  Beer beerDtoToBeer(BeerDTO beerDto);

  BeerDTO beerToBeerDto(Beer beer);

}
