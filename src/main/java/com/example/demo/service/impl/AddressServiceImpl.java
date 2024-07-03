package com.example.demo.service.impl;

import com.example.demo.dto.request.AddressRequestDto;
import com.example.demo.dto.response.AddressResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.persistence.entity.Address;
import com.example.demo.persistence.entity.User;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.util.ExceptionSourceName.ADDRESS;
import static com.example.demo.util.ExceptionSourceName.USER;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public AddressResponseDto addAddress(int userId, AddressRequestDto addressRequestDto) {
        log.info("Adding address to user with id {}", userId);
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
        log.info("Retrieving address by id {}", id);
        return addressMapper.toDto(findAddressById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressResponseDto> getAllAddresses() {
        log.info("Retrieving all addresses");
        return addressMapper.toDto(addressRepository.findAll());
    }

    @Override
    @Transactional
    public AddressResponseDto updateAddress(int id, AddressRequestDto addressRequestDto) {
        log.info("Updating address with id {}", id);
        Address address = findAddressById(id);
        addressMapper.updateAddressFromDto(addressRequestDto, address);
        addressRepository.save(address);
        return addressMapper.toDto(address);
    }

    @Override
    @Transactional
    public void deleteAddress(int id) {
        log.info("Deleting address with id {}", id);
        Address address = findAddressById(id);
        addressRepository.delete(address);
    }

    private Address findAddressById(int id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Address with id {} was not found", id);
                    return new EntityNotFoundException(ADDRESS, id);
                });
    }

    private User findUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.error("User with id {} was not found", userId);
                    return new EntityNotFoundException(USER, userId);
                });
    }
}
