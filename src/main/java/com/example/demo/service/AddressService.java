package com.example.demo.service;

import com.example.demo.dto.request.AddressRequestDto;
import com.example.demo.dto.response.AddressResponseDto;

import java.util.List;

public interface AddressService {
    AddressResponseDto addAddress(int userId,AddressRequestDto addressDto);

    AddressResponseDto getAddressById(int id);

    List<AddressResponseDto> getAllAddresses();

    AddressResponseDto updateAddress(int id, AddressRequestDto addressDto);

    void deleteAddress(int id);
}