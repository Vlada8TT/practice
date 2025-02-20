package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.persistence.entity.Order;
import com.example.demo.persistence.entity.Role;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.enums.RoleName;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.util.ExceptionSourceName.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final OrderRepository orderRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        log.info("Creating user");
        checkIfEmailUnique(userRequestDto);
        checkIfMobilePhoneUnique(userRequestDto);
        User user = userMapper.toEntity(userRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(findRoleByName(RoleName.ROLE_USER.name()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getUserById(int id) {
        log.info("Retrieving user by id {}", id);
        return userMapper.toDto(findUserById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUsers() {
        log.info("Retrieving all users");
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    @Transactional
    public UserResponseDto updateUser(int id, UserRequestDto userRequestDto) {
        log.info("Updating user with id {}", id);
        User user = findUserById(id);
        if (!userRequestDto.email().equals(user.getEmail())) {
            checkIfEmailUnique(userRequestDto);
        }
        if (!userRequestDto.mobilePhone().equals(user.getMobilePhone())) {
            checkIfMobilePhoneUnique(userRequestDto);
        }
        userMapper.updateUserFromDto(userRequestDto, user);
        user.setPassword(passwordEncoder.encode(userRequestDto.password()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public UserResponseDto setRole(String roleName, int userId) {
        log.info("Setting role to user with id {}", userId);
        User user = findUserById(userId);
        user.setRole(findRoleByName(roleName));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        log.info("Deleting user with id {}", id);
        User user = findUserById(id);
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isOrderOwner(int userId, int orderId) {
        log.info("Find out if user with id {} is owner of order with id {}", userId, orderId);
        return findOrderById(orderId).getUser().getId().equals(userId);
    }

    private void checkIfEmailUnique(UserRequestDto userRequestDto) {
        log.info("Email uniqueness checking...");
        if (userRepository.existsByEmail(userRequestDto.email())) {
            log.error("User with email {} already exists",
                    userRequestDto.email(),
                    new ResourceAlreadyExistsException(USER, userRequestDto.email()));
            throw new ResourceAlreadyExistsException(USER, userRequestDto.email());
        }
    }

    private void checkIfMobilePhoneUnique(UserRequestDto userRequestDto) {
        log.info("Mobile phone uniqueness checking...");
        if (userRepository.existsByMobilePhone(userRequestDto.mobilePhone())) {
            log.error("User with mobile phone {} already exists",
                    userRequestDto.mobilePhone(),
                    new ResourceAlreadyExistsException(USER, userRequestDto.mobilePhone()));
            throw new ResourceAlreadyExistsException(USER, userRequestDto.mobilePhone());
        }
    }

    private User findUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("User with id {} was not found", id);
                    return new EntityNotFoundException(USER, id);
                });
    }

    private Role findRoleByName(String roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> {
                    log.error("Role with name {} was not found", roleName);
                    return new EntityNotFoundException(ROLE);
                });
    }

    private Order findOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Order with id {} was not found", id);
                    return new EntityNotFoundException(ORDER, id);
                });
    }
}