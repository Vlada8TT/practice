package com.example.demo.services;


import com.example.demo.dto.requests.AddressRequestDto;
import com.example.demo.dto.responses.AddressResponseDto;
import com.example.demo.persistence.entity.Address;

import java.util.List;

public interface AddressService {
    AddressResponseDto createAddress(AddressRequestDto addressDto);
    AddressResponseDto getAddressById(int id);
    List<AddressResponseDto> getAllAddresses();
    AddressResponseDto updateAddress(int id, AddressRequestDto addressDto);
    void deleteAddress(int id);
}

