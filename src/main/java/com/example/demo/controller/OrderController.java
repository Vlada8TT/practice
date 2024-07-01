package com.example.demo.controller;

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
@Tag(name = "Order Controller", description = "Operations related to order management: create, update, get by id, delete by id")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    @Operation(summary = "Create new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 401, \"message\": \"Unauthorized\"}"))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 403, \"message\": \"Access denied\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 500, \"message\": \"Internal server error\"}"))),
    })
    public OrderResponseDto createOrder(
            @PathVariable int id,
            @Validated(OnCreate.class) @RequestBody OrderRequestDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("canAccessOrder(#id)")
    @Operation(summary = "Update order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 401, \"message\": \"Unauthorized\"}"))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 403, \"message\": \"Access denied\"}"))),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 404, \"message\": \"Not found\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 500, \"message\": \"Internal server error\"}"))),
    })
    public OrderResponseDto update(
            @PathVariable int id,
            @Validated(OnUpdate.class) @RequestBody OrderRequestDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("canAccessOrder(#id)")
    @Operation(summary = "Get order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order received successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 401, \"message\": \"Unauthorized\"}"))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 403, \"message\": \"Access denied\"}"))),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 404, \"message\": \"Not found\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 500, \"message\": \"Internal server error\"}"))),
    })
    public OrderResponseDto getById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("canAccessOrder(#id)")
    @Operation(summary = "Delete order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order deleted successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 401, \"message\": \"Unauthorized\"}"))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 403, \"message\": \"Access denied\"}"))),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 404, \"message\": \"Not found\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"status\": 500, \"message\": \"Internal server error\"}"))),
    })
    public void deleteById(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

}