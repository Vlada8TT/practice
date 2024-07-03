package com.example.demo.controller;

import com.example.demo.dto.request.OrderItemRequestDto;
import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderItemResponseDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orderItems")
@RequiredArgsConstructor
@Validated
public class OrderItemController {

    public final OrderItemService orderItemService;

    @PostMapping("/{orderId}/add")
    @PreAuthorize("canAccessOrder(#orderId)")
    public void addOrderItem(
            @PathVariable int orderId,
            @Validated(OnCreate.class) @RequestBody OrderItemRequestDto orderItemRequestDto) {
        orderItemService.addOrderItem(orderId, orderItemRequestDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("canAccessOrder(#id)")
    public OrderItemResponseDto update(
            @PathVariable int id,
            @Validated(OnUpdate.class) @RequestBody OrderItemRequestDto orderItemRequestDto) {
        return orderItemService.updateOrderItem(id, orderItemRequestDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("canAccessOrder(#id)")
    public void deleteById(@PathVariable int id) {
        orderItemService.deleteOrderItem(id);
    }

    @PostMapping("/{orderId}/{orderItemId}/increment")
    @PreAuthorize("canAccessOrder(#orderId)")
    public void incrementOrderItemQuantity(@PathVariable int orderId, @PathVariable int orderItemId) {
        orderItemService.incrementOrderItemQuantity(orderItemId);
    }

    @PostMapping("/{orderId}/{orderItemId}/decrement")
    @PreAuthorize("canAccessOrder(#orderId)")
    public void decrementOrderItemQuantity(@PathVariable int orderId, @PathVariable int orderItemId) {
        orderItemService.decrementOrderItemQuantity(orderItemId);
    }
}
