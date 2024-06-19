package com.example.demo.service.impl;

import com.example.demo.dto.request.AddressRequestDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.dto.response.AddressResponseDto;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.persistence.entity.Address;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    @Transactional
    public AddressResponseDto createAddress(AddressRequestDto addressRequestDto) {

        Address address = addressMapper.toEntity(addressRequestDto);
        addressRepository.save(address);
        return addressMapper.toDto(address);
    }

    @Override
    @Transactional(readOnly = true)
    public AddressResponseDto getAddressById(int id) {

        return addressMapper.toDto(addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("address", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressResponseDto> getAllAddresses() {

        return addressMapper.toDto(addressRepository.findAll());
    }

    @Override
    @Transactional
    public AddressResponseDto updateAddress(int id, AddressRequestDto addressRequestDto) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("address", id));
        updateAddressFields(address, addressRequestDto);
        addressRepository.save(address);
        return addressMapper.toDto(address);
    }

    @Override
    @Transactional
    public void deleteAddress(int id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("address", id));
        addressRepository.delete(address);
    }

    private void updateAddressFields(Address address, AddressRequestDto addressRequestDto){

        address.setCity(addressRequestDto.city());
        address.setStreet(addressRequestDto.street());
        address.setHouseNumber(addressRequestDto.houseNumber());
        address.setApartmentNumber(addressRequestDto.apartmentNumber());
    }
}