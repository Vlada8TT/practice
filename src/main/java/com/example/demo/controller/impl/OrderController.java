package com.example.demo.controller.impl;

import com.example.demo.controller.OrderAPI;
import com.example.demo.dto.auth.JwtResponse;
import com.example.demo.dto.exception.ExceptionBody;
import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Validated
public class OrderController implements OrderAPI {

    private final OrderService orderService;

    @PostMapping("/create")
    public OrderResponseDto createOrder(
            @Validated(OnCreate.class) @RequestBody OrderRequestDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("canAccessOrder(#id)")
    public OrderResponseDto update(
            @PathVariable int id,
            @Validated(OnUpdate.class) @RequestBody OrderRequestDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("canAccessOrder(#id)")
    public OrderResponseDto getById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("canAccessOrder(#id)")
    public void deleteById(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

}