package com.example.demo.controller;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final OrderService orderService;

    @PostMapping("/create")
    public UserResponseDto createUser(
            @Validated(OnCreate.class)
            @RequestBody UserRequestDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("canAccessUser(#id)")
    public UserResponseDto update(
            @PathVariable int id,
            @Validated(OnUpdate.class) @RequestBody UserRequestDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("canAccessUser(#id)")
    public UserResponseDto getById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("canAccessUser(#id)")
    public void deleteById(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/orders")
    @PreAuthorize("canAccessUser(#id)")
    public List<OrderResponseDto> getOrdersByUserId(@PathVariable int id) {
        return orderService.getAllOrders(); //todo
    }
}