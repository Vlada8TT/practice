package com.example.demo.controller;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Validated
@Tag(name = "Order Controller", description = "Operations related to order management: create, update, get by id, delete by id")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    @Operation(summary = "Create new order")
    public OrderResponseDto createOrder(
            @PathVariable int id,
            @Validated(OnCreate.class) @RequestBody OrderRequestDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("canAccessOrder(#id)")
    @Operation(summary = "Update order by id")
    public OrderResponseDto update(
            @PathVariable int id,
            @Validated(OnUpdate.class) @RequestBody OrderRequestDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("canAccessOrder(#id)")
    @Operation(summary = "Get order by id")
    public OrderResponseDto getById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("canAccessOrder(#id)")
    @Operation(summary = "Delete order by id")
    public void deleteById(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

}