package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.exception.EntityNotFoundException;
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
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {

        User user = userMapper.toEntity(userRequestDto);
        Address address = addressRepository.findById(userRequestDto.addressId())
                .orElseThrow(() -> new EntityNotFoundException("address",userRequestDto.addressId()));
        Role role = roleRepository.findById(userRequestDto.roleId())
                .orElseThrow(() -> new EntityNotFoundException("role",userRequestDto.roleId()));
        user.setAddress(address);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(userRepository.findByName(user.getName()).isPresent()){
            throw new IllegalStateException("User already exist");
        }
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getUserByEmail(String email) {

        return userMapper.toDto(userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("user", email)));
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getUserById(int id) {

        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUsers() {

        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    @Transactional
    public UserResponseDto updateUser(int id, UserRequestDto userRequestDto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user",id));
        updateUserFields(user,userRequestDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user", id));
        userRepository.delete(user);
    }

    private void updateUserFields(User user, UserRequestDto userRequestDto){

        Address address = addressRepository.findById(userRequestDto.addressId())
                .orElseThrow(() -> new EntityNotFoundException("address",userRequestDto.addressId()));
        Role role = roleRepository.findById(userRequestDto.roleId())
                .orElseThrow(() -> new EntityNotFoundException("role",userRequestDto.roleId()));
        user.setAddress(address);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(userRequestDto.password()));
        user.setName(userRequestDto.name());
        user.setMobilePhone(userRequestDto.mobilePhone());
        user.setEmail(userRequestDto.email());
    }
}