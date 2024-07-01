package com.example.demo.controller;

import com.example.demo.dto.exception.ExceptionBody;
import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class))),
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
    public UserResponseDto createUser(
            @Validated(OnCreate.class)
            @RequestBody UserRequestDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping
    @PreAuthorize("canAccessUser(#id)")
    @Operation(summary = "Update user data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class))),
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
    public UserResponseDto update(
            @PathVariable int id,
            @Validated(OnUpdate.class) @RequestBody UserRequestDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("canAccessUser(#id)")
    @Operation(summary = "Get user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User received successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class))),
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
    public UserResponseDto getById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("canAccessUser(#id)")
    @Operation(summary = "Delete user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
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
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/orders")
    @PreAuthorize("canAccessUser(#id)")
    @Operation(summary = "Get user orders list by user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders received successfully",
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
    public List<OrderResponseDto> getOrdersByUserId(@PathVariable int id) {
        return orderService.getAllOrders();
    }
}