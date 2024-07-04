package com.example.demo.controller.impl;

import com.example.demo.controller.OrderItemAPI;
import com.example.demo.dto.exception.ExceptionBody;
import com.example.demo.dto.request.OrderItemRequestDto;
import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.IngredientResponseDto;
import com.example.demo.dto.response.OrderItemResponseDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.service.OrderItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orderItems")
@RequiredArgsConstructor
@Validated
public class OrderItemController implements OrderItemAPI {

    public final OrderItemService orderItemService;

    @PostMapping("/{orderId}/add")
    @PreAuthorize("canAccessOrder(#orderId)")
    public void addOrderItem(
            @PathVariable int orderId,
            @Validated(OnCreate.class) @RequestBody OrderItemRequestDto orderItemRequestDto) {
        orderItemService.addOrderItem(orderId, orderItemRequestDto);
    }

    @PutMapping("/{orderId}/{orderItemId}")
    @PreAuthorize("canAccessOrder(#orderId)")
    public OrderItemResponseDto update(
            @PathVariable int orderId,
            @PathVariable int orderItemId,
            @Validated(OnUpdate.class) @RequestBody OrderItemRequestDto orderItemRequestDto) {
        return orderItemService.updateOrderItem(orderItemId, orderItemRequestDto);
    }

    @DeleteMapping("/{orderId}/{orderItemId}")
    @PreAuthorize("canAccessOrder(#orderId)")
    public void deleteById(@PathVariable int orderId, @PathVariable int orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
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
