package com.example.demo.controller;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/Order")
@RequiredArgsConstructor
@Validated
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PutMapping
    public OrderResponseDto update(@Validated(OnUpdate.class)@PathVariable int id, @RequestBody OrderRequestDto orderDto){
        OrderResponseDto updateOrder = orderService.updateOrder(id, orderDto);
        return updateOrder;
    }

    @GetMapping("/{id}")
    public OrderResponseDto getById(@PathVariable int id){
        OrderResponseDto order = orderService.getOrderById(id);
        return order;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        orderService.deleteOrder(id);
    }

}