package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.persistence.entity.*;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.demo.util.ExceptionSourceName.ROLE;
import static com.example.demo.util.ExceptionSourceName.USER;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        checkIfEmailUnique(userRequestDto);
        checkIfMobilePhoneUnique(userRequestDto);
        User user = userMapper.toEntity(userRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(findRoleByName("ROLE_USER"));
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
        user.setPassword(passwordEncoder.encode(userRequestDto.password()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public UserResponseDto setRole(String roleName, int userId) {
        User user = findUserById(userId);
        user.setRole(findRoleByName(roleName));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }

    private void checkIfEmailUnique(UserRequestDto userRequestDto){
        if(userRepository.existsByEmail(userRequestDto.email())){
            throw new ResourceAlreadyExistsException(USER, userRequestDto.email());
        }
    }

    private void checkIfMobilePhoneUnique(UserRequestDto userRequestDto){
        if(userRepository.existsByMobilePhone(userRequestDto.mobilePhone())){
            throw new ResourceAlreadyExistsException(USER, userRequestDto.mobilePhone());
        }
    }

    private User findUserById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(USER, id));
    }

    private Role findRoleByName(String roleName){
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new EntityNotFoundException(ROLE));
    }
}