package com.juhmaran.beersystem.mappers;

import com.juhmaran.beersystem.dto.BeerDTO;
import com.juhmaran.beersystem.entities.Beer;
import org.mapstruct.Mapper;

/**
 * Created by Juliane Maran
 */
@Mapper
public interface BeerMapper {

  Beer beerDtoToBeer(BeerDTO beerDto);

  BeerDTO beerToBeerDto(Beer beer);

}
