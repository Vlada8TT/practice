package com.example.demo.mappers;

import com.example.demo.persistence.entity.Address;
import com.example.demo.dto.AddressDto;

public interface AddressMapper {
    AddressDto toDto (Address address);
    Address toEntity (AddressDto dto);
}
