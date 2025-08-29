package com.juhmaran.springframework.beer.mappers;

import com.juhmaran.springframework.beer.dto.CustomerDTO;
import com.juhmaran.springframework.beer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

  Customer customerDtoToCustomer(CustomerDTO customerDto);

  CustomerDTO customerToCustomerDto(Customer customer);

}
