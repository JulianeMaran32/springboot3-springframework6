package com.juhmaran.beersystem.mappers;

import com.juhmaran.beersystem.dto.CustomerDTO;
import com.juhmaran.beersystem.entities.Customer;
import org.mapstruct.Mapper;

/**
 * Created by Juliane Maran
 */
@Mapper
public interface CustomerMapper {

  Customer customerDtoToCustomer(CustomerDTO customerDto);

  CustomerDTO customerToCustomerDto(Customer customer);

}
