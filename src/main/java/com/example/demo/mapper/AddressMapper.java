package com.example.demo.mapper;

import com.example.demo.dto.response.AddressResponseDto;
import com.example.demo.persistence.entity.Address;
import com.example.demo.dto.request.AddressRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressResponseDto toDto(Address address);

    List<AddressResponseDto> toDto(List<Address> address);

    Address toEntity(AddressRequestDto dto);
}