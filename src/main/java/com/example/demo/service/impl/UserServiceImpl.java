package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.exception.EntityNotFoundException;
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
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        user.setAddress(addressMapper.toEntity(userRequestDto.addressRequestDto()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        checkIfEmailUnique(userRequestDto);
        checkIfMobilePhoneUnique(userRequestDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("user", email));
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
        checkIfEmailUnique(userRequestDto);
        checkIfMobilePhoneUnique(userRequestDto);
        updateUserFields(user,userRequestDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }

    private void updateUserFields(User user, UserRequestDto userRequestDto){
        user = userMapper.toEntity(userRequestDto);
        user.setAddress(addressMapper.toEntity(userRequestDto.addressRequestDto()));
        user.setPassword(passwordEncoder.encode(userRequestDto.password()));
    }

    private void checkIfEmailUnique(UserRequestDto userRequestDto){
        if(userRepository.existsByEmail(userRequestDto.email())){
            throw new ResourceAlreadyExistsException("User",userRequestDto.email());
        }
    }

    private void checkIfMobilePhoneUnique(UserRequestDto userRequestDto){
        if(userRepository.existsByMobilePhone(userRequestDto.mobilePhone())){
            throw new ResourceAlreadyExistsException("User",userRequestDto.mobilePhone());
        }
    }

    private User findUserById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user", id));
    }
}