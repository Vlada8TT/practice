package com.example.demo.services.impl;

import com.example.demo.dto.requests.AddressRequestDto;
import com.example.demo.dto.responses.AddressResponseDto;
import com.example.demo.services.AddressService;
import java.util.List;


public class AddressServiceImpl implements AddressService {
    @Override
    public AddressResponseDto createAddress(AddressRequestDto address) {
        return null;
    }

    @Override
    public AddressResponseDto getAddressById(int id) {
        return null;
    }

    @Override
    public List<AddressResponseDto> getAllAddresses() {
        return null;
    }

    @Override
    public AddressResponseDto updateAddress(int id, AddressRequestDto address) {
        return null;
    }

    @Override
    public void deleteAddress(int id) {

    }
}
