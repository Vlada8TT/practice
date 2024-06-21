package com.example.demo.service.impl;

import com.example.demo.dto.request.AddressRequestDto;
import com.example.demo.dto.response.AddressResponseDto;
import com.example.demo.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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