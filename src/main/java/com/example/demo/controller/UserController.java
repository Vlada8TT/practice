package com.example.demo.controller;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
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

    @PutMapping
    public UserResponseDto update(@Validated(OnUpdate.class) @PathVariable int id, @RequestBody UserRequestDto userDto){
        UserResponseDto updateUser = userService.updateUser(id, userDto);
        return updateUser;
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable int id){
        UserResponseDto user = userService.getUserById(id);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/Order")
    public List<OrderResponseDto> getOrderByUserId(@PathVariable int id){
        List<OrderResponseDto> order = orderService.getAllOrders();
        return order;
    }

    @PostMapping("/{id}/Order")
    public OrderResponseDto createOrder(@Validated(OnCreate.class) @PathVariable int id, @RequestBody OrderRequestDto orderDto){
        OrderResponseDto createdOrder = orderService.createOrder(orderDto);
        return createdOrder;
    }
}