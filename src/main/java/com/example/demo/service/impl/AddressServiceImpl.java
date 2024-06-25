package com.example.demo.service.impl;

import com.example.demo.dto.request.AddressRequestDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.dto.response.AddressResponseDto;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.persistence.entity.Address;
import com.example.demo.persistence.entity.User;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.demo.util.ExceptionSourceName.ADDRESS;
import static com.example.demo.util.ExceptionSourceName.USER;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public AddressResponseDto addAddress(int userId, AddressRequestDto addressRequestDto) {
        User user = findUserById(userId);
        Address address = addressMapper.toEntity(addressRequestDto);
        addressRepository.save(address);
        user.setAddress(address);
        userRepository.save(user);
        return addressMapper.toDto(address);
    }

    @Override
    @Transactional(readOnly = true)
    public AddressResponseDto getAddressById(int id) {
        return addressMapper.toDto(findAddressById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressResponseDto> getAllAddresses() {
        return addressMapper.toDto(addressRepository.findAll());
    }

    @Override
    @Transactional
    public AddressResponseDto updateAddress(int id, AddressRequestDto addressRequestDto) {
        Address address = findAddressById(id);
        addressMapper.updateAddressFromDto(addressRequestDto,address);
        addressRepository.save(address);
        return addressMapper.toDto(address);
    }

    @Override
    @Transactional
    public void deleteAddress(int id) {
        Address address = findAddressById(id);
        addressRepository.delete(address);
    }

    private Address findAddressById(int id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ADDRESS, id));
    }

    private User findUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(USER, userId));
    }
}
