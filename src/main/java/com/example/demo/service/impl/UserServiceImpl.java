package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.persistence.entity.*;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final PasswordEncoder passwordEncoder;
    private final AddressServiceImpl addressService;

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        checkIfEmailUnique(userRequestDto);
        checkIfMobilePhoneUnique(userRequestDto);
        User user = userMapper.toEntity(userRequestDto);
        user.setAddress(addressMapper.toEntity(addressService.createAddress(userRequestDto.addressRequestDto())));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getUserById(int id) {
        return userMapper.toDto(findUserById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUsers() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    @Transactional
    public UserResponseDto updateUser(int id, UserRequestDto userRequestDto) {
        User user = findUserById(id);
        if (!userRequestDto.email().equals(user.getEmail())) {
            checkIfEmailUnique(userRequestDto);
        }
        if (!userRequestDto.mobilePhone().equals(user.getMobilePhone())) {
            checkIfMobilePhoneUnique(userRequestDto);
        }
        userMapper.updateUserFromDto(userRequestDto,user);
        addressService.updateAddress(user.getAddress().getId(),userRequestDto.addressRequestDto());
        user.setPassword(passwordEncoder.encode(userRequestDto.password()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    //TODO method setUserRole

    @Override
    @Transactional
    public void deleteUser(int id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }

    private void checkIfEmailUnique(UserRequestDto userRequestDto){
        if(userRepository.existsByEmail(userRequestDto.email())){
            throw new ResourceAlreadyExistsException("user",userRequestDto.email());
        }
    }

    private void checkIfMobilePhoneUnique(UserRequestDto userRequestDto){
        if(userRepository.existsByMobilePhone(userRequestDto.mobilePhone())){
            throw new ResourceAlreadyExistsException("user",userRequestDto.mobilePhone());
        }
    }

    private User findUserById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user", id));
    }
}