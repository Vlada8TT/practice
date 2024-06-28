package com.example.demo.controller;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Controller", description = "Operations related to user management: create, update, get by id, delete by id, get user`s orders")
public class UserController {

    private final UserService userService;
    private final OrderService orderService;

    @PostMapping("/api/v1/users")
    @Operation(summary = "Create new user")
    public UserResponseDto createUser(
            @Validated(OnCreate.class)
            @RequestBody UserRequestDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping
    @PreAuthorize("canAccessUser(#id)")
    @Operation(summary = "Update user data")
    public UserResponseDto update(
            @PathVariable int id,
            @Validated(OnUpdate.class) @RequestBody UserRequestDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("canAccessUser(#id)")
    @Operation(summary = "Get user by id")
    public UserResponseDto getById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("canAccessUser(#id)")
    @Operation(summary = "Delete user by id")
    public void deleteById(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/orders")
    @PreAuthorize("canAccessUser(#id)")
    @Operation(summary = "Get user orders list by user id")
    public List<OrderResponseDto> getOrdersByUserId(@PathVariable int id) {
        return orderService.getAllOrders();
    }
}