package com.example.practice.mappers;

import com.example.practice.dto.AddressDto;
import com.example.practice.persistence.entities.Address;

public interface AddressMapper {
    AddressDto toDto (Address address);
    Address toEntity (AddressDto dto);
}
